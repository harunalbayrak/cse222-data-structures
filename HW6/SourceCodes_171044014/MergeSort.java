import java.util.LinkedList;

/**
 * The type Merge sort.
 */
public class MergeSort implements SortAlgorithm {
    @Override
    public <T extends Comparable<T>> void sort(T[] table) {
        if (table.length > 1) {
            int halfSize = table.length / 2;
            T[] leftTable = (T[]) new Comparable[halfSize];
            T[] rightTable =
                    (T[]) new Comparable[table.length - halfSize];
            System.arraycopy(table, 0, leftTable, 0, halfSize);
            System.arraycopy(table, halfSize, rightTable, 0,
                    table.length - halfSize);
            sort(leftTable);
            sort(rightTable);
            merge(table, leftTable, rightTable);
        }
    }

    public <T extends Comparable<T>> void sort(LinkedList<T> table) {
        if (table.size() > 1) {
            int halfSize = table.size() / 2;
            LinkedList<T> leftList = new LinkedList<>();
            leftList.addAll(table.subList(0,halfSize));
            LinkedList<T> rightList = new LinkedList<>();
            rightList.addAll(table.subList(halfSize,table.size()));
            sort(leftList);
            sort(rightList);
            merge(table, leftList, rightList);
        }
    }

    private static <T extends Comparable<T>> void merge(T[] outputSequence,
                                                        T[] leftSequence, T[] rightSequence) {
        int i = 0; // Index into the left input sequence.
        int j = 0; // Index into the right input sequence.
        int k = 0; // Index into the output sequence.
        while (i < leftSequence.length && j < rightSequence.length) {
            if (leftSequence[i].compareTo(rightSequence[j]) < 0) {
                outputSequence[k++] = leftSequence[i++];
            } else {
                outputSequence[k++] = rightSequence[j++];
            }
        }
        while (i < leftSequence.length) {
            outputSequence[k++] = leftSequence[i++];
        }
        while (j < rightSequence.length) {
            outputSequence[k++] = rightSequence[j++];
        }
    }

    private static <T extends Comparable<T>> void merge(LinkedList<T> outputSequence,
                                                        LinkedList<T> leftSequence, LinkedList<T> rightSequence) {
        int i = 0; // Index into the left input sequence.
        int j = 0; // Index into the right input sequence.
        int k = 0; // Index into the output sequence.
        while (i < leftSequence.size() && j < rightSequence.size()) {
            if (leftSequence.get(i).compareTo(rightSequence.get(j)) < 0) {
                outputSequence.set(k++,leftSequence.get(i++));
            } else {
                outputSequence.set(k++,rightSequence.get(j++));
            }
        }
        while (i < leftSequence.size()) {
            outputSequence.set(k++,leftSequence.get(i++));
        }
        while (j < rightSequence.size()) {
            outputSequence.set(k++,rightSequence.get(j++));
        }
    }
}
