import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * The Simple Text Editor for Question2.
 */
public class Q2_SimpleTextEditor {
    /**
     * The filename path.
     */
    private final String FILENAME;
    /**
     * The List.
     */
    private List<Character> list;

    /**
     * Instantiates simple text editor.
     *
     * @param listType the list type(ArrayList or LinkedList)
     * @throws Exception the exception
     */
    Q2_SimpleTextEditor(String listType,String FILENAME) throws Exception {
        this.FILENAME = FILENAME;
        if(listType.equals("LinkedList"))
            list = new LinkedList<>();
        else if(listType.equals("ArrayList"))
            list = new ArrayList<>();
        else
            throw new Exception("This list type is not available. List type can be LinkedList or ArrayList.");
    }

    /**
     * Read method without iterator
     */
    public void read(){
        String file = FILENAME;
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String string;
            while((string = br.readLine()) != null) {
                for (int i = 0; i < string.length(); ++i) {
                    list.add(string.charAt(i));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Read with iterator
     */
    public void readWithIterator(){
        String file = FILENAME;
        ListIterator<Character> iter = list.listIterator();
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String string;
            while((string = br.readLine()) != null) {
                for (int i = 0; i < string.length(); ++i) {
                    iter.add(string.charAt(i));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Add method without iterator
     *
     * @param str the string to be added
     * @param index the index
     */
    public void add(String str,int index){
        if(index < 0 || index > list.size())
            throw new IndexOutOfBoundsException("Wrong index : " + index);

        for(int i=0;i<str.length();++i){
            list.add(index+i,str.charAt(i));
        }
    }

    /**
     * Add with iterator.
     *
     * @param str   the string to be added
     * @param index the index
     */
    public void addWithIterator(String str,int index){
        ListIterator<Character> iter = list.listIterator(index);
        if(index < 0 || index > list.size())
            throw new IndexOutOfBoundsException("Wrong index : " + index);

        for(int i=0;i<str.length();++i){
            iter.add(str.charAt(i));
        }
    }

    /**
     * Find method without iterator
     *
     * @param str the string to be found
     * @return the int
     */
    public int find(String str){
        String result = list.toString().replaceAll("[\\[\\]]", "").replaceAll(", ","");
        return result.indexOf(str);
    }

    /**
     * Find with iterator
     *
     * @param str the string to be found
     * @return the int
     */
    public int findWithIterator(String str){
        int count=0,count2=0;
        ListIterator<Character> iter = list.listIterator();

        while(iter.hasNext()){
            count++;
            count2=0;
            for(int i=0;i<str.length();++i){
                if(iter.hasNext()) {
                    if (iter.next() == str.charAt(i)) {
                        count2++;
                        if (i == str.length() - 1) {
                            return count-1;
                        }
                    } else {
                        break;
                    }
                }
            }
            for(int j=0;j<count2;++j){
                if(iter.hasPrevious())
                    iter.previous();
            }
        }
        return -1;
    }

    /**
     * Replace method without iterator
     *
     * @param c   the char for the replacement
     * @param rep the replacement char
     */
    public void replace(Character c,Character rep){
        String result = list.toString().replaceAll("[\\[\\]]", "").replaceAll(", ","").replaceAll(c.toString(),rep.toString());
        for(int i=0;i<list.size();++i){
                list.set(i,result.charAt(i));
        }
    }

    /**
     * Replace with iterator.
     *
     * @param c   the char for the replacement
     * @param rep the replacement char
     */
    public void replaceWithIterator(Character c,Character rep){
        ListIterator<Character> iter = list.listIterator();

        while(iter.hasNext()){
            if(iter.next().equals(c)){
                iter.set(rep);
            }
        }
    }

    public List<Character> getList(){
        return list;
    }
}
