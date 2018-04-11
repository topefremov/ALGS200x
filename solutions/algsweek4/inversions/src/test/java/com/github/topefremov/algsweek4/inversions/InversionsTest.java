package com.github.topefremov.algsweek4.inversions;

import org.junit.Test;

import java.io.InputStream;
import java.util.Scanner;

import static com.github.topefremov.algsweek4.inversions.Inversions.*;
import static org.junit.Assert.*;

public class InversionsTest {

    @Test
    public void mergeTest1() {
        int[] a = new int[] {3, 2};
        int[] b = new int[a.length];
        int[] expected = new int[] {2, 3};
        long numberOfInversions = merge(a, b, 0, 1, 1, 2);
        assertArrayEquals(expected, a);
        assertEquals(1, numberOfInversions);
    }

    @Test
    public void mergeTest2() {
        int[] a = new int[] {2, 3};
        int[] b = new int[a.length];
        int[] expected = new int[] {2, 3};
        long numberOfInversions = merge(a, b, 0, 1, 1, 2);
        assertArrayEquals(expected, a);
        assertEquals(0, numberOfInversions);
    }

    @Test
    public void mergeTest3() {
        int[] a = new int[] {9, 2, 9};
        int[] b = new int[a.length];
        int[] expected = new int[] {2, 9, 9};
        long numberOfInversions = merge(a, b, 0, 1, 1, 3);
        assertArrayEquals(expected, a);
        assertEquals(1, numberOfInversions);
    }

    @Test
    public void mergeTest4() {
        int[] a = new int[] {2, 3, 2, 9, 9};
        int[] b = new int[a.length];
        int[] expected = new int[] {2, 2, 3, 9, 9};
        long numberOfInversions = merge(a, b, 0, 2, 2, 5);
        assertArrayEquals(expected, a);
        assertEquals(1, numberOfInversions);
    }

    @Test
    public void getNumberOfInversionsTest1() {
        int[] a = new int[] {2, 3, 9, 2, 9};
        int[] b = new int[a.length];
        int[] expected = new int[] {2, 2, 3, 9, 9};
        long numberOfInversions = getNumberOfInversions(a, b, 0, a.length);
        assertArrayEquals(expected, a);
        assertEquals(2, numberOfInversions);
    }

    @Test
    public void getNumberOfInversionsTest2() {
        int[] a = new int[] {4, 3, 2, 1};
        int[] b = new int[a.length];
        int[] expected = new int[] {1, 2, 3, 4};
        long numberOfInversions = getNumberOfInversions(a, b, 0, a.length);
        assertArrayEquals(expected, a);
        assertEquals(6, numberOfInversions);
    }

    @Test
    public void getNumberOfInversionsTest3() {
        int[] a = new int[] {5, 4, 3, 2, 1};
        int[] b = new int[a.length];
        int[] expected = new int[] {1, 2, 3, 4, 5};
        long numberOfInversions = getNumberOfInversions(a, b, 0, a.length);
        assertArrayEquals(expected, a);
        assertEquals(10, numberOfInversions);
    }

    @Test
    public void getNumberOfInversionsTest4() {
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream in = classLoader.getResourceAsStream("inversions.txt");
        Scanner scanner = new Scanner(in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int[] b = new int[n];
        assertEquals(76669230, getNumberOfInversions(a, b, 0, a.length));
    }
}
