/**
 * The interface for heap.
 *
 * @param <E> the type parameter
 */
public interface myHeap<E> {
    /**
     * Add method.
     *
     * @param item the item
     */
    void add(E item);

    /**
     * Remove method.
     *
     * @param item the item
     */
    void remove(E item);

    /**
     * Find method.
     *
     * @param item the item
     * @return the e
     */
    E find(E item);

    /**
     * Younger than method.
     *
     * @param age the age
     * @return the int
     */
    int youngerThan(int age);

    /**
     * Older than method.
     *
     * @param age the age
     * @return the int
     */
    int olderThan(int age);
}
