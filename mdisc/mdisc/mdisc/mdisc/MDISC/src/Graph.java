
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Graph {
    private List<Edge> graph;
    private List<Vertex> vertices;

    static final String FILE_PATH = "C:\\Users\\gonca\\Downloads\\mdisc\\mdisc\\mdisc\\MDISC\\us13_results\\";

    public Graph(List<Edge> edges) {
        this.graph = new ArrayList<>(edges);
        this.vertices = getVerticesFromEdges(edges);
    }

    public Graph() {
        this.graph = new ArrayList<>();
        this.vertices = new ArrayList<>();
    }

    private List<Vertex> getVerticesFromEdges(List<Edge> edges) {
        Set<Vertex> vertexSet = new HashSet<>();
        for (Edge edge : edges) {
            vertexSet.add(edge.getVertexOrigin());
            vertexSet.add(edge.getVertexDestination());
        }
        return new ArrayList<>(vertexSet);
    }

    public List<Edge> getGraph() {
        return new ArrayList<>(graph);
    }

    public int getGraphSize() {
        return graph.size();
    }

    public void setGraph(List<Edge> graph) {
        this.graph = new ArrayList<>(graph);
        this.vertices = getVerticesFromEdges(graph);
    }

    public void addEdge(Edge edge) {
        graph.add(new Edge(edge));
        if (!vertices.contains(edge.getVertexOrigin())) {
            vertices.add(edge.getVertexOrigin());
        }
        if (!vertices.contains(edge.getVertexDestination())) {
            vertices.add(edge.getVertexDestination());
        }
    }

    @Override
    public String toString() {
        return "Graph{" +
                "graph=" + graph +
                '}';
    }

    public List<Vertex> getVertices() {
        return new ArrayList<>(vertices);
    }

    public List<Vertex> getVerticesConnectedTo(Vertex v) {
        List<Vertex> connectedVertices = new ArrayList<>();
        for (Edge edge : graph) {
            if (edge.getVertexOrigin().equals(v)) {
                connectedVertices.add(edge.getVertexDestination());
            } else if (edge.getVertexDestination().equals(v)) {
                connectedVertices.add(edge.getVertexOrigin());
            }
        }
        return connectedVertices;
    }

    public void sortGraphEdgesByCost() {
        if (graph == null) {
            throw new IllegalArgumentException("Edges cannot be null.");
        }
        graph.sort(Edge::compareTo);
    }

    public void generateGraph(String filename) {
        try (FileWriter writer = new FileWriter(FILE_PATH + filename)) {
            StringBuilder sb = new StringBuilder();
            sb.append("@startuml\n");
            sb.append("graph Graph {\n");

            for (Edge edge : graph) {
                sb.append("\t").append(edge.getVertexOrigin().getName()).append(" -- ")
                        .append(edge.getVertexDestination().getName()).append("[label=\"")
                        .append(edge.getDistance()).append("\"]\n");
            }

            sb.append("}\n@enduml");
            writer.write(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public double getGraphCost() {
        double sumCost = 0;
        for (Edge edge : graph) {
            sumCost += edge.getDistance();
        }
        return sumCost;
    }

    public void generateCsvOutput(String filename, List<Edge> shortestPath) {
        try (FileWriter writer = new FileWriter(FILE_PATH + filename)) {
            StringBuilder sb = new StringBuilder();

            for (Edge edge : graph) {
                sb.append(edge.getVertexOrigin()).append(", ")
                        .append(edge.getVertexDestination()).append(", ")
                        .append(edge.getDistance()).append("\n");
            }
            sb.append("Total cost: ").append(this.getGraphCost());
            writer.write(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void generateGraphWithShortestPaths(String filename, List<Vertex> assemblyPoints) {
        try (FileWriter writer = new FileWriter(FILE_PATH + filename)) {
            StringBuilder sb = new StringBuilder();
            sb.append("@startuml\n");
            sb.append("graph Graph {\n");

            for (Vertex vertex : vertices) {
                for (Vertex assemblyPoint : assemblyPoints) {
                    List<Edge> shortestPath = shortestPaths(vertex, assemblyPoint);
                    for (Edge edge : shortestPath) {
                        sb.append("\t").append(edge.getVertexOrigin().getName()).append(" -- ")
                                .append(edge.getVertexDestination().getName()).append("[label=\"")
                                .append(edge.getDistance()).append("\"]\n");
                    }
                }
            }

            sb.append("}\n@enduml");
            writer.write(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<Edge> shortestPaths(Vertex start, Vertex end) {
        // Implementação do método de Dijkstra ou outro algoritmo de caminho mais curto
        // Placeholder para evitar erro de compilação
        return new ArrayList<>();
    }

    public List<Edge> findShortestPath(Vertex signalPoint, Vertex assemblyPoint) {
   }
}
