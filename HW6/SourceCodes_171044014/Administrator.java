/**
 * The type Administrator.
 */
public class Administrator extends AbstractUser implements User{
    private UserType userType = UserType.Administrator;
    private Menu menu = new AdministratorMenu();

    /**
     * Instantiates a new Administrator.
     */
    public Administrator(){
        super();
    }

    /**
     * Instantiates a new Administrator.
     *
     * @param username the username
     * @param password the password
     */
    public Administrator(String username, String password) {
        super(username, password);
    }

    /**
     * Add books.
     *
     * @param books      the books
     * @param authorName the author name
     * @param title      the title
     * @param location   the location
     */
    public void addBooks(BookInformations books, String authorName, String title, String location){
        books.addBook(authorName,title,location);
    }

    public int printMenu(LibraryAutomationSystem system){
        return menu.print(system);
    }

    public UserType getUserType(){ return userType; }
}
