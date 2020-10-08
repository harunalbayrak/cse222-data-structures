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
}
