package Graph;

import java.util.*;

public class VerticesWithinDistanceGraph {
    public static void main(String[] args) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(1, Arrays.asList(2, 3));
        graph.put(2, Arrays.asList(1, 4, 5));
        graph.put(3, Arrays.asList(1));
        graph.put(4, Arrays.asList(2));
        graph.put(5, Arrays.asList(2, 6));
        graph.put(6, Arrays.asList(5));

        System.out.println(findVerticesWithinDistance(graph, 1, 2));
    }

    private static List<Integer> findVerticesWithinDistance(Map<Integer, List<Integer>> graph, int start, int distance) {
        Set<Integer> visited = new HashSet<>();
        Queue<int[]> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();

        queue.offer(new int[]{start, 0});

        while (!queue.isEmpty()){
            int[] current = queue.poll();
            int node = current[0];
            int dist = current[1];

            if(!visited.contains(node)){
                visited.add(node);
                result.add(node);

                if(dist < distance){
                    for(int neighbor : graph.get(node)){
                        if(!visited.contains(neighbor)){
                            queue.offer(new int[]{neighbor, dist + 1});
                        }
                    }
                }
            }
        }

        Collections.sort(result);
        return result;
    }
}
