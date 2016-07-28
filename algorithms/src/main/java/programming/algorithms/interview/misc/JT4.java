package programming.algorithms.interview.misc;

public class JT4 {
    private static int count = 5;
    
    public JT4(int _count) {
	count = _count;
    }

    public static void main(String[] args) {
	JT4 me1 = new JT4(7);
	JT4 me2 = new JT4(9);
System.out.println(me1.count + " " + me2.count);
    }

}
