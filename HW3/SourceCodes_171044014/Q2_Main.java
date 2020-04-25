import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * The Main of the Question.2
 */
public class Q2_Main {
    /**
     * The main method
     *
     * @param args the input arguments
     * @throws Exception the exception
     */
    public static void main(String[] args) throws Exception {
        System.out.println("It may take a bit longer to read the 2nd and 3rd files.");
        testAllWithFile("test3.txt");
        testAllWithFile("test2.txt");
        testAllWithFile("test.txt");
        System.out.println("THE LOG FILE WAS CREATED!");

        // You print Lists If you want( NOTE:It is very very long output! )!
        /*testMethod(arrayList1,9);
        testMethod(arrayList2,9);
        testMethod(linkedList1,9);
        testMethod(linkedList2,9);*/
    }

    public static void testAllWithFile(String FILENAME) throws Exception {
        String[] methodNames = {"Read","Add","Find","Replace"};
        String[] methodNamesWithIterator = {"Read(Iterator)","Add(Iterator)","Find(Iterator)","Replace(Iterator)"};
        Q2_SimpleTextEditor arrayList1 = new Q2_SimpleTextEditor("ArrayList",FILENAME);
        Q2_SimpleTextEditor arrayList2 = new Q2_SimpleTextEditor("ArrayList",FILENAME);
        Q2_SimpleTextEditor linkedList1 = new Q2_SimpleTextEditor("LinkedList",FILENAME);
        Q2_SimpleTextEditor linkedList2 = new Q2_SimpleTextEditor("LinkedList",FILENAME);
        for(int i=1,k=0;i<8;i+=2,k++){
            WriteToFile(String.valueOf("List is an ArrayList( " + methodNames[k] + " ): "   + testMethod(arrayList1,i) + " ms"));
        }
        WriteToFile("--------------------");
        for(int i=2,k=0;i<9;i+=2,k++){
            WriteToFile(String.valueOf("List is an ArrayList( " + methodNamesWithIterator[k] + " ): "   + testMethod(arrayList2,i) + " ms"));
        }
        WriteToFile("--------------------");
        for(int i=1,k=0;i<8;i+=2,k++){
            WriteToFile(String.valueOf("List is an LinkedList( " + methodNames[k] + " ): "   + testMethod(linkedList1,i) + " ms"));
        }
        WriteToFile("--------------------");
        for(int i=2,k=0;i<9;i+=2,k++){
            WriteToFile(String.valueOf("List is an LinkedList( " + methodNamesWithIterator[k] + " ): "   + testMethod(linkedList2,i) + " ms"));
        }
        WriteToFile("THE FILENAME : "+FILENAME + "  |  THE SIZE: " + arrayList1.getList().size() + " Characters");
        WriteToFile("-------------------------------------------------------------------------");
    }

    /**
     * Test method long.
     *
     * @param editor the simple text editor
     * @param num    the number of the chosen method
     * @return the time duration of the one selected method
     */
    public static long testMethod(Q2_SimpleTextEditor editor,int num){
        long startTime=0,endTime=0;
        switch (num){
            case 1:
                startTime = System.currentTimeMillis();
                editor.read();
                endTime = System.currentTimeMillis();
                break;
            case 2:
                startTime = System.currentTimeMillis();
                editor.readWithIterator();
                endTime = System.currentTimeMillis();
                break;
            case 3:
                startTime = System.currentTimeMillis();
                editor.add("String",0);
                endTime = System.currentTimeMillis();
                break;
            case 4:
                startTime = System.currentTimeMillis();
                editor.addWithIterator("String",0);
                endTime = System.currentTimeMillis();
                break;
            case 5:
                startTime = System.currentTimeMillis();
                int k = editor.find("ALBAYRAKHARUN");
                if(k > 0){
                    System.out.println("String found!: " + k + ".index");
                }else{
                    System.out.println("String not found!");
                }
                endTime = System.currentTimeMillis();
                break;
            case 6:
                startTime = System.currentTimeMillis();
                int m = editor.findWithIterator("ALBAYRAKHARUN");
                if(m > 0){
                    System.out.println("String found!: " + m + ".index");
                }else{
                    System.out.println("String not found!");
                }
                endTime = System.currentTimeMillis();
                break;
            case 7:
                startTime = System.currentTimeMillis();
                editor.replace(' ','_');
                endTime = System.currentTimeMillis();
                break;
            case 8:
                startTime = System.currentTimeMillis();
                editor.replaceWithIterator('c','_');
                endTime = System.currentTimeMillis();
                break;
            case 9:
                System.out.println(editor.getList().toString());
                break;
        }
        return endTime-startTime;
    }

    /**
     * Writes to the file. Creates a log file
     *
     * @param text the text
     * @throws IOException the io exception
     */
    public static void WriteToFile(String text) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("LogFile_Q2.txt", true));
        writer.write(text);
        writer.newLine();
        writer.close();
    }
}
