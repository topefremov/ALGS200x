/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.topefremov.algs.fibonacci_partial_sum_lastdigit;

import io.github.topefremov.algs.fibonaccisumlastdigit.FibonacciSumLastDigit;

/**
 *
 * @author efrem
 */
public class FibonacciPartialSum {

    public static long getFibonacciPartialSumNaive(long from, long to) {
        long sum = 0;

        long current = 0;
        long next = 1;

        for (long i = 0; i <= to; ++i) {
            if (i >= from) {
                sum += current;
            }

            long new_current = next;
            next = next + current;
            current = new_current;
        }

        return sum % 10;
    }
    
    public static long getFibonacciPartialSumEfficient(long from, long to) {
        long upperBoundResult = FibonacciSumLastDigit.getFibonacciSumEfficient(to);
        long lowerBoudResult = FibonacciSumLastDigit.getFibonacciSumEfficient(from-1);
        long result = upperBoundResult - lowerBoudResult;
        return result < 0 ? result + 10 : result;
    }
}
