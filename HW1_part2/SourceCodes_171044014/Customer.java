import java.util.Scanner;

/**
 * The Customer class
 */
public class Customer extends User implements UserInterface {
    /**
     * Instantiates a new Customer.
     */
    public Customer(){
        super("customer" + User.count,"1234");
    }

    /**
     * Instantiates a new Customer.
     *
     * @param user the user
     * @param pass the pass
     */
    public Customer(String user,String pass){
        super(user,pass);
    }

    @Override
    public boolean checkIsThere(String string, AutomationSystem system, int which) {
        for(int i=0;i<system.branches.size();++i)
            for(int j=0;j<system.branches.get(i).products.size();++j)
                if(string.equals(system.branches.get(i).products.get(j).trackingNum))
                    return true;
        return false;
    }

    @Override
    public void print(AutomationSystem system, int which) {
        for(int i=0;i<system.branches.size();++i){
            for(int j=0;j<system.branches.get(i).products.size();++j){
                System.out.println(system.branches.get(i).products.get(j).information);
            }
        }
    }

    /**
     * Track product.
     *
     * @param system the system
     */
    public void TrackProduct(AutomationSystem system){
        Scanner input = new Scanner(System.in);
        String trackNum;
        System.out.println("Please enter your tracking number");
        trackNum = input.nextLine();

        if(checkIsThere(trackNum,system,0))
            print(system,0);
        else
            System.out.println("Tracking number is not found.");
    }
}
