package com.github.topefremov.algsweek5.primcalc;

import java.util.*;

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
        Map<Integer, Integer> variants = new HashMap<>();
        variants.put(1, 0);

        int minOps;
        int m;
        for (int i = 2; i <= n; i++) {
            minOps = Integer.MAX_VALUE;
            for (String operation : operations) {
                if (isOperationApplied(operation, i)) {
                    m = variants.get(applyOperation(operation, i)) + 1;
                    if (m < minOps) {
                        minOps = m;
                    }
                }
            }
            variants.put(i, minOps);
        }


        List<Integer> sequence = new ArrayList();
        sequence.add(n);
        int minSequenceLength = variants.get(n);

        while (n > 1) {
            for (String operation: operations) {
                if (isOperationApplied(operation, n)) {
                    int temp = applyOperation(operation, n);
                    if (variants.get(temp) < minSequenceLength) {
                        n = temp;
                        sequence.add(n);
                        minSequenceLength--;
                        break;
                    }
                }
            }
        }

        return sequence;
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
