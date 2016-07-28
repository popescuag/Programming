package technical.interview.preemployment;

public class PowerOfTwo {
  public boolean isPowerOfTwo(int n) {
    return Integer.bitCount(n) == 1;
  }
  
  public static void main(String[] s) {
    PowerOfTwo pot = new PowerOfTwo();
    System.out.println(pot.isPowerOfTwo(16));
    System.out.println(pot.isPowerOfTwo(8));
    System.out.println(pot.isPowerOfTwo((int) Math.pow(2, 30)));
    System.out.println(pot.isPowerOfTwo(14));
    System.out.println(pot.isPowerOfTwo(1));
    System.out.println(pot.isPowerOfTwo(0));
  }
}
