/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.topefremov.algs.hugefibonacci;

import io.github.topefremov.algs.hugefibonaccci.HugeFibonacci;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author efrem
 */
public class HugeFibonacciTest {
    
    @Test
    public void getPisanoPeriodLengthTest() {
        assertEquals(3, HugeFibonacci.getPisanoPeriodLength(2));
        assertEquals(8, HugeFibonacci.getPisanoPeriodLength(3));
        assertEquals(6, HugeFibonacci.getPisanoPeriodLength(4));
        assertEquals(20, HugeFibonacci.getPisanoPeriodLength(5));
        assertEquals(420, HugeFibonacci.getPisanoPeriodLength(130));
        assertEquals(150000, HugeFibonacci.getPisanoPeriodLength(100000));
    }
    
    @Test
    public void getFibonacciModuloTest() {
        assertEquals(0, HugeFibonacci.getFibonacciModulo(0, 3));
        assertEquals(1, HugeFibonacci.getFibonacciModulo(1, 3));
        assertEquals(1, HugeFibonacci.getFibonacciModulo(2, 3));
        assertEquals(2, HugeFibonacci.getFibonacciModulo(3, 3));
        assertEquals(0, HugeFibonacci.getFibonacciModulo(4, 3));
        assertEquals(2, HugeFibonacci.getFibonacciModulo(14, 3));
    }
    
    @Test
    public void getFibonacciHugeTest() {
        assertEquals(1, HugeFibonacci.getFibonacciHuge(2015, 3));
        assertEquals(161, HugeFibonacci.getFibonacciHuge(239, 1000));
        assertEquals(10249, HugeFibonacci.getFibonacciHuge(2816213588l, 30524));
    }
     
}
