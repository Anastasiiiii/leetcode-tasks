package String;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class WordFindGrid {
    public static void main(String[] args) {

    }

    private static boolean exist(char[][] board, String word) {
        StringBuilder tempWord = new StringBuilder();
        Set<int[]> visited = new HashSet<>();
        Queue<int[]> queue = new LinkedList<>();


        queue.add(new int[] {0, 0});

        while(!queue.isEmpty()){
            for (int i = 1; i < board.length; i++) {
                for (int j = 1; j < board[0].length; j++) {
                    int[]node = {i, j};
                        if (!visited.contains(node)){

                        }

                }
            }
        }



        return false;
    }
}
