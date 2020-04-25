import java.util.*;

/**
 * The Deque for Question2
 *
 * @param <E> the type parameter
 */
public class Q2_Deque<E> extends AbstractCollection<E> implements Deque<E> {
    /**
     * The data
     */
    private Q2_LinkedList<E> data = new Q2_LinkedList<E>();
    /**
     * The removed data
     */
    private Q2_LinkedList<E> removedData = new Q2_LinkedList<E>();

    /**
     * Return an iterator
     */
    @Override
    public Iterator<E> iterator() {
        return data.iterator();
    }

    /**
     * Return a descending iterator
     */
    @Override
    public Iterator<E> descendingIterator() {
        return data.descendingIterator();
    }

    /**
     * Adds a element to the first of the data
     * @param e Element
     */
    @Override
    public void addFirst(E e) {
        try {
            data.addFirst(e, removedData);
        } catch (Exception err){
            System.out.println(err.getMessage());
        }
    }

    /**
     * Adds a element to the last of the data
     * @param e Element
     */
    @Override
    public void addLast(E e) {
        try {
            data.addLast(e, removedData);
        } catch (Exception err){
            System.out.println(err.getMessage());
        }
    }

    /**
     * Adds a element to the first of the data
     * @param e Element
     */
    @Override
    public boolean offerFirst(E e) {
        try {
            data.addFirst(e, removedData);
            return true;
        } catch (Exception err){
            System.out.println(err.getMessage());
            return false;
        }
    }

    /**
     * Adds a element to the last of the data
     * @param e Element
     */
    @Override
    public boolean offerLast(E e) {
        try {
            data.addLast(e, removedData);
            return true;
        } catch (Exception err){
            System.out.println(err.getMessage());
            return false;
        }
    }

    /**
     * Removes a element from the first of the data
     */
    @Override
    public E removeFirst() {
        if(data.size() <= 0)
            throw new NoSuchElementException();
        try {
            E temp = data.removeFirst();
            removedData.addFirst(temp);
            return temp;
        } catch (Exception err){
            System.out.println(err.getMessage());
            return null;
        }
    }

    /**
     * Removes a element from the last of the data
     */
    @Override
    public E removeLast() {
        if(data.size() <= 0)
            throw new NoSuchElementException();
        try {
            E temp = data.removeLast();
            removedData.addFirst(temp);
            return temp;
        } catch (Exception err){
            System.out.println(err.getMessage());
            return null;
        }
    }

    /**
     * Removes a element from the first of the data
     */
    @Override
    public E pollFirst() {
        if(data.size() <= 0)
            return null;
        try {
            E temp = data.removeFirst();
            removedData.addFirst(temp);
            return temp;
        } catch (Exception err){
            System.out.println(err.getMessage());
            return null;
        }
    }

    /**
     * Removes a element from the last of the data
     */
    @Override
    public E pollLast() {
        if(data.size() <= 0)
            return null;
        try {
            E temp = data.removeLast();
            removedData.addFirst(temp);
            return temp;
        } catch (Exception err){
            System.out.println(err.getMessage());
            return null;
        }
    }

    /**
     * Returns the first of the data
     */
    @Override
    public E getFirst() {
        if(data.size() <= 0)
            throw new NoSuchElementException();

        return data.getFirst();
    }

    /**
     * Returns the last of the data
     */
    @Override
    public E getLast() {
        if(data.size() <= 0)
            throw new NoSuchElementException();

        return data.getLast();
    }

    /**
     * Returns the first of the data
     */
    @Override
    public E peekFirst() {
        if(data.size() <= 0)
            return null;

        return getFirst();
    }

    /**
     * Returns the last of the data
     */
    @Override
    public E peekLast() {
        if(data.size() <= 0)
            return null;

        return getLast();
    }

    /**
     * Removes a first occurrence of object
     * @param o The Object
     */
    @Override
    public boolean removeFirstOccurrence(Object o) {
        int count = 0;
        if(data.size() <= 0)
            return false;

        Iterator itr = iterator();

        try {
            while(itr.hasNext()){
                if(itr.next().equals(o)){
                    data.removeAtIndex(count);
                    return true;
                }
                count++;
            }
        }catch (Exception err){
            System.out.println(err.getMessage());
            return false;
        }
        return false;
    }

    /**
     * Removes a last occurrence of object
     * @param o The Object
     */
    @Override
    public boolean removeLastOccurrence(Object o) {
        int count = 0;
        if(data.size() <= 0)
            return false;

        Iterator itr = descendingIterator();

        try {
            while(itr.hasNext()){
                if(itr.next().equals(o)){
                    data.removeAtIndex(data.size()-count-1);
                    return true;
                }
                count++;
            }
        }catch (Exception err){
            System.out.println(err.getMessage());
            return false;
        }
        return false;
    }

    /**
     * Adds a element to the last of the data
     * @param e Element
     */
    @Override
    public boolean offer(E e) {
        return offerLast(e);
    }

    /**
     * Removes a element from the last of the data
     */
    @Override
    public E remove() {
        return removeLast();
    }

    /**
     * Removes a element from the last of the data
     */
    @Override
    public E poll() {
        return pollLast();
    }

    @Override
    public E element() {
        throw new UnsupportedOperationException();
    }

    /**
     * Returns the last of the data
     */
    @Override
    public E peek() {
        return peekLast();
    }

    /**
     * Throws a UnSupportedOperationException
     * @param e Element
     */
    @Override
    public void push(E e) {
        throw new UnsupportedOperationException();
    }

    /**
     * Throws a UnSupportedOperationException
     */
    @Override
    public E pop() {
        throw new UnsupportedOperationException();
    }

    /**
     * Return size of the data
     * @return size of the data
     */
    @Override
    public int size() {
        return data.size();
    }

    /**
     * Return string of the data
     * @return string of the data
     */
    @Override
    public String toString() {
        StringBuilder n = new StringBuilder();
        Iterator itr = data.iterator();
        while(itr.hasNext()){
            n.append(itr.next() + " ");
        }
        n.append("\n");
        return n.toString();
    }
}
