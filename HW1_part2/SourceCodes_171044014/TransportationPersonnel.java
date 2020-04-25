import java.util.Scanner;

/**
 * The Transportation personnel class
 */
public class TransportationPersonnel extends User implements UserInterface {
    /**
     * Instantiates a new Transportation personnel.
     */
    public TransportationPersonnel(){
        super("transportation_personnel" + User.count,"1234");
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

    @Override
    public boolean checkIsThere(String string, AutomationSystem system, int which) {
        for(int i=0;i<system.branches.size();++i) {
            for (int j = 0; j < system.branches.get(i).products.size(); ++j) {
                if (string.equals(system.branches.get(i).products.get(j).trackingNum)) {
                    System.out.println("The tracking number already exists.");
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void print(AutomationSystem system, int which) {
        if(which == 0)
            for(int i=0;i<system.branches.size();++i)
                System.out.println(i + " : " + system.branches.get(i).branchName);
    }

    /**
     * Updates that it has been delivered.
     *
     * @param system the system
     */
    public void makeDeliveredUpdate(AutomationSystem system){
        Scanner input = new Scanner(System.in);
        int branchNum=0,productNum=0;

        if(system.branches.size() == 0){
            System.out.println("There is no branch in this system.");
            return;
        }

        print(system,0);
        do {
            try{
                branchNum = input.nextInt();
            }
            catch(Exception e){
                System.out.println("Automatically 0.branch is choosen.");
                System.out.println(e.getMessage());
            }
            if(branchNum < 0 || branchNum >= system.branches.size())
                System.out.println("Wrong Input. Try Again...");
        }while(branchNum < 0 || branchNum >= system.branches.size());

        if(system.branches.get(branchNum).products.size() == 0) {
            System.out.println("There is no product in this branch.");
            return;
        } else
            System.out.println("Product(s)\n----------");

        for(int i=0;i<system.branches.get(branchNum).products.size();++i){
            System.out.println(i + " : " + system.branches.get(branchNum).products.get(i).trackingNum);
        }
        do {
            try{
                productNum = input.nextInt();
            }
            catch(Exception e){
                System.out.println("Automatically 0.product is choosen.");
                System.out.println(e.getMessage());
            }
            if(productNum < 0 || productNum >= system.branches.get(branchNum).products.size())
                System.out.println("Wrong Input. Try Again...");
        }while(productNum < 0 || productNum >= system.branches.get(branchNum).products.size());

        try {
            system.branches.get(branchNum).products.get(productNum).makeDelivered();
            System.out.println("The product is delivered!");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
