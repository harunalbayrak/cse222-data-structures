import java.util.Scanner;

/**
 * The Customer class
 */
public class Customer extends User{
    /**
     * Instantiates a new Customer.
     */
    public Customer(){
        super("customer","1234");
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

        for(int i=0;i<system.branches.length;++i){
            for(int j=0;j<system.branches[i].products.length;++j){
                if(trackNum.equals(system.branches[i].products[j].trackingNum)) {
                    System.out.println(system.branches[i].products[j]);
                    return;
                }
            }
        }
        System.out.println("Tracking number is not found.");
    }
}
