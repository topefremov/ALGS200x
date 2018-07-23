package com.github.topefremov.algsweek5.primcalc;

import java.util.*;
import java.util.stream.IntStream;

public class PrimitiveCalculator {


    private static String[] operations = { "DIVIDE_BY_3", "DIVIDE_BY_2", "MINUS_1" };

    private static boolean isOperationApplied(String operation, int value) {
        switch (operation) {
            case "DIVIDE_BY_3":
                return value % 3 == 0;
            case "DIVIDE_BY_2":
                return value % 2 == 0;
            case "MINUS_1":
                return true;
            default:
                return false;
        }
    }

    private static int applyOperation(String operation, int value) {
        switch (operation) {
            case "DIVIDE_BY_3":
                return value / 3;
            case "DIVIDE_BY_2":
                return value / 2;
            case "MINUS_1":
                return value - 1;
            default:
                throw new IllegalArgumentException("There is no such operation: " + operation);
        }
    }

    static List<Integer> optimal_sequence(int n) {
//        Map<Integer, Integer> variants = new HashMap<>();
//        variants.put(1, 0);
//
//        int minOps;
//        int m;
//        for (int i = 2; i <= n; i++) {
//            minOps = Integer.MAX_VALUE;
//            for (String operation : operations) {
//                if (isOperationApplied(operation, i)) {
//                    m = variants.get(applyOperation(operation, i)) + 1;
//                    if (m < minOps) {
//                        minOps = m;
//                    }
//                }
//            }
//            variants.put(i, minOps);
//        }
//
//
//        List<Integer> sequence = new ArrayList();
//        sequence.add(n);
//        int minSequenceLength = variants.get(n);
//
//        while (n > 1) {
//            for (String operation: operations) {
//                if (isOperationApplied(operation, n)) {
//                    int temp = applyOperation(operation, n);
//                    if (variants.get(temp) < minSequenceLength) {
//                        n = temp;
//                        sequence.add(n);
//                        minSequenceLength--;
//                        break;
//                    }
//                }
//            }
//        }
//
//        return sequence;

        List<Integer> result = constructMinSeq(minOps(n));
        Collections.reverse(result);
        return result;
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
