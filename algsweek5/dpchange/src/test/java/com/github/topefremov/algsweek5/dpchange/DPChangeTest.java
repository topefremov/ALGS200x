package com.github.topefremov.algsweek5.dpchange;

import org.junit.Assert;
import org.junit.Test;

import static com.github.topefremov.algsweek5.dpchange.DPChange.*;

public class DPChangeTest {

    @Test
    public void testCase1() {
        Assert.assertEquals(3, getChange(9));
    }

    @Test
    public void testCase2() {
        Assert.assertEquals(9, getChange(34));
    }

    @Test
    public void testCase3() {
        Assert.assertEquals(238, getChange(950));
    }
}
