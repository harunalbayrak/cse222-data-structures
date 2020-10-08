/**
 * The type My hash table open.
 *
 * @param <K> the type parameter
 * @param <V> the type parameter
 */
public class myHashTableOpen<K,V> implements KWHashMap<K,V> {
    private Entry<K, V>[] table;
    private static final int START_CAPACITY = 101;
    private double LOAD_THRESHOLD = 0.75;
    private int numKeys;
    private int numDeletes;
    private final Entry<K, V> DELETED = new Entry<K, V>(null, null);

    /**
     * Instantiates a new My hash table open.
     */
    public myHashTableOpen() {
        table = new Entry[START_CAPACITY];
    }

    private int secondHashCode(Object key){
        int hashCode = key.hashCode();
        int result = ((hashCode % 17)*5) % 37;

        return result;
    }

    private int find(Object key){
        int index = key.hashCode() % table.length;
        if(index<0)
            index += table.length;

        int i=1;
        while(table[index]!=null && (!key.equals(table[index].getKey()))){
            index = ++i*secondHashCode(index) % table.length;
            if(index>=table.length)
                index=0;
        }
        return index;
    }

    private void rehash(){
        Entry<K,V>[] oldTable = table;
        table = new Entry[2*oldTable.length + 1];

        numKeys=0;
        numDeletes=0;
        for(int i=0;i<oldTable.length;i++)
            if(oldTable[i] != null && oldTable[i] != DELETED)
                put(oldTable[i].getKey(),oldTable[i].getValue());
    }

    @Override
    public V get(Object key) {
        int index = find(key);

        return table[index] != null ? table[index].getValue() : null;
    }

    @Override
    public boolean isEmpty() {
        return numKeys==0;
    }

    @Override
    public V put(K key, V value) {
        int index = find(key);

        if(table[index] == null){
            table[index] = new Entry<K,V>(key,value);
            numKeys++;

            double loadFactor = (double) (numKeys+numDeletes) / table.length;

            if(loadFactor > LOAD_THRESHOLD)
                rehash();

            return null;
        }

        V oldVal = table[index].getValue();
        table[index].setValue(value);
        return oldVal;
    }

    @Override
    public V remove(Object key) {
        int index = find(key);

        if(table[index] == null){
            return null;
        }

        V oldVal = table[index].getValue();
        table[index] = DELETED;
        numDeletes++;
        numKeys--;
        return oldVal;
    }

    @Override
    public int size() {
        return numKeys;
    }
}
