import static org.junit.Assert.*;
import org.junit.*;
import java.util.Arrays;
import java.util.List;

class IsMoon implements IntegerChecker {
  public boolean checkInteger(Integer s) {
    return s.equalsIgnoreCase("moon");
  }
}

public class ListExamplesTester {
  @Test(timeout = 500)
  public void testMergeEvenLen() {
    List<Integer> left = Arrays.asList(2, 4, 6);
    List<Integer> right = Arrays.asList(1, 3, 5, 7);
    List<Integer> merged = ListExamples.merge(left, right);
    List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
    assertEquals(expected, merged);
  }

  @Test(timeout = 500)
  public void testMergeOddLen() {
    List<Integer> right = Arrays.asList(2, 4, 6);
    List<Integer> left = Arrays.asList(1, 3, 5, 7);
    List<Integer> merged = ListExamples.merge(left, right);
    List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
    assertEquals(expected, merged);
  }

  @Test(timeout = 500)
  public void testMergeBothOdd() {
    List<Integer> left = Arrays.asList(1, 2, 5);
    List<Integer> right = Arrays.asList(1, 3, 5);
    List<Integer> merged = ListExamples.merge(left, right);
    List<Integer> expected = Arrays.asList(1, 2, 3, 5, 5);
    assertEquals(expected, merged);
  }

  @Test(timeout = 500)
  public void testMergeBothEven() {
    List<Integer> left = Arrays.asList(2, 4, 6, 8);
    List<Integer> right = Arrays.asList(1, 4, 5, 9);
    List<Integer> merged = ListExamples.merge(left, right);
    List<Integer> expected = Arrays.asList(1, 2, 4, 4, 5, 6, 8, 9);
    assertEquals(expected, merged);
  }

  @Test(timeout = 500)
  public void testMergeEmpty() {
    List<Integer> left = Arrays.asList();
    List<Integer> right = Arrays.asList();
    List<Integer> merged = ListExamples.merge(left, right);
    List<Integer> expected = Arrays.asList();
    assertEquals(expected, merged);
    left = Arrays.asList(1);
    right = Arrays.asList();
    merged = ListExamples.merge(left, right);
    expected = Arrays.asList(1);
    assertEquals(expected, merged);
    left = Arrays.asList();
    right = Arrays.asList(1);
    merged = ListExamples.merge(left, right);
    expected = Arrays.asList(1);
    assertEquals(expected, merged);
  }

  @Test(timeout = 500)
  public void testShouldPass() {
    assertEquals(0, 0);
  }
}
