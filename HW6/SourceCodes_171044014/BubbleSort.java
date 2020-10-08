import java.util.Collections;
import java.util.LinkedList;

/**
 * The type Bubble sort.
 */
public class BubbleSort implements SortAlgorithm{
    public <T extends Comparable<T>> void sort(T[] table) {
        int pass = 1;
        boolean exchanges = false;
        do {
            exchanges = false; // No exchanges yet.
            for (int i = 0; i < table.length - pass; i++) {
                if (table[i].compareTo(table[i + 1]) > 0) {
                    T temp = table[i];
                    table[i] = table[i + 1];
                    table[i + 1] = temp;
                    exchanges = true; // Set flag.
                }
            }
            pass++;
        } while (exchanges);
    }

    public <T extends Comparable<T>> void sort(LinkedList<T> table) {
        int pass = 1;
        boolean exchanges = false;
        do {
            exchanges = false; // No exchanges yet.
            for (int i = 0; i < table.size() - pass; i++) {
                if (table.get(i).compareTo(table.get(i+1)) > 0) {
                    Collections.swap(table,i,i+1);
                    exchanges = true; // Set flag.
                }
            }
            pass++;
        } while (exchanges);
    }
}
