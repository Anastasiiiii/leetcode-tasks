package Matrix;

import java.util.*;

public class ReshapeTheMatrix {
    public static void main(String[] args) {
        int[][] mat = {
                {1, 2},
                {3, 4}
        };
        int r = 1, c = 4;

        System.out.println(Arrays.deepToString(matrixReshape(mat, r, c)));
        System.out.println(Arrays.deepToString(matrixReshape2(mat, r, c)));
    }

    /*Reshape an m x n matrix into a new one with a different size r x c keeping its original data.*/
    private static int[][] matrixReshape(int[][] mat, int r, int c) {
        ArrayList<Integer> list = new ArrayList<>();
        int[][] newMat = new int[r][c];
        for (int[] ints : mat) {
            for (int j = 0; j < mat[0].length; j++) {
                list.add(ints[j]);
            }
        }

        for (int i = 0; i < newMat.length; i++) {
            for (int j = 0; j < newMat[0].length; j++) {
                newMat[i][j] = list.getFirst();
                list.removeFirst();
            }
        }

        return newMat;
    }

    private static int[][] matrixReshape2(int[][] mat, int r, int c) {
        int n = mat.length;
        int m = mat[0].length;

        if (m * n != r * c) {
            System.out.println("Reshaping the array is not possible");
            return mat;
        }

        int[][] newMat = new int[r][c];
        int[] temp = new int[m * n];

        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                temp[index++] = mat[i][j];
            }
        }

        index = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                newMat[i][j] = temp[index++];
            }
        }

        return newMat;
    }
}
