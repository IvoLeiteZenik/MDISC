
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/* public class Tests {
    static final int NUMBER_OF_TRIES = 5;
    static final String PATH_TO_INPUT_FILES = "C:\\Users\\gonca\\Downloads\\mdisc\\mdisc\\mdisc\\MDISC\\us14_input\\";
    static final String PATH_TO_OUTPUT_FILES = "C:\\Users\\gonca\\Downloads\\mdisc\\mdisc\\mdisc\\MDISC\\us14_results\\";

    public static boolean runTestsForVariableInputsSize(String filePrefix) throws IOException {
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= 30; i++) {
            String fileName = filePrefix + i + ".csv";
            List<Double> runtimes = new ArrayList<>();


            List<Edge> edges = CSVReader.readCSV(PATH_TO_INPUT_FILES + fileName, ";");


            Graph graph = new Graph(edges);

            int size = graph.getGraphSize();

            for (int j = 0; j < NUMBER_OF_TRIES; j++) {
                double runtime = runTest(graph);
                runtimes.add(runtime);
            }
            double meanRuntime = calculateMean(runtimes);
            sb.append(size).append(", ").append(meanRuntime).append(". \n");
        }

        PrintWriter pw = new PrintWriter(PATH_TO_OUTPUT_FILES + filePrefix + ".csv");
        pw.write(sb.toString());
        pw.close();

        plot(PATH_TO_OUTPUT_FILES + filePrefix + ".csv", filePrefix);

        return true;
    }


    public static double calculateMean(List<Double> values) {
        double sum = 0;
        for (double val : values) {
            sum += val;
        }
        return sum / values.size();
    }


    public static void plot(String filename, String filePrefix) throws IOException {
        File outF = new File(PATH_TO_OUTPUT_FILES + "auxFile.gp");
        PrintWriter out = new PrintWriter(outF);
        out.println("set terminal png\n");
        out.println("set output '" + PATH_TO_OUTPUT_FILES + filePrefix + ".png'");
        out.print("set title 'Execution time tests'" + "\n");
        out.print("set xlabel 'Size of Graph (number of edges)'" + "\n");
        out.print("set ylabel 'Runtime (milliseconds)'" + "\n");
        out.print("set grid\n");
        out.print("set xrange [0:*]\n");
        out.print("set yrange [0:*]\n");
        out.print("set style fill transparent solid 0.9\n");
        out.println("plot '" + filename + "'  u 1:2 w p t 'Algorithm Performance'");
        out.close();// It's done, closing document.
        Runtime.getRuntime().exec("\"C:\\Program Files\\gnuplot\\bin\\gnuplot.exe\"" + PATH_TO_OUTPUT_FILES + "auxFile.gp");
    }

    public static double runTest(Graph graph) {
        final double MILI_TO_NANO_CONVERSION = Math.pow(10, 6);
        KruskalMethod k = new KruskalMethod();
        double startTime = System.nanoTime();
        Graph mst = k.generateMinimumSpanningTree(graph);
        double endTime = System.nanoTime();
        double duration = (endTime - startTime) / MILI_TO_NANO_CONVERSION;
        System.out.println("Runtime: " + duration + " milliseconds");

        return duration;
    }
}*/
