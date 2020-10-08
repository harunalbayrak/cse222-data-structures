import java.util.Collections;
import java.util.LinkedList;

/**
 * The type My quicksort.
 */
public class myQuicksort implements SortAlgorithm{
    public <T extends Comparable<T>> void sort(T[] table){
        quickSort(table,0,table.length-1);
    }

    public <T extends Comparable<T>> void sort(LinkedList<T> table){
        quickSort(table,0,table.size()-1);
    }

    /**
     * Quick sort.
     *
     * @param <T>   the type parameter
     * @param table the table
     * @param start the start
     * @param end   the end
     */
    public <T extends Comparable<T>> void quickSort(T[] table,int start,int end){
        int index = partition(table, start, end);
        if (start < index - 1)
            quickSort(table, start, index - 1);
        if (end > index)
            quickSort(table, index, end);
    }

    /**
     * Quick sort.
     *
     * @param <T>   the type parameter
     * @param table the table
     * @param start the start
     * @param end   the end
     */
    public <T extends Comparable<T>> void quickSort(LinkedList<T> table,int start,int end){
        int index = partition(table, start, end);
        if (start < index - 1)
            quickSort(table, start, index - 1);
        if (end > index)
            quickSort(table, index, end);
    }

    /**
     * Partition int.
     *
     * @param <T>   the type parameter
     * @param table the table
     * @param left  the left
     * @param right the right
     * @return the int
     */
    public <T extends Comparable<T>> int partition(T[] table,int left,int right){
        T pivot = table[left];

        while (left <= right) {
            while (table[left].compareTo(pivot) < 0)
                left++;
            while (table[right].compareTo(pivot) > 0)
                right--;

            if (left <= right) {
                T temp = table[left];
                table[left++] = table[right];
                table[right--] = temp;
            }
        }
        return left;
    }

    /**
     * Partition int.
     *
     * @param <T>   the type parameter
     * @param table the table
     * @param left  the left
     * @param right the right
     * @return the int
     */
    public <T extends Comparable<T>> int partition(LinkedList<T> table,int left,int right){
        T pivot = table.get(left);

        while (left <= right) {
            while (table.get(left).compareTo(pivot) < 0)
                left++;
            while (table.get(right).compareTo(pivot) > 0)
                right--;

            if (left <= right)
                Collections.swap(table,left++,right--);
        }
        return left;
    }
}
