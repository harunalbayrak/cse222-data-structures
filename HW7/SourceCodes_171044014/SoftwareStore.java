import java.util.Scanner;

/**
 * The type Software store.
 */
public class SoftwareStore implements Store {
    private User user = new Guest();
    private RedBlackTree<Software> softwareTree = new RedBlackTree<>();

    /**
     * Instantiates a new Software store.
     */
    public SoftwareStore(){
        softwareTree.add(new Software("Adobe Photoshop 6.0","15.99"));
        softwareTree.add(new Software("Adobe Photoshop 6.2","19.99"));
        softwareTree.add(new Software("Norton 4.5","12.49"));
        softwareTree.add(new Software("Norton 5.5","17.99"));
        softwareTree.add(new Software("Adobe Flash 3.3","27.99"));
        softwareTree.add(new Software("Adobe Flash 4.0","29.99"));
    }

    /**
     * Search.
     */
    public void search(){
        user.search(this);
    }

    /**
     * Add software.
     */
    public void addSoftware(){
        if(user.getUserType().equals(UserType.Administrator))
            user.addSoftware(this);
    }

    /**
     * Update software.
     */
    public void updateSoftware(){
        if(user.getUserType().equals(UserType.Administrator))
            user.updateSoftware(this);
    }

    /**
     * Delete software.
     */
    public void deleteSoftware(){
        if(user.getUserType().equals(UserType.Administrator))
            user.deleteSoftware(this);
    }

    @Override
    public void login() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Username : ");
        String username = scanner.nextLine();
        System.out.print("Password : ");
        String password = scanner.nextLine();

        if (username.equals("admin") && password.equals("1234")) {
            System.out.println("You have successfully logged in.");
            user = new Administrator("admin", "1234");
        } else {
            System.out.println("Password or username is wrong you entered.");
        }
    }

    @Override
    public void logout() {
        user = new Guest();
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

    /**
     * Get user user.
     *
     * @return the user
     */
    public User getUser(){ return user; }

    /**
     * Gets software tree.
     *
     * @return the software tree
     */
    public RedBlackTree<Software> getSoftwareTree() {
        return softwareTree;
    }
}
