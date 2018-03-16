package io.github.topefremov.algs.fibonacci;

import java.util.Scanner;

/**
 *
 * @author efrem
 */
public class Fibonacci {
    public static long calc_fib(int n) {
        if (n <= 1) {
            return n;
        }

        return calc_fib(n - 1) + calc_fib(n - 2);
    }
    
    public static long calc_fib_efficiently(int n) {
        if (n <= 1)
            return n;
        int[] fibs = new int[n+1];
        fibs[0] = 0;
        fibs[1] = 1;
        for (int i = 2; i <= n; i++)
            fibs[i] = fibs[i-1] + fibs[i-2];
        return fibs[n];
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        System.out.println(calc_fib(n));
    }
}
