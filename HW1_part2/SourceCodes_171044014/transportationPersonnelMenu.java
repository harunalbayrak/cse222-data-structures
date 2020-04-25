import java.util.Scanner;

/**
 * The Transportation personnel menu.
 */
public class transportationPersonnelMenu implements Menu {

    @Override
    public void print(AutomationSystem system) {
        Scanner input = new Scanner(System.in);
        int currentTransportationPersonnel = system.currentUserNum[0];
        int choice=0;

        System.out.println("**** TRANSPORTATION PERSONNEL MENU ****");
        System.out.println("**** 1 - Make Update ****");
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
                system.transportation_personnels.get(currentTransportationPersonnel).makeDeliveredUpdate(system);
                break;
            case 2:
                system.userType = 0;
                break;
            case 3:
                System.exit(0);
        }
    }
}
