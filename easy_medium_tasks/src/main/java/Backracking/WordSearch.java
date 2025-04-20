package Backracking;

public class WordSearch {
    public static void main(String[] args) {
       char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
       String word = "ABCCED";

       System.out.println(exist(board, word));
    }

    private static boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(dfs(board, word, i, j, 0)) return true;
            }
        }
        return false;
    }

    private static boolean dfs(char[][] board, String word, int row, int col, int index){

        if(index == word.length()) return true;

        if(row < 0 || row >= board.length || col < 0 || col >= board[0].length) return false;

        if(board[row][col] != word.charAt(index)) return false;

        char temp = board[row][col];
        board[row][col] = '#';

        int[][] directions = {
                {0, 1}, // вправо
                {0, -1}, //вліво
                {1, 0}, //вниз
                {-1, 0} //вгору
        };

        for(int[] dir : directions){
            if(dfs(board, word, row + dir[0], col + dir[1], index + 1)) return true;
        }

        board[row][col] = temp;

        return false;
    }

}
