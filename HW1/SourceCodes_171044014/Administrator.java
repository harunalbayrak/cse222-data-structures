import java.util.Scanner;

/**
 * The Administrator Class
 */
public class Administrator extends User {
    /**
     * Instantiates a new Administrator.
     */
    public Administrator(){
        super("admin","1234");
    }

    /**
     * Instantiates a new Administrator.
     *
     * @param user the username
     * @param pass the password
     */
    public Administrator(String user,String pass){
        super(user,pass);
    }

    /**
     * Add branch.
     *
     * @param system the system
     */
    public void addBranch(AutomationSystem system){
        Scanner input = new Scanner(System.in);
        String branch_name;
        do {
            System.out.println("Please enter name of the branch ");
            branch_name = input.nextLine();
            if(checkIsThere(branch_name,system,0))
                System.out.println("The user using this username already exists.");
        }while(checkIsThere(branch_name,system,0));
        Branch[] _branches = new Branch[system.branches.length + 1];
        for(int i=0;i<system.branches.length;++i){
            _branches[i] = system.branches[i];
        }
        _branches[system.branches.length] = new Branch(branch_name);
        system.branches = _branches;

        System.out.println("Branch is successfully added.");
        for(int i=0;i<system.branches.length;++i)
            System.out.println(i + " : " + system.branches[i].branchName);
    }

    /**
     * Add branch employee.
     *
     * @param system the system
     */
    public void addBranchEmployee(AutomationSystem system){
        Scanner input = new Scanner(System.in);
        String branch_employee_username,branch_employee_password;
        int branchNum;
        do {
            System.out.println("Please enter username of the Branch employee ");
            branch_employee_username = input.nextLine();
            if(checkIsThere(branch_employee_username,system,1))
                System.out.println("The user using this username already exists.");
        }while(checkIsThere(branch_employee_username,system,1));

        System.out.println("Please enter password of the branch employee ");
        branch_employee_password = input.nextLine();

        System.out.println("Which branch would you like to add?");
        for(int i=0;i<system.branches.length;++i)
            System.out.println(i + " : " + system.branches[i].branchName);
        do {
            branchNum = input.nextInt();
            if(branchNum < 0 || branchNum >= system.branches.length)
                System.out.println("Wrong Input. Try Again...");
        }while(branchNum < 0 || branchNum >= system.branches.length);

        BranchEmployee[] branch_emps = new BranchEmployee[system.branches[branchNum].branch_employees.length + 1];

        for(int i=0;i<system.branches[branchNum].branch_employees.length;++i)
            branch_emps[i] = system.branches[branchNum].branch_employees[i];
        branch_emps[branch_emps.length-1] = new BranchEmployee(branch_employee_username,branch_employee_password);

        system.branches[branchNum].branch_employees = branch_emps;

        System.out.println("Branch employee is successfully added.");
        for(int i=0;i<system.branches[branchNum].branch_employees.length;++i)
            System.out.println(i + " : " + system.branches[branchNum].branch_employees[i].username);
    }

    /**
     * Add transportation personnel.
     *
     * @param system the system
     */
    public void addTransportationPersonnel(AutomationSystem system){
        Scanner input = new Scanner(System.in);
        String transp_username,transp_password;
        do {
            System.out.println("Please enter username of the Transportation personnel ");
            transp_username = input.nextLine();
            if(checkIsThere(transp_username,system,2))
                System.out.println("The user using this username already exists.");
        }while(checkIsThere(transp_username,system,2));

        System.out.println("Please enter password of the Transportation personnel ");
        transp_password = input.nextLine();

        TransportationPersonnel[] transp_per = new TransportationPersonnel[system.transportation_personnels.length + 1];

        for(int i=0;i<system.transportation_personnels.length;++i){
            transp_per[i] = system.transportation_personnels[i];
        }
        transp_per[system.transportation_personnels.length] = new TransportationPersonnel(transp_username,transp_password);
        system.transportation_personnels = transp_per;

        System.out.println("Transportation Personnel is successfully added.");
        for(int i=0;i<system.transportation_personnels.length;++i)
            System.out.println(i + " : " + system.transportation_personnels[i].username);
    }

    /**
     * Remove branch.
     *
     * @param system the system
     */
    public void removeBranch(AutomationSystem system){
        Scanner input = new Scanner(System.in);
        int branchNum;

        if(system.branches.length == 0){
            System.out.println("There is no branch in this system.");
            return;
        }

        System.out.println("Which branch would you like to remove?");
        for(int i=0;i<system.branches.length;++i)
            System.out.println(i + " : " + system.branches[i].branchName);
        do {
            branchNum = input.nextInt();
            if(branchNum < 0 || branchNum >= system.branches.length)
                System.out.println("Wrong Input. Try Again...");
        }while(branchNum < 0 || branchNum >= system.branches.length);

        Branch[] branch = new Branch[system.branches.length-1];
        for (int i = 0, k = 0; k < system.branches.length - 1; ++i, ++k) {
            if (i != branchNum)
                branch[k] = system.branches[i];
            else
                k--;
        }
        system.branches = branch;

        System.out.println("The Branch is successfully removed.");
        for(int i=0;i<system.branches.length;++i)
            System.out.println(i + " : " + system.branches[i].branchName);
    }

