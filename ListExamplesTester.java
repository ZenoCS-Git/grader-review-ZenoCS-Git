import static org.junit.Assert.*;
import org.junit.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class IsMoon implements StringChecker {
  public boolean checkString(String s) {
    return s.equalsIgnoreCase("moon");
  }
}

public class ListExamplesTester {
  @Test(timeout = 500)
  public void testMergeEvenLen() {
    List<String> left = Arrays.asList("2", "4", "6");
    List<String> right = Arrays.asList("1", "3", "5", "7");
    List<String> merged = ListExamples.merge(left, right);
    List<String> expected = Arrays.asList("1", "2", "3", "4", "5", "6", "7");
    assertEquals(expected, merged);
  }

  @Test(timeout = 500)
  public void testMergeOddLen() {
    List<String> right = Arrays.asList("2", "4", "6");
    List<String> left = Arrays.asList("1", "3", "5", "7");
    List<String> merged = ListExamples.merge(left, right);
    List<String> expected = Arrays.asList("1", "2", "3", "4", "5", "6", "7");
    assertEquals(expected, merged);
  }

  @Test(timeout = 500)
  public void testMergeBothOdd() {
    List<String> left = Arrays.asList("1", "2", "5");
    List<String> right = Arrays.asList("1", "3", "5");
    List<String> merged = ListExamples.merge(left, right);
    List<String> expected = Arrays.asList("1", "1", "2", "3", "5", "5");
    assertEquals(expected, merged);
  }

  @Test(timeout = 500)
  public void testMergeBothEven() {
    List<String> left = Arrays.asList("2", "4", "6", "8");
    List<String> right = Arrays.asList("1", "4", "5", "9");
    List<String> merged = ListExamples.merge(left, right);
    List<String> expected = Arrays.asList("1", "2", "4", "4", "5", "6", "8", "9");
    assertEquals(expected, merged);
  }

  @Test(timeout = 500)
  public void testMergeEmpty() {
    List<String> left = Arrays.asList();
    List<String> right = Arrays.asList();
    List<String> merged = ListExamples.merge(left, right);
    List<String> expected = Arrays.asList();
    assertEquals(expected, merged);
    left = Arrays.asList("1");
    right = Arrays.asList();
    merged = ListExamples.merge(left, right);
    expected = Arrays.asList("1");
    assertEquals(expected, merged);
    left = Arrays.asList();
    right = Arrays.asList("1");
    merged = ListExamples.merge(left, right);
    expected = Arrays.asList("1");
    assertEquals(expected, merged);
  }

  @Test(timeout = 500)
  public void testShouldPass() {
    assertEquals("0", "0");
  }

  class someClass implements StringChecker {
    public boolean checkString(String s) {
      if (s.length() < 4) {
        return true;
      }
      return false;
    }
  }

  // Tester for filter
  @Test(timeout = 500)
  public void testFilter() {
    List<String> l1 = new ArrayList<String>(Arrays.asList("gd", "sk"));
    List<String> l2 = new ArrayList<String>(Arrays.asList("sk", "aadw", "cawd", "bfwt", "gd", "eeae"));
    someClass a = new someClass();
    assertEquals(l1, ListExamples.filter(l2, a));
    assertEquals(2, ListExamples.filter(l2, a).size());
  }

}
