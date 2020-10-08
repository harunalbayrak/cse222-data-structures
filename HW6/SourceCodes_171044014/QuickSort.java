import java.util.Collections;
import java.util.LinkedList;

/**
 * The type Quick sort.
 */
public class QuickSort implements SortAlgorithm {
    @Override
    public <T extends Comparable<T>> void sort(T[] table) {
        quickSort(table,0,table.length-1);
    }

    public <T extends Comparable<T>> void sort(LinkedList<T> table) {
        quickSort(table,0,table.size()-1);
    }

    /**
     * Quick sort.
     *
     * @param <T>   the type parameter
     * @param table the table
     * @param first the first
     * @param last  the last
     */
    protected <T extends Comparable<T>> void quickSort(T[] table,
                                                       int first,
                                                       int last) {
        if (first < last) { // There is data to be sorted.
            int pivIndex = partition(table, first, last);
            quickSort(table, first, pivIndex - 1);
            quickSort(table, pivIndex + 1, last);
        }
    }

    /**
     * Quick sort.
     *
     * @param <T>   the type parameter
     * @param table the table
     * @param first the first
     * @param last  the last
     */
    protected <T extends Comparable<T>> void quickSort(LinkedList<T> table,
                                                       int first,
                                                       int last) {
        if (first < last) { // There is data to be sorted.
            int pivIndex = partition(table, first, last);
            quickSort(table, first, pivIndex - 1);
            quickSort(table, pivIndex + 1, last);
        }
    }

    /**
     * Partition int.
     *
     * @param <T>   the type parameter
     * @param table the table
     * @param first the first
     * @param last  the last
     * @return the int
     */
    protected <T extends Comparable<T>> int partition(T[] table,
                                                       int first, int last) {
        T pivot = table[first];
        int up = first; int down = last;
        do {
            while ((up < last) && (pivot.compareTo(table[up]) >= 0)) {
                up++;
            }
            while (pivot.compareTo(table[down]) < 0) {
                down--;
            }
            if (up < down) { // if up is to the left of down.
                swap(table, up, down);
            }
        } while (up < down); // Repeat while up is left of down.
        swap(table, first, down);
        return down;
    }

    /**
     * Partition int.
     *
     * @param <T>   the type parameter
     * @param table the table
     * @param first the first
     * @param last  the last
     * @return the int
     */
    protected <T extends Comparable<T>> int partition(LinkedList<T> table,
                                                      int first, int last) {
        T pivot = table.get(first);
        int up = first; int down = last;
        do {
            while ((up < last) && (pivot.compareTo(table.get(up)) >= 0)) {
                up++;
            }
            while (pivot.compareTo(table.get(down)) < 0) {
                down--;
            }
            if (up < down) { // if up is to the left of down.
                Collections.swap(table,up,down);
            }
        } while (up < down); // Repeat while up is left of down.
        Collections.swap(table,first,down);
        return down;
    }

    private static <T extends Comparable<T>> void swap(T[] table,
                                                       int i, int j) {
        T temp = table[i];
        table[i] = table[j];
        table[j] = temp;
    }
}
