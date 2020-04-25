import java.util.Scanner;

/**
 * The Branch Employee Class
 */
public class BranchEmployee extends User{
    /**
     * Instantiates a new Branch employee.
     */
    public BranchEmployee(){
        super("branch_employee" + User.count ,"1234");
    }

    /**
     * Instantiates a new Branch employee.
     *
     * @param user the username
     * @param pass the password
     */
    public BranchEmployee(String user,String pass){
        super(user,pass);
    }

    /**
     * Add product.
     *
     * @param branch the branch
     */
    public void addProduct(Branch branch){
        Scanner input = new Scanner(System.in);
        String information,trackingNum,senderNameSurname,receiverNameSurname;
        do {
            System.out.println("Please enter tracking number of the product ");
            trackingNum = input.nextLine();
            if(checkIsThere(trackingNum,branch))
                System.out.println("The product is already exists.");
        }while(checkIsThere(trackingNum,branch));

        System.out.println("Please enter Name and Surname of the sender ");
        senderNameSurname = input.nextLine();

        System.out.println("Please enter Name and Surname of the receiver ");
        receiverNameSurname = input.nextLine();

        System.out.println("Please enter information about the product ");
        information = input.nextLine();

        Product[] products = new Product[branch.products.length + 1];
        for(int i=0;i<branch.products.length;++i)
            products[i] = branch.products[i];
        products[branch.products.length] = new Product(information,trackingNum,senderNameSurname,receiverNameSurname);
        branch.products = products;

        System.out.println("The Product is successfully added.");
        for(int i=0;i<branch.products.length;++i)
            System.out.println(i + " : " + branch.products[i].trackingNum + " - "
                    + branch.products[i].senderNameSurname + " - " + branch.products[i].receiverNameSurname
                    + " - " + branch.products[i].information);
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
            if(checkIsThere(user_username,system))
                System.out.println("The user using this username already exists.");
        }while(checkIsThere(user_username,system));

        System.out.println("Please enter password of the User ");
        user_password = input.nextLine();

        Customer[] user = new Customer[system.customers.length + 1];

        for(int i=0;i<system.customers.length;++i){
            user[i] = system.customers[i];
        }
        user[system.customers.length] = new Customer(user_username,user_password);
        system.customers = user;

        System.out.println("Customer is successfully added.");
        for(int i=0;i<system.customers.length;++i)
            System.out.println(i + " : " + system.customers[i].username);
    }

    /**
     * Remove product.
     *
     * @param branch the branch
     */
    public void removeProduct(Branch branch){
        Scanner input = new Scanner(System.in);
        int productNum;

        if(branch.products.length == 0){
            System.out.println("There is no product in this branch.");
            return;
        }

        System.out.println("Which branch would you like to remove the product?");
        for(int i=0;i<branch.products.length;++i)
            System.out.println(i + " : " + branch.products[i].trackingNum);
        do {
            productNum = input.nextInt();
            if(productNum < 0 || productNum >= branch.products.length)
                System.out.println("Wrong Input. Try Again...");
        }while(productNum < 0 || productNum >= branch.products.length);

        Product[] products = new Product[branch.products.length-1];
        for (int i = 0, k = 0; k < branch.products.length - 1; ++i, ++k) {
            if (i != productNum)
                products[k] = branch.products[i];
            else
                k--;
        }
        branch.products = products;

        System.out.println("The Product is successfully removed.");
        for(int i=0;i<branch.products.length;++i)
            System.out.println(i + " : " + branch.products[i].trackingNum + " - "
                    + branch.products[i].senderNameSurname + " - " + branch.products[i].receiverNameSurname
                    + " - " + branch.products[i].information);
    }

    /**
     * Remove customer.
     *
     * @param system the system
     */
    public void removeCustomer(AutomationSystem system){
        Scanner input = new Scanner(System.in);
        int userNum;

        if(system.customers.length == 0){
            System.out.println("There is no customers in this system.");
            return;
        }

        System.out.println("Which branch would you like to remove the customer?");
        for(int i=0;i<system.customers.length;++i)
            System.out.println(i + " : " + system.customers[i].username);
        do {
            userNum = input.nextInt();
            if(userNum < 0 || userNum >= system.customers.length)
                System.out.println("Wrong Input. Try Again...");
        }while(userNum < 0 || userNum >= system.customers.length);

        Customer[] users = new Customer[system.customers.length-1];
        for (int i = 0, k = 0; k < system.customers.length - 1; ++i, ++k) {
            if (i != userNum)
                users[k] = system.customers[i];
            else
                k--;
        }
        system.customers = users;

        System.out.println("The Customer is successfully removed.");
        for(int i=0;i<system.customers.length;++i)
            System.out.println(i + " : " + system.customers[i].username);
    }

    /**
     * Add information.
     *
     * @param branch the branch
     */
    public void addInformation(Branch branch){
        Scanner input = new Scanner(System.in);
        String information;
        int productNum;

        System.out.println("Which product would you like to add information about?");
        for(int i=0;i<branch.products.length;++i)
            System.out.println(i + " : " + branch.products[i].trackingNum);
        do {
            productNum = input.nextInt();
            if(productNum < 0 || productNum >= branch.products.length)
                System.out.println("Wrong Input. Try Again...");
        }while(productNum < 0 || productNum >= branch.products.length);

        System.out.println("Please enter information ");
        information = input.nextLine();

        branch.products[productNum].information = information;
    }

    /**
     * Remove information.
     *
     * @param branch the branch
     */
    public void removeInformation(Branch branch){
        Scanner input = new Scanner(System.in);
        int productNum;

        if(branch.products.length == 0){
            System.out.println("There is no product in this branch.");
            return;
        }

        System.out.println("Which product would you like to add information about?");
        for(int i=0;i<branch.products.length;++i)
            System.out.println(i + " : " + branch.products[i].trackingNum);
        do {
            productNum = input.nextInt();
            if(productNum < 0 || productNum >= branch.products.length)
                System.out.println("Wrong Input. Try Again...");
        }while(productNum < 0 || productNum >= branch.products.length);

        branch.products[productNum].removeInformation();
    }

    /**
     * Check if is there same username
     *
     * @param user the username
     * @param system the system
     * @return the boolean
     */
    public boolean checkIsThere(String user,AutomationSystem system){
        for(int i=0;i<system.customers.length;++i){
            if(user.equals(system.customers[i])){
                //System.out.println("The user using this username already exists.");
                return true;
            }
        }
        return false;
    }

    /**
     * Check if is there same username
     *
     * @param user the username
     * @param branch the branch
     * @return the boolean
     */
    public boolean checkIsThere(String user,Branch branch){
        for(int i=0;i<branch.products.length;++i){
            if(user.equals(branch.products[i].trackingNum)){
                //System.out.println("The user using this username already exists.");
                return true;
            }
        }
        return false;
    }
}
