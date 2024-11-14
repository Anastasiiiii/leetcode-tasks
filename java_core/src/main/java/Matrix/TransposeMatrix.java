package Matrix;

import java.util.Arrays;

public class TransposeMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {2, 4, -1},
                {-10, 5, 11},
                {18, -7, 6}
        };

        System.out.println(Arrays.deepToString(transpose(matrix)));

        int[][] matrix2 = {{1,2,3},{4,5,6}};
        System.out.println(Arrays.deepToString(transpose(matrix2)));
    }

    private static int[][] transpose(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] transposedMatrix = new int[m][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                transposedMatrix[j][i] = matrix[i][j];
            }
        }

        return transposedMatrix;
    }
}
