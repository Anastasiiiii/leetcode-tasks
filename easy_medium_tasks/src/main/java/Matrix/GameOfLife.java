//package Matrix;
//
//public class GameOfLife {
//    public static void main(String[] args) {
//
//    }
//
//    private static void gameOfLife(int[][] board){
//        for (int i = 0; i < board.length; i++) {
//            for (int j = 0; j < board[i].length; j++) {
//                encode(board, i, j);
//            }
//        }
//
//        for (int i = 0; i < board.length; i++) {
//            for (int j = 0; j < board[i].length; j++) {
//                update();
//            }
//        }
//    }
//
//    private static void encode(int[][] board, int i, int j){
//        int aliveCount = 0;
//        for(int r = -1; r <= 1; r++){
//            for (int c = -1; c <= 1; c++){
//                int neighR = i + r;
//                int neighC = j + c;
//
//                if(neighR >= 0 && neighR <board.length && neighC >= 0 && neighC < board[0].length){
//                    int neighVal = board[neighR][neighC];
//
//                }
//            }
//        }
//    }
//}
