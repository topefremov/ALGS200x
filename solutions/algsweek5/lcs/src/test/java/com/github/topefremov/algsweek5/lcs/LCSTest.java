package com.github.topefremov.algsweek5.lcs;

import org.junit.Test;

import static com.github.topefremov.algsweek5.lcs.LCS.lcs2;
import static org.junit.Assert.*;

public class LCSTest {

    @Test
    public void sample1Test() {
        int[] a = { 2, 7, 5 };
        int[] b = { 2, 5 };
        assertEquals(2, lcs2(a, b));
    }

    @Test
    public void sample2Test() {
        int[] a = { 7 };
        int[] b = { 1, 2, 3, 4 };
        assertEquals(0, lcs2(a, b));
    }

    @Test
    public void sample3Test() {
        int[] a = { 2, 7, 8, 3 };
        int[] b = { 5, 2, 8, 7 };
        assertEquals(2, lcs2(a, b));
    }

    @Test
    public void sample4Test() {
        int[] a = { 2, 1, 3, 1, 4, 1, 5 };
        int[] b = { 1, 2, 1, 3, 1, 4, 5 };
        assertEquals(6, lcs2(a, b));
    }

    @Test
    public void sample5Test() {
        int[] a = { 0, 1, 5, 1, 3, 0, 3 };
        int[] b = { 0, 1, 0, 1, 1, 2, 1 };
        assertEquals(3, lcs2(a, b));
    }

}