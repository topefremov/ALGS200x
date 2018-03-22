package com.github.topefremov.algs.week3.moneychange;

import java.util.Scanner;

public class Change {
    public static int getChange(int m) {
        int remaining = m;
        int countOfCoins = 0;
        while (remaining != 0) {
            if (remaining >= 10)
                remaining -= 10;
            else if (remaining >= 5)
                remaining -= 5;
            else
                remaining -= 1;
            countOfCoins++;
        }
        return countOfCoins;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}
