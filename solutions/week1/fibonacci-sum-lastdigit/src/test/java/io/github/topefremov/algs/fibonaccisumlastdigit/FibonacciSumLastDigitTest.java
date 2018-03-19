/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.topefremov.algs.fibonaccisumlastdigit;

import io.github.topefremov.algs.fibonaccisumlastdigit.FibonacciSumLastDigit;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author efrem
 */
public class FibonacciSumLastDigitTest {
    
    @Test
    public void getFibonacciSumNaiveTest() {
        assertEquals(4, FibonacciSumLastDigit.getFibonacciSumNaive(3));
        assertEquals(5, FibonacciSumLastDigit.getFibonacciSumNaive(100));
        assertEquals(2, FibonacciSumLastDigit.getFibonacciSumNaive(5));
        assertNotEquals(5, FibonacciSumLastDigit.getFibonacciSumNaive(1000));
    } 
    
    @Test
    public void getFibonacciSumEfficientTest() {
        assertEquals(4, FibonacciSumLastDigit.getFibonacciSumEfficient(3));
        assertEquals(5, FibonacciSumLastDigit.getFibonacciSumEfficient(100));
        assertEquals(2, FibonacciSumLastDigit.getFibonacciSumEfficient(5));
        assertEquals(9, FibonacciSumLastDigit.getFibonacciSumEfficient(614162383528l));
    }
}
