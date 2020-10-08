import java.io.IOException;
import java.util.Scanner;

/**
 * The type Q 3 main.
 */
public class Q3_Main {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     * @throws IOException the ıo exception
     */
    public static void main(String[] args) throws IOException {
        findShortestPath();
    }

    /**
     * Find shortest path.
     *
     * @throws IOException the ıo exception
     */
    public static void findShortestPath() throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the name of the file you want to read the graph: ");
        String fileName = sc.nextLine();

        writeFileAndCreateGraph.readFileAndFindShortestPath(fileName);
    }
}
