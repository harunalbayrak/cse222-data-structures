import java.util.Scanner;

/**
 * The type Abstract user.
 */
public abstract class AbstractUser implements User{
    private String username;
    private String password;

    /**
     * Instantiates a new Abstract user.
     */
    public AbstractUser(){
        username = "guest";
        password = "guest";
    }

    /**
     * Instantiates a new Abstract user.
     *
     * @param username the username
     * @param password the password
     */
    public AbstractUser(String username,String password){
        this.username = username;
        this.password = password;
    }

    @Override
    public void search(SoftwareStore store) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Please enter of software's name(with version) to search");
            String name = scanner.nextLine();

            Software searched = store.getSoftwareTree().find(new Software(name));
            if(searched != null){
                System.out.print("Found: ");
                System.out.println(searched);
            } else{
                System.out.println("The item could not be found.");
            }
        } catch (Exception ex){
            System.out.println("The item could not be deleted(or it could not be found).");
        }
    }
}
