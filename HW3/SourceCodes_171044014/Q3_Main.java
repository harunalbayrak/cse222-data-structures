/**
 * The Main of the Question3.
 */
public class Q3_Main {
    /**
     * Main.
     *
     * @param args the args
     */
    public static void main(String[] args){

        testMethod();

    }

    /**
     * Test methods.
     */
    public static void testMethod(){
        Q3_WordLinkedList z0 = new Q3_WordLinkedList("HARUN");
        Q3_WordLinkedList z1 = new Q3_WordLinkedList("ALBAYRAK");
        Q3_WordLinkedList z2 = new Q3_WordLinkedList("MEKAN");
        Q3_WordLinkedList z3 = new Q3_WordLinkedList("ONUR");
        Q3_WordLinkedList z4 = new Q3_WordLinkedList("RESİM");
        Q3_WordLinkedList z5 = new Q3_WordLinkedList("LALE");
        Q3_WordLinkedList z6 = new Q3_WordLinkedList("SAMSUN");
        Q3_WordLinkedList z7 = new Q3_WordLinkedList("OSMAN");

        z0.addCross(z1);
        z0.addCross(z4);
        z1.addCross(z2);
        z1.addCross(z5);
        z2.addCross(z3);
        z3.addCross(z7);
        z4.addCross(z6);

        Q3_CrossWordPuzzle x = new Q3_CrossWordPuzzle();
        x.addWord(z0);
        x.addWord(z1);
        x.addWord(z2);
        x.addWord(z3);
        x.addWord(z4);
        x.addWord(z5);
        x.addWord(z6);
        x.addWord(z7);

        x.print();

        x.removeWord(z3);
        System.out.println("\n\n\n");
        x.print();
    }
}
