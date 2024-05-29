

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;


public class EmergencyPlanManager {

    private Graph graph;
    private List<Vertex> assemblyPoints;

    public EmergencyPlanManager() {
        this.graph = new Graph();
        this.assemblyPoints = new ArrayList<>();
    }

    public void importEmergencyData(String matrixFilePath, String pointsFilePath, String separator) {
        try {
            double[][] graphData = CSVReader.readMatrix(matrixFilePath, separator);
            List<String> points = CSVReader.readPoints(pointsFilePath, separator);
            List<Integer> assemblyPointsIndices = CSVReader.identifyAssemblyPoints(points);

            List<Edge> edges = new ArrayList<>();
            for (int i = 0; i < graphData.length; i++) {
                for (int j = 0; j < graphData[i].length; j++) {
                    double distance = graphData[i][j];
                    if (distance != 0) {
                        Vertex origin = new Vertex(points.get(i));
                        Vertex destination = new Vertex(points.get(j));
                        edges.add(new Edge(origin, destination, distance));
                    }
                }
            }

            this.graph.setGraph(edges);
            for (Integer index : assemblyPointsIndices) {
                assemblyPoints.add(new Vertex(points.get(index)));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void generateEvacuationRoutes() {
        graph.sortGraphEdgesByCost();
        for (Vertex signalPoint : graph.getVertices()) {
            for (Vertex assemblyPoint : assemblyPoints) {
                List<Edge> shortestPath = graph.findShortestPath(signalPoint, assemblyPoint);
                String outputPath = "evacuation_route_" + signalPoint.getName() + "_to_" + assemblyPoint.getName() + ".csv";
                graph.generateCsvOutput(outputPath, shortestPath);
            }
        }
    }

    public void visualizeGraphAndPaths() {
        String graphFilename = "emergency_graph.uml";
        String pathsFilename = "evacuation_paths.uml";
        graph.generateGraph(graphFilename);
        graph.generateGraphWithShortestPaths(pathsFilename, assemblyPoints);
    }

    public void generateShortestRoutesToClosestAssemblyPoint() {
    }

    public void importAssemblyPoints(String assemblyPointsFilePath, String separator) {
    }
}
