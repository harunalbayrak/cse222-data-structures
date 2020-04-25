import java.util.*;

/**
 * The Linked Array List for the Question1.
 *
 * @param <E> the type parameter
 */
public class Q1_LinkedArrayList<E> extends AbstractList<E> implements List<E>  {
    /**
     * Lowest array size
     */
    private static final int LOW_BOUND_ARRAY = 3;
    /**
     * Highest array size
     */
    private static final int MAX_BOUND_ARRAY = 7;
    /**
     * The Head node.
     */
    public Q1_Node<E> head = null;
    /**
     * The Tail node.
     */
    public Q1_Node<E> tail = null;
    private int size = 0;

    private static class Q1_Node<E>{
        /**
         * The Max capacıty.
         */
        final int MAX_CAPACITY;
        /**
         * The Data.
         */
        E[] data;
        /**
         * The Next.
         */
        Q1_Node<E> next = null;
        /**
         * The Prev.
         */
        Q1_Node<E> prev = null;

        /**
         * Instantiates a new Q 1 node.
         *
         * @param item    the item
         * @param MAX_CAP the max cap
         */
        Q1_Node(E item,int MAX_CAP){
            MAX_CAPACITY = MAX_CAP;
            addToArray(item);
        }

        /**
         * Instantiates a new Q 1 node.
         *
         * @param items   the items
         * @param MAX_CAP the max cap
         */
        Q1_Node(E[] items,int MAX_CAP){
            MAX_CAPACITY = MAX_CAP;
            addAllToArray(items);
        }

        /**
         * Add to array boolean.
         *
         * @param element the element
         * @return the boolean
         */
        boolean addToArray(E element){
            if(data == null)
                data = (E[]) new Object[0];
            try {
                if(data.length == MAX_CAPACITY)
                    throw new Exception("Maximum capacity has been reached.");
                E[] temp = (E[]) new Object[data.length+1];
                for (int i = 0; i < data.length; ++i)
                    temp[i] = data[i];
                temp[data.length] = element;
                data = temp;
                return true;
            }
            catch (Exception e){
                System.out.print(e.getMessage());
                System.out.println(" " + element + " could not be added.");
                return false;
            }
        }

        /**
         * Add all to array boolean.
         *
         * @param elements the elements
         * @return the boolean
         */
        boolean addAllToArray(E[] elements){
            if(data == null)
                data = (E[]) new Object[0];
            try {
                if(data.length+elements.length >= MAX_CAPACITY)
                    throw new Exception("Maximum capacity has been exceeded.");
                E[] temp = (E[]) new Object[data.length+elements.length];
                for (int i = 0; i < data.length; ++i)
                    temp[i] = data[i];
                for(int i = 0; i < elements.length; ++i)
                    temp[data.length+i] = elements[i];
                data = temp;
                return true;
            }
            catch (Exception e){
                System.out.print(e.getMessage());
                System.out.println(" " + elements + " could not be added.");
                return false;
            }
        }

        /**
         * Remove from array boolean.
         *
         * @param element the element
         * @return the boolean
         */
        boolean removeFromArray(E element){
            try {
                if(data == null)
                    throw new Exception("Array is empty.");
                for (int i = 0; i < data.length-1; ++i) {
                    if (data[i] == element) {
                        E[] temp = (E[]) new Object[data.length - 1];
                        for (int j = 0; j < i; ++j)
                            temp[j] = data[j];
                        for (int j = 0; j < data.length - i - 1; ++j)
                            temp[j + i] = data[j + i + 1];
                        data = temp;
                        return true;
                    }
                }
            }
            catch (Exception e){
                System.out.println(e.getMessage());
                return false;
            }
            return false;
        }

        /**
         * Remove.
         *
         * @param ind the ind
         */
        void remove(int ind){
            try {
                if(data == null)
                    throw new Exception("Array is empty.");
                for (int i = 0; i < data.length-1; ++i) {
                    if (i == ind) {
                        E[] temp = (E[]) new Object[data.length - 1];
                        for (int j = 0; j < i; ++j)
                            temp[j] = data[j];
                        for (int j = 0; j < data.length - i - 1; ++j)
                            temp[j + i] = data[j + i + 1];
                        data = temp;
                        return;
                    }
                }
            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }
        }

        /**
         * Remove all boolean.
         *
         * @return the boolean
         */
        boolean removeAll(){
            data = null;
            return true;
        }

        /**
         * Is full boolean.
         *
         * @return the boolean
         */
        boolean isFull(){
            return data.length == MAX_CAPACITY;
        }

        /**
         * Gets size.
         *
         * @return the size
         */
        int getSize() { return data.length; }
    }

    /**
     * Instantiates a new linked array list.
     */
    public Q1_LinkedArrayList(){
    }

    /**
     * Instantiates a new linked array list.
     *
     * @param element the element
     */
    public Q1_LinkedArrayList(E element){
        add(element);
    }

