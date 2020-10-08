import java.util.ArrayList;
import java.util.Random;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentSkipListSet;

/**
 * The type Q 3 test driver.
 */
public class Q3_TestDriver {
    /**
     * The Binary search tree.
     */
    private BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();
    /**
     * The Red black tree book.
     */
    private RedBlackTree<Integer> redBlackTreeBook = new RedBlackTree<>();
    /**
     * The Red black tree java.
     */
    private TreeSet<Integer> redBlackTreeJava = new TreeSet<>();
    /**
     * The B tree book.
     */
    private BTree<Integer> bTreeBook = new BTree<>(5);
    /**
     * The Skip list book.
     */
    private SkipList<Integer> skipListBook = new SkipList<>();
    /**
     * The Skip list java.
     */
    private ConcurrentSkipListSet<Integer> skipListJava = new ConcurrentSkipListSet<>();

    /**
     * Verify methods.
     */
    public void verifyMethods(){
        insertElementsRandomly(1,10);
        insertElementsRandomly(2,10);
        insertElementsRandomly(3,10);
        insertElementsRandomly(4,10);
        insertElementsRandomly(5,10);
        insertElementsRandomly(6,10);

        System.out.println("BinarySearchTree(inorder): " + binarySearchTree.inorder());
        System.out.println("RedBlackTree(Book-inorder): " + redBlackTreeBook.inorder());
        System.out.println("RedBlackTree(Java-inorder): " + redBlackTreeJava.toString());
        System.out.println("BTree(Book-inorder): " + bTreeBook.toString());
        System.out.println("SkipList(Book-inorder): " + skipListBook.toString());
        System.out.println("SkipList(Java-inorder): " + skipListJava.toString());

        clearAllCollections();
    }

    /**
     * Test methods.
     *
     * @param length the length
     */
    public void testMethods(int length){
        double time1 = measureAverageOf10Times(1,length);
        double time2 = measureAverageOf10Times(2,length);
        double time3 = measureAverageOf10Times(3,length);
        double time4 = measureAverageOf10Times(4,length);
        double time5 = measureAverageOf10Times(5,length);
        double time6 = measureAverageOf10Times(6,length);

        System.out.println("------------------------------------------");
        System.out.println("Insertion - Regular Binary search tree-(" + length + "): " + time1);
        System.out.println("Insertion - Red-Black tree implementation in the book-(" + length + "): " + time2);
        System.out.println("Insertion - Red Black tree implementation in java-(" + length + "): " + time3);
        System.out.println("Insertion - B-Tree implementation(order: 5) in the book-(" + length + "): " + time4);
        System.out.println("Insertion - Skip list implementation in the book-(" + length + "): " + time5);
        System.out.println("Insertion - Skip list implementation in java-(" + length + "): " + time6);

        clearAllCollections();
    }

    /**
     * Test delete methods.
     *
     * @param length        the length
     * @param deletedLength the deleted length
     */
    public void testDeleteMethods(int length,int deletedLength){
        double time1 = insertAndDeleteElementsRandomly(1,length,deletedLength);
        double time2 = insertAndDeleteElementsRandomly(2,length,deletedLength);
        double time3 = insertAndDeleteElementsRandomly(3,length,deletedLength);
        double time5 = insertAndDeleteElementsRandomly(5,length,deletedLength);
        double time6 = insertAndDeleteElementsRandomly(6,length,deletedLength);

        System.out.println("------------------------------------------");
        System.out.println("Deletion - Regular Binary search tree-(" + deletedLength + " deletion): " + time1);
        System.out.println("Deletion - Red-Black tree implementation in the book-(" + deletedLength + " deletion): " + time2);
        System.out.println("Deletion - Red Black tree implementation in java-(" + deletedLength + " deletion): " + time3);
        System.out.println("Deletion - Skip list implementation in the book-(" + deletedLength + " deletion): " + time5);
        System.out.println("Deletion - Skip list implementation in java-(" + deletedLength + " deletion): " + time6);

        clearAllCollections();
    }

