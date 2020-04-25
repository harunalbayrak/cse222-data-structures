import java.util.Scanner;

/**
 * The Customer menu.
 */
public class customerMenu implements Menu {

    @Override
    public void print(AutomationSystem system) {
        Scanner input = new Scanner(System.in);
        int currentCustomer = system.currentUserNum[0];
        int choice=0;

        System.out.println("**** CUSTOMER MENU ****");
        System.out.println("**** 1 - Track the Product ****");
        System.out.println("**** 2 - Log Out ****");
        System.out.println("**** 3 - Exit ****");
        try {
            do {
                choice = input.nextInt();
                if (choice <= 0 || choice > 3)
                    System.out.println("Wrong Choice. Please Try Again");
            } while (choice <= 0 || choice > 3);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            choice = -1;
            return;
        }
        switch (choice) {
            case 1:
                system.customers.get(currentCustomer).TrackProduct(system);
                break;
            case 2:
                system.userType = 0;
                break;
            case 3:
                System.exit(0);
        }
    }
}
