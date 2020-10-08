import java.util.*;

/**
 * The type My set.
 *
 * @param <E> the type parameter
 */
public class mySet<E> implements Set<E> {
    /**
     * The Data.
     */
    public List<E> data;

    /**
     * Instantiates a new My set.
     */
    public mySet(){
        data = new ArrayList<>();
    }

    @Override
    public int size() {
        return data.size();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return data.contains(o);
    }

    @Override
    public Iterator<E> iterator() {
        return data.iterator();
    }

    @Override
    public Object[] toArray() {
        Object[] temp = new Object[data.size()];
        int i=0;
        for(E t : data) {
            temp[i++] = (Object) t;
        }
        return temp;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        E[] temp = (E[]) new Object[data.size()];
        int i=0;
        for(E t : data) {
            temp[i++] = t;
        }
        return (T[]) temp;
    }

    @Override
    public boolean add(E e) {
        if(data.contains(e))
            return false;
        return data.add(e);
    }

    @Override
    public boolean remove(Object o) {
        return data.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return data.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        Iterator iter = c.iterator();
        if(iter.hasNext()){
            Object temp = iter.next();
            if(data.contains(temp)){
                return false;
            }
        }
        return data.addAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return data.retainAll(c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return data.removeAll(c);
    }

    @Override
    public void clear() {
        data = new ArrayList<>();
    }

    /**
     * Get e.
     *
     * @param index the index
     * @return the e
     */
    public E get(int index){
        if(index < 0 || index >= data.size())
            throw new IndexOutOfBoundsException();
        return data.get(index);
    }
}
