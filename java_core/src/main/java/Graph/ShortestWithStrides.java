package Graph;
import java.util.*;

public class ShortestWithStrides {
    public static void main(String[] args) {

    }

    private static int shortestRoute(int distance, int strideLength, List<Integer> obstacles){
        int[] visited = new int[distance];
        Arrays.fill(visited, 0);
        for(int obstacle : obstacles){
            if(obstacle < distance){
                visited[obstacle] = -1;
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});

        return 4;
    }
}
