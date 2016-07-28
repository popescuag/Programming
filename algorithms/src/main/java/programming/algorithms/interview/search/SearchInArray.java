package programming.algorithms.interview.search;

/**
 * Finds a number in an sorted array
 * @author adrian.popescu
 *
 */
public class SearchInArray {
  
  private int findNumber(int n, int[] array) {
    if (array == null || array.length == 0) {
      return -1;
    }
    int len = array.length;
    int i = 0;
    for (;i < len && n > array[i]; i++);
    return i == len || array[i] > n ? -1 : i;
  }

  public static void main(String[] args) {
    int[] array = new int[] {1,3,5,6};
    SearchInArray s = new SearchInArray();
System.out.println(s.findNumber(1, array));
System.out.println(s.findNumber(6, array));
System.out.println(s.findNumber(-1, array));
System.out.println(s.findNumber(100, array));
  }

}
