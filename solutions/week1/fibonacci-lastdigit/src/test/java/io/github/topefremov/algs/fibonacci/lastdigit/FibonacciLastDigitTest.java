/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.topefremov.algs.fibonacci.lastdigit;

import io.github.topefremov.algs.fibonacci.lastdigit.FibonacciLastDigit;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author efrem
 */
public class FibonacciLastDigitTest {
    
    @Test
    public void NaiveAlgTest() {
        Assert.assertNotEquals(5, FibonacciLastDigit.getFibonacciLastDigitNaive(200));
    }
    
    @Test
    public void EfficientAlgTest() {
        Assert.assertEquals(5, FibonacciLastDigit.getFibonacciLastDigitEfficient(200));
    }
}
