import java.util.Scanner;

    import java.io.FileNotFoundException;
import java.util.Scanner;

    public class Main {

        public static void main(String[] args) {
            EmergencyPlanManager emergencyPlanManager = new EmergencyPlanManager();
            Scanner scanner = new Scanner(System.in);

            System.out.println("Choose an option:");
            System.out.println("1 - Place signs to evacuate park users to an Assembly Point (US17)");
            System.out.println("2 - Place signs to evacuate park users to one of the several Assembly Points (US18)");

            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    executeUS17(emergencyPlanManager);
                    break;
                case 2:
                    executeUS18(emergencyPlanManager);
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }

        private static void executeUS17(EmergencyPlanManager emergencyPlanManager) {
            String matrixFilePath = "C:\\Users\\gonca\\Downloads\\mdisc\\mdisc\\mdisc\\MDISC\\us17_input\\matrix.csv";
            String pointsFilePath = "C:\\Users\\gonca\\Downloads\\mdisc\\mdisc\\mdisc\\MDISC\\us17_input\\points.csv";
            String separator = ";";

            emergencyPlanManager.importEmergencyData(matrixFilePath, pointsFilePath, separator);
            emergencyPlanManager.generateEvacuationRoutes();
            emergencyPlanManager.visualizeGraphAndPaths();
        }

        private static void executeUS18(EmergencyPlanManager emergencyPlanManager) {
            String assemblyPointsFilePath = "C:\\Users\\gonca\\Downloads\\mdisc\\mdisc\\mdisc\\MDISC\\us18_input\\assembly_points.csv";
            String separator = ";";

            emergencyPlanManager.importAssemblyPoints(assemblyPointsFilePath, separator);
            emergencyPlanManager.generateShortestRoutesToClosestAssemblyPoint();
            emergencyPlanManager.visualizeGraphAndPaths();
        }
    }


