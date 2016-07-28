package interview;

import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;

public class JT5 {
    private static class A {
	int x = 1;

	int getX() {
	    return x;
	}
    }

    private static class B extends A {
	int x = 2;

	int getX() {
	    return x;
	}
    }

    public static void main(String[] args) {
	A a = new B();
	System.out.println(a.x);
	System.out.println(a.getX());
	
	int maxKeyLen = -1;
	try {
		maxKeyLen = Cipher.getMaxAllowedKeyLength("AES");
	} catch (NoSuchAlgorithmException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	System.out.println(maxKeyLen);
    }
}
