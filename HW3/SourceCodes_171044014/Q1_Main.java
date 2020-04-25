import java.util.ListIterator;

/**
 * Main of the Question 1
 */
public class Q1_Main {
    /**
     * Main.
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
        //Linked array list implementation
        Q1_LinkedArrayList<String> linked_array_list = new Q1_LinkedArrayList<>();

        //Adding Operations
        for(int i=0;i<4;++i){
            linked_array_list.add("Harun"+i);
        }
        for(int i=0;i<4;++i){
            linked_array_list.add("Albayrak"+i);
        }
        for(int i=0;i<4;++i){
            linked_array_list.add("CSE"+i);
        }

        //Size of the nodes, size of the nodes' array
        System.out.println("Size of Nodes: " + linked_array_list.size());
        for(int i=0;i<linked_array_list.size();++i){
            System.out.println("Size of Array(" + i + ".node): " + linked_array_list.nodeSize(i));
        }

        //Prints the linked array list
        System.out.println(linked_array_list);

        //Remove method remove(Object o)
        linked_array_list.remove("Harun1");
        linked_array_list.remove("Albayrak2");
        linked_array_list.remove("123123123");

        linked_array_list.remove(0);
        linked_array_list.remove(3);


        //ListIterator implementation
        ListIterator<String> iter = linked_array_list.listIterator();

        //iter.hasNext() and iter.next()
        System.out.print("The iterator(next) : ");
        while(iter.hasNext())
            System.out.print(iter.next() + " ");

        //adding operation with ListIterator
        iter.add("EklenenString");
        for(int i=2;i<5;++i){
            iter.add("AddingIter"+i);
        }

        //Printing the system
        System.out.println();
        System.out.println(linked_array_list);

        //iter.hasPrevious() and iter.previous()
        System.out.print("The iterator(previous) : ");
        while(iter.hasPrevious()) {
            System.out.print(iter.previous() + " ");
        }

        System.out.println();
        //and again iter.hasNext() and iter.next()
        System.out.print("The iterator(next) : ");
        while(iter.hasNext()) {
            System.out.print(iter.next() + " ");
        }
    }
}
