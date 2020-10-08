import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * The type Read file and find edge.
 */
public class readFileAndFindEdge {
    /**
     * Read int [ ] [ ].
     *
     * @param fileName the file name
     * @return the int [ ] [ ]
     */
    public static int[][] read(String fileName) {
        Scanner scanner = null;
        int rowCount=0;
        int columnCount=0;
        int[][] array;

        try {
            scanner = new Scanner(new File(fileName));
        } catch (FileNotFoundException ex){
            System.out.println("File Not Found.");
            System.exit(0);
        }
        rowCount = scanner.nextLine().length();
        columnCount++;
        while (scanner.hasNextLine()){
            scanner.nextLine();
            columnCount += 1;
        }
        array = new int[columnCount][rowCount];
        try {
            scanner = new Scanner(new File(fileName));
        } catch (FileNotFoundException ex){
            System.out.println("File Not Found.");
            System.exit(0);
        }
        int j=0;
        while (scanner.hasNextLine()){
            String line = scanner.nextLine();
            for(int i=0;i<line.length();++i){
                array[j][i] = Integer.parseInt(String.valueOf(line.charAt(i)));
            }
            j++;
        }
        return array;
    }

    /**
     * Find vertex location string [ ].
     *
     * @param array the array
     * @return the string [ ]
     */
    public static String[] findVertexLocation(int[][] array){
        int columnNumber = array.length;
        int rowNumber = array[0].length;
        String[] vertexLocation = new String[90];
        int a=0;

        for(int i=0;i<columnNumber;++i){
            for(int j=0;j<rowNumber;++j){
                //System.out.print(array[i][j]);
                if(array[i][j] == 0){
                    boolean x = checkAround(array,i,j,0,vertexLocation,a++);
                    if (!x)
                        a--;
                } else{
                    boolean x = checkAround(array,i,j,1,vertexLocation,a++);
                    if (!x)
                        a--;
                }
            }
        }

        //for(int i=0;i<vertexLocation.length;++i)
            //System.out.println(vertexLocation[i]);

        return vertexLocation;
    }

    /**
     * Find edges string [ ].
     *
     * @param array          the array
     * @param vertexLocation the vertex location
     * @return the string [ ]
     */
    public static String[] findEdges(int[][] array, String[] vertexLocation){
        String[] edges = new String[180];

        int i=0;
        while(vertexLocation[i] != null){
            checkForEdges(i,edges,array,vertexLocation,vertexLocation[i]);

            i++;
        }

        /*for(int m=0;m<35;++m){
            System.out.println(edges[m]);
        }*/
        return edges;
    }

    private static void checkForEdges(int originalIndex,String[] edges,int[][] array, String[] vertexLocation, String s) {
        String[] vertex = s.split(",");
        int x = Integer.parseInt(vertex[0]);
        int y = Integer.parseInt(vertex[1]);

        checkForEdgesAround(originalIndex,edges,vertexLocation,array,x,y);
    }

    private static void checkForEdgesAround(int originalIndex,String[] edges, String[] vertexLocation, int[][] array, int x, int y) {
        if(leftNumber(array,x,y) == 0){
            goAround(originalIndex,edges,vertexLocation,array,x,y-1,1,true,false,true,true);
        }
        if(rightNumber(array,x,y) == 0){
            goAround(originalIndex,edges,vertexLocation,array,x,y+1,1,false,true,true,true);
        }
        if(upNumber(array,x,y) == 0){
            goAround(originalIndex,edges,vertexLocation,array,x-1,y,1,true,true,true,false);
        }
        if(downNumber(array,x,y) == 0){
            goAround(originalIndex,edges,vertexLocation,array,x+1,y,1,true,true,false,true);
        }
    }

