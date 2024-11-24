package Matrix;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LuckyNumbers {
    public static void main(String[] args) {
        int[][] matrix = {
                {3, 7, 8},
                {9, 11, 13},
                {15, 16, 17}
        };

        int[][] matrix2 = {
                {1,10,4,2},
                {9,3,8,7},
                {15,16,17,12}
        };
        System.out.println(luckyNumbers(matrix));
        System.out.println(luckyNumbers(matrix2));
    }

    private static List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> luckyNumbers = new ArrayList<>();
        List<Integer> minInRow = new ArrayList<>();
        List<Integer> maxInCol = new ArrayList<>();

        for (int i = 0; i < matrix.length; i++) {
            int minimum = matrix[i][0];
            for (int j = 1; j < matrix[0].length; j++) {
                if(matrix[i][j] < minimum){
                    minimum = matrix[i][j];
                }
            }
            minInRow.add(minimum);
        }
        System.out.println(minInRow);

        for (int i = 0; i < matrix[0].length; i++) {
            int maximum = matrix[0][i];
            for (int j = 0; j < matrix.length; j++) {
                if(matrix[j][i] > maximum){
                    maximum = matrix[j][i];
                }
            }
            maxInCol.add(maximum);
        }

        for (int i = 0; i < minInRow.size(); i++) {
            if(maxInCol.contains(minInRow.get(i))){
                luckyNumbers.add(minInRow.get(i));
            }
        }

        System.out.println(maxInCol);

        return luckyNumbers;
    }

}
