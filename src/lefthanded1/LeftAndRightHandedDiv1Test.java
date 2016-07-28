package lefthanded1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LeftAndRightHandedDiv1Test {
    private LeftAndRightHandedDiv1 solution;
    
    @Before
    public void setUp() {
        solution = new LeftAndRightHandedDiv1();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        String Y = "LR";
        int A = 1;
        int B = 0;
        int C = 1;
        int D = 2;
        int N = 1;

        long expected = 0;
        long actual = solution.countSwaps(Y, A, B, C, D, N);

        Assert.assertEquals(expected, actual);
    }
    
    @Test(timeout = 2000)
    public void testCase1() {
        String Y = "LRLR";
        int A = 1;
        int B = 1;
        int C = 2;
        int D = 3;
        int N = 4;

        long expected = 0;
        long actual = solution.countSwaps(Y, A, B, C, D, N);

        Assert.assertEquals(expected, actual);
    }

    @Test
    //(timeout = 2000)
    public void testCase2() {
        String Y = "LRRLLR";
        int A = 2;
        int B = 3;
        int C = 4;
        int D = 5;
        int N = 6;

        long expected = 1;
        long actual = solution.countSwaps(Y, A, B, C, D, N);

        Assert.assertEquals(expected, actual);
    }

    @Test
    //(timeout = 2000)
    public void testCase3() {
        String Y = "LRRLRLLRLRLRLLRLR";
        int A = 12;
        int B = 15;
        int C = 3;
        int D = 22;
        int N = 10;

        long expected = 2;
        long actual = solution.countSwaps(Y, A, B, C, D, N);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        String Y = "LLLLLLLLL";
        int A = 0;
        int B = 1;
        int C = 2;
        int D = 3;
        int N = 1000000;

        long expected = 0;
        long actual = solution.countSwaps(Y, A, B, C, D, N);

        Assert.assertEquals(expected, actual);
    }
    
    @Test
    //(timeout = 12000)
    public void testCase5() {
        String Y = "RLRRRLLLRLRLLRLRLLRLRLLLLLRRLRLRLRLRLLRRRLRRLLLLLRRRLRRLRLRRLLLLRLRRLRLRRLRRLRLLRRLRLRRRLRLLRLLLLRLLLLRLLRRLLRRRRLLRLLRLRLRRLL";
        int A = 48658960;
        int B = 221863772;
        int C = 385355602;
        int D = 393787970;
        int N = 980265;

        long expected = 59619692663L;
        long actual = solution.countSwaps(Y, A, B, C, D, N);

        Assert.assertEquals(expected, actual);
    }
}
