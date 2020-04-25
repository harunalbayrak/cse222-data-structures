import java.util.*;

/**
 * The Word Linked List for the Question3.
 */
public class Q3_WordLinkedList {
    /**
     * The Head Node.
     */
    public Node head=null;
    private int size=0;
    private int id=0;
    /**
     * The constant countClass.
     */
    public static int countClass=0;
    private final String theWord;
    /**
     * The Array List of Cross indexes.
     */
    public ArrayList<Integer> crossIndexes = new ArrayList<>();
    /**
     * The Array List of Cross classes.
     */
    public ArrayList<Integer> crossClasses = new ArrayList<>();
    /**
     * The Array List of Cross words.
     */
    public ArrayList<String> crossWords = new ArrayList<>();

    /**
     * Instantiates a new Word linked list with string.
     *
     * @param string the string
     */
    Q3_WordLinkedList(String string){
        theWord = string;
        id = countClass++;
        for(int i=0;i<string.length();++i){
            add(string.charAt(i));
        }
    }

    /**
     * Add cross word.
     *
     * @param wd the word list.
     */
    public void addCross(Q3_WordLinkedList wd){
        boolean exit=false;
        Character a,b;
        Node x = head;
        Node y = wd.head;

        for(int i=0;i < this.size();x=x.next,i++){
            if(exit)
                break;
            a = x.item;
            y = wd.head;
            for(int j=0; j < wd.size();y=y.next,j++){
                b = y.item;
                if(a == b && crossIndexAvailability(i) && wd.crossIndexAvailability(j)){
                    this.crossIndexes.add(i);
                    this.crossClasses.add(wd.id);
                    this.crossWords.add(wd.getTheWord());
                    wd.crossIndexes.add(j);
                    wd.crossClasses.add(this.id);
                    wd.crossWords.add(this.getTheWord());
                    exit = true;
                    break;
                }
            }
        }
    }

    /**
     * Remove cross.
     *
     * @param index the index
     */
    public void removeCross(int index){
        if(crossIndexes.contains(index)){
            int x = crossIndexes.indexOf(index);
            crossClasses.remove(x);
            crossWords.remove(x);
            crossIndexes.remove(new Integer(index));
        }
    }

    /**
     * Print method.
     */
    public void print(){
        System.out.println(this);
    }

    /**
     * Checks index availability.
     *
     * @param index the index
     * @return the boolean
     */
    public boolean crossIndexAvailability(int index){
        Iterator<Integer> iter = crossIndexes.iterator();

        while(iter.hasNext()) {
            if (iter.next() == index)
                return false;
            else
                return true;
        }
        return true;
    }

    /**
     * Get the word string.
     *
     * @return the string
     */
    public String getTheWord(){
        return theWord;
    }

    /**
     * Add method
     *
     * @param item the item
     * @return the boolean
     */
    public boolean add(Character item){
        add(size,item);
        return true;
    }

    /**
     * Add method(index,item)
     *
     * @param index the index
     * @param item  the item
     */
    public void add(int index,Character item){
        if(index < 0 || index > size)
            throw new IndexOutOfBoundsException("Wrong index: " + index);

        if(index == 0){
            addFirst(item);
        } else{
            Node n = getNode(index-1);
            addAfter(n,item);
        }
    }

    private void addAfter(Node node,Character item){
        node.next = new Node(node,item);
        size++;
    }

    private void addFirst(Character item){
        head = new Node(head,item);
        size++;
    }

    private Node getNode(int index){
        Node n = head;
        for(int i=0; i<index;++i){
            n = n.next;
        }
        return n;
    }

    private Character get(int index){
        Node n = head;
        for(int i=0; i<index;++i){
            n = n.next;
        }
        return n.item;
    }

    /**
     * Size of the word.
     *
     * @return the int
     */
    public int size() { return size; }

    public String toString(){
        StringBuilder string = new StringBuilder("The Word: ");
        string.append(this.getTheWord());
        string.append("\n");
        for(int i=0;i<this.crossIndexes.size();++i){
            if(i==0){
                string.append("---------------\n");
                string.append("Its cross words\n");
            }
            string.append(this.crossWords.get(i));
            string.append(" - in ");
            string.append(this.crossIndexes.get(i));
            string.append(".index");
            string.append("\n");
        }
        return string.toString();
    }

    private static class Node {
        /**
         * The character.
         */
        Character item;
        /**
         * The Next node.
         */
        Node next=null;
        /**
         * Instantiates a new Node.
         *
         * @param next    the next
         * @param element the element
         */
        Node(Node next, Character element) {
            this.item = element;
            this.next = next;
        }
    }
}
