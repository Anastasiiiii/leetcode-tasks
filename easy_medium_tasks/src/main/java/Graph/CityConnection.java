package Graph;

import java.util.*;

public class CityConnection {
    /*
     * You are provided with a representation of a network of cities and roads between them.
     * Each city can be identified by a unique string identifier, and for each city you are given a set of cities it is connected to by a road.
     *
     * Your task is to create a function shortestDistance(Map<String, Set<String>> roads, String start, String destination) in Java that extracts the shortest
     * distance from start to destination using the graph traversal algorithm we discussed in the lesson, the Breadth-First Search (BFS).
     * If there are no roads leading to the destination, your function should return null.*/

    public static void main(String[] args) {
        HashMap<String, Set<String>> roads = new HashMap<>();

        roads.put("A", new HashSet<>(Arrays.asList("B", "C")));
        roads.put("B", new HashSet<>(Arrays.asList("A", "D")));
        roads.put("C", new HashSet<>(Arrays.asList("A", "E")));
        roads.put("D", new HashSet<>(Arrays.asList("B", "E", "F")));
        roads.put("E", new HashSet<>(Arrays.asList("C", "D", "F")));
        roads.put("F", new HashSet<>(Arrays.asList("D", "E")));

        System.out.println("Shortest distance from A to F: " + CityConnection.shortestDistance(roads, "A", "F"));
        System.out.println("Shortest distance from A to G: " + CityConnection.shortestDistance(roads, "A", "G")); // No path
    }

    private static Integer shortestDistance(HashMap<String, Set<String>> roads, String start, String destination) {
        Set<String> visited = new HashSet<>();
        Queue<Pair> queue = new LinkedList<>();

        queue.offer(new Pair(start, 0));
        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            String city = current.city;
            int dist = current.distance;

            if (city.equals(destination)) {
                return dist;
            }

            for (String neighbor : roads.getOrDefault(city, new HashSet<>())) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.offer(new Pair(neighbor, dist + 1));
                }
            }
        }
        return null;
    }

    private static class Pair {
        String city;
        int distance;

        public Pair(String city, int distance) {
            this.city = city;
            this.distance = distance;
        }
    }
}

