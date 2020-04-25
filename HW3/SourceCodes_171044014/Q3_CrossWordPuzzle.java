import java.util.ArrayList;

/**
 * The Cross Word Puzzle for the Question3.
 */
public class Q3_CrossWordPuzzle {
    /**
     * The Words.
     */
    ArrayList<Q3_WordLinkedList> words = new ArrayList<Q3_WordLinkedList>();

    /**
     * Instantiates a new Q 3 cross word puzzle.
     */
    Q3_CrossWordPuzzle(){}

    /**
     * Add word to the arraylist.
     *
     * @param word the word
     */
    public void addWord(Q3_WordLinkedList word){
        words.add(word);
    }

    /**
     * Remove word from the arraylist.
     *
     * @param word the word
     */
    public void removeWord(Q3_WordLinkedList word){
        words.remove(word);
    }

    /**
     * Print the puzzle.
     */
    public void print(){
        System.out.print(this);
    }

    public String toString(){
        StringBuilder string = new StringBuilder();
        for(int i=0;i<words.size();++i){
            string.append(words.get(i));
            string.append("\n");
        }
        return string.toString();
    }
}
