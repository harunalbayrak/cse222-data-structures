import java.util.Scanner;

/**
 * The Branch employee Menu.
 */
public class branchEmployeeMenu implements Menu {

    @Override
    public void print(AutomationSystem system) {
        Scanner input = new Scanner(System.in);
        int currentBranch = system.currentUserNum[0];
        int currentBranchEmployee = system.currentUserNum[1];
        int choice=0;

        System.out.println("**** BRANCH EMPLOYEE MENU ****");
        System.out.println("**** 1 - Add Product ****");
        System.out.println("**** 2 - Remove Product ****");
        System.out.println("**** 3 - Add Customer ****");
        System.out.println("**** 4 - Remove Customer ****");
        System.out.println("**** 5 - Add Information ****");
        System.out.println("**** 6 - Remove Information ****");
        System.out.println("**** 7 - Log Out ****");
        System.out.println("**** 8 - Exit ****");
        try {
            do {
                choice = input.nextInt();
                if(choice <= 0 || choice > 8)
                    System.out.println("Wrong Choice. Please Try Again");
            }while(choice <= 0 || choice > 8);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            choice = -1;
            return;
        }
        switch (choice) {
            case 1:
                system.branches.get(currentBranch).branch_employees.get(currentBranchEmployee).addProduct(system);
                break;
            case 2:
                system.branches.get(currentBranch).branch_employees.get(currentBranchEmployee).removeProduct(system);
                break;
            case 3:
                system.branches.get(currentBranch).branch_employees.get(currentBranchEmployee).addCustomer(system);
                break;
            case 4:
                system.branches.get(currentBranch).branch_employees.get(currentBranchEmployee).removeCustomer(system);
                break;
            case 5:
                system.branches.get(currentBranch).branch_employees.get(currentBranchEmployee).addInformation(system);
                break;
            case 6:
                system.branches.get(currentBranch).branch_employees.get(currentBranchEmployee).removeInformation(system);
                break;
            case 7:
                system.userType = 0;
                break;
            case 8:
                System.exit(0);
        }
    }
}
