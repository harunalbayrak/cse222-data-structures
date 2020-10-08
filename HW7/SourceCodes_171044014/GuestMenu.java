import java.util.Scanner;

/**
 * The type Guest menu.
 */
public class GuestMenu implements Menu {
    @Override
    public int print(SoftwareStore system) {
        Scanner scanner = new Scanner(System.in);
        int choose;
        try {
            do {
                System.out.println("-------------------------------------------");
                System.out.println("******     Admin username: admin     ******");
                System.out.println("******     Admin password: 1234      ******");
                System.out.println("-- Library Automation System Menu(Guest) --");
                System.out.println("1 - Browse the software");
                System.out.println("2 - Administrator login");
                System.out.println("(Press -1 to exit)");
                System.out.println("-------------------------------------------");
                choose = scanner.nextInt();

                try {
                    switch (choose) {
                        case 1:
                            system.search();
                            return 1;
                        case 2:
                            system.login();
                            return 2;
                        case -1:
                            return -1;
                    }
                } catch (Exception ex) {
                    return 0;
                }
            } while (system.getUser().getUserType().equals(UserType.Guest));
        } catch (Exception ex){
            System.out.println("Wrong Input...");
            system.menu();
        }
        return -1;
    }
}
