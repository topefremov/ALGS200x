/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.topefremov.algs.fibonacci.lastdigit;

import java.util.*;

/**
 * 
 * @author efrem
 */
public class FibonacciLastDigit {
    public static int getFibonacciLastDigitNaive(int n) {
        if (n <= 1)
            return n;

        int previous = 0;
        int current  = 1;

        for (int i = 0; i < n - 1; ++i) {
            int tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
        }

        return current % 10;
    }
    
    public static int getFibonacciLastDigitEfficient(int n) {
        if (n <= 1)
            return n;

        int previousLastDigit = 0;
        int currentLastDigit  = 1;

        for (int i = 0; i < n - 1; ++i) {
            int tmpPreviousLastDitit = previousLastDigit;
            previousLastDigit = currentLastDigit;
            currentLastDigit = (tmpPreviousLastDitit + currentLastDigit) % 10;
        }

        return currentLastDigit;
    }
     
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int c = getFibonacciLastDigitNaive(n);
        System.out.println(c);
    }
}
