package com.github.topefremov.algs.week3.differentsummands;

import java.util.*;

public class DifferentSummands {
     static List<Integer> optimalSummands(int n) {
        if (n < 1) throw new IllegalArgumentException("n must be greate or equal to 1");
        List<Integer> summands = new ArrayList<>();
        int lastSummand;
        for (int i = 1; n > 0; i++) {
            lastSummand = i;
            n -= lastSummand;
            if (n <= lastSummand) {
                lastSummand += n;
                n = 0;
            }
            summands.add(lastSummand);
        }
        return summands;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> summands = optimalSummands(n);
        System.out.println(summands.size());
        for (Integer summand : summands) {
            System.out.print(summand + " ");
        }
    }
}
