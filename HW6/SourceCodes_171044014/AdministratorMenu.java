import java.util.Scanner;

/**
 * The type Administrator menu.
 */
public class AdministratorMenu implements Menu {
    @Override
    public int print(LibraryAutomationSystem system) {
        Scanner scanner = new Scanner(System.in);
        int choose;

        try{
            do{
                System.out.println("-------------------------------------------");
                System.out.println("-- Library Automation System Menu(Admin) --");
                System.out.println("1 - Search using author name");
                System.out.println("2 - Search using title");
                System.out.println("3 - Add book");
                System.out.println("4 - Delete book");
                System.out.println("5 - Administrator logout");
                System.out.println("(Press -1 to exit)");
                System.out.println("-------------------------------------------");
                try {
                    choose = scanner.nextInt();
                    switch (choose){
                        case 1:
                            system.searchByAuthorName();
                            return 1;
                        case 2:
                            system.searchByTitle();
                            return 2;
                        case 3:
                            system.addBook();
                            return 3;
                        case 4:
                            system.deleteBook();
                            return 4;
                        case 5:
                            system.logout();
                            return 5;
                        case -1:
                            return -1;
                    }
                } catch (Exception ex){
                    return 0;
                }
            }while (system.getUser().getUserType().equals(UserType.Administrator));
        } catch (Exception ex){
            System.out.println("Wrong Input...");
            system.menu();
        }
        return -1;
    }
}
