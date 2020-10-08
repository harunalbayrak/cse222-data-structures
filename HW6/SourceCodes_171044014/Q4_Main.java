/**
 * The type Q 4 main.
 */
public class Q4_Main {
    private static HashTableOpen<Integer, Integer> open;
    private static myHashTableOpen<Integer, Integer> myOpen;
    private static HashTableChain<Integer, Integer> chain;
    private static myHashTableChain<Integer, Integer> myChain;


    /**
     * Main.
     *
     * @param args the args
     */
    public static void main(String[] args){
        testMethods();
    }

    /**
     * Test methods.
     */
    public static void testMethods(){
        testHashMapsPut(0,10000);
        testHashMapsPut(1,10000);
        testHashMapsPut(2,10000);
        testHashMapsPut(3,10000);
        System.out.println("--------------------");
        testHashMapsRemove(0,10000);
        testHashMapsRemove(1,10000);
        testHashMapsRemove(2,10000);
        testHashMapsRemove(3,10000);
    }

    /**
     * Test hash maps put.
     *
     * @param choose the choose
     * @param length the length
     */
    public static void testHashMapsPut(int choose,int length){
        long startTime = System.currentTimeMillis();
        if(choose == 0){
            open = new HashTableOpen<>();
            putElements(open,length);
        }else if(choose == 1){
            myOpen = new myHashTableOpen<>();
            putElements(myOpen,length);
        }else if(choose == 2){
            chain = new HashTableChain<>();
            putElements(chain,length);
        }else if(choose == 3){
            myChain = new myHashTableChain<>();
            putElements(myChain,length);
        }
        long endTime = System.currentTimeMillis();

        if(choose == 0){
            System.out.print("Hash Map Open(Linear Probing-Put Elements-");
        }else if(choose == 1){
            System.out.print("My Hash Map Open(Double Hashing-Put Elements-");
        }else if(choose == 2){
            System.out.print("Hash Map Chain(LinkedList-Put Elements-");
        }else if(choose == 3){
            System.out.print("My Hash Map Chain(TreeSet-Put Elements-");
        }
        System.out.println(length + "): " + (endTime-startTime));
    }

    /**
     * Test hash maps remove.
     *
     * @param choose the choose
     * @param length the length
     */
    public static void testHashMapsRemove(int choose,int length){
        long startTime = System.currentTimeMillis();
        if(choose == 0){
            HashTableOpen<Integer,Integer> open = new HashTableOpen<>();
            removeElements(open,length);
        }else if(choose == 1){
            myHashTableOpen<Integer,Integer> myOpen = new myHashTableOpen<>();
            removeElements(myOpen,length);
        }else if(choose == 2){
            HashTableChain<Integer,Integer> chain = new HashTableChain<>();
            removeElements(chain,length);
        }else if(choose == 3){
            myHashTableChain<Integer,Integer> myChain = new myHashTableChain<>();
            removeElements(myChain,length);
        }
        long endTime = System.currentTimeMillis();

        if(choose == 0){
            System.out.print("Hash Map Open(Linear Probing-Remove Elements-");
        }else if(choose == 1){
            System.out.print("My Hash Map Open(Double Hashing-Remove Elements-");
        }else if(choose == 2){
            System.out.print("Hash Map Chain(LinkedList-Remove Elements-");
        }else if(choose == 3){
            System.out.print("My Hash Map Chain(TreeSet-Remove Elements-");
        }
        System.out.println(length + "): " + (endTime-startTime));
    }

    /**
     * Put elements.
     *
     * @param map    the map
     * @param length the length
     */
    public static void putElements(KWHashMap<Integer,Integer> map,int length){
        for(int i=0;i<length;++i){
            map.put(i,i*3);
        }
    }

    /**
     * Remove elements.
     *
     * @param map    the map
     * @param length the length
     */
    public static void removeElements(KWHashMap<Integer,Integer> map,int length){
        for(int i=0;i<length;++i){
            map.remove(i);
        }
    }
}
