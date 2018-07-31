import org.junit.Test;

import static org.junit.Assert.*;

public class Partition3Test {

    @Test
    public void sample1Test() {
        int[] A = {3, 3, 3, 3};
        assertFalse(Partition3.partition3(A));
    }

    @Test
    public void sample2Test() {
        int[] A = { 30 };
        assertFalse(Partition3.partition3(A));
    }

    @Test
    public void sample3Test() {
        int[] A = { 1, 2, 3, 4, 5, 5, 7, 7, 8, 10, 12, 19, 25 };
        assertTrue(Partition3.partition3(A));
    }

    @Test
    public void sample4Test() {
        int[] A = { 1, 1, 1 };
        assertTrue(Partition3.partition3(A));
    }


}