package com.github.topefremov.algsweek5.lcs3;

import org.junit.Test;

import static org.junit.Assert.*;

public class LCS3Test {

    @Test
    public void sample1Test() {
        int[] a = { 1, 2, 3 };
        int[] b = { 2, 1, 3 };
        int[] c = { 1, 3, 5 };
        assertEquals(2, LCS3.lcs3(a, b, c));
    }

    @Test
    public void sample2Test() {
        int[] a = { 8, 3, 2, 1, 7 };
        int[] b = { 8, 2, 1, 3, 8, 10, 7 };
        int[] c = { 6, 8, 3, 1, 4, 7 };
        assertEquals(3, LCS3.lcs3(a, b, c));
    }
}