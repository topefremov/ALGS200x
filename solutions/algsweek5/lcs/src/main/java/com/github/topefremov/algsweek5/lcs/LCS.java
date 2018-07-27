package com.github.topefremov.algsweek5.lcs;

import java.util.Scanner;
import java.util.stream.IntStream;

class LCS {
    static int lcs2(int[] a, int[] b) {
        int[][] matrix = new int[a.length + 1][b.length + 1];

        for (int i = 1; i <= a.length; i++) {
            for (int j = 1; j <= b.length; j++) {

                int var1 = IntStream.of(matrix[i][j-1], matrix[i-1][j]).max().getAsInt();
                int var2 = matrix[i-1][j-1] + 1;

                if (a[i-1] != b[j-1]) {
                    matrix[i][j] = var1;
                } else {
                    matrix[i][j] = var2;
                }
            }
        }

        return matrix[a.length][b.length];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        int m = scanner.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = scanner.nextInt();
        }

        System.out.println(lcs2(a, b));
    }
}
