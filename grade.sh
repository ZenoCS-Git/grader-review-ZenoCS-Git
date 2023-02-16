#!/bin/bash

CPATH='.:lib/hamcrest-core-1.3.jar:lib/junit-4.13.2.jar'

rm -rf student-submission
git clone $1 student-submission > /dev/null 2> /dev/null

if [[ $? -ne 0 ]]
then
  echo "Invalid github repository"
  exit
fi

if [[ ! -f student-submission/ListExamples.java ]]
then
  echo "Your file to be graded does not exist"
  exit 
fi

rm student-submission/ListExamplesTester.java 2> /dev/null > /dev/null
cp ListExamplesTester.java student-submission/ListExamplesTester.java 2> /dev/null > /dev/null

javac -cp $CPATH student-submission/ListExamplesTester.java student-submission/ListExamples.java 2> stderr.txt > stdout.txt
STDOUT=`cat stdout.txt`
STDERR=`cat stderr.txt`

if [[ $? -ne 0 ]]
then
  echo "A compile error occured"
  echo "Standard output: $STDOUT"
  echo "Standard error: $STDERR"
  exit
fi

mv student-submission/*.class .

java -cp $CPATH org.junit.runner.JUnitCore ListExamplesTester 2> stderr.txt > stdout.txt
STDOUT=`cat stdout.txt`
STDERR=`cat stderr.txt`

rm *.class

if [[ $? -ne 0 ]]
then
  echo "A runtime error occured"
  echo "Standard output: $STDOUT"
  echo "Standard error: $STDERR"
  exit
fi

TESTOK=`cat stdout.txt | grep "OK" -o`
if [[ "OK" == $TESTOK ]]
then
  TESTSPASSED=`cat stdout.txt | grep "OK" | grep -E "[0-9]*" -o`
  TESTSRUN=$TESTSPASSED
else
  TESTSRUN=`cat stdout.txt  | grep -E "Tests run: [0-9]*" -o | sed -r "s/Tests run: ([0-9]*)/\1/g"`
  TESTSFAILED=`cat stdout.txt | grep -E "Failures: [0-9]*" -o | sed -r "s/Failures: ([0-9]*)/\1/g"`
  TESTSPASSED=$(echo $(( TESTSRUN - TESTSFAILED )))
fi

echo "Graded: You got $TESTSPASSED/$TESTSRUN tests correct"



