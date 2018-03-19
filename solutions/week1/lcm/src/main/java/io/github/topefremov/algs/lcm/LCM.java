/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.topefremov.algs.lcm;

import java.util.Scanner;
import static io.github.topefremov.algs.gcd.GCD.gcdEfficient;

/**
 *
 * @author efrem
 */
public class LCM {

    public static long lcm_naive(int a, int b) {
        for (long l = 1; l <= (long) a * b; ++l) {
            if (l % a == 0 && l % b == 0) {
                return l;
            }
        }

        return (long) a * b;
    }
    
    public static long lcmEfficient(int a, int b) {
        return ((long) a*b)/ gcdEfficient(a, b);
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        System.out.println(lcm_naive(a, b));
    }

}
