import java.util.ArrayList;
import java.util.Scanner;

/**
 * The Automation system
 */
public class AutomationSystem {
    /**
     * The Admins.
     */
    protected ArrayList<Administrator> admins = new ArrayList<Administrator>();
    /**
     * The Branches.
     */
    protected ArrayList<Branch> branches = new ArrayList<Branch>();
    /**
     * The Transportation personnels.
     */
    protected ArrayList<TransportationPersonnel> transportation_personnels = new ArrayList<TransportationPersonnel>();
    /**
     * The Customers.
     */
    protected ArrayList<Customer> customers = new ArrayList<Customer>();
    /**
     * The User type.
     */
    protected int userType;
    /**
     * The Current user index
     */
    protected int[] currentUserNum = new int[2];

    /**
     * Instantiates a new Automation system.
     */
    public AutomationSystem(){
        admins.add(new Administrator());
        branches.add(new Branch());
        transportation_personnels.add(new TransportationPersonnel());
        userType = 0;
    }

    /**
     * Instantiates a new Automation system.
     *
     * @param aUser the admin username
     * @param aPass the admin password
     * @param bName the branch name
     * @param tUser the transportation personnel username
     * @param tPass the transportation personnel password
     */
    public AutomationSystem(String aUser,String aPass,String bName,String tUser,String tPass){
        admins.add(new Administrator(aUser,aPass));
        branches.add(new Branch(bName));
        transportation_personnels.add(new TransportationPersonnel(tUser,tPass));
        userType = 0;
    }

    /**
     * Login.
     */
    public void login(){
        String username="",password="";
        try {
            Scanner input = new Scanner(System.in);
            System.out.println("Please enter your username");
            username = input.nextLine();
            System.out.println("Please enter your password");
            password = input.nextLine();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        for(int i=0;i<admins.size();++i){
            if(username.equals(admins.get(i).username) && password.equals(admins.get(i).password)){
                userType = 1;
                System.out.println("You have successfully logged in. You are a Administrator.");
                currentUserNum[0] = i;
                break;
            }
        }
        for(int i=0;i<branches.size();++i){
            for(int j=0;j<branches.get(i).branch_employees.size();++j) {
                if (username.equals(branches.get(i).branch_employees.get(j).username) && password.equals(branches.get(i).branch_employees.get(j).password)) {
                    userType = 2;
                    System.out.println("You have successfully logged in. You are a Branch Employee.");
                    currentUserNum[0] = i;
                    currentUserNum[1] = j;
                    break;
                }
            }
        }
        for(int i=0;i<transportation_personnels.size();++i){
            if(username.equals(transportation_personnels.get(i).username) && password.equals(transportation_personnels.get(i).password)){
                userType = 3;
                System.out.println("You have successfully logged in. You are a Transportation Personnel.");
                currentUserNum[0] = i;
                break;
            }
        }
        for(int i=0;i<customers.size();++i){
            if(username.equals(customers.get(i).username) && password.equals(customers.get(i).password)){
                userType = 4;
                System.out.println("You have successfully logged in. You are a Customer.");
                currentUserNum[0] = i;
                break;
            }
        }
        if(userType == 1 || userType == 2 || userType == 3 || userType == 4)
            return;
        else
            System.out.println("You entered an incorrect username or password.");
    }

    /**
     * The main function.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        AutomationSystem test_system = new AutomationSystem();
        System.out.println("A test system was created automatically.");
        startMenu start_menu = new startMenu();
        adminMenu admin_menu = new adminMenu();
        branchEmployeeMenu branchemployee_menu = new branchEmployeeMenu();
        transportationPersonnelMenu transportationpersonnel_menu = new transportationPersonnelMenu();
        customerMenu customer_menu = new customerMenu();

        while(true) {
            switch (test_system.userType) {
                case 0:
                    start_menu.print(test_system);
                    break;
                case 1:
                    admin_menu.print(test_system);
                    break;
                case 2:
                    branchemployee_menu.print(test_system);
                    break;
                case 3:
                    transportationpersonnel_menu.print(test_system);
                    break;
                case 4:
                    customer_menu.print(test_system);
                    break;
            }
        }


    }

    @Override
    public String toString(){
        String all = "";
        String _admins = "-Admin(s)\n",_branches = "-Branch(es)\n",_branchesEmployee = "-Branch Employee(s)\n",
                _products = "-Product(s)\n",_transportationPersonnels = "-Transportation Personnel(s)\n",_customers = "-Customer(s)\n";
        for(int i=0;i<admins.size();++i){
            if(i==0)
                _admins += "username: " + admins.get(i).username + " | password: " + admins.get(i).password + " (Automatically created) " + "\n";
            else
                _admins += "username: " + admins.get(i).username + " | password: " + admins.get(i).password +"\n";
        }
        for(int i=0;i<branches.size();++i){
            if(branches.get(i).branchName.contains("branch"))
                _branches += "branch name: " + branches.get(i).branchName + " (Automatically created) " + "\n";
            else
                _branches += "branch name: " + branches.get(i).branchName + "\n";
            for(int j=0;j<branches.get(i).branch_employees.size();++j) {
                if(branches.get(i).branch_employees.get(j).username.contains("branch_employee"))
                    _branchesEmployee += "username: " + branches.get(i).branch_employees.get(j).username + " | password: " + branches.get(i).branch_employees.get(j).password + " ( " + i + ".branch )" + " (Automatically created) " + "\n";
                else
                    _branchesEmployee += "username: " + branches.get(i).branch_employees.get(j).username + " | password: " + branches.get(i).branch_employees.get(j).password + " ( " + i + ".branch ) " + "\n";
            }
            for(int j=0;j<branches.get(i).products.size();++j) {
                _products += "tracking number: " + branches.get(i).products.get(j).trackingNum + " ( " + i + ".branch )" + " ( " + branches.get(i).products.get(j).information + " ) " + "\n";
            }
        }
        for(int i=0;i<transportation_personnels.size();++i){
            if(i == 0)
                _transportationPersonnels += "username: " + transportation_personnels.get(i).username  + " | password: " + transportation_personnels.get(i).password + " (Automatically created) " + "\n";
            else
                _transportationPersonnels += "username: " + transportation_personnels.get(i).username  + " | password: " + transportation_personnels.get(i).password + "\n";
        }
        for(int i=0;i<customers.size();++i){
            _customers += "username: " + customers.get(i).username + "\n";
        }
        all += _admins + "----------\n" + _branches + "----------\n" + _branchesEmployee
                + "----------\n" + _products  + "----------\n" + _transportationPersonnels + "----------\n" + _customers;

        return all;
    }
}
