/**
 * TheKw hash map interface .
 *
 * @param <K> the type parameter
 * @param <V> the type parameter
 */
public interface KWHashMap<K,V> {
    /**
     * Get v.
     *
     * @param key the key
     * @return the v
     */
    V get(Object key);

    /**
     * Is empty boolean.
     *
     * @return the boolean
     */
    boolean isEmpty();

    /**
     * Put v.
     *
     * @param key   the key
     * @param value the value
     * @return the v
     */
    V put(K key,V value);

    /**
     * Remove v.
     *
     * @param key the key
     * @return the v
     */
    V remove(Object key);

    /**
     * Size int.
     *
     * @return the int
     */
    int size();
}
