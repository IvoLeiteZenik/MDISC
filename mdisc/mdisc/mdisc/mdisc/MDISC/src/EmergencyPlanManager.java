import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EmergencyPlanManager {

    private Graph graph;
    private List<Vertex> assemblyPoints;

    public EmergencyPlanManager(String outputDirectory) {
        this.graph = new Graph(outputDirectory);
        this.assemblyPoints = new ArrayList<>();
    }

    public void importEmergencyData(String matrixFilePath, String pointsFilePath, String separator) throws IOException {
        double[][] graphData = CSVReader.readMatrix(matrixFilePath, separator);
        List<String> points = CSVReader.readPoints(pointsFilePath, separator);
        List<Integer> assemblyPointsIndices = CSVReader.identifyAssemblyPoints(points);

        validateInputData(graphData, points, assemblyPointsIndices);

        this.graph.setAdjacencyMatrix(graphData);
        this.graph.createEdgesFromMatrix();
        this.graph.setAssemblyPoints(assemblyPointsIndices, points);

        for (Integer index : assemblyPointsIndices) {
            assemblyPoints.add(new Vertex(points.get(index)));
        }
    }

    private void validateInputData(double[][] graphData, List<String> points, List<Integer> assemblyPointsIndices) throws IllegalArgumentException {
        if (graphData == null || points == null || assemblyPointsIndices == null) {
            throw new IllegalArgumentException("Input data cannot be null");
        }
        if (graphData.length != points.size()) {
            throw new IllegalArgumentException("Graph data size does not match points size");
        }
    }

    public void generateEvacuationRoutes() {
        graph.sortGraphEdgesByCost();
        for (Vertex signalPoint : graph.getVertices()) {
            for (Vertex assemblyPoint : assemblyPoints) {
                List<Edge> shortestPath = DijkstraMethod.findShortestPath(graph, signalPoint, assemblyPoint);
                graph.setGraph(shortestPath);  // Temporarily set the graph to the shortest path
                String outputPath = "evacuation_route_" + signalPoint.getName() + "_to_" + assemblyPoint.getName() + ".csv";
                graph.generateCsvOutput(outputPath);
            }
        }
    }

    public void visualizeGraphAndPaths() {
        String graphFilename = "emergency_graph.uml";
        String pathsFilename = "evacuation_paths.uml";
        graph.generateGraph(graphFilename, assemblyPoints);
        graph.generateGraph(pathsFilename, assemblyPoints);
    }

    public void generateShortestRoutesToClosestAssemblyPoint() {
        for (Vertex signalPoint : graph.getVertices()) {
            List<Edge> shortestPath = null;
            double minCost = Double.MAX_VALUE;
            for (Vertex assemblyPoint : assemblyPoints) {
                List<Edge> path = DijkstraMethod.findShortestPath(graph, signalPoint, assemblyPoint);
                double pathCost = DijkstraMethod.calculatePathCost(path);
                if (pathCost < minCost) {
                    shortestPath = path;
                    minCost = pathCost;
                }
            }
            graph.setGraph(shortestPath);  // Temporarily set the graph to the shortest path
            String outputPath = "evacuation_route_to_closest_assembly_point_" + signalPoint.getName() + ".csv";
            graph.generateCsvOutput(outputPath);
        }
    }
}
