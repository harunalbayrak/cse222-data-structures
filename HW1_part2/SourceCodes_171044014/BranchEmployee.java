import java.util.Scanner;

/**
 * The Branch Employee class
 */
public class BranchEmployee extends User implements UserInterface {
    /**
     * The Branch index.
     */
    protected int branchIndex;

    /**
     * Instantiates a new Branch employee.
     *
     * @param branchIndex the branch index
     */
    public BranchEmployee(int branchIndex){
        super("branch_employee" + User.count ,"1234");
        this.branchIndex = branchIndex;
    }

    /**
     * Instantiates a new Branch employee.
     *
     * @param user        the user
     * @param pass        the pass
     * @param branchIndex the branch index
     */
    public BranchEmployee(String user,String pass,int branchIndex){
        super(user,pass);
        this.branchIndex = branchIndex;
    }

    @Override
    public boolean checkIsThere(String string, AutomationSystem system, int which) {
        if(which == 0) {
            for (int i = 0; i < system.branches.get(branchIndex).products.size(); ++i) {
                if (string.equals(system.branches.get(branchIndex).products.get(i).trackingNum)) {
                    System.out.println("The tracking number already exists.");
                    return true;
                }
            }
        } else if(which == 1) {
            for (int i = 0; i < system.customers.size(); ++i) {
                if (string.equals(system.customers.get(i).username)) {
                    System.out.println("The customer already exists.");
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void print(AutomationSystem system, int which) {
        final Branch branch = system.branches.get(branchIndex);
        if(which == 0){
            for(int i=0;i<branch.products.size();++i)
                System.out.println(i + " : " + branch.products.get(i).trackingNum + " - "
                        + branch.products.get(i).senderNameSurname + " - " + branch.products.get(i).receiverNameSurname
                        + " - " + branch.products.get(i).information);
        } else if(which == 1){
            for(int i=0;i<system.customers.size();++i)
                System.out.println(i + " : " + system.customers.get(i).username);
        }
    }

    /**
     * Add product.
     *
     * @param system the system
     */
    public void addProduct(AutomationSystem system){
        Scanner input = new Scanner(System.in);
        String information,trackingNum,senderNameSurname,receiverNameSurname;
        do {
            System.out.println("Please enter tracking number of the product ");
            trackingNum = input.nextLine();
        }while(checkIsThere(trackingNum,system,0));

        System.out.println("Please enter Name and Surname of the sender ");
        senderNameSurname = input.nextLine();

        System.out.println("Please enter Name and Surname of the receiver ");
        receiverNameSurname = input.nextLine();

        System.out.println("Please enter information about the product ");
        information = input.nextLine();

        try {
            system.branches.get(branchIndex).products.add(new Product(information, trackingNum, senderNameSurname, receiverNameSurname));
            System.out.println("The Product is successfully added.");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        print(system,0);
    }

    /**
     * Add customer.
     *
     * @param system the system
     */
    public void addCustomer(AutomationSystem system){
        Scanner input = new Scanner(System.in);
        String user_username,user_password;
        do {
            System.out.println("Please enter username of the User ");
            user_username = input.nextLine();
        }while(checkIsThere(user_username,system,1));

        System.out.println("Please enter password of the User ");
        user_password = input.nextLine();

        try {
            system.customers.add(new Customer(user_username, user_password));
            System.out.println("Customer is successfully added.");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        print(system,1);
    }

    /**
     * Add information.
     *
     * @param system the system
     */
    public void addInformation(AutomationSystem system){
        Scanner input = new Scanner(System.in);
        Scanner input2 = new Scanner(System.in);
        String information;
        int productNum=0;

        if(system.branches.get(branchIndex).products.size() == 0){
            System.out.println("There is no product in this branch.");
            return;
        }

        System.out.println("Which product would you like to add information about?");
        print(system,0);
        do {
            try{
                productNum = input.nextInt();
            }
            catch(Exception e){
                System.out.println("Automatically 0.product is choosen.");
                System.out.println(e.getMessage());
            }
            if(productNum < 0 || productNum >= system.branches.get(branchIndex).products.size())
                System.out.println("Wrong Input. Try Again...");
        }while(productNum < 0 || productNum >= system.branches.get(branchIndex).products.size());

        System.out.println("Please enter information ");
        information = input2.nextLine();

        try {
            system.branches.get(branchIndex).products.get(productNum).information = information;
            System.out.println("The information is added.");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    /**
     * Remove product.
     *
     * @param system the system
     */
    public void removeProduct(AutomationSystem system){
        Scanner input = new Scanner(System.in);
        int productNum=0;

        if(system.branches.get(branchIndex).products.size() == 0){
            System.out.println("There is no product in this branch.");
            return;
        }

        System.out.println("Which branch would you like to remove the product?");
        print(system,0);
        do {
            try{
                productNum = input.nextInt();
            }
            catch(Exception e){
                System.out.println("Automatically 0.product is removed.");
                System.out.println(e.getMessage());
            }
            if(productNum < 0 || productNum >= system.branches.get(branchIndex).products.size())
                System.out.println("Wrong Input. Try Again...");
        }while(productNum < 0 || productNum >= system.branches.get(branchIndex).products.size());

        try {
            system.branches.get(branchIndex).products.remove(productNum);
            System.out.println("The Product is successfully removed.");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        print(system,0);
    }

    /**
     * Remove customer.
     *
     * @param system the system
     */
    public void removeCustomer(AutomationSystem system){
        Scanner input = new Scanner(System.in);
        int userNum=0;

        if(system.customers.size() == 0){
            System.out.println("There is no customers in this system.");
            return;
        }

        System.out.println("Which branch would you like to remove the customer?");
        print(system,1);
        do {
            try{
                userNum = input.nextInt();
            }
            catch(Exception e){
                System.out.println("Automatically 0.customer is removed.");
                System.out.println(e.getMessage());
            }
            if(userNum < 0 || userNum >= system.customers.size())
                System.out.println("Wrong Input. Try Again...");
        }while(userNum < 0 || userNum >= system.customers.size());

        try {
            system.customers.remove(userNum);
            System.out.println("The Customer is successfully removed.");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        print(system,1);
    }

    /**
     * Remove information.
     *
     * @param system the system
     */
    public void removeInformation(AutomationSystem system){
        Scanner input = new Scanner(System.in);
        int productNum=0;

        if(system.branches.get(branchIndex).products.size() == 0){
            System.out.println("There is no product in this branch.");
            return;
        }

        System.out.println("Which product would you like to remove information about?");
        print(system,0);
        do {
            try{
                productNum = input.nextInt();
            }
            catch(Exception e){
                System.out.println("Automatically 0.product's information is removed.");
                System.out.println(e.getMessage());
            }
            if(productNum < 0 || productNum >= system.branches.get(branchIndex).products.size())
                System.out.println("Wrong Input. Try Again...");
        }while(productNum < 0 || productNum >= system.branches.get(branchIndex).products.size());

        try {
            system.branches.get(branchIndex).products.get(productNum).removeInformation();
            System.out.println("The information is removed.");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}
