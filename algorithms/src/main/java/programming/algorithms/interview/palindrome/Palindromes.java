package programming.algorithms.interview.palindrome;

public class Palindromes {
  private boolean isPalindrome(String s) {
    if (s == null) {
      return false;
    }
    
    int i = 0;
    int len = s.length();
    
    for (;s.charAt(i) == s.charAt(len -i - 1) && i < len / 2 ; i++);
    return i == len / 2;
  }
  
  public static void main(String[] args) {
    Palindromes checker = new Palindromes();
System.out.println("capac " + checker.isPalindrome("capac") );
System.out.println("copac " + checker.isPalindrome("copac") );
System.out.println("sas " + checker.isPalindrome("sas") );
System.out.println("cappac " + checker.isPalindrome("cappac") );
  }
}
