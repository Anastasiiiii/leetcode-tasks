package Matrix;

public class CountLessThanTarget {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4},
                {2, 3, 4, 5},
                {3, 4, 5, 6},
                {4, 5, 6, 7}
        };

        System.out.println(countLessThan(matrix, 5));
    }

    private static int countLessThan(int[][] matrix, int target){
        int rows = matrix.length;
        int cols = matrix[0].length;

        int row = 0;
        int col = cols - 1;
        int count = 0;

        while (row < rows && col >= 0){
            if(matrix[row][col] < target){
                count += col + 1;
            } else if(matrix[row][col] >= target){
                col--;
            } else{
                row++;
            }
        }

        return count;
    }
}
