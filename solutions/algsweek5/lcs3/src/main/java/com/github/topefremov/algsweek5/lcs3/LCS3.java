package com.github.topefremov.algsweek5.lcs3;

import java.util.Scanner;
import java.util.stream.IntStream;

public class LCS3 {
    static int lcs3(int[] a, int[] b, int[] c) {
        int[][][] matrix = new int[a.length + 1][b.length + 1][c.length + 1];

        for (int i = 1; i <= a.length; i++) {
            for (int j = 1; j <= b.length; j++) {
                for (int k = 1; k <= c.length; k++) {
                    int var1 = IntStream.of(matrix[i][j-1][k], matrix[i-1][j][k], matrix[i][j][k-1]).max().getAsInt();
                    int var2 = matrix[i-1][j-1][k-1] + 1;

                    if (a[i-1] != b[j-1] || b[j-1] != c[k-1] || a[i-1] != c[k-1]) {
                        matrix[i][j][k] = var1;
                    } else {
                        matrix[i][j][k] = var2;
                    }
                }
            }
        }

        return matrix[a.length][b.length][c.length];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int an = scanner.nextInt();
        int[] a = new int[an];
        for (int i = 0; i < an; i++) {
            a[i] = scanner.nextInt();
        }
        int bn = scanner.nextInt();
        int[] b = new int[bn];
        for (int i = 0; i < bn; i++) {
            b[i] = scanner.nextInt();
        }
        int cn = scanner.nextInt();
        int[] c = new int[cn];
        for (int i = 0; i < cn; i++) {
            c[i] = scanner.nextInt();
        }
        System.out.println(lcs3(a, b, c));
    }
}
