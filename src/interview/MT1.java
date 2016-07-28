package interview;

public class MT1 {
   private static int count = 5;
    
    static {
	count = 6;
System.out.println("Static block");
    }
    
    public MT1(int _count) {
	count = _count;
System.out.println("Constructor");
    }

    public static void main(String[] args) {
	MT1 me1 = new MT1(7);
	MT1 me2 = new MT1(9);
System.out.println(me2.count);
    }

}
