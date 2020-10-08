import java.util.Collections;
import java.util.LinkedList;

/**
 * The type Heap sort.
 */
public class HeapSort implements SortAlgorithm {
    @Override
    public <T extends Comparable<T>> void sort(T[] table) {
        buildHeap(table);
        shrinkHeap(table);
    }

    public <T extends Comparable<T>> void sort(LinkedList<T> table) {
        buildHeap(table);
        shrinkHeap(table);
    }

    private <T extends Comparable<T>> void buildHeap(T[] table) {
        int n = 1;
        while (n < table.length) {
            n++; // Add a new item to the heap and reheap.
            int child = n - 1;
            int parent = (child - 1) / 2; // Find parent.
            while (parent >= 0
                    && table[parent].compareTo(table[child]) < 0) {
                swap(table, parent, child);
                child = parent;
                parent = (child - 1) / 2;
            }
        }
    }

    private <T extends Comparable<T>> void buildHeap(LinkedList<T> table) {
        int n = 1;
        while (n < table.size()) {
            n++; // Add a new item to the heap and reheap.
            int child = n - 1;
            int parent = (child - 1) / 2; // Find parent.
            while (parent >= 0
                    && table.get(parent).compareTo(table.get(child)) < 0) {
                Collections.swap(table,parent,child);
                child = parent;
                parent = (child - 1) / 2;
            }
        }
    }

    private <T extends Comparable<T>> void shrinkHeap(T[] table) {
        int n = table.length;
        while (n > 0) {
            n--;
            swap(table, 0, n);
            int parent = 0;
            while (true) {
                int leftChild = 2 * parent + 1;
                if (leftChild >= n) {
                    break; // No more children.
                }
                int rightChild = leftChild + 1;
                int maxChild = leftChild;
                if (rightChild < n // There is a right child.
                        && table[leftChild].compareTo(table[rightChild]) < 0) {
                    maxChild = rightChild;
                }
                if (table[parent].compareTo(table[maxChild]) < 0) {
                    swap(table, parent, maxChild);
                    parent = maxChild;
                } else { // Heap property is restored.
                    break; // Exit the loop.
                }
            }
        }
    }

    private <T extends Comparable<T>> void shrinkHeap(LinkedList<T> table) {
        int n = table.size();
        while (n > 0) {
            n--;
            Collections.swap(table,0,n);
            int parent = 0;
            while (true) {
                int leftChild = 2 * parent + 1;
                if (leftChild >= n) {
                    break; // No more children.
                }
                int rightChild = leftChild + 1;
                int maxChild = leftChild;
                if (rightChild < n // There is a right child.
                        && table.get(leftChild).compareTo(table.get(rightChild)) < 0) {
                    maxChild = rightChild;
                }
                if (table.get(parent).compareTo(table.get(maxChild)) < 0) {
                    Collections.swap(table,parent,maxChild);
                    parent = maxChild;
                } else { // Heap property is restored.
                    break; // Exit the loop.
                }
            }
        }
    }

    private static <T extends Comparable<T>> void swap(T[] table,
                                                       int i, int j) {
        T temp = table[i];
        table[i] = table[j];
        table[j] = temp;
    }
}
