package com.github.topefremov.algs3.week3.dotproduct;

import com.github.topefremov.algs.week3.dotproduct.DotProduct;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class DotProductTest {

    @Test
    public void getMaxValueIndexTest() {
        int[] arr1 = new int[] {3, 2, 10, 1, 3};
        int[] arr2 = new int[] {10, 23, 33, 51, 23};
        int[] expected1 = new int[] {2, 3};
        int[] expected2 = new int[] {4, 3};
        assertArrayEquals(expected1, DotProduct.maxValueIndices(arr1, arr2, 0));
        assertArrayEquals(expected2, DotProduct.maxValueIndices(arr1, arr2, 3));
    }

    @Test
    public void swapTest() {
        int[] arr = new int[] {10, 23, 33, 51, 23};
        int[] expected = new int[] {10, 23, 51, 33 , 23};
        assertArrayEquals(expected, DotProduct.swap(arr, 2, 3));
    }

    @Test
    public void maxDotProductTest1() {
        int[] arr1 = new int[] {23};
        int[] arr2 = new int[] {39};
        assertEquals(897, DotProduct.maxDotProduct(arr1, arr2));
    }

    @Test
    public void maxDotProductTest2() {
        int[] arr1 = new int[] {1, 3, -5};
        int[] arr2 = new int[] {-2, 4, 1};
        assertEquals(23, DotProduct.maxDotProduct(arr1, arr2));
    }
    @Test
    public void maxDotProductTest3() {
        int[] arr1 = new int[] {3138, 19637, 6760, 4043, 26759};
        int[] arr2 = new int[] {21038, 40042, 12934, 39516, 44685};
        assertEquals(2374802355L, DotProduct.maxDotProduct(arr1, arr2));
    }

    @Test
    public void maxDotProductTest4() {
        int[] arr1 = new int[1000];
        int[] arr2 = new int[1000];
        for (int i = 0; i < 1000; i++) {
            arr1[i] = 100000;
            arr2[i] = 100000;
        }
        assertEquals(10000000000000L, DotProduct.maxDotProduct(arr1, arr2));
    }
}
