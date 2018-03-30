package com.github.topefremov.algs.week3.largestnumber;

import java.util.Scanner;

public class LargestNumber {

    /**
     * Function takes a minimum number of the first digits of input args(2, 21 => 1),
     * and compares this amount of first digits (2 and 2 in the example above).
     *
     * @param dig1 digit
     * @param dig2 max digit
     * @return true if first digits of dig1 greater than or equal to dig2, otherwise false
     */
    static boolean isGreaterOrEqual(String dig1, String dig2) {
        int minAmount = Math.min(dig1.length(), dig2.length());
        int firstDigts1 = Integer.valueOf(dig1.substring(0, minAmount));
        int firstDigts2 = Integer.valueOf(dig2.substring(0, minAmount));
        return firstDigts1 > firstDigts2 || firstDigts1 == firstDigts2 && dig1.length() <= dig2.length();
    }

    static String largestNumber(String[] a) {
        String[] aCopy = a.clone();
        StringBuilder result = new StringBuilder();
        for (String ignored : a) {
            String maxDigit = "0";
            int maxDigitIndex = -1;
            for (int j = 0; j < aCopy.length; j++) {
                if (aCopy[j] != null && isGreaterOrEqual(aCopy[j], maxDigit)) {
                    maxDigit = aCopy[j];
                    maxDigitIndex = j;
                }
            }
            result.append(maxDigit);
            aCopy[maxDigitIndex] = null;
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] a = new String[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.next();
        }
        System.out.println(largestNumber(a));
    }
}
