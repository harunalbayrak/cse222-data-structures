/**
 * The Question1 Main Class
 */
public class Q1_Main {
    /**
     * Question1 Main.
     *
     * @param args the args
     */
    public static void main(String[] args){
        testMethods();
    }

    /**
     * Test methods.
     */
    public static void testMethods(){
        FileSystemTree fil = new FileSystemTree("root");
        fil.addDir("root/first_directory");
        fil.addDir("root/first_directory2");
        fil.addDir("root/second_directory");
        fil.addFile("root/first_directory/new.file.txt");
        fil.addDir("root/second_directory/new_directory");
        fil.addFile("root/second_directory/new_directory/new_file.doc");

        System.out.println("Printing file system");
        fil.printFileSystem();
        System.out.println("-------------------------------------");

        System.out.println("Removing 2 element");
        fil.remove("root/first_directory/new_file.txt");
        fil.remove("root/second_directory/new_directory");

        System.out.println("Printing file system");
        fil.printFileSystem();
        System.out.println("-------------------------------------");

        System.out.println("Searching keyword 'new'");
        fil.search("new");
        System.out.println("-------------------------------------");
    }
}