    /**
     * Instantiates a new linked array list with Array.
     *
     * @param elements the elements
     * @param MAX      the max
     */
    public Q1_LinkedArrayList(E[] elements,int MAX){
        if(elements.length > MAX){
            Q1_Node<E> temp = new Q1_Node<E>(elements,MAX);
            head = temp;
            size += elements.length;
        } else{
            head = null;
            size = 0;
            System.out.println("Since length of elements array is lower than MAX number, Elements could not be added.");
        }
    }

    /**
     * Returns element at specified element
     * @param index specified index
     * @return element at the specified index
     */
    @Override
    public E get(int index) {
        int i=0;
        if(index < 0){
            throw new IndexOutOfBoundsException("Wrong Index: "+index);
        }
        Q1_Node<E> temp = head;

        while(temp != null){
            if(index < nodeSize(i))
                return nodeData(i,index);
            temp = temp.next;
            i++;
        }
        throw new IndexOutOfBoundsException("Wrong Index: "+index);
    }

    /**
     * Returns size of the nodes
     * @return size of the nodes
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Adds element to the node's array
     * @param element element to be added
     * @return if succeed returns true
     */
    @Override
    public boolean add(E element) {
        linkLast(element);
        return true;
    }

    private int linkLast(E element){
        if(head == null){
            Random r = new Random();
            int MAX = r.nextInt(MAX_BOUND_ARRAY-LOW_BOUND_ARRAY) + LOW_BOUND_ARRAY;
            head = new Q1_Node<E>(element,MAX);
            tail = head;
            size++;
            return -1;
        }

        Q1_Node<E> last = head;

        if(!last.isFull()){
            last.addToArray(element);
            return 1;
        }

        if(last.isFull() && last.next != null){
            while(last.next != null) {
                last = last.next;
                if (!last.isFull()) {
                    last.addToArray(element);
                    return 1;
                }
            }
        }
        if(last.isFull() && last.next == null){
            Random r = new Random();
            int MAX = r.nextInt(MAX_BOUND_ARRAY-LOW_BOUND_ARRAY) + LOW_BOUND_ARRAY;
            Q1_Node<E> temp = new Q1_Node<E>(element,MAX);
            last.next = temp;
            temp.prev = last;
            tail = temp;
            size++;
            return -1;
        }
        return 0;
    }

    private E unLink(E element){
        E x=null;
        int k = 0;
        if(size <= 0)
            throw new NoSuchElementException();
        int sizeNode = nodeSize(0);
        if(sizeNode <= 0)
            throw new NoSuchElementException();

        Q1_Node<E> temp = head;
        while(temp != null){
            for(int i=0;i<nodeSize(k);++i){
                if(temp.data[i].equals(element)){
                    if(i != 0)
                        x = temp.data[i-1];
                    temp.removeFromArray(temp.data[i]);
                    if(nodeSize(k) == 0){
                        if(temp.prev == null){
                            head = temp.next;
                        } else{
                            temp.prev.next = temp.next;
                            temp.prev = null;
                        }
                        if(temp.next == null){
                            tail = temp.prev;
                            temp.prev = null;
                        } else{
                            temp.next.prev = temp.prev;
                            temp.next = null;
                        }
                        size--;
                    }
                    return x;
                }
            }
            k++;
            temp = temp.next;
        }
        return null;
    }

    @Override
    public void add(int index, E element) {
       throw new UnsupportedOperationException();
    }

    /**
     * Clear the Linked Array List
     */
    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * Removes element at specified index
     * @param index the element to be removed
     * @return removed element
     */
    @Override
    public E remove(int index) {
        int max=0;
        for(int i=0;i<size();++i){
            for(int j=0;j<nodeSize(i);++j){
                max++;
            }
        }

        if(index < 0 || index > max){
            throw new IndexOutOfBoundsException("Wrong index: "+ index);
        }

        int count = 0;
        Q1_Node x = head;
        for(int i=0;i<size();++i){
            for(int j=0;j<nodeSize(i);++j){
                if(count == index){
                    x.remove(j);
                    if(x.data.length == 0){
                        if(x.prev == null){
                            head = x.next;
                        } else{
                            x.prev.next = x.next;
                            x.prev = null;
                        }
                        if(x.next == null){
                            tail = x.prev;
                            x.prev = null;
                        } else{
                            x.next.prev = x.prev;
                            x.next = null;
                        }
                        size--;
                    }
                }
                count++;
            }
            x = x.next;
        }

        return null;
    }

    /**
     * Removes specified object
     * @param o the object is given
     * @return if succeed returns true
     */
    @Override
    public boolean remove(Object o) {
        if(o.getClass() != head.data[0].getClass())
            throw new ClassFormatError();
        unLink((E)o);
        return true;
    }

