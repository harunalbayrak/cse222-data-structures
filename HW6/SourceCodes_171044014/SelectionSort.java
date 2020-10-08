import java.util.Collections;
import java.util.LinkedList;

/**
 * The type Selection sort.
 */
public class SelectionSort implements SortAlgorithm {
    @Override
    public <T extends Comparable<T>> void sort(T[] table) {
        int n = table.length;
        for (int fill = 0; fill < n - 1; fill++) {
            int posMin = fill;
            for (int next = fill + 1; next < n; next++) {
                if (table[next].compareTo(table[posMin]) < 0) {
                    posMin = next;
                }
            }
            T temp = table[fill];
            table[fill] = table[posMin];
            table[posMin] = temp;
        }
    }

    public <T extends Comparable<T>> void sort(LinkedList<T> table) {
        int n = table.size();
        for (int fill = 0; fill < n - 1; fill++) {
            int posMin = fill;
            for (int next = fill + 1; next < n; next++) {
                if (table.get(next).compareTo(table.get(posMin)) < 0) {
                    posMin = next;
                }
            }
            Collections.swap(table,fill,posMin);
        }
    }
}