    /**
     * Remove branch employee.
     *
     * @param system the system
     */
    public void removeBranchEmployee(AutomationSystem system){
        Scanner input = new Scanner(System.in);
        int branchNum,branchEmpNum;

        if(system.branches.length == 0){
            System.out.println("There is no branch in this system.");
            return;
        }

        System.out.println("Which branch would you like to remove the branch employee?");
        for(int i=0;i<system.branches.length;++i)
            System.out.println(i + " : " + system.branches[i].branchName);
        do {
            branchNum = input.nextInt();
            if(branchNum < 0 || branchNum >= system.branches.length)
                System.out.println("Wrong Input. Try Again...");
        }while(branchNum < 0 || branchNum >= system.branches.length);

        if(system.branches[branchNum].branch_employees.length == 0){
            System.out.println("There is no branch employee in this branch.");
            return;
        }

        System.out.println("Which branch employee would you like to remove?");
        for(int i=0;i<system.branches[branchNum].branch_employees.length;++i)
            System.out.println(i + " : " + system.branches[branchNum].branch_employees[i].username);
        do {
            branchEmpNum = input.nextInt();
            if(branchEmpNum < 0 || branchEmpNum >= system.branches[branchNum].branch_employees.length)
                System.out.println("Wrong Input. Try Again...");
        }while(branchNum < 0 || branchEmpNum >= system.branches[branchNum].branch_employees.length);

        BranchEmployee[] branch_emp = new BranchEmployee[system.branches[branchNum].branch_employees.length-1];
        for(int i=0,k=0;k<system.branches[branchNum].branch_employees.length - 1;++i,++k){
            if(i != branchEmpNum)
                branch_emp[k] = system.branches[branchNum].branch_employees[i];
            else
                k--;
        }
        system.branches[branchNum].branch_employees = branch_emp;

        System.out.println("The Branch employee is successfully removed.");
        for(int i=0;i<system.branches[branchNum].branch_employees.length;++i)
            System.out.println(i + " : " + system.branches[branchNum].branch_employees[i].username);
    }

    /**
     * Remove transportation personnel.
     *
     * @param system the system
     */
    public void removeTransportationPersonnel(AutomationSystem system){
        Scanner input = new Scanner(System.in);
        int transpNum;

        if(system.transportation_personnels.length == 0){
            System.out.println("There is no transportation personel in this system.");
            return;
        }

        System.out.println("Which branch would you like to remove the transportation personnel?");
        for(int i=0;i<system.transportation_personnels.length;++i)
            System.out.println(i + " : " + system.transportation_personnels[i].username);
        do {
            transpNum = input.nextInt();
            if(transpNum < 0 || transpNum >= system.transportation_personnels.length)
                System.out.println("Wrong Input. Try Again...");
        }while(transpNum < 0 || transpNum >= system.transportation_personnels.length);

        TransportationPersonnel[] transp_per = new TransportationPersonnel[system.transportation_personnels.length-1];
        for (int i = 0, k = 0; k < system.transportation_personnels.length - 1; ++i, ++k) {
            if (i != transpNum)
                transp_per[k] = system.transportation_personnels[i];
            else
                k--;
        }
        system.transportation_personnels = transp_per;

        System.out.println("The Transportation personnel is successfully removed.");
        for(int i=0;i<system.transportation_personnels.length;++i)
            System.out.println(i + " : " + system.transportation_personnels[i].username);
    }

    /**
     * Check if is there same username
     *
     * @param user the username
     * @param system the system
     * @param which type to check
     * @return the boolean
     */
    public boolean checkIsThere(String user,AutomationSystem system,int which){
        if(which == 0){
            for(int i=0;i<system.branches.length;++i){
                if(user.equals(system.branches[i])){
                    //System.out.println("The user using this username already exists.");
                    return true;
                }
            }
        }
        else if(which == 1){
            for(int i=0;i<system.branches.length;++i){
                for(int j=0;j<system.branches[i].branch_employees.length;++j) {
                    if (user.equals(system.branches[i].branch_employees[j].username)) {
                        //System.out.println("The user using this username already exists.");
                        return true;
                    }
                }
            }
        }
        else if(which == 2){
            for(int i=0;i<system.transportation_personnels.length;++i){
                if(user.equals(system.transportation_personnels[i].username)){
                    //System.out.println("The user using this username already exists.");
                    return true;
                }
            }
        }
        return false;
    }

}