    /**
     * Measure average of 10 times double.
     *
     * @param collection the collection
     * @param length     the length
     * @return the double
     */
    public double measureAverageOf10Times(int collection,int length){
        if(collection >= 1 && collection <= 6){
            long time = 0;
            for(int i=0;i<10;++i){
                time += insertElementsRandomly(collection,length);
                clearAllCollections();
            }
            return time / 10.0;
        }
        return -1;
    }

    /**
     * Insert elements randomly long.
     *
     * @param collection the collection
     * @param length     the length
     * @return the long
     */
    public long insertElementsRandomly(int collection,int length){
        Random random = new Random();
        long startTime = System.currentTimeMillis();
        switch (collection){
            case 1:
                for(int i=0;i<length;++i)
                    binarySearchTree.add(random.nextInt(100));
                break;
            case 2:
                for(int i=0;i<length;++i)
                    redBlackTreeBook.add(random.nextInt(100));
                break;
            case 3:
                for(int i=0;i<length;++i)
                    redBlackTreeJava.add(random.nextInt(100));
                break;
            case 4:
                for(int i=0;i<length;++i)
                    bTreeBook.insert(random.nextInt(100));
                break;
            case 5:
                for(int i=0;i<length;++i)
                    skipListBook.add(random.nextInt(100));
                break;
            case 6:
                for(int i=0;i<length;++i)
                    skipListJava.add(random.nextInt(100));
                break;
        }
        long endTime = System.currentTimeMillis();

        return endTime-startTime;
    }

    /**
     * Insert and delete elements randomly long.
     *
     * @param collection    the collection
     * @param length        the length
     * @param deletedNumber the deleted number
     * @return the long
     */
    public double insertAndDeleteElementsRandomly(int collection,int length,int deletedNumber){
        Random random = new Random();
        ArrayList<Integer> elements = new ArrayList<>();
        switch (collection){
            case 1:
                for(int i=0;i<length;++i){
                    Integer num = random.nextInt(100);
                    binarySearchTree.add(num);
                    if(i < deletedNumber){
                        elements.add(num);
                    }
                }
                break;
            case 2:
                for(int i=0;i<length;++i){
                    Integer num = random.nextInt(100);
                    redBlackTreeBook.add(num);
                    if(i < deletedNumber){
                        elements.add(num);
                    }
                }
                break;
            case 3:
                for(int i=0;i<length;++i){
                    Integer num = random.nextInt(100);
                    redBlackTreeJava.add(num);
                    if(i < deletedNumber){
                        elements.add(num);
                    }
                }
                break;
            case 5:
                for(int i=0;i<length;++i){
                    Integer num = random.nextInt(100);
                    skipListBook.add(num);
                    if(i < deletedNumber){
                        elements.add(num);
                    }
                }
                break;
            case 6:
                for(int i=0;i<length;++i){
                    Integer num = random.nextInt(100);
                    skipListJava.add(num);
                    if(i < deletedNumber){
                        elements.add(num);
                    }
                }
                break;
        }

        double startTime = System.currentTimeMillis();
        switch (collection){
            case 1:
                for(int i=0;i<deletedNumber;++i)
                    binarySearchTree.delete(elements.get(i));
                break;
            case 2:
                for(int i=0;i<deletedNumber;++i)
                    redBlackTreeBook.delete(elements.get(i));
                break;
            case 3:
                for(int i=0;i<deletedNumber;++i)
                    redBlackTreeJava.remove(elements.get(i));
                break;
            case 5:
                for(int i=0;i<deletedNumber;++i)
                    skipListBook.remove(elements.get(i));
                break;
            case 6:
                for(int i=0;i<deletedNumber;++i)
                    skipListJava.remove(elements.get(i));
                break;
        }
        double endTime = System.currentTimeMillis();

        clearAllCollections();
        return endTime-startTime;
    }

    /**
     * Clear all collections.
     */
    public void clearAllCollections(){
        binarySearchTree = new BinarySearchTree<>();
        redBlackTreeBook = new RedBlackTree<>();
        redBlackTreeJava = new TreeSet<>();
        bTreeBook = new BTree<>(5);
        skipListBook = new SkipList<>();
        skipListJava = new ConcurrentSkipListSet<>();
    }
}
