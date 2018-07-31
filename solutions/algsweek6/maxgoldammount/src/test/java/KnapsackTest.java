import org.junit.Test;

import static org.junit.Assert.*;

public class KnapsackTest {

    @Test
    public void sample1Test() {
        int[] w = { 1, 4, 8 };
        int W = 10;
        assertEquals(9, Knapsack.optimalWeight(W, w));
    }
}