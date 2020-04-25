import java.util.Scanner;

/**
 * The Admin Menu
 */
public class adminMenu implements Menu {

    @Override
    public void print(AutomationSystem system) {
        Scanner input = new Scanner(System.in);
        int currentAdmin = system.currentUserNum[0];
        int choice = 0;

        while (system.userType == 1) {
            System.out.println("**** ADMIN MENU ****");
            System.out.println("**** 1 - Add Branch ****");
            System.out.println("**** 2 - Remove Branch ****");
            System.out.println("**** 3 - Add Branch Employee ****");
            System.out.println("**** 4 - Remove Branch Employee ****");
            System.out.println("**** 5 - Add Transportation Personel ****");
            System.out.println("**** 6 - Remove Transportation Personel ****");
            System.out.println("**** 7 - Log Out ****");
            System.out.println("**** 8 - Exit ****");
            try {
                do {
                    choice = input.nextInt();
                    if (choice <= 0 || choice > 8)
                        System.out.println("Wrong Choice. Please Try Again");
                } while (choice <= 0 || choice > 8);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                choice = -1;
                return;
            }

            switch (choice) {
                case 1:
                    system.admins.get(currentAdmin).addBranch(system);
                    break;
                case 2:
                    system.admins.get(currentAdmin).removeBranch(system);
                    break;
                case 3:
                    system.admins.get(currentAdmin).addBranchEmployee(system);
                    break;
                case 4:
                    system.admins.get(currentAdmin).removeBranchEmployee(system);
                    break;
                case 5:
                    system.admins.get(currentAdmin).addTransportationPersonnel(system);
                    break;
                case 6:
                    system.admins.get(currentAdmin).removeTransportationPersonnel(system);
                    break;
                case 7:
                    system.userType = 0;
                    break;
                case 8:
                    System.exit(0);
            }
        }
    }
}
