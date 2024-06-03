import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {

    public static double[][] readMatrix(String filePath, String separator) throws IOException {
        List<double[]> data = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(separator);
                double[] row = new double[values.length];
                for (int i = 0; i < values.length; i++) {
                    row[i] = Double.parseDouble(values[i]);
                }
                data.add(row);
            }
        }
        return data.toArray(new double[0][]);
    }

    public static List<String> readPoints(String filePath, String separator) throws IOException {
        List<String> points = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line = br.readLine();
            if (line != null) {
                String[] values = line.split(separator);
                for (String value : values) {
                    points.add(value);
                }
            }
        }
        return points;
    }

    public static List<Integer> identifyAssemblyPoints(List<String> points) {
        List<Integer> assemblyPoints = new ArrayList<>();
        for (int i = 0; i < points.size(); i++) {
            if (points.get(i).startsWith("AP")) {
                assemblyPoints.add(i);
            }
        }
        return assemblyPoints;
    }
}
