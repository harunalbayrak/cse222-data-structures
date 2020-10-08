import java.util.TreeSet;

/**
 * The type My hash table chain.
 *
 * @param <K> the type parameter
 * @param <V> the type parameter
 */
public class myHashTableChain<K,V> implements KWHashMap<K,V> {
    private TreeSet<Entry<K,V>>[] table;
    private int numKeys;
    private static final int CAPACITTY = 101;
    private static final double LOAD_THRESHOLD = 3.0;

    /**
     * Instantiates a new My hash table chain.
     */
    public myHashTableChain(){
        table = new TreeSet[CAPACITTY];
    }

    @Override
    public V get(Object key) {
        int index = key.hashCode() % table.length;
        if(index < 0)
            index += table.length;
        if(table[index] == null)
            return null;

        for(Entry<K,V> nextItem : table[index]){
            if(nextItem.getKey().equals(key))
                return nextItem.getValue();
        }

        return null;
    }

    @Override
    public boolean isEmpty() {
        return numKeys == 0;
    }

    @Override
    public V put(K key, V value) {
        int index = key.hashCode() % table.length;
        if(index < 0)
            index += table.length;
        if(table[index] == null)
            table[index] = new TreeSet<>();

        for(Entry<K,V> nextItem : table[index]){
            if(nextItem.getKey().equals(key)){
                V oldVal = nextItem.getValue();
                nextItem.setValue(value);
                return oldVal;
            }
        }

        table[index].add(new Entry<>(key,value));
        numKeys++;
        if(numKeys > (LOAD_THRESHOLD * table.length))
            rehash();
        return null;
    }

    private void rehash(){

    }

    @Override
    public V remove(Object key) {
        int index = key.hashCode() % table.length;
        if(index < 0)
            index += table.length;

        if(table[index] == null)
            return null;

        V val = get(table[index]);
        if(val != null){
            table[index].remove(val);
            numKeys--;
            if(table[index].isEmpty())
                table[index] = null;
            return val;
        }

        return null;
    }

    @Override
    public int size() {
        return numKeys;
    }
}
