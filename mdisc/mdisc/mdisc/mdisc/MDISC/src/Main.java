import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String separator = ";";

        // US17
        try {
            EmergencyPlanManager emergencyPlanManagerUS17 = new EmergencyPlanManager("C:\\Users\\gonca\\MDISC.sprint2\\src\\us17_output");
            String matrixFilePathUS17 = "C:\\Users\\gonca\\MDISC.sprint2\\src\\us17_matrix\\us17_matrix.csv\\";
            String pointsFilePathUS17 = "C:\\Users\\gonca\\MDISC.sprint2\\src\\us17_point_names\\us17_points.csv\\";

            // Verificar se o arquivo de matriz existe e está acessível
            File matrixFileUS17 = new File(matrixFilePathUS17);
            if (!matrixFileUS17.exists() || !matrixFileUS17.canRead()) {
                System.err.println("Cannot access file: " + matrixFilePathUS17);
                return;
            }

            // Verificar se o arquivo de pontos existe e está acessível
            File pointsFileUS17 = new File(pointsFilePathUS17);
            if (!pointsFileUS17.exists() || !pointsFileUS17.canRead()) {
                System.err.println("Cannot access file: " + pointsFilePathUS17);
                return;
            }

            emergencyPlanManagerUS17.importEmergencyData(matrixFilePathUS17, pointsFilePathUS17, separator);
            emergencyPlanManagerUS17.visualizeGraphAndPaths();
            emergencyPlanManagerUS17.generateEvacuationRoutes();
            System.out.println("US17 completed successfully.");
        } catch (IOException e) {
            System.err.println("US17 - Error during execution: " + e.getMessage());
        }

        // US18
        try {
            EmergencyPlanManager emergencyPlanManagerUS18 = new EmergencyPlanManager("C:\\Users\\gonca\\MDISC.sprint2\\src\\us18_output");
            String matrixFilePathUS18 = "C:\\Users\\gonca\\MDISC.sprint2\\src\\us18_matrix\\us18_matrix.csv";
            String pointsFilePathUS18 = "C:\\Users\\gonca\\MDISC.sprint2\\src\\us18_point_names\\us18_points.csv";

            // Verificar se o arquivo de matriz existe e está acessível
            File matrixFileUS18 = new File(matrixFilePathUS18);
            if (!matrixFileUS18.exists() || !matrixFileUS18.canRead()) {
                System.err.println("Cannot access file: " + matrixFilePathUS18);
                return;
            }

            // Verificar se o arquivo de pontos existe e está acessível
            File pointsFileUS18 = new File(pointsFilePathUS18);
            if (!pointsFileUS18.exists() || !pointsFileUS18.canRead()) {
                System.err.println("Cannot access file: " + pointsFilePathUS18);
                return;
            }

            emergencyPlanManagerUS18.importEmergencyData(matrixFilePathUS18, pointsFilePathUS18, separator);
            emergencyPlanManagerUS18.visualizeGraphAndPaths();
            emergencyPlanManagerUS18.generateShortestRoutesToClosestAssemblyPoint();
            System.out.println("US18 completed successfully.");
        } catch (IOException e) {
            System.err.println("US18 - Error during execution: " + e.getMessage());
        }
    }
}
