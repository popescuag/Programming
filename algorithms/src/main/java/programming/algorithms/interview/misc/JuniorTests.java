package programming.algorithms.interview.misc;

public class JuniorTests {
    static class A {
	private int count = 0;
	
	public int getCount() {
	    return count;
	}
    }
    
    static class B extends A {
	private int count = 1;

	public int getCount() {
	    return count;
	}
    }

    public static void main(String[] args) {
	A a = new B();
	System.out.println(a.getCount());
    }
    
}
