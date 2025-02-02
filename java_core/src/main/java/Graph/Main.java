package Graph;

import java.util.*;

class Graph {
    private Map<Integer, List<Integer>> adjList = new HashMap<>();

    public void addEdge(int src, int dest) {
        adjList.putIfAbsent(src, new ArrayList<>());
        adjList.putIfAbsent(dest, new ArrayList<>());
        adjList.get(src).add(dest);
        adjList.get(dest).add(src);
    }

    public List<Integer> bfs(int start) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();

        queue.offer(start);  //Add the element if the queue is not full;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            if (!visited.contains(node)) {
                visited.add(node);
                result.add(node);
                for (int neighbor : adjList.get(node)) {
                    if (!visited.contains(neighbor)) {
                        queue.offer(neighbor);
                    }
                }
            }
        }
        return result;
    }
}

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);
        System.out.println("BFS traversal starting from node 2:");
        System.out.println(graph.bfs(2));
    }
}
