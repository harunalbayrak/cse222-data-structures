import java.util.LinkedList;
import java.util.Random;

/**
 * The type Q 2 main.
 */
public class Q2_Main {
    /**
     * The Bubble sort.
     */
    static BubbleSort bubbleSort = new BubbleSort();
    /**
     * The Insertion sort.
     */
    static InsertionSort insertionSort = new InsertionSort();
    /**
     * The Selection sort.
     */
    static SelectionSort selectionSort = new SelectionSort();
    /**
     * The Shell sort.
     */
    static ShellSort shellSort = new ShellSort();
    /**
     * The Heap sort.
     */
    static HeapSort heapSort = new HeapSort();
    /**
     * The Merge sort.
     */
    static MergeSort mergeSort = new MergeSort();
    /**
     * The Quick sort.
     */
    static QuickSort quickSort = new QuickSort();
    /**
     * The My mergesort.
     */
    static myMergesort myMergesort = new myMergesort();
    /**
     * The My quicksort.
     */
    static myQuicksort myQuicksort = new myQuicksort();

    /**
     * Main.
     *
     * @param args the args
     */
    public static void main(String[] args){
        testMethodFor9Methods();
    }

    /**
     * Test method for 9 methods.
     */
    public static void testMethodFor9Methods(){
        for(int i=1;i<10;++i){
            testFor9Methods(1000,i,true);
            testFor9Methods(1000,i,false);
        }
    }

    /**
     * Test for 9 methods.
     *
     * @param length the length
     * @param num    the num
     * @param random the random
     */
    public static void testFor9Methods(int length,int num,boolean random){
        LinkedList<Integer> linkedList;
        if(random)
            linkedList = createRandomLinkedList(length);
        else
            linkedList = createSortedLinkedList(length);

        long startTime=0,endTime=0;

        startTime = System.currentTimeMillis();
        if(num == 1)
            bubbleSort.sort(linkedList);
        else if(num == 2)
            insertionSort.sort(linkedList);
        else if(num == 3)
            selectionSort.sort(linkedList);
        else if(num == 4)
            shellSort.sort(linkedList);
        else if(num == 5)
            heapSort.sort(linkedList);
        else if(num == 6)
            mergeSort.sort(linkedList);
        else if(num == 7)
            quickSort.sort(linkedList);
        else if(num == 8)
            myMergesort.sort(linkedList);
        else if(num == 9)
            myQuicksort.sort(linkedList);
        endTime = System.currentTimeMillis();

        if(num == 1)
            System.out.print("Bubble Sort");
        else if(num == 2)
            System.out.print("Insertion Sort");
        else if(num == 3)
            System.out.print("Selection Sort");
        else if(num == 4)
            System.out.print("Shell Sort");
        else if(num == 5)
            System.out.print("Heap Sort");
        else if(num == 6)
            System.out.print("Merge Sort");
        else if(num == 7)
            System.out.print("Quick Sort");
        else if(num == 8)
            System.out.print("My Merge Sort");
        else if(num == 9)
            System.out.print("My Quick Sort");

        System.out.print("("+  length);

        if(random)
            System.out.println("-Random): " + (endTime-startTime));
        else
            System.out.println("-Sorted): " + (endTime-startTime));
    }

    /**
     * Create sorted array int [ ].
     *
     * @param length the length
     * @return the int [ ]
     */
    public static int[] createSortedArray(int length){
        int[] array = new int[length];
        for(int i=0;i<array.length;++i){
            array[i] = i;
        }
        return array;
    }

    /**
     * Create sorted linked list linked list.
     *
     * @param length the length
     * @return the linked list
     */
    public static LinkedList<Integer> createSortedLinkedList(int length){
        LinkedList<Integer> list = new LinkedList<>();
        for(int i=0;i<length;++i){
            list.add(i);
        }
        return list;
    }

    /**
     * Create random array int [ ].
     *
     * @param length the length
     * @return the int [ ]
     */
    public static int[] createRandomArray(int length){
        Random random = new Random();
        int[] array = new int[length];

        for(int i=0;i<array.length;++i){
            int num = random.nextInt((i + 10) * 3);
            array[i] = num;
        }

        return array;
    }

    /**
     * Create random linked list linked list.
     *
     * @param length the length
     * @return the linked list
     */
    public static LinkedList<Integer> createRandomLinkedList(int length){
        Random random = new Random();
        LinkedList<Integer> list = new LinkedList<>();
        for(int i=0;i<length;++i){
            int num = random.nextInt((i + 10) * 3);
            list.add(num);
        }
        return list;
    }
}
