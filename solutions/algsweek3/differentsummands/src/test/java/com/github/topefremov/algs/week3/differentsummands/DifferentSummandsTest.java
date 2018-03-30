package com.github.topefremov.algs.week3.differentsummands;

import static com.github.topefremov.algs.week3.differentsummands.DifferentSummands.*;
import static org.junit.Assert.*;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class DifferentSummandsTest {

    @Test
    public void testCase1() {
        int n = 6;
        List<Integer> expected = Arrays.asList(1, 2 ,3);
        assertEquals(expected, optimalSummands(n));
    }

    @Test
    public void testCase2() {
        int n = 8;
        List<Integer> expected = Arrays.asList(1, 2 ,5);
        assertEquals(expected, optimalSummands(n));
    }

    @Test
    public void testCase3() {
        int n = 15;
        List<Integer> expected = Arrays.asList(1, 2 , 3, 4, 5);
        assertEquals(expected, optimalSummands(n));
    }

    @Test
    public void testCase4() {
        int n = 182414564;
        assertEquals(19100, optimalSummands(n).size());
    }
}
