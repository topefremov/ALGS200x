package com.github.topefremov.algs.week3.moneychange;

import static org.junit.Assert.*;

import org.junit.Test;

public class ChangeTest {

    @Test
    public void testChange() {
        assertEquals(2, Change.getChange(2));
        assertEquals(6, Change.getChange(28));
        assertEquals(100, Change.getChange(1000));
        assertEquals(102, Change.getChange(997));
    }
}
