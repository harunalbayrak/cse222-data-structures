import java.util.*;

/**
 * The type My map.
 *
 * @param <K> the type parameter
 * @param <V> the type parameter
 */
public class myMap<K,V> implements Map<K,V> {
    private List<K> key;
    private List<V> value;

    /**
     * Instantiates a new My map.
     */
    public myMap(){
        key = new ArrayList<>();
        value = new ArrayList<>();
    }

    @Override
    public int size() {
        return key.size();
    }

    @Override
    public boolean isEmpty() {
        return key.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return this.key.contains(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return this.value.contains(value);
    }

    @Override
    public V get(Object key) {
        int indexOf = this.key.indexOf(key);
        return (indexOf == -1) ? null : value.get(indexOf);
    }

    @Override
    public V put(K key, V value) {
        this.key.add(key);
        this.value.add(value);
        return value;
    }

    @Override
    public V remove(Object key) {
        int indexOf = this.key.indexOf(key);
        if(indexOf == -1)
            return null;

        V oldVal = this.value.get(indexOf);
        this.value.remove(indexOf);
        return oldVal;
    }

    /**
     * Remove.
     *
     * @param index the index
     */
    public void remove(int index) {
        key.remove(index);
        value.remove(index);
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void clear() {
        key.clear();
        value.clear();
    }

    @Override
    public Set<K> keySet() {
        Set<K> temp = new mySet<>();
        temp.addAll(key);
        return temp;
    }

    @Override
    public Collection<V> values() {
        return new ArrayList<>(value);
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return null;
    }
}
