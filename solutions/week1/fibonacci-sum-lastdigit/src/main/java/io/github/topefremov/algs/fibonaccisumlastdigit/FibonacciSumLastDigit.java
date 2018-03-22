/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.topefremov.algs.fibonaccisumlastdigit;

import io.github.topefremov.algs.hugefibonaccci.HugeFibonacci;

/**
 *
 * @author efrem
 */
public class FibonacciSumLastDigit {
    public static long getFibonacciSumNaive(long n) {
        if (n <= 1)
            return n;

        long previous = 0;
        long current  = 1;
        long sum      = 1;

        for (long i = 0; i < n - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
            sum += current;
        }

        return sum % 10;
    }
    
    public static long getFibonacciSumEfficient(long n) {
        long result = HugeFibonacci.getFibonacciHuge(n+2, 10);
        return result == 0 ? 9 : result -1;
    }
}
