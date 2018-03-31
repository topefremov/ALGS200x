package com.github.topefremov.algsweek4.binarysearch;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static com.github.topefremov.algsweek4.binarysearch.BinarySearch.*;
import static org.junit.Assert.*;

public class BinarySearchTest {

    private int[] arr;

    @Before
    public void  init() {
        arr = new int[] {1, 5, 8, 12, 13};
    }

    @Test
    public void binarySearchTest_shouldReturn2() {
        assertEquals(2, binarySearch(arr, 8));
    }

    @Test
    public void binarySearchTest_shouldReturn0() {
        assertEquals(0, binarySearch(arr, 1));
    }

    @Test
    public void binarySearchTest_shouldNotFind1() {
        assertEquals(-1, binarySearch(arr, 23));
    }

    @Test
    public void binarySearchTest_shouldNotFind2() {
        assertEquals(-1, binarySearch(arr, 11));
    }
}
