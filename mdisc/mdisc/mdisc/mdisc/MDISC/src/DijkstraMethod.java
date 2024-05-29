import java.util.*;

public class DijkstraMethod {

    public static Map<Vertex, Double> shortestPaths(Graph graph, Vertex source) {
        // Initialization of variables
        Map<Vertex, Double> distances = new HashMap<>();
        PriorityQueue<Vertex> queue = new PriorityQueue<>(Comparator.comparingDouble(distances::get));
        Set<Vertex> visited = new HashSet<>();

        // Set all distances to infinity, except for the source vertex
        for (Vertex vertex : graph.getVertices()) {
            distances.put(vertex, Double.POSITIVE_INFINITY);
        }
        distances.put(source, 0.0);
        queue.add(source);

        // Dijkstra's algorithm
        while (!queue.isEmpty()) {
            Vertex current = queue.poll();
            visited.add(current);
            for (Edge edge : graph.getGraph()) {
                if (edge.getVertexOrigin().equals(current)) {
                    Vertex next = edge.getVertexDestination();
                    double newDistance = distances.get(current) + edge.getDistance();
                    if (newDistance < distances.get(next)) {
                        distances.put(next, newDistance);
                        queue.add(next);
                    }
                }
            }
        }

        return distances;
    }
}
