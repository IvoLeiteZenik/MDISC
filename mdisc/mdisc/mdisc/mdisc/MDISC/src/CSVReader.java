
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CSVReader {

    public static double[][] readMatrix(String filePath, String separator) throws FileNotFoundException {
        List<double[]> rows = new ArrayList<>();

        File file = new File(filePath);
        if (!file.exists()) {
            throw new FileNotFoundException("The file " + filePath + " doesn't exist.");
        }

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(separator);

                double[] row = new double[parts.length];
                for (int i = 0; i < parts.length; i++) {
                    try {
                        row[i] = Double.parseDouble(parts[i].trim());
                    } catch (NumberFormatException e) {
                        throw new NumberFormatException("Matrix value is not in a valid format");
                    }
                }
                rows.add(row);
            }
        }

        double[][] matrix = new double[rows.size()][];
        for (int i = 0; i < rows.size(); i++) {
            matrix[i] = rows.get(i);
        }

        return matrix;
    }

    public static List<String> readPoints(String filePath, String separator) throws FileNotFoundException {
        List<String> points = new ArrayList<>();

        File file = new File(filePath);
        if (!file.exists()) {
            throw new FileNotFoundException("The file " + filePath + " doesn't exist.");
        }

        try (Scanner scanner = new Scanner(file)) {
            if (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(separator);
                for (String part : parts) {
                    points.add(part.trim());
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
