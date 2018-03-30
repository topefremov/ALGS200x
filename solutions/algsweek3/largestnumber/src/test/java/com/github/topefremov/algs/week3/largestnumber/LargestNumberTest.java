package com.github.topefremov.algs.week3.largestnumber;

import org.junit.Test;

import static com.github.topefremov.algs.week3.largestnumber.LargestNumber.isGreaterOrEqual;
import static com.github.topefremov.algs.week3.largestnumber.LargestNumber.largestNumber;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LargestNumberTest {

    @Test
    public void isGreaterOrEqualTest1() {
        String dig1 = "2";
        String dig2 = "21";
        assertTrue(isGreaterOrEqual(dig1, dig2));
    }

    @Test
    public void isGreaterOrEqualTest2() {
        String dig1 = "300";
        String dig2 = "20";
        assertTrue(isGreaterOrEqual(dig1, dig2));
    }

    @Test
    public void largestNumberTest1() {
        String dig1 = "2";
        String dig2 = "21";
        assertEquals("221", largestNumber(new String[]{dig2, dig1}));
    }

    @Test
    public void largestNumberTest2() {
        String dig1 = "9";
        String dig2 = "4";
        String dig3 = "6";
        String dig4 = "1";
        String dig5 = "9";
        assertEquals("99641", largestNumber(new String[]{dig1, dig2, dig3, dig4, dig5}));
    }

    @Test
    public void largestNumberTest3() {
        String dig1 = "23";
        String dig2 = "39";
        String dig3 = "92";
        assertEquals("923923", largestNumber(new String[]{dig1, dig2, dig3}));
    }

    @Test
    public void largestNumberTest4() {
        String dig1 = "9";
        String dig2 = "960";
        assertEquals("9960", largestNumber(new String[]{dig1, dig2}));
    }

    @Test
    public void largestNumberTest5() {
        String dig1 = "960";
        String dig2 = "9";
        assertEquals("9960", largestNumber(new String[]{dig1, dig2}));
    }
}
