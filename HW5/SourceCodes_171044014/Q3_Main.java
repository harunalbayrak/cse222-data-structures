/**
 * The Question3 Main Class
 */
public class Q3_Main {
    /**
     * Question3 Main.
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
        AgeSearchTree<AgeData> ageTree = new AgeSearchTree<AgeData>();
        ageTree.add(new AgeData(10));
        ageTree.add(new AgeData(10));
        ageTree.add(new AgeData(20));
        ageTree.add(new AgeData(20));
        ageTree.add(new AgeData(30));
        ageTree.add(new AgeData(5));
        ageTree.add(new AgeData(5));
        ageTree.add(new AgeData(15));
        ageTree.add(new AgeData(15));
        ageTree.add(new AgeData(10));

        System.out.println(ageTree.toString());
        System.out.println("---------------------------------");

        System.out.println("Find method: " + ageTree.find(new AgeData(30)).toString());
        System.out.println("---------------------------------");

        System.out.println("Younger than 15: " + ageTree.youngerThan(15));
        System.out.println("---------------------------------");

        System.out.println("Older than 12: "+ ageTree.olderThan(12));
        System.out.println("---------------------------------");

        System.out.println("Remove Method (30,15,5)");
        ageTree.remove(new AgeData(30));
        ageTree.remove(new AgeData(15));
        ageTree.remove(new AgeData(5));

        System.out.println(ageTree.toString());
        System.out.println("---------------------------------");
    }
}
