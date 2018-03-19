/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.topefremov.algs.fibonacci_partial_sum_lastdigit;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author efrem
 */
public class FibonacciPartialSumTest {

    @Test
    public void getFibonacciPartialSumNaiveTest() {
        assertEquals(0, FibonacciPartialSum.getFibonacciPartialSumNaive(0, 0));
        assertEquals(2, FibonacciPartialSum.getFibonacciPartialSumNaive(1, 2));
        assertEquals(5, FibonacciPartialSum.getFibonacciPartialSumNaive(10, 10));
//         assertEquals(2, FibonacciPartialSum.getFibonacciPartialSumNaive(10, 200)); // doesn't work!
    }
    
    @Test
    public void getFibinacciPartialSumEfficientTest() {
        assertEquals(0, FibonacciPartialSum.getFibonacciPartialSumEfficient(0, 0));
        assertEquals(2, FibonacciPartialSum.getFibonacciPartialSumEfficient(1, 2));
        assertEquals(5, FibonacciPartialSum.getFibonacciPartialSumEfficient(10, 10));
        assertEquals(2, FibonacciPartialSum.getFibonacciPartialSumEfficient(10, 200));
    }
}
