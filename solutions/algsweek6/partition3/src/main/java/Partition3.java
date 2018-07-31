import java.util.*;

public class Partition3 {
    static boolean partition3(int[] A) {

        int sum = Arrays.stream(A).sum();

        if (sum % 3 != 0) {
            return false;
        }

        boolean[][][] matrix = new boolean[sum/3+1][sum/3+1][A.length+1];
        for (int k = 0; k <= A.length; k++) {
            matrix[0][0][k] = true;
        }

        for (int i = 1; i <= sum/3; i++) {
            for (int j = 1; j <= sum/3; j++) {
                for (int k = 1; k <= A.length; k++) {
                    if (i - A[k-1] >= 0 && j - A[k-1] >= 0) {
                        matrix[i][j][k] = matrix[i][j][k-1] || matrix[i-A[k-1]][j-A[k-1]][k-1];

                    } else {
                        matrix[i][j][k] = matrix[i][j][k-1];
                    }
                }
            }
        }

        return matrix[sum/3][sum/3][A.length];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = scanner.nextInt();
        }
        System.out.println(partition3(A));
    }
}