    /**
     * Returns the node size at specified node
     * @param index index of the node
     * @return size of the node
     */
    public int nodeSize(int index){
        if(index < 0 || index > size)
            throw new IndexOutOfBoundsException("Wrong Index: " + index);

        Q1_Node<E> temp = head;
        for(int i=0;i<index;i++){
            temp = temp.next;
        }
        if(temp != null)
            return temp.data.length;
        else
            return -1;
    }

    private E nodeData(int node_index,int index){
        if(node_index < 0 || node_index > size)
            throw new IndexOutOfBoundsException("Wrong Index: " + node_index);

        Q1_Node<E> temp = head;
        for(int i=0;i<node_index;i++){
            temp = temp.next;
        }

        if (index < 0 || index >= temp.data.length)
            throw new IndexOutOfBoundsException("Wrong Index: " + index);

        return temp.data[index];
    }

    @Override
    public String toString() {
        int node_num = 0;
        StringBuilder myString = new StringBuilder();
        Q1_Node<E> temp = head;
        myString.append("--------------------------------\n");
        while(temp != null){
            myString.append(node_num + ".Node : ");
            for(E x : temp.data) {
                myString.append(x + " ");
            }
            myString.append("\n");
            node_num++;
            temp = temp.next;
        }
        myString.append("--------------------------------");
        return myString.toString();
    }

    @Override
    public ListIterator<E> listIterator() {
        return new Q1_ListIterator(0);
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        if(index < 0 || index > size)
            throw new IndexOutOfBoundsException("Wrong Index: " + index);
        return new Q1_ListIterator(index);
    }

    /**
     * List iterator for Linked array list
     *
     * @return the list iterator
     */
    public Q1_ListIterator Q1_listIterator(){
        return new Q1_ListIterator(0);
    }

    /**
     * List iterator for Linked array list
     *
     * @param index the index
     * @return the list iterator
     */
    public Q1_ListIterator Q1_listIterator(int index) {
        if(index < 0 || index > size)
            throw new IndexOutOfBoundsException("Wrong Index: " + index);
        return new Q1_ListIterator(index);
    }

    private class Q1_ListIterator implements ListIterator<E>{
        private E lastReturned;
        private Q1_LinkedArrayList.Q1_Node<E> next;
        private int indexNode;
        private int indexArray = 0;

        /**
         * Instantiates a new list iterator for linked array list.
         *
         * @param indexNode the index node
         */
        Q1_ListIterator(int indexNode){
            if(indexNode < 0 || indexNode >= size)
                throw new IndexOutOfBoundsException("Wrong Index: " + indexNode);

            lastReturned = null;
            if(indexNode == size){
                this.indexNode = size;
                next = null;
            } else {
                next = head;
                for(this.indexNode = 0; this.indexNode < indexNode;this.indexNode++){
                    next = next.next;
                }
            }
        }

        @Override
        public boolean hasNext() {
            if(indexArray == -1)
                indexArray = 0;
            if(indexArray < nodeSize(indexNode)){
                return true;
            }
            if(indexArray == nodeSize(indexNode) && indexNode == size-1){
                return false;
            }
            if(indexArray == nodeSize(indexNode) && indexNode < size){
                Q1_LinkedArrayList.Q1_Node<E> x = head;
                for(int i=0;i<indexNode;++i)
                    x = x.next;
                next = x.next;
                indexNode++;
                indexArray = 0;
                return indexArray < nodeSize(indexNode);
            }
            else{
                return false;
            }
        }

        @Override
        public E next() {
            if (!hasNext())
                throw new NoSuchElementException();

            lastReturned = nodeData(indexNode,indexArray++);
            return lastReturned;
        }

        @Override
        public boolean hasPrevious() {
            if(indexNode == size)
                indexNode--;
            if(indexNode < 0)
                return false;
            else if(indexNode == 0 && indexArray < 0)
                return false;
            if(indexArray >= nodeSize(indexNode)){
                indexArray--;
                indexArray = nodeSize(indexNode) - 1;
            }
            else if(indexArray < 0){
                indexNode--;
                indexArray = nodeSize(indexNode) - 1;
            }
            return true;
        }

        @Override
        public E previous() {
            if (!hasPrevious())
                throw new NoSuchElementException();

            lastReturned = nodeData(indexNode,indexArray--);
            return lastReturned;
        }

        @Override
        public int nextIndex() {
            return indexNode;
        }

        @Override
        public int previousIndex() {
            return indexNode - 1;
        }

        @Override
        public void remove() {
            int x = size();
            //E x = nodeData(size-1,nodeSize(size-1));
            lastReturned = unLink(lastReturned);
            if(x != size()){
                indexNode--;
            }
        }

        @Override
        public void set(E e) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void add(E e) {
            int a = linkLast(e);
            if(a == -1) {
                indexArray=0;
                indexNode++;
            }else if(a == 1){
                indexArray++;
            }
        }
    }
}
