import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.LongStream;

import static java.lang.Character.getNumericValue;

public class PlacingParentheses {
    /**
     * @param exp mathematical expression as String consisting of integers and
     *            operations in set {+,-,*}. Must be in format 1+2+3+2*24-2
     * @return maximum value of exp
     */
    static long getMaximValue(String exp) {

        if (exp.length() < 3) {
            throw new IllegalArgumentException("exp size must be greater than or equal to 3 ");
        }

        List<Integer> digits = new ArrayList<>();
        digits.add(getNumericValue(exp.charAt(0)));
        List<Character> ops = new ArrayList<>();
        for (int i = 2; i < exp.length(); i += 2) {
            digits.add(getNumericValue(exp.charAt(i)));
            ops.add(exp.charAt(i-1));
        }
        long[][] minMatrix = new long[digits.size()+1][digits.size()+1];
        long[][] maxMatrix = new long[digits.size()+1][digits.size()+1];

        for (int i = 1; i <= digits.size(); i++) {
            minMatrix[i][i] = digits.get(i-1);
            maxMatrix[i][i] = digits.get(i-1);
        }

        for (int s = 1; s < digits.size(); s++) {
            for (int i = 1; i <= digits.size() - s; i++) {
                int j = i + s;

                long max = Integer.MIN_VALUE;
                long min = Integer.MAX_VALUE;

                for (int k = i; k <= j-1; k++) {
                    long a = eval(maxMatrix[i][k], maxMatrix[k+1][j], ops.get(k-1));
                    long b = eval(maxMatrix[i][k], minMatrix[k+1][j], ops.get(k-1));
                    long c = eval(minMatrix[i][k], maxMatrix[k+1][j], ops.get(k-1));
                    long d = eval(minMatrix[i][k], minMatrix[k+1][j], ops.get(k-1));
                    min = LongStream.of(min, a, b, c, d).min().getAsLong();
                    max = LongStream.of(max, a, b, c, d).max().getAsLong();
                }

                minMatrix[i][j] = min;
                maxMatrix[i][j] = max;
            }
        }

        return maxMatrix[1][digits.size()];
    }

    private static long eval(long a, long b, char op) {
        if (op == '+') {
            return a + b;
        } else if (op == '-') {
            return a - b;
        } else if (op == '*') {
            return a * b;
        } else {
            assert false;
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String exp = scanner.next();
        System.out.println(getMaximValue(exp));
    }
}
