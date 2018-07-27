package com.github.topefremov.algsweek5.primcalc;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class PrimitiveCalculatorTest {

    @Test
    public void sample1Test() {
        int n = 1;
        List<Integer> expected = Collections.singletonList(1);

        List<Integer> actual = PrimitiveCalculator.optimal_sequence(n);

        assertThat(actual, is(equalTo(expected)));
    }

    @Test
    public void sample2Test() {
        int n = 5;
        List<Integer> expected = Arrays.asList(1,2,4,5);

        List<Integer> actual = PrimitiveCalculator.optimal_sequence(n);

        assertThat(actual, is(equalTo(expected)));
    }

    @Test
    public void sample3Test() {
        int n = 96234;
        List<Integer> expected = Arrays.asList(1,3,9,10,11,22,66,198,594,1782,5346,16038,16039,32078,96234);

        List<Integer> actual = PrimitiveCalculator.optimal_sequence(n);

        assertThat(actual, is(equalTo(expected)));
    }

    @Test
    public void sample4Test() {
        int n = 98734;

        List<Integer> actual = PrimitiveCalculator.optimal_sequence(n);

        assertEquals(19, actual.size());
    }
}