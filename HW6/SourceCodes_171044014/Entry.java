import java.util.Random;

/**
 * The type Entry.
 *
 * @param <K> the type parameter
 * @param <V> the type parameter
 */
public class Entry<K,V> implements Comparable<K>{
    private K key;
    private V value;

    /**
     * Instantiates a new Entry.
     *
     * @param key   the key
     * @param value the value
     */
    public Entry(K key,V value){
        this.key = key;
        this.value = value;
    }

    /**
     * Get key k.
     *
     * @return the k
     */
    public K getKey(){ return key; }

    /**
     * Get value v.
     *
     * @return the v
     */
    public V getValue(){ return value; }

    /**
     * Set value v.
     *
     * @param val the val
     * @return the v
     */
    public V setValue(V val){ V old = this.value; this.value = val; return old; }

    @Override
    public int compareTo(K o) {
        Random rnd = new Random();
        int x = rnd.nextInt(2);

        if(x == 0)
            return 1;
        else if(x == 1)
            return -1;

        return 1;
    }
}
