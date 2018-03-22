/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.topefremov.algs.hugefibonaccci;

/**
 *
 * @author efrem
 */
public class HugeFibonacci {
    
    public static long getFibonacciModulo(long n, long m) {
        if (n <= 1)
            return n;

        long previous = 0;
        long current  = 1;

        for (int i = 0; i < n - 1; ++i) {
            long tmpPrevious = previous;
            previous = current;
            current = (tmpPrevious + current) % m;
        }

        return current;
    }
    
    public static long getPisanoPeriodLength(long m) {
        if (m < 2) {
            throw new IllegalArgumentException("m should be greater or equal to 2");
        }
        if (m == 2) {
            return 3;
        }

        int seqLenght = 0;
        long previous = 0;
        long current = 1;
        long next = -1;
        long nextPlus1 = -1;

        while (next != 0 || nextPlus1 != 1) {
            seqLenght += 2;
            next = (previous + current) % m;
            nextPlus1 = (current + next) % m;
            previous = next;
            current = nextPlus1;
        }

        return seqLenght;
    }
    
    public static long getFibonacciHuge(long n, long m) {
        long pisanoPeriod = getPisanoPeriodLength(m);
        long remainder = n % pisanoPeriod;
        return getFibonacciModulo(remainder, m);
    }
}
