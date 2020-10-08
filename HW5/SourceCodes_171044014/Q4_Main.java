/**
 * The Question4 Main Class
 */
public class Q4_Main {
    /**
     * Question4 Main.
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
        MaxHeap<AgeData> heap = new MaxHeap<>();

        heap.add(new AgeData(10));
        heap.add(new AgeData(10));
        heap.add(new AgeData(10));
        heap.add(new AgeData(5));
        heap.add(new AgeData(5));
        heap.add(new AgeData(70));
        heap.add(new AgeData(70));
        heap.add(new AgeData(10));
        heap.add(new AgeData(50));
        heap.add(new AgeData(50));
        heap.add(new AgeData(5));
        heap.add(new AgeData(15));

        System.out.println(heap.toString());
        System.out.println("-------------------------------------");

        System.out.println("Find method: " + heap.find(new AgeData(70)).toString());
        System.out.println("-------------------------------------");

        System.out.println("Younger than 69: " + heap.youngerThan(69));
        System.out.println("-------------------------------------");

        System.out.println("Older than 69: " + heap.olderThan(69));
        System.out.println("-------------------------------------");

        System.out.println("Remove Method (10,5,5)");
        heap.remove(new AgeData(10));
        heap.remove(new AgeData(5));
        heap.remove(new AgeData(5));
        System.out.println(heap.toString());
        System.out.println("-------------------------------------");

    }
}
