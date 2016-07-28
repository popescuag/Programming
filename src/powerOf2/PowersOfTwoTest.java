package powerOf2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PowersOfTwoTest {
    private PowersOfTwo solution;
    
    @Before
    public void setUp() throws Exception {
	solution = new PowersOfTwo();
    }

    @Test(timeout = 2000)
    public void testCase0() {
	long[] powers = new long[2];
	powers[0] = 1;
	powers[1] = 2;
	
        long expected = 4;
        long actual = solution.count(powers);
        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
	long[] powers = new long[7];
	powers[0] = 1;
	powers[1] = 1;
	powers[2] = 1;
	powers[3] = 1;
	powers[4] = 1;
	powers[5] = 1;
	powers[6] = 1;

        long expected = 8;
        long actual = solution.count(powers);
        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
	long[] powers = new long[7];
	powers[0] = 1;
	powers[1] = 2;
	powers[2] = 2;
	powers[3] = 2;
	powers[4] = 4;
	powers[5] = 4;
	powers[6] = 16;

        long expected = 32;
        long actual = solution.count(powers);
        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
	long[] powers = new long[5];
	powers[0] = 1;
	powers[1] = 32;
	powers[2] = 1;
	powers[3] = 16;
	powers[4] = 32;

        long expected = 18;
        long actual = solution.count(powers);
        Assert.assertEquals(expected, actual);
    }
    
	@Test(timeout = 2000)
	public void testCase4() {
	    long[] powers = new long[22];
	    powers[0] = 1048576;
	    powers[1] = 1073741824;
	    powers[2] = 549755813888L;
	    powers[3] = 70368744177664L;
	    powers[4] = 4398046511104L;
	    powers[5] = 262144;
	    powers[6] = 1048576;
	    powers[7] = 2097152;
	    powers[8] = 8796093022208L;
	    powers[9] = 1048576;
	    powers[10] = 1048576;
	    powers[11] = 35184372088832L;
	    powers[12] = 2097152;
	    powers[13] = 256;
	    powers[14] = 256;
	    powers[15] = 256;
	    powers[16] = 262144;
	    powers[17] = 1048576;
	    powers[18] = 1048576;
	    powers[19] = 70368744177664L;
	    powers[20] = 262144;
	    powers[21] = 1048576;

	    long expected = 18432;
	    long actual = solution.count(powers);
	    Assert.assertEquals(expected, actual);
	}
}
