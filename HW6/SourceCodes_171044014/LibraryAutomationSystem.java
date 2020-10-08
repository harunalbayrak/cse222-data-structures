import java.util.Scanner;

/**
 * The type Library automation system.
 */
public class LibraryAutomationSystem implements AutomationSystem{
    private User user = new Guest();
    private BookInformations books;
    private static int bookCount = 0;

    /**
     * Instantiates a new Library automation system.
     */
    public LibraryAutomationSystem(){
        books = new BookInformations();
    }

    /**
     * Delete book.
     */
    public void deleteBook(){
        if(user.getUserType().equals(UserType.Administrator))
            books.deleteBook();
    }

    /**
     * Add book.
     */
    public void addBook(){
        if(user.getUserType().equals(UserType.Administrator)) {
            Scanner sc = new Scanner(System.in);
            String authorName="null",title="null";
            int shelfNo=0,corridorNo=0;
            String location = "c0s0." + bookCount++;

            try {
                System.out.print("Please enter author name: ");
                authorName = sc.nextLine();

                System.out.print("Please enter title of the book: ");
                title = sc.nextLine();

                System.out.print("Please enter shelf no: ");
                shelfNo = sc.nextInt();

                System.out.print("Please enter corridor no: ");
                corridorNo = sc.nextInt();

                location = "c" +
                        corridorNo +
                        "s" +
                        shelfNo +
                        "." +
                        bookCount;
                System.out.println("The book has added.");
                System.out.println(authorName + " - " + title + " - " + location);
            } catch (Exception ex){
                System.out.println("The book has added.");
                System.out.println(authorName + " - " + title + " - " + location);
            }

            books.addBook(authorName,title, location);
        }
    }

    /**
     * Menu.
     */
    public void menu() {
        int m = 1;
        while (m != -1) {
             m = user.printMenu(this);
        }
    }

    @Override
    public void searchByAuthorName() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter an author name you want to search: ");
        String author = sc.nextLine();
        books.searchByAuthorName(author);
    }

    @Override
    public void searchByTitle() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter title of the book you want to search: ");
        String title = sc.nextLine();
        books.searchByBookTitle(title);
    }

    @Override
    public void login() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Username : ");
        String username = scanner.nextLine();
        System.out.print("Password : ");
        String password = scanner.nextLine();

        if(username.equals("admin") && password.equals("1234")){
            System.out.println("You have successfully logged in.");
            user = new Administrator("admin","1234");
        } else{
            System.out.println("Password or username is wrong you entered.");
        }
    }

    @Override
    public void logout() {
        user = new Guest();
    }

    /**
     * Get user user.
     *
     * @return the user
     */
    public User getUser(){ return user; }
}
