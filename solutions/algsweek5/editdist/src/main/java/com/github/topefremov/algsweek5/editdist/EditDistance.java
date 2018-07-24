package com.github.topefremov.algsweek5.editdist;

import java.util.Scanner;
import java.util.stream.IntStream;

class EditDistance {
    public static int editDistance(String s, String t) {
        int[][] matrix = new int[s.length()+1][t.length()+1];

        for (int i = 0; i < matrix.length; i++) {
            matrix[i][0] = i;
        }

        for (int j = 0; j < matrix[0].length; j++) {
            matrix[0][j] = j;
        }

        int insertion, deletion, match, mismatch;

        for (int j = 1; j <= t.length(); j++) {
            for (int i = 1; i <= s.length(); i++ ) {
                insertion = matrix[i][j - 1] + 1;
                deletion = matrix[i - 1][j] + 1;
                match = matrix[i - 1][j - 1];
                mismatch = matrix[i - 1][j - 1]  + 1;
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    matrix[i][j] = IntStream.of(insertion, deletion, match).min().getAsInt();
                } else {
                    matrix[i][j] = IntStream.of(insertion, deletion, mismatch).min().getAsInt();
                }
            }
        }

        return matrix[s.length()][t.length()];
    }
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);

        String s = scan.next();
        String t = scan.next();

        System.out.println(editDistance(s, t));
    }

}
