package com.github.topefremov.algsweek5.primcalc;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class PrimitiveCalculatorTest {

    @Test
    public void sample1Test() {
        int n = 5;
        List<Integer> expected = Arrays.asList(5,4,2,1);


        List<Integer> actual = PrimitiveCalculator.optimal_sequence(n);

        assertThat(actual, is(equalTo(expected)));
    }
}