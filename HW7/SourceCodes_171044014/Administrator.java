import java.util.Scanner;

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

    public int printMenu(SoftwareStore system){
        return menu.print(system);
    }

    @Override
    public void addSoftware(SoftwareStore store) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Please enter of software's name(with version)");
            String name = scanner.nextLine();

            System.out.println("Please enter of software's price");
            String price = scanner.nextLine();

            Software temp = new Software(name, price);

            if (store.getSoftwareTree().add(temp)) {
                System.out.println(temp);
            } else {
                System.out.println("Its quantity has been incremented.");
                store.getSoftwareTree().find(temp).incrementQuantity();
                System.out.println(store.getSoftwareTree().find(temp));
            }
        } catch (Exception ex){
            System.out.println("It could not be added.");
        }
    }

    public void updateSoftware(SoftwareStore store){
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Please enter of software's name(with version) to update");
            String name = scanner.nextLine();

            Software searched = store.getSoftwareTree().find(new Software(name,"0"));
            if (searched != null) {
                System.out.println("Which property of the software do you want to update?(-1 to exit)");
                System.out.println("1 - Change the name");
                System.out.println("2 - Increase quantity");
                System.out.println("3 - Decrease quantity(Sell operation)");
                System.out.println("4 - Change the price");
                int choose = 0;
                String newName,newPrice;
                do{
                    choose = scanner.nextInt();
                    if(choose != -1 && (choose < 1 || choose > 4))
                        System.out.println("Wrong input...");
                }while(choose != -1 && (choose < 1 || choose > 4));
                Scanner scanner2 = new Scanner(System.in);
                switch (choose){
                    case -1:
                        break;
                    case 1:
                        System.out.println("Please enter new name you want");
                        newName = scanner2.nextLine();
                        searched.setName(newName);
                        System.out.println("Successfully changed. -- New Name: " + searched.getName());
                        break;
                    case 2:
                        searched.incrementQuantity();
                        System.out.println("Successfully increased. -- New Quantity: " + searched.getQuantity());
                        break;
                    case 3:
                        searched.incrementQuantity();
                        System.out.println("Successfully decreased. -- New Quantity: " + searched.getQuantity());
                        if(searched.getQuantity() == 0){
                            System.out.println("Since the quantity decreased to zero, it have been deleted.");
                            store.getSoftwareTree().delete(new Software(name));
                        }
                        break;
                    case 4:
                        System.out.println("Please enter new price you want");
                        newPrice = scanner2.nextLine();
                        searched.setPrice(newPrice);
                        System.out.println("Successfully changed. -- New Price: " + searched.getPrice());
                        break;
                }
            } else {
                System.out.println("The item could not be found.");
            }
        } catch (Exception ex){
            System.out.println("The item could not be found.");
        }
    }

    public void deleteSoftware(SoftwareStore store){
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Please enter of software's name(with version) to delete");
            String name = scanner.nextLine();

            Software searched = store.getSoftwareTree().find(new Software(name,"0"));
            if (searched != null) {
                if(store.getSoftwareTree().delete(searched) != null)
                    System.out.println("The item has been successfully deleted.");
                else
                    System.out.println("The item could not be deleted.");
            } else {
                System.out.println("The item could not be deleted(or it could not be found).");
            }
        } catch (Exception ex){
            System.out.println("The item could not be deleted(or it could not be found).");
        }
    }

    public UserType getUserType(){ return userType; }
}
