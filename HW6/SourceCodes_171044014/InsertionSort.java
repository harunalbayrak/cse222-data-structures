import java.util.LinkedList;

/**
 * The type Insertion sort.
 */
public class InsertionSort implements SortAlgorithm {
    @Override
    public <T extends Comparable<T>> void sort(T[] table) {
        for (int nextPos = 1; nextPos < table.length; nextPos++) {
            insert(table, nextPos);
        }
    }

    public <T extends Comparable<T>> void sort(LinkedList<T> table) {
        for (int nextPos = 1; nextPos < table.size(); nextPos++) {
            insert(table, nextPos);
        }
    }

    private static <T extends Comparable<T>> void insert(T[] table,
                                                         int nextPos) {
        T nextVal = table[nextPos]; // Element to insert.
        while (nextPos > 0
                && nextVal.compareTo(table[nextPos - 1]) < 0) {
            table[nextPos] = table[nextPos - 1]; // Shift down.
            nextPos--; // Check next smaller element.
        }
        table[nextPos] = nextVal;
    }

    private static <T extends Comparable<T>> void insert(LinkedList<T> table,
                                                         int nextPos) {
        T nextVal = table.get(nextPos); // Element to insert.
        while (nextPos > 0
                && nextVal.compareTo(table.get(nextPos-1)) < 0) {
            table.set(nextPos,table.get(nextPos-1));
            nextPos--; // Check next smaller element.
        }
        table.set(nextPos,nextVal);
    }
}
