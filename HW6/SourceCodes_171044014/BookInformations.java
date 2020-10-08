import java.util.Scanner;
import java.util.Set;

/**
 * The type Book ınformations.
 */
public class BookInformations {
    private myMap<String,myMap<String,mySet<String>>> information = new myMap<>();

    /**
     * Search by author name.
     *
     * @param authorName the author name
     */
    public void searchByAuthorName(String authorName){
        int input;
        myMap<String,mySet<String>> titleAndLocations = information.get(authorName);

        if(titleAndLocations == null){
            System.out.println("The author is not found.");
        }
        Set<String> titles = titleAndLocations.keySet();
        Object[] arrays = titles.toArray();
        int i=0;
        for(Object tt : arrays){
            System.out.printf("%d - %s\n",i++,tt);
        }
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Please choose number to display its location.(-1 to exit)");
            input = scanner.nextInt();
            if(input == -1)
                break;
            else if (input < 0 || input > i - 1)
                System.out.println("Wrong input! Try again.");
            else
                searchByBookTitle(arrays[input].toString());
        }while(input < 0 || input > i - 1);
    }

    /**
     * Search by book title.
     *
     * @param title the title
     */
    public void searchByBookTitle(String title){
        boolean found = false;
        mySet<String> temp = (mySet<String>) information.keySet();
        for(int i=0;i<temp.size();++i){
            myMap<String,mySet<String>> titleAndLocations = information.get(temp.get(i));
            if(titleAndLocations != null){
                mySet<String> locations = titleAndLocations.get(title);
                if(locations!=null){
                    found = true;
                    for(int j=0;j<locations.size();++j) {
                        if(j == 0)
                            System.out.printf("Author Name: %s ---- Location: %s",temp.get(i),locations.get(j));
                        else
                            System.out.printf(" - %s",locations.get(j));
                    }
                    System.out.println();
                }
            }
        }

        if(!found)
            System.out.println("This book is not found.");
    }

    /**
     * Delete by author name.
     *
     * @param authorName the author name
     */
    public void deleteByAuthorName(String authorName){
        int input;
        myMap<String,mySet<String>> titleAndLocations = information.get(authorName);

        if(titleAndLocations == null)
            return;

        Set<String> titles = titleAndLocations.keySet();
        Object[] arrays = titles.toArray();
        int i=0;
        for(Object tt : arrays){
            System.out.printf("%d - %s\n",i++,tt);
        }
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Please choose number to delete the book.(-1 to exit)");
            input = scanner.nextInt();
            if(input == -1)
                break;
            else if (input < 0 || input > i - 1)
                System.out.println("Wrong input! Try again.");
            else
                deleteByBookTitle(arrays[input].toString());
        }while(input < 0 || input > i - 1);
    }

    /**
     * Delete by book title.
     *
     * @param title the title
     */
    public void deleteByBookTitle(String title){
        boolean found = false;
        mySet<String> temp = (mySet<String>) information.keySet();
        for(int i=0;i<temp.size();++i){
            myMap<String,mySet<String>> titleAndLocations = information.get(temp.get(i));
            if(titleAndLocations != null){
                mySet<String> locations = titleAndLocations.get(title);
                if(locations!=null){
                    found = true;
                    for(int j=0;j<locations.size();++j) {
                            locations.remove(locations.get(j));
                            System.out.println("The book has deleted.");
                    }
                    if(locations.size() == 0)
                        titleAndLocations.remove(0);
                    if(titleAndLocations.size() == 0)
                        information.remove(0);
                    System.out.println();
                }
            }
        }

        if(!found)
            System.out.println("This book is not found.");
    }

    /**
     * Add book.
     *
     * @param author   the author
     * @param title    the title
     * @param location the location
     */
    protected void addBook(String author,String title,String location){
        myMap<String,mySet<String>> secondMap = information.get(author);

        if(secondMap != null){
            mySet<String> innerSet = secondMap.get(title);
            if(innerSet != null){
                innerSet.add(location);
            } else{
                mySet<String> tempSet = new mySet<>();
                tempSet.add(location);
                secondMap.put(title,tempSet);
            }
        } else{
            mySet<String> tempSet = new mySet<>();
            tempSet.add(location);
            myMap<String,mySet<String>> tempMap = new myMap<>();
            tempMap.put(title,tempSet);
            information.put(author,tempMap);
        }
    }

    /**
     * Delete book.
     */
    protected void deleteBook(){
        Scanner scanner = new Scanner(System.in);
        mySet<String> authors = (mySet<String>) information.keySet();
        int m = 0;
        for(String a : authors){
            System.out.println(m + ". " + a);
            m++;
        }
        int choose = 0;
        do {
            if(authors.size() == 0){
                System.out.println("There is no book...");
                break;
            }
            System.out.println("Which author's book would you like to delete?");
            choose = scanner.nextInt();
            if(choose < 0 || choose >= authors.size())
                System.out.println("Wrong input. Try again...");
        }while (choose < 0 || choose >= authors.size());
        if(authors.size() != 0){
            deleteByAuthorName(authors.get(choose));
        }
    }
}
