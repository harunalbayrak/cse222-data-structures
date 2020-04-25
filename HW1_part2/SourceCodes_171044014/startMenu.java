import java.util.Scanner;

/**
 * The Start menu.
 */
public class startMenu implements Menu {

    @Override
    public void print(AutomationSystem system) {
        Scanner input = new Scanner(System.in);
        int choice=0;

        while (system.userType == 0) {
            System.out.println("**** START MENU ****");
            System.out.println("**** 1 - Login ****");
            System.out.println("**** 2 - Print the System ****");
            System.out.println("**** 3 - Add Admin ****");
            System.out.println("**** 4 - Exit ****");
            try {
                do {
                    choice = input.nextInt();
                    if (choice <= 0 || choice > 4)
                        System.out.println("Wrong Choice. Please Try Again");
                } while (choice <= 0 || choice > 4);
            }
            catch (Exception e){
                System.out.println(e.getMessage());
                choice = -1;
                return;
            }
            switch (choice) {
                case 1:
                    system.login();
                    break;
                case 2:
                    System.out.println(system);
                    break;
                case 3:
                    System.out.println("Unfortunately, Admin cannot be added to the system for now");
                    break;
                case 4:
                    System.exit(0);
            }
        }
    }
}
