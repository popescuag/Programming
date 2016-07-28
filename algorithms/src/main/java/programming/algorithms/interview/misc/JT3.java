package programming.algorithms.interview.misc;

public class JT3 {
    private static String str;
    private static int count;

    private static void printCounter() {
System.out.println(count);
    }
    
    private static void printStringLength(String s) {
System.out.println(s.length());
    }
    
    public static void main(String[] args) {
	printCounter();	
	printStringLength(str);
	count = 5;
	printCounter();
    }
}
