/**
 * The Branch class
 */
public class Branch {
    /**
     * The Branch name.
     */
    protected String branchName;
    /**
     * The Branch employees.
     */
    protected BranchEmployee[] branch_employees = new BranchEmployee[1];
    /**
     * The Products.
     */
    protected Product[] products = new Product[0];

    /**
     * Instantiates a new Branch.
     */
    public Branch(){
        branchName = "branch";
        branch_employees[0] = new BranchEmployee();
    }

    /**
     * Instantiates a new Branch.
     *
     * @param name the name
     */
    public Branch(String name){
        branchName = name;
        branch_employees[0] = new BranchEmployee();
    }
}
