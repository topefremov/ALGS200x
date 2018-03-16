/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.topefremov.algs.fibonacci;

import io.github.topefremov.algs.fibonacci.Fibonacci;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author efrem
 */
public class FibonacciTest {
    
    @Test
    public void fibonacciOf10ShouldReturn55() {
        assertEquals(55, Fibonacci.calc_fib(10));
    }
    
    @Test 
    public void fibboncciEfficientAlgorithmTest() {
        assertEquals(0, Fibonacci.calc_fib_efficiently(0));
        assertEquals(1, Fibonacci.calc_fib_efficiently(1));
        assertEquals(1, Fibonacci.calc_fib_efficiently(2));
        assertEquals(55, Fibonacci.calc_fib_efficiently(10));
    }
}
