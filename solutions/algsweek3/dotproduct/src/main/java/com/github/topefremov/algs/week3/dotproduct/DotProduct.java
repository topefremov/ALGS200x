package com.github.topefremov.algs.week3.dotproduct;

import java.util.*;

public class DotProduct {

    public static int[] maxValueIndices(int[] arr1, int[] arr2, int startWithIndex) {
        if (arr1.length != arr2.length) throw new IllegalStateException("lengths must be equal");
        int maxValueIndexArr1 = startWithIndex, maxValueIndexArr2 = startWithIndex;
        for (int i = startWithIndex; i < arr1.length; i++) {
            if (arr1[i] > arr1[maxValueIndexArr1]) maxValueIndexArr1 = i;
            if (arr2[i] > arr2[maxValueIndexArr2]) maxValueIndexArr2 = i;
        }
        return new int[] {maxValueIndexArr1, maxValueIndexArr2};
    }

    public  static int[] swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
        return arr;
    }

    public static long maxDotProduct(int[] a, int[] b) {
        if (a.length != b.length) throw new IllegalStateException("lengths must be equal");
        long result = 0;
        int[] maxValueIndices;
        for (int i = 0; i < a.length; i++) {
            maxValueIndices = maxValueIndices(a, b, i);
            result += (long) a[maxValueIndices[0]] * b[maxValueIndices[1]];
            swap(a, i, maxValueIndices[0]);
            swap(b, i, maxValueIndices[1]);
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            b[i] = scanner.nextInt();
        }
        System.out.println(maxDotProduct(a, b));
    }
}


