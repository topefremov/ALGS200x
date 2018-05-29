package com.github.topefremov.algsweek4.lottery;

import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.Arrays;
import java.util.Scanner;

import static com.github.topefremov.algsweek4.lottery.PointsAndSegments.*;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class PointsAndSegmentsTest {

    private InputStream in;
    private int[] starts, ends, points;

    public void loadInput() {
        ClassLoader classLoader = getClass().getClassLoader();
        in = classLoader.getResourceAsStream("4_5_lottery.txt");
        Scanner scanner = new Scanner(in);
        int n, m;
        n = scanner.nextInt();
        m = scanner.nextInt();
        this.starts = new int[n];
        this.ends = new int[n];
        this.points = new int[m];
        for (int i = 0; i < n; i++) {
            starts[i] = scanner.nextInt();
            ends[i] = scanner.nextInt();
        }
        for (int i = 0; i < m; i++) {
            points[i] = scanner.nextInt();
        }
    }

    @Test
    public void fastCountSegmentsTest1() {
        int[] starts = new int[] { 0, 7 };
        int[] ends = new int[] { 5, 10 };
        int[] points = new int[] { 1, 6, 11 };
        int[] expected = new int[] { 1, 0, 0 };
        assertArrayEquals(expected, fastCountSegments(starts, ends, points));
    }

    @Test
    public void fastCountSegmentsTest2() {
        int[] starts = new int[] { -10 };
        int[] ends = new int[] { 10 };
        int[] points = new int[] { -100, 100, 0 };
        int[] expected = new int[] { 0, 0, 1 };
        assertArrayEquals(expected, fastCountSegments(starts, ends, points));
    }

    @Test
    public void fastCountSegmentsTest3() {
        int[] starts = new int[] { 0, -3, 7 };
        int[] ends = new int[] { 5, 2, 10 };
        int[] points = new int[] { 1, 6 };
        int[] expected = new int[] { 2, 0 };
        assertArrayEquals(expected, fastCountSegments(starts, ends, points));
    }

    @Test
    public void fastCountSegmentsMainTest() {
        loadInput();
        int[] cnt = fastCountSegments(this.starts, this.ends, this.points);
        assertEquals(15980463, Arrays.stream(cnt).summaryStatistics().getSum());
    }
}
