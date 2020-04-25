import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * The Double-Linked List for Question2
 *
 * @param <E> the type parameter
 */
public class Q2_LinkedList<E> {
    /**
     * The head
     */
    private Q2_Node<E> head=null;
    /**
     * The tail
     */
    private Q2_Node<E> tail=null;
    /**
     * The size of the data
     */
    private int size=0;

    /**
     * The Class of the Node
     * @param <E>
     */
    private static class Q2_Node<E>{
        /**
         * The Data.
         */
        E data;
        /**
         * The Next.
         */
        Q2_Node<E> next;
        /**
         * The Prev.
         */
        Q2_Node<E> prev;

        /**
         * Instantiates a new Q2 node.
         *
         * @param data the data
         * @param next the next
         * @param prev the prev
         */
        public Q2_Node(E data,Q2_Node<E> next,Q2_Node<E> prev){
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }

    /**
     * The size of the data
     *
     * @return the int
     */
    public int size() { return size; }

    /**
     * Add first.
     *
     * @param e the e
     */
    public void addFirst(E e){
        Q2_Node<E> temp;
        temp = new Q2_Node<E>(e,head,null);

        if(head!=null)
            head.prev = temp;
        head = temp;
        if(tail==null)
            tail = temp;
        size++;
    }

    /**
     * Add first.
     *
     * @param e       the e
     * @param removed the removed
     */
    public void addFirst(E e,Q2_LinkedList<E> removed){
        Q2_Node<E> temp;
        if(removed.head==null)
            temp = new Q2_Node<E>(e,head,null);
        else {
            temp = removed.head;
            temp.next = head;
            temp.prev = null;
            temp.data = e;
        }
        if(head!=null)
            head.prev = temp;
        head = temp;
        if(tail==null)
            tail = temp;
        size++;
    }

    /**
     * Add last.
     *
     * @param e the e
     */
    public void addLast(E e){
        Q2_Node<E> temp;
        temp = new Q2_Node<E>(e,null,tail);

        if(tail!=null)
            tail.next = temp;
        tail = temp;
        if(head==null)
            head = temp;
        size++;
    }

    /**
     * Add last.
     *
     * @param e       the e
     * @param removed the removed
     */
    public void addLast(E e,Q2_LinkedList<E> removed){
        Q2_Node<E> temp;
        if(removed.head==null)
            temp = new Q2_Node<E>(e,null,tail);
        else {
            temp = removed.head;
            temp.next = null;
            temp.prev = tail;
            temp.data = e;
        }
        if(tail!=null)
            tail.next = temp;
        tail = temp;
        if(head==null)
            head = temp;
        size++;
    }

    /**
     * Remove first element.
     *
     * @return the element
     */
    public E removeFirst(){
        if(size == 0)
            throw new NoSuchElementException();
        E temp = head.data;
        head = head.next;
        head.prev = null;
        size--;
        return temp;
    }

    /**
     * Remove last element.
     *
     * @return the element
     */
    public E removeLast(){
        if(size==0)
            throw new NoSuchElementException();
        E temp = tail.data;
        tail = tail.prev;
        tail.next = null;
        size--;
        return temp;
    }

    /**
     * Removes at specified index.
     *
     * @param x the x
     */
    protected void removeAtIndex(int x){
        if(head == null || x < 0 || x >= size)
            return;

        Q2_Node<E> temp = head;

        for(int i=0;temp != null && i<x;++i)
            temp = temp.next;

        if(temp == null)
            return;

        if(head == temp)
            head = temp.next;

        if(tail == temp)
            tail = temp.prev;

        if(temp.next != null)
            temp.next.prev = temp.prev;

        if(temp.prev != null)
            temp.prev.next = temp.next;

        temp = null;
    }

    /**
     * Get first.
     *
     * @return the e
     */
    public E getFirst(){
        if(head == null)
            return null;
        else
            return head.data;
    }

    /**
     * Get last.
     *
     * @return the e
     */
    public E getLast(){
        if(tail == null)
            return null;
        else
            return tail.data;
    }

    /**
     * Returns an iterator.
     *
     * @return the iterator
     */
    public Iterator<E> iterator(){
        return new Iter();
    }

    /**
     * Returns an iterator.
     *
     * @param index the index
     * @return the iterator
     */
    public Iterator<E> iterator(int index){
        return new Iter(index);
    }

    /**
     * Returns a descending iterator.
     *
     * @return the descending iterator
     */
    public Iterator<E> descendingIterator(){
        return new DescendingIter();
    }

    /**
     * The class of the Iterator.
     */
    public class Iter implements Iterator<E>{
        /**
         * The Element.
         */
        Q2_Node<E> element;

        /**
         * Instantiates a new Iterator.
         */
        public Iter(){
            element = head;
        }

        /**
         * Instantiates a new Iterator at specified index.
         *
         * @param index the index
         */
        public Iter(int index){
            element = head;
            for(int i=0;i<index||element.next!=null;++i){
                element = element.next;
            }
        }

        @Override
        public boolean hasNext() {
            return element != null;
        }

        @Override
        public E next() {
            E data = element.data;
            element = element.next;
            return data;
        }
    }

    /**
     * The Class of the descending iterator.
     */
    public class DescendingIter implements Iterator<E>{
        /**
         * The Element.
         */
        Q2_Node<E> element;

        /**
         * Instantiates a new Descending iterator.
         */
        public DescendingIter(){
            element = tail;
        }

        @Override
        public boolean hasNext() {
            return element != null;
        }

        @Override
        public E next() {
            E data = element.data;
            element = element.prev;
            return data;
        }
    }
}
