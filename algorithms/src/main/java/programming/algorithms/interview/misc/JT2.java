package programming.algorithms.interview.misc;

public class JT2 {
    static class A {
 	private int count = 0;
 	
 	public A() {
 	    this.count = 3;
System.out.println(this.count);
 	}
 	
 	public int getCount() {
 	    return count;
 	}
     }
     
     static class B extends A {
 	private int count = 1;
 	
 	public B() {
 	    this.count = 2;
System.out.println(this.count);
 	}

 	public int getCount() {
 	    return count;
 	}
     }

     public static void main(String[] args) {
 	A a = new B();
 	System.out.println(a.getCount());
     }
     
}
