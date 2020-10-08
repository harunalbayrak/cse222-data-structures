import java.util.Scanner;

/**
 * The type Administrator menu.
 */
public class AdministratorMenu implements Menu {
    @Override
    public int print(SoftwareStore system) {
        Scanner scanner = new Scanner(System.in);
        int choose;

        try{
            do{
                System.out.println("-------------------------------------------");
                System.out.println("-- Library Automation System Menu(Admin) --");
                System.out.println("1 - Browse the software");
                System.out.println("2 - Add Software");
                System.out.println("3 - Update Software");
                System.out.println("4 - Delete Software");
                System.out.println("5 - Administrator logout");
                System.out.println("(Press -1 to exit)");
                System.out.println("-------------------------------------------");
                try {
                    choose = scanner.nextInt();
                    switch (choose){
                        case 1:
                            system.search();
                            return 1;
                        case 2:
                            system.addSoftware();
                            return 2;
                        case 3:
                            system.updateSoftware();
                            return 3;
                        case 4:
                            system.deleteSoftware();
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
