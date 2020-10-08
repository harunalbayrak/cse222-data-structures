import java.util.LinkedList;

/**
 * The Sort algorithm interface.
 */
public interface SortAlgorithm {
    /**
     * Sort.
     *
     * @param <T>   the type parameter
     * @param table the table
     */
    <T extends Comparable<T>> void sort(T[] table);

    /**
     * Sort.
     *
     * @param <T>   the type parameter
     * @param table the table
     */
    <T extends Comparable<T>> void sort(LinkedList<T> table);
}
