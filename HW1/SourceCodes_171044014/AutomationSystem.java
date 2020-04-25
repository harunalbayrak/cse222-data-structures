import java.util.Scanner;

/**
 * The Automation system
 */
public class AutomationSystem {
    /**
     * The Admins.
     */
    protected Administrator[] admins = new Administrator[1];
    /**
     * The Branches.
     */
    protected Branch[] branches = new Branch[1];
    /**
     * The Transportation personnels.
     */
    protected TransportationPersonnel[] transportation_personnels = new TransportationPersonnel[1];
    /**
     * The Customers.
     */
    protected Customer[] customers = new Customer[0];
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
        admins[0] = new Administrator();
        branches[0] = new Branch();
        transportation_personnels[0] = new TransportationPersonnel();
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
        admins[0] = new Administrator(aUser,aPass);
        branches[0] = new Branch(bName);
        transportation_personnels[0] = new TransportationPersonnel(tUser,tPass);
        userType = 0;
    }

    /**
     * Login.
     */
    public void login(){
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter your username");
        String username = input.nextLine();
        System.out.println("Please enter your password");
        String password = input.nextLine();

        for(int i=0;i<admins.length;++i){
            if(username.equals(admins[i].username) && password.equals(admins[i].password)){
                userType = 1;
                System.out.println("You have successfully logged in. You are a Administrator.");
                currentUserNum[0] = i;
                break;
            }
        }
        for(int i=0;i<branches.length;++i){
            for(int j=0;j<branches[i].branch_employees.length;++j) {
                if (username.equals(branches[i].branch_employees[j].username) && password.equals(branches[i].branch_employees[j].password)) {
                    userType = 2;
                    System.out.println("You have successfully logged in. You are a Branch Employee.");
                    currentUserNum[0] = i;
                    currentUserNum[1] = j;
                    break;
                }
            }
        }
        for(int i=0;i<transportation_personnels.length;++i){
            if(username.equals(transportation_personnels[i].username) && password.equals(transportation_personnels[i].password)){
                userType = 3;
                System.out.println("You have successfully logged in. You are a Transportation Personnel.");
                currentUserNum[0] = i;
                break;
            }
        }
        for(int i=0;i<customers.length;++i){
            if(username.equals(customers[i].username) && password.equals(customers[i].password)){
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
     * Add admin.
     */
    public void addAdmin(){
        Scanner input = new Scanner(System.in);
        String admin_username,admin_password;
        do {
            System.out.println("Please enter username of the Admin ");
            admin_username = input.nextLine();
            if(checkIsThere(admin_username))
                System.out.println("The admin using this username already exists.");
        }while(checkIsThere(admin_username));

        System.out.println("Please enter password of the Admin ");
        admin_password = input.nextLine();

        Administrator[] _admins = new Administrator[admins.length + 1];

        for(int i=0;i<admins.length;++i){
            _admins[i] = admins[i];
        }
        _admins[admins.length] = new Administrator(admin_username,admin_password);
        admins = _admins;

        System.out.println("Admin is successfully added.");
        for(int i=0;i<admins.length;++i)
            System.out.println(i + " : " + admins[i].username);
    }

    /**
     * Check if is there same username
     *
     * @param user the username
     * @return the boolean
     */
    public boolean checkIsThere(String user){
        for(int i=0;i<admins.length;++i){
            if(user.equals(admins[i].username)){
                //System.out.println("The user using this username already exists.");
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString(){
        String all = "";
        String _admins = "-Admin(s)\n",_branches = "-Branch(es)\n",_branchesEmployee = "-Branch Employee(s)\n",
                _products = "-Product(s)\n",_transportationPersonnels = "-Transportation Personnel(s)\n",_customers = "-Customer(s)\n";
        for(int i=0;i<admins.length;++i){
            if(i == 0)
                _admins += "username: " + admins[i].username + " | password: " + admins[i].password + " (Automatically created) " + "\n";
            else
                _admins += "username: " + admins[i].username + " | password: " + admins[i].password +"\n";
        }
        for(int i=0;i<branches.length;++i){
            if(i == 0)
                _branches += "branch name: " + branches[i].branchName + " (Automatically created) " + "\n";
            else
                _branches += "branch name: " + branches[i].branchName + "\n";
            for(int j=0;j<branches[i].branch_employees.length;++j) {
                if(branches[i].branch_employees[j].username.contains("branch_employee"))
                    _branchesEmployee += "username: " + branches[i].branch_employees[j].username + " | password: " + branches[i].branch_employees[j].password + " ( " + i + ".branch )" + " (Automatically created) " + "\n";
                else
                    _branchesEmployee += "username: " + branches[i].branch_employees[j].username + " | password: " + branches[i].branch_employees[j].password + " ( " + i + ".branch ) " + "\n";
            }
            for(int j=0;j<branches[i].products.length;++j) {
                _products += "tracking number: " + branches[i].products[j].trackingNum + " ( " + i + ".branch )" + " ( " + branches[i].products[j].information + " ) " + "\n";
            }
        }
        for(int i=0;i<transportation_personnels.length;++i){
            if(i == 0)
                _transportationPersonnels += "username: " + transportation_personnels[i].username  + " | password: " + transportation_personnels[i].password + " (Automatically created) " + "\n";
            else
                _transportationPersonnels += "username: " + transportation_personnels[i].username  + " | password: " + transportation_personnels[i].password + "\n";
        }
        for(int i=0;i<customers.length;++i){
            _customers += "username: " + customers[i].username + "\n";
        }
        all += _admins + "----------\n" + _branches + "----------\n" + _branchesEmployee
                + "----------\n" + _products  + "----------\n" + _transportationPersonnels + "----------\n" + _customers;

        return all;
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        testSystem();
    }

    /**
     * Test system.
     */
    public static void testSystem(){
        AutomationSystem test_system = new AutomationSystem();
        System.out.println("A test system was created automatically.");
        System.out.println(test_system);

        while(true) {
            switch (test_system.userType) {
                case 0:
                    startMenu(test_system);
                case 1:
                    adminMenu(test_system);
                    break;
                case 2:
                    branchEmployeeMenu(test_system);
                    break;
                case 3:
                    transportationPersonnelMenu(test_system);
                    break;
                case 4:
                    customerMenu(test_system);
                    break;
            }
        }
    }

    /**
     * Start menu.
     *
     * @param system the system
     */
    public static void startMenu(AutomationSystem system){
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
                    system.addAdmin();
                    break;
                case 4:
                    System.exit(0);
            }
        }
    }

    /**
     * Admin menu.
     *
     * @param system the system
     */
    public static void adminMenu(AutomationSystem system){
        Scanner input = new Scanner(System.in);
        int currentAdmin = system.currentUserNum[0];
        int choice=0;

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
            }
            catch (Exception e){
                System.out.println(e.getMessage());
                choice = -1;
                return;
            }
            switch (choice) {
                case 1:
                    system.admins[currentAdmin].addBranch(system);
                    break;
                case 2:
                    system.admins[currentAdmin].removeBranch(system);
                    break;
                case 3:
                    system.admins[currentAdmin].addBranchEmployee(system);
                    break;
                case 4:
                    system.admins[currentAdmin].removeBranchEmployee(system);
                    break;
                case 5:
                    system.admins[currentAdmin].addTransportationPersonnel(system);
                    break;
                case 6:
                    system.admins[currentAdmin].removeTransportationPersonnel(system);
                    break;
                case 7:
                    system.userType = 0;
                    break;
                case 8:
                    System.exit(0);
            }
        }
    }

    /**
     * Branch employee menu.
     *
     * @param system the system
     */
    public static void branchEmployeeMenu(AutomationSystem system){
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
                system.branches[currentBranch].branch_employees[currentBranchEmployee].addProduct(system.branches[currentBranch]);
                break;
            case 2:
                system.branches[currentBranch].branch_employees[currentBranchEmployee].removeProduct(system.branches[currentBranch]);
                break;
            case 3:
                system.branches[currentBranch].branch_employees[currentBranchEmployee].addCustomer(system);
                break;
            case 4:
                system.branches[currentBranch].branch_employees[currentBranchEmployee].removeCustomer(system);
                break;
            case 5:
                system.branches[currentBranch].branch_employees[currentBranchEmployee].addInformation(system.branches[currentBranch]);
                break;
            case 6:
                system.branches[currentBranch].branch_employees[currentBranchEmployee].removeInformation(system.branches[currentBranch]);
                break;
            case 7:
                system.userType = 0;
                break;
            case 8:
                System.exit(0);
        }
    }

    /**
     * Transportation personnel menu.
     *
     * @param system the system
     */
    public static void transportationPersonnelMenu(AutomationSystem system){
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
                system.transportation_personnels[currentTransportationPersonnel].makeDeliveredUpdate(system);
                break;
            case 2:
                system.userType = 0;
                break;
            case 3:
                System.exit(0);
        }
    }

    /**
     * Customer menu.
     *
     * @param system the system
     */
    public static void customerMenu(AutomationSystem system){
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
                system.customers[currentCustomer].TrackProduct(system);
                break;
            case 2:
                system.userType = 0;
                break;
            case 3:
                System.exit(0);
        }
    }
}