    private static void goAround(int originalIndex,String[] edges,String[] vertexLocation,int[][] array,
                               int x, int y,int weight,boolean left,boolean right,boolean up,boolean down) {
        String newV = x + "," + y;
        int currentIndex = checkContainsVertex(vertexLocation,newV);
        if(currentIndex != -1){
            for(int i=0;i<edges.length;++i){
                if(edges[i] == null) {
                    String ters = new String(currentIndex + "-" + originalIndex + " " + weight);
                    if(checkContainsVertex(edges,ters) == -1)
                        edges[i] = new String(originalIndex + "-" + currentIndex + " " + weight);
                    break;
                }
            }
            return;
        }
        if(leftNumber(array,x,y) == 0 && left){
            goAround(originalIndex,edges,vertexLocation,array,x,y-1,weight+1,true,false,true,true);
        } else if(rightNumber(array,x,y) == 0 && right){
            goAround(originalIndex,edges,vertexLocation,array,x,y+1,weight+1,false,true,true,true);
        } else if(upNumber(array,x,y) == 0 && up){
            goAround(originalIndex,edges,vertexLocation,array,x-1,y,weight+1,true,true,true,false);
        } else if(downNumber(array,x,y) == 0 && down){
            goAround(originalIndex,edges,vertexLocation,array,x+1,y,weight+1,true,true,false,true);
        }
    }

    /**
     * Check contains vertex int.
     *
     * @param vertexLocation the vertex location
     * @param v              the v
     * @return the int
     */
    public static int checkContainsVertex(String[] vertexLocation, String v){
        if(v == null || v.equals(""))
            return -1;
        for(int i=0;i<vertexLocation.length;++i){
            if(vertexLocation[i] == null || vertexLocation[i].equals(""))
                return -1;
            if(vertexLocation[i].equals(v))
                return i;
        }
        return -1;
    }

    /**
     * Check around boolean.
     *
     * @param array          the array
     * @param x              the x
     * @param y              the y
     * @param num            the num
     * @param vertexLocation the vertex location
     * @param a              the a
     * @return the boolean
     */
    public static boolean checkAround(int[][] array,int x,int y,int num,String[] vertexLocation,int a){
        int zeroNum=0,oneNum=0;

        if(leftNumber(array,x,y)==0)
            zeroNum++;
        else if(leftNumber(array,x,y)==1)
            oneNum++;

        if(rightNumber(array,x,y)==0)
            zeroNum++;
        else if(rightNumber(array,x,y)==1)
            oneNum++;

        if(upNumber(array,x,y)==0)
            zeroNum++;
        else if(upNumber(array,x,y)==1)
            oneNum++;

        if(downNumber(array,x,y)==0)
            zeroNum++;
        else if(downNumber(array,x,y)==1)
            oneNum++;

        if(num == 0) {
            //System.out.println(zeroNum + " - " + oneNum);

            if (zeroNum == 1 && oneNum == 1) {
                vertexLocation[a] = new String(x + "," + y);
                return true;
                //System.out.println("Vertex.");
            } else if(zeroNum == 2 && (oneNum == 1 || oneNum == 2)){
                return false;
                //System.out.println("Not vertex.");
            } else if(zeroNum == 1 && oneNum == 2){
                return false;
                //System.out.println("Not vertex.");
            } else if(zeroNum == 1 && oneNum == 3) {
                vertexLocation[a] = new String(x + "," + y);
                return true;
            }else {
                vertexLocation[a] = new String(x + "," + y);
                return true;
                //System.out.println("Vertex.");
            }
        } else if(num == 1){
            return false;
            //System.out.println(zeroNum + " - " + oneNum);

            //System.out.println("Not vertex.");
        }
        return false;
    }

    /**
     * Left number int.
     *
     * @param array the array
     * @param x     the x
     * @param y     the y
     * @return the int
     */
    public static int leftNumber(int[][] array,int x,int y){
        if(y-1 < 0 || y-1 >= array[0].length)
            return -1;
        else
            return array[x][y-1];
    }

    /**
     * Right number int.
     *
     * @param array the array
     * @param x     the x
     * @param y     the y
     * @return the int
     */
    public static int rightNumber(int[][] array,int x,int y){
        if(y+1 < 0 || y+1 >= array[0].length)
            return -1;
        else
            return array[x][y+1];
    }

    /**
     * Up number int.
     *
     * @param array the array
     * @param x     the x
     * @param y     the y
     * @return the int
     */
    public static int upNumber(int[][] array,int x,int y){
        if(x-1 < 0 || x-1 >= array.length)
            return -1;
        else
            return array[x-1][y];
    }

    /**
     * Down number int.
     *
     * @param array the array
     * @param x     the x
     * @param y     the y
     * @return the int
     */
    public static int downNumber(int[][] array,int x,int y){
        if(x+1 < 0 || x+1 >= array.length)
            return -1;
        else
            return array[x+1][y];
    }
}
