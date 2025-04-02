package Matrix;

import java.util.Arrays;

public class TicTacToe {
    public static void main(String[] args) {
        int[][] moves = {{0,0},{1,1},{0,1},{0,2},{1,0},{2,0}};
        System.out.println(tictactoe(moves));
    }

    private static String tictactoe(int[][] moves) {
        String[][] field = new String[3][3];
        int row = 0;
        while (row < moves.length){
            if(row % 2 == 0){
                field[moves[row][0]][moves[row][1]] = "A";
            } else {
                field[moves[row][0]][moves[row][1]] = "B";
            }
            row++;
        }

        System.out.println(Arrays.deepToString(field));

        for (int i = 0; i < 3; i++) {
            // Checking rows
            if (field[i][0] != null && field[i][0].equals(field[i][1]) && field[i][1].equals(field[i][2])) {
                return field[i][0];
            }
            // Checking columns
            if (field[0][i] != null && field[0][i].equals(field[1][i]) && field[1][i].equals(field[2][i])) {
                return field[0][i];
            }
        }

        //checking diagonals
        if (field[0][0] != null && field[0][0].equals(field[1][1]) && field[1][1].equals(field[2][2])) {
            return field[0][0];
        }
        if (field[0][2] != null && field[0][2].equals(field[1][1]) && field[1][1].equals(field[2][0])) {
            return field[0][2];
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(field[i][j] == null) {
                    return "Pending";
                }
            }
        }

        return "Draw";
    }
}
