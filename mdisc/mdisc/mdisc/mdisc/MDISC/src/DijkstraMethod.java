import java.util.*;

public class DijkstraMethod {

    public static List<Edge> findShortestPath(Graph graph, Vertex source, Vertex destination) {
        Map<Vertex, Double> distances = new HashMap<>();
        Map<Vertex, Vertex> previous = new HashMap<>();
        PriorityQueue<Vertex> queue = new PriorityQueue<>(Comparator.comparingDouble(distances::get));
        Set<Vertex> visited = new HashSet<>();

        for (Vertex vertex : graph.getVertices()) {
            distances.put(vertex, Double.POSITIVE_INFINITY);
        }
        distances.put(source, 0.0);
        queue.add(source);

        while (!queue.isEmpty()) {
            Vertex current = queue.poll();
            visited.add(current);

            if (current.equals(destination)) {
                break;
            }

            for (Edge edge : graph.getGraph()) {
                if (edge.getVertexOrigin().equals(current)) {
                    Vertex next = edge.getVertexDestination();
                    double newDistance = distances.get(current) + edge.getDistance();
                    if (newDistance < distances.get(next)) {
                        distances.put(next, newDistance);
                        previous.put(next, current);
                        queue.add(next);
                    }
                }
            }
        }

        List<Edge> path = new ArrayList<>();
        for (Vertex at = destination; at != null; at = previous.get(at)) {
            Vertex prev = previous.get(at);
            if (prev != null) {
                path.add(0, new Edge(prev, at, distances.get(at) - distances.get(prev)));
            }
        }

        return path;
    }

    public static double calculatePathCost(List<Edge> path) {
        double totalCost = 0.0;
        for (Edge edge : path) {
            totalCost += edge.getDistance();
        }
        return totalCost;
    }
}
