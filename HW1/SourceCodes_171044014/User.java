/**
 * The User Abstract Class
 */
public abstract class User {
    /**
     * The Username.
     */
    protected String username;
    /**
     * The Password.
     */
    protected String password;
    /**
     * The number of users
     */
    protected static int count=0;

    /**
     * Instantiates a new User.
     */
    public User(){
        username = "Null" + count;
        password = "Null" + count;
        count++;
    }

    /**
     * Instantiates a new User.
     *
     * @param user the user
     * @param pass the pass
     */
    public User(String user,String pass){
        username = user;
        password = pass;
        count++;
    }
}
