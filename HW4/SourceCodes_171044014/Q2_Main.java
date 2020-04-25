import java.util.Iterator;

/**
 * The Main of Question2
 */
public class Q2_Main {
    /**
     * The Main of Question2
     *
     * @param args the args
     */
    public static void main(String[] args){
        testMethod();
    }

    /**
     * Test method.
     */
    public static void testMethod(){
        Q2_Deque<String> deneme = new Q2_Deque<>();
        deneme.addLast("Harun1");
        deneme.addLast("Harun2");
        deneme.offerLast("Harun3");
        deneme.offerLast("Harun4");
        deneme.addLast("Harun5");
        deneme.offerFirst("Harun6");
        deneme.addFirst("Harun7");

        Iterator<String> iter = deneme.iterator();
        while(iter.hasNext()){
            System.out.print(iter.next()+" ");
        }
        System.out.println();

        Iterator<String> descendingIter = deneme.descendingIterator();
        while(descendingIter.hasNext()){
            System.out.print(descendingIter.next()+" ");
        }
        System.out.println();

        deneme.pollLast();
        deneme.pollFirst();

        Iterator<String> iter2 = deneme.iterator();
        while(iter2.hasNext()){
            System.out.print(iter2.next()+" ");
        }
        System.out.println();

        deneme.removeFirstOccurrence("Harun1");

        Iterator<String> iter3 = deneme.iterator();
        while(iter3.hasNext()){
            System.out.print(iter3.next()+" ");
        }
        System.out.println();

        deneme.removeLast();
        deneme.removeFirst();

        Iterator<String> iter4 = deneme.iterator();
        while(iter4.hasNext()){
            System.out.print(iter4.next()+" ");
        }
        System.out.println();

        System.out.println(deneme.peekFirst());
        System.out.println(deneme.peekLast());
        System.out.println(deneme.getFirst());
        System.out.println(deneme.getLast());
    }
}
