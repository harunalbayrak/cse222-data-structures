import java.util.LinkedList;

/**
 * The type Shell sort.
 */
public class ShellSort implements SortAlgorithm {
    @Override
    public <T extends Comparable<T>> void sort(T[] table) {
        int gap = table.length / 2;
        while (gap > 0) {
            for (int nextPos = gap; nextPos < table.length;
                 nextPos++) {
                insert(table, nextPos, gap);
            } // End for.
            if (gap == 2) {
                gap = 1;
            } else {
                gap = (int) (gap / 2.2);
            }
        } // End while.
    }

    public <T extends Comparable<T>> void sort(LinkedList<T> table) {
        int gap = table.size() / 2;
        while (gap > 0) {
            for (int nextPos = gap; nextPos < table.size();
                 nextPos++) {
                insert(table, nextPos, gap);
            } // End for.
            if (gap == 2) {
                gap = 1;
            } else {
                gap = (int) (gap / 2.2);
            }
        } // End while.
    }

    private static <T extends Comparable<T>> void insert(T[] table,
                                                         int nextPos,
                                                         int gap) {
        T nextVal = table[nextPos]; // Element to insert.
        while ((nextPos > gap - 1) // First element not shifted.
                && (nextVal.compareTo(table[nextPos - gap]) < 0)) {
            table[nextPos] = table[nextPos - gap]; // Shift down.
            nextPos -= gap; // Check next position in subarray.
        }
        table[nextPos] = nextVal; // Insert nextVal.
    }

    private static <T extends Comparable<T>> void insert(LinkedList<T> table,
                                                         int nextPos,
                                                         int gap) {
        T nextVal = table.get(nextPos); // Element to insert.
        while ((nextPos > gap - 1) // First element not shifted.
                && (nextVal.compareTo(table.get(nextPos-gap)) < 0)) {
            table.set(nextPos,table.get(nextPos-gap));
            nextPos -= gap; // Check next position in subarray.
        }
        table.set(nextPos,nextVal);
    }
}
