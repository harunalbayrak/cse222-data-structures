import java.util.ArrayList;

/**
 * The Branch class
 */
public class Branch {
    /**
     * The Branch name.
     */
    protected String branchName;
    /**
     * The Branch index
     */
    protected int branchIndex;
    /**
     * The Products.
     */
    protected ArrayList<Product> products = new ArrayList<Product>();
    /**
     * The Branch employees.
     */
    protected ArrayList<BranchEmployee> branch_employees = new ArrayList<BranchEmployee>();
    /**
     * The number of branches
     */
    protected static int branchCount=0;

    /**
     * Instantiates a new Branch.
     */
    public Branch(){
        branchName = "branch" + branchCount;
        branchIndex = branchCount;
        branch_employees.add(new BranchEmployee(branchIndex));
        branchCount++;
    }

    /**
     * Instantiates a new Branch.
     *
     * @param name the name
     */
    public Branch(String name){
        branchName = name;
        branchIndex = branchCount;
        branch_employees.add(new BranchEmployee(branchIndex));
        branchCount++;
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        --branchCount;
    }
}
