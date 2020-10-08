import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

/**
 * The type Write file and create graph.
 */
public class writeFileAndCreateGraph {
    /**
     * The Vertex count.
     */
    static int vertexCount=0;
    /**
     * The Edge count.
     */
    static int edgeCount=0;


    /**
     * Read file and find shortest path.
     *
     * @param fileName the file name
     * @throws IOException the ıo exception
     */
    public static void readFileAndFindShortestPath(String fileName) throws IOException {
        int[][] array = readFileAndFindEdge.read(fileName);

        String[] vertexLocation = readFileAndFindEdge.findVertexLocation(array);
        for (int i = 0; i < vertexLocation.length; ++i)
            if (vertexLocation[i] != null)
                vertexCount++;

        String[] edges = readFileAndFindEdge.findEdges(array,vertexLocation);
        for(int i=0;i<edges.length;++i)
            if(edges[i] != null)
                edgeCount++;

        writeFile(edges);
        createGraph();
    }

    /**
     * Write file.
     *
     * @param edges the edges
     * @throws IOException the ıo exception
     */
    public static void writeFile(String[] edges) throws IOException {
        FileWriter f0 = new FileWriter("q3_output.txt");

        String newLine = System.getProperty("line.separator");
        for(int i=0;i<edgeCount+1;i++) {

            if(i==0)
                f0.write(vertexCount + newLine);
            else {
                String[] split = edges[i-1].split("-");
                String[] split2 = split[1].split(" ");

                int source = Integer.parseInt(split[0]);
                int dest = Integer.parseInt(split2[0]);
                int weight = Integer.parseInt(split2[1]);
                f0.write(source + "," + dest + "," + weight + newLine);
            }
        }
        f0.close();
    }

    /**
     * Create graph.
     */
    public static void createGraph(){
        int numV = 0;
        Graph theMaze = null;

        try {
            Scanner scan = new Scanner(new File("q3_output.txt"));
            theMaze = AbstractGraph.createGraph(scan, false, "List");
            numV = theMaze.getNumV();
        } catch (IOException ex) {
            System.err.println("IO Error while reading graph");
            System.err.println(ex.toString());
            System.exit(1);
        }

        int[] parent = BreadthFirstSearch.breadthFirstSearch(theMaze, 0);
        Stack<Integer> thePath = new Stack<>();
        int v = numV - 1;

        while(parent[v] != -1){
            thePath.push(v);
            v = parent[v];
        }

        System.out.println("The shortest path is:");
        while(!thePath.empty()){
            System.out.println(thePath.pop());
        }
    }
}
