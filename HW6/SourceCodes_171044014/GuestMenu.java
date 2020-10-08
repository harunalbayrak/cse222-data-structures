import java.util.Scanner;

/**
 * The type Guest menu.
 */
public class GuestMenu implements Menu {
    @Override
    public int print(LibraryAutomationSystem system) {
        Scanner scanner = new Scanner(System.in);
        int choose;
        try {
            do {
                System.out.println("-------------------------------------------");
                System.out.println("-- Library Automation System Menu(Guest) --");
                System.out.println("1 - Search using author name");
                System.out.println("2 - Search using title");
                System.out.println("3 - Administrator login");
                System.out.println("(Press -1 to exit)");
                System.out.println("-------------------------------------------");
                choose = scanner.nextInt();

                try {
                    switch (choose) {
                        case 1:
                            system.searchByAuthorName();
                            return 1;
                        case 2:
                            system.searchByTitle();
                            return 2;
                        case 3:
                            system.login();
                            return 3;
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
