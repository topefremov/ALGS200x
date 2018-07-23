package com.github.topefremov.algsweek5.primcalc;

import java.util.*;
import java.util.stream.IntStream;

public class PrimitiveCalculator {

    static List<Integer> optimal_sequence(int n) {
        return constructMinSeq(minOps(n));
    }

    private static int[] minOps(int n) {
        int[] minOps = new int[n + 1];
        minOps[1] = 0;

        int min1, min2, min3;

        for (int i = 2; i <= n; i++) {
            min1 = minOps[i-1] + 1;
            min2 = Integer.MAX_VALUE;
            min3 = Integer.MAX_VALUE;

            if (i % 2 == 0)
                min2 = minOps[i/2] + 1;

            if (i % 3 == 0) {
                min3 = minOps[i/3] + 1;
            }

            minOps[i] = IntStream.of(min1, min2, min3).min().getAsInt();

        }

        return minOps;
    }

    private static List<Integer> constructMinSeq(int[] minOps) {
        int n = minOps.length - 1;
        List<Integer> seq = new ArrayList<>(Arrays.asList(n));
        int minSeqLen = minOps[n];
        int temp;
        while (n > 1) {
            if (n % 3 == 0 && (minSeqLen - minOps[n/3]) == 1) {
                temp = n / 3;
            } else  if (n % 2 == 0 && (minSeqLen - minOps[n/2]) == 1) {
                temp = n / 2;
            } else {
                temp = n - 1;
            }

            n = temp;
            seq.add(n);
            minSeqLen--;
        }
        Collections.reverse(seq);
        return seq;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> sequence = optimal_sequence(n);
        System.out.println(sequence.size() - 1);
        for (Integer x : sequence) {
            System.out.print(x + " ");
        }
    }
}
