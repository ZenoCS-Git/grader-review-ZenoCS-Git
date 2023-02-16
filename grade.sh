#!/bin/bash

CPATH='.:lib/hamcrest-core-1.3.jar:lib/junit-4.13.2.jar'

rm -rf student-submission
git clone $1 student-submission

if [[$? -neq 0]]
then
  echo "Invalid github repository"
  exit
fi

if [[-f student-submission/ListExamples.java]]
then
  echo "Your file to be graded does not exist"
  exit 
fi

set -e
rm student-submission/ListExamplesTester.java
cp ListExamplesTester student-submission/ListExamplesTester.java
unset -e

javac -cp $CPATH student-submission/ListExamplesTester.java student-submission/ListExamples.java 2> stderr.txt > stdout.txt
STDOUT=`cat stdout.txt`
STDERR=`cat stderr.txt`

if [[$? -neq 0]]
then
  echo "A compile error occured"
  echo "Standard output: {$STDOUT}"
  echo "Standard error: {$STDERR}"
  exit
fi

java -cp $CPATH org.junit.runner.JUnitCore ListExamplesTester 2> stderr.txt > stdout.txt
STDOUT=`cat stdout.txt`
STDERR=`cat stderr.txt`


echo 'Finished cloning'



