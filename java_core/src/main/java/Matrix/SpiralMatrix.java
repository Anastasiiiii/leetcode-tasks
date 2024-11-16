package Matrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        System.out.println(spiralOrder(matrix));
    }

    private static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> spiralMatrix = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return spiralMatrix;
        }

        int top = 0, bottom = matrix.length - 1, left = 0, right = matrix[0].length - 1;

        while (top <= bottom && left <= right) {
            // Прохід зліва направо по верхньому рядку
            for (int i = left; i <= right; i++) {
                spiralMatrix.add(matrix[top][i]);
            }
            top++;

            // Прохід зверху вниз по правому стовпцю
            for (int i = top; i <= bottom; i++) {
                spiralMatrix.add(matrix[i][right]);
            }
            right--;

            // Прохід справа наліво по нижньому рядку
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    spiralMatrix.add(matrix[bottom][i]);
                }
                bottom--;
            }

            // Прохід знизу вверх по лівому стовпцю
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    spiralMatrix.add(matrix[i][left]);
                }
                left++;
            }
        }

        return spiralMatrix;
    }

}
