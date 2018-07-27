package com.github.topefremov.algsweek5.dpchange;

import java.util.Scanner;

class DPChange {

    private static final int[] denominations = new int[] { 1, 3, 4 };

    static int getChange(int m) {
        int[] minCoinsChange = new int[m+1];
        minCoinsChange[0] = 0;
        for (int i = 1; i <= m; i++) {
            minCoinsChange[i] = Integer.MAX_VALUE;
            for (int d : denominations) {
                if (i >= d) {
                    int minCoins = minCoinsChange[i - d] + 1;
                    if (minCoins < minCoinsChange[i]) {
                        minCoinsChange[i] = minCoins;
                    }
                }
            }
        }
        return minCoinsChange[m];
    }

    static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}
