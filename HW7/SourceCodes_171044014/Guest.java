/**
 * The type Guest.
 */
public class Guest extends AbstractUser implements User{
    private UserType userType = UserType.Administrator;
    private Menu menu = new GuestMenu();

    /**
     * Instantiates a new Guest.
     */
    public Guest(){
        super();
    }

    /**
     * Instantiates a new Guest.
     *
     * @param username the username
     * @param password the password
     */
    public Guest(String username, String password) {
        super(username, password);
    }

    public int printMenu(SoftwareStore system){
        return menu.print(system);
    }

    @Override
    public void addSoftware(SoftwareStore store) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void updateSoftware(SoftwareStore store) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteSoftware(SoftwareStore store) {
        throw new UnsupportedOperationException();
    }

    public UserType getUserType(){ return userType; }
}
