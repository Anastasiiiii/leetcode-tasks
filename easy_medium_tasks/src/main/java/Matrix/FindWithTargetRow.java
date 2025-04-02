package Matrix;

public class FindWithTargetRow {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 4, 7},
                {2, 5, 8},
                {3, 6, 9}
        };
        System.out.println(findWithTarget(matrix, 5));
    }

    private static int findWithTarget(int[][] matrix, int target){
        int rows = matrix.length, cols = matrix[0].length;
        int row = rows-1, col = 0;

        while(row >= 0 && col < cols){
            if(target < matrix[row][col]){
                row--;
            } else if (target > matrix[row][col]){
                col++;
            } else {
                return row;
            }
        }
        return -1;
    }
}
