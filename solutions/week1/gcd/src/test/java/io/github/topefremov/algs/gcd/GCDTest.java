/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.topefremov.algs.gcd;

import io.github.topefremov.algs.gcd.GCD;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author efrem
 */
public class GCDTest {
    
    @Test
    public void gcdNaiveTest() {
        Assert.assertEquals(1, GCD.gcd_naive(18, 35));
        Assert.assertEquals(17657, GCD.gcd_naive(28851538, 1183019));
        Assert.assertEquals(1, GCD.gcd_naive(2147483647,291213132));
    }
    
    @Test
    public void gcdEfficientTest() {
        Assert.assertEquals(1, GCD.gcdEfficient(18, 35));
        Assert.assertEquals(17657, GCD.gcdEfficient(28851538, 1183019));
        Assert.assertEquals(1, GCD.gcdEfficient(2147483647,291213132));
    }
}
