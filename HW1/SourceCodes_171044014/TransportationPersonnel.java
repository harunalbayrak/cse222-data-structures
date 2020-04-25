import java.util.Scanner;

/**
 * The Transportation personnel Class
 */
public class TransportationPersonnel extends User{
    /**
     * Instantiates a new Transportation personnel.
     */
    public TransportationPersonnel(){
        super("transportation_personnel","1234");
    }

    /**
     * Instantiates a new Transportation personnel.
     *
     * @param user the user
     * @param pass the pass
     */
    public TransportationPersonnel(String user,String pass){
        super(user,pass);
    }

    /**
     * Updates that it has been delivered.
     *
     * @param system the system
     */
    public void makeDeliveredUpdate(AutomationSystem system){
        Scanner input = new Scanner(System.in);
        int branchNum,productNum;

        if(system.branches.length == 0){
            System.out.println("Ther is no branch in this system.");
            return;
        }

        for(int i=0;i<system.branches.length;++i){
            System.out.println(i + " : " + system.branches[i].branchName);
        }
        do {
            branchNum = input.nextInt();
            if(branchNum < 0 || branchNum >= system.branches.length)
                System.out.println("Wrong Input. Try Again...");
        }while(branchNum < 0 || branchNum >= system.branches.length);

        if(system.branches[branchNum].products.length == 0) {
            System.out.println("There is no product in this branch.");
            return;
        } else
            System.out.println("Product(s)\n----------");

        for(int i=0;i<system.branches[branchNum].products.length;++i){
            System.out.println(i + " : " + system.branches[branchNum].products[i].trackingNum);
        }
        do {
            productNum = input.nextInt();
            if(productNum < 0 || productNum >= system.branches[branchNum].products.length)
                System.out.println("Wrong Input. Try Again...");
        }while(productNum < 0 || productNum >= system.branches[branchNum].products.length);

        system.branches[branchNum].products[productNum].makeDelivered();
    }
}
