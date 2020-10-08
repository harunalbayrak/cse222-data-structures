/**
 * The interface Search tree.
 *
 * @param <E> the type parameter
 */
public interface SearchTree<E> {
    /**
     * Add method.
     *
     * @param item the item
     * @return the boolean
     */
    boolean add(E item);

    /**
     * Contains method.
     *
     * @param target the target
     * @return the boolean
     */
    boolean contains(E target);

    /**
     * Find method.
     *
     * @param target the target
     * @return the e
     */
    E find(E target);

    /**
     * Delete method.
     *
     * @param target the target
     * @return the e
     */
    E delete(E target);

    /**
     * Remove method.
     *
     * @param target the target
     * @return the boolean
     */
    boolean remove(E target);
}
