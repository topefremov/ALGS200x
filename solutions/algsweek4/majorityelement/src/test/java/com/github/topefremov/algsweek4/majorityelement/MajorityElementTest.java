package com.github.topefremov.algsweek4.majorityelement;

import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.Random;

import static com.github.topefremov.algsweek4.majorityelement.MajorityElement.*;
import static org.junit.Assert.*;

public class MajorityElementTest {

    private Random r = new Random();
    private InputStream in;
    private int a[];

    private static int NUMBER_OF_ELEMENTS_MAX = 25;
    private static int ELEMENTS_MAX = 10;



    @Before
    public void loadInput() {
        ClassLoader classLoader = getClass().getClassLoader();
        in = classLoader.getResourceAsStream("majority_element.txt");
        FastScanner scanner = new FastScanner(in);
        int n = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
    }

    @Test
    public void majorityElementTest1() {
        int[] arr = new int[] {2, 3, 9, 2, 2};
        assertEquals(2, getMajorityElement(arr, 0, arr.length - 1));
        assertEquals(2, getMajorityElementNaive(arr));
    }

    @Test
    public void majorityElementTest2() {
        int[] arr = new int[] {3, 3, 3, 2, 2, 3};
        assertEquals(3, getMajorityElement(arr, 0, arr.length - 1));
        assertEquals(3, getMajorityElementNaive(arr));
    }

    @Test
    public void majorityElementTest3() {
        int[] arr = new int[] {1, 2, 3, 4};
        assertEquals(-1, getMajorityElement(arr, 0, arr.length - 1));
        assertEquals(-1, getMajorityElementNaive(arr));
    }

    @Test
    public void majorityElementTest4() {
        int[] arr = new int[] {1, 2, 3, 1};
        assertEquals(-1, getMajorityElement(arr, 0, arr.length - 1));
        assertEquals(-1, getMajorityElementNaive(arr));
    }

    @Test
    public void majorityElementTest5() {
        int[] arr = new int[] {3, 0, 10, 0, 0, 5, 0, 10, 0, 6, 0, 0, 0};
        assertEquals(0, getMajorityElement(arr, 0, arr.length - 1));
        assertEquals(0, getMajorityElementNaive(arr));
    }



    @Test
    public void majorityElementTest6() {
        assertEquals(127472093, getMajorityElementNaive(this.a));
    }

    @Test
    public void majorityElementTest7() {
        assertEquals(127472093, getMajorityElement(this.a, 0, this.a.length - 1));
    }

    @Test
    public void majorityElementTest() {
        for (int i = 0; i <= 100000; i++) {
            int [] arr = generateDataset();
            printDataset(arr);
            int majorityElementNaiveResult = getMajorityElementNaive(arr);
            int majorityElementResult = getMajorityElement(arr, 0, arr.length - 1);
            printResult("majorityElementNaive", majorityElementNaiveResult);
            printResult("majorityElementResult", majorityElementResult);
            assertEquals(majorityElementNaiveResult, majorityElementResult);
        }
    }

    private int[] generateDataset() {
        int[] arr = new int[r.nextInt(NUMBER_OF_ELEMENTS_MAX) + 1];
        for (int j = 0; j < arr.length; j++) {
            arr[j] = r.nextInt(ELEMENTS_MAX + 1);
        }
        return arr;
    }

    private void printDataset(int[] arr) {
        System.out.print("Dataset: ");
        for (int anArr : arr) System.out.print(anArr + ", ");
        System.out.println();
    }

    private void printResult(String of, int result) {
        System.out.println();
        System.out.print("Result of " + of + " is " + result);
        System.out.println();
    }
}
