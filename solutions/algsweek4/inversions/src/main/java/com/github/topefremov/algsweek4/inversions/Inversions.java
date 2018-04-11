package com.github.topefremov.algsweek4.inversions;

import java.util.Scanner;

public class Inversions {

    static long merge(int[] a, int[] b, int left1, int right1, int left2, int right2) {
        long numberOfInversions = 0;
        System.arraycopy(a, 0, b, 0, right2);
        int i = left1;
        while(left1 != right1 && left2 != right2) {
            int el_1 = b[left1];
            int el_2 = b[left2];
            if (el_1 <= el_2) {
               a[i] = el_1;
               left1++;
            } else {
                numberOfInversions += right1 - left1;
                a[i] = el_2;
                left2++;
            }
            i++;
        }

        for(;left1 < right1; left1++, i++)
            a[i] = b[left1];
        for(;left2 < right2; left2++, i++)
            a[i] = b[left2];

        return numberOfInversions;
    }

    static long getNumberOfInversions(int[] a, int[] b, int left, int right) {
        long numberOfInversions = 0;
        if (right <= left + 1) {
            return numberOfInversions;
        }
        int ave = (left + right) / 2;
        numberOfInversions += getNumberOfInversions(a, b, left, ave);
        numberOfInversions += getNumberOfInversions(a, b, ave, right);
        numberOfInversions += merge(a, b, left, ave, ave, right);
        return numberOfInversions;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int[] b = new int[n];
        System.out.println(getNumberOfInversions(a, b, 0, a.length));
    }
}
