package com.github.topefremov.algs.week3.maximizingloot;

import java.util.Scanner;

public class FractionalKnapsack {

    public static int getBestItem(int values[], int[] weights) {
        if (values.length != weights.length)
            throw new IllegalArgumentException("values and weights must be equal in length");

        double maxValuePerWait = 0;
        int bestItem = 0;
        for (int i = 0; i < values.length; i++) {
            if (weights[i] > 0) {
                double candidate = (double) values[i] / weights[i];
                if (candidate > maxValuePerWait) {
                    maxValuePerWait = candidate;
                    bestItem = i;
                }
            }
        }
        return bestItem;
    }

    public static double getOptimalValue(int capacity, int[] values, int[] weights) {
        if (values.length != weights.length)
            throw new IllegalArgumentException("values and weights must be equal in length");

        int[] valuesCopy = values.clone();
        int[] weightsCopy = weights.clone();
        double resultValue = 0;

        for (int i = 0; i < values.length; i++) {
            if (capacity <= 0)
                return resultValue;
            int bestItemIndex = getBestItem(valuesCopy, weightsCopy);
            int minusWeight = Math.min(weightsCopy[bestItemIndex], capacity);
            resultValue += minusWeight * ((double) valuesCopy[bestItemIndex]/weightsCopy[bestItemIndex]);
            capacity -= minusWeight;
            weightsCopy[bestItemIndex] -= minusWeight;
        }
        return resultValue;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }
        System.out.println(getOptimalValue(capacity, values, weights));
    }
}
