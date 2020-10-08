import java.util.LinkedList;

/**
 * The type My mergesort.
 */
public class myMergesort implements SortAlgorithm{

    @Override
    public <T extends Comparable<T>> void sort(T[] table) {
        T[] table2 = (T[]) new Comparable[table.length];
        mergeSort(table,table2,0,table.length-1);
    }

    public <T extends Comparable<T>> void sort(LinkedList<T> table) {
        LinkedList<T> table2 = new LinkedList<T>(table);
        mergeSort(table,table2,0,table.size()-1);
    }

    private <T extends Comparable<T>> void mergeSort(T[] table,T[] table2,int low, int high) {
        if (low < high) {
            int middle = low + (high - low) / 2;
            mergeSort(table,table2,low, middle);
            mergeSort(table,table2,middle + 1, high);
            merge(table, table2, low, middle, high);
        }
    }

    private <T extends Comparable<T>> void mergeSort(LinkedList<T> table,LinkedList<T> table2,int low, int high) {
        if (low < high) {
            int middle = low + (high - low) / 2;
            mergeSort(table,table2,low, middle);
            mergeSort(table,table2,middle + 1, high);
            merge(table, table2, low, middle, high);
        }
    }

    private <T extends Comparable<T>> void merge(T[] table,T[] table2,int low,int middle ,int high) {
        for (int i = low; i <= high; i++) {
            table2[i] = table[i];
        }
        int i = low;
        int j = middle + 1;
        int k = low;
        while (i <= middle && j <= high) {
            if (table2[i].compareTo(table2[j]) <= 0) {
                table[k++] = table2[i++];
            } else {
                table[k++] = table2[j++];
            }
        }
        while (i <= middle) {
            table[k++] = table2[i++];
        }
    }

    private <T extends Comparable<T>> void merge(LinkedList<T> table,LinkedList<T> table2,int low,int middle ,int high) {
        for (int i = low; i <= high; i++) {
            table2.set(i,table.get(i));
        }
        int i = low;
        int j = middle + 1;
        int k = low;
        while (i <= middle && j <= high) {
            if (table2.get(i).compareTo(table2.get(j)) <= 0) {
                table.set(k++,table2.get(i++));
            } else {
                table.set(k++,table2.get(j++));
            }
        }
        while (i <= middle) {
            table.set(k++,table2.get(i++));
        }
    }
}
