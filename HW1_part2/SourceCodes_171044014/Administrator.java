import java.util.ArrayList;
import java.util.Scanner;

/**
 * The Administrator Class
 */
public class Administrator extends User implements UserInterface{
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

    @Override
    public boolean checkIsThere(String string, AutomationSystem system, int which) {
        if(which == 0){
            for(int i=0;i<system.branches.size();++i){
                if(string.equals(system.branches.get(i).branchName)) {
                    System.out.println("The branch already exists.");
                    return true;
                }
            }
        }
        else if(which == 1){
            for(int i=0;i<system.branches.size();++i) {
                for (int j = 0; j < system.branches.get(i).branch_employees.size(); ++j) {
                    if (string.equals(system.branches.get(i).branch_employees.get(j).username)) {
                        System.out.println("The user using this username already exists.");
                        return true;
                    }
                }
            }
        }
        else if(which == 2) {
            for (int i = 0; i < system.transportation_personnels.size(); ++i) {
                if (string.equals(system.transportation_personnels.get(i).username)){
                    System.out.println("The user using this username already exists.");
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void print(AutomationSystem system, int which) {
        if(which == 0){
            for(int i=0;i<system.branches.size();++i)
                System.out.println(i + " : " + system.branches.get(i).branchName);
        } else if(which == 1){
            for(int i=0;i<system.transportation_personnels.size();++i)
                System.out.println(i + " : " + system.transportation_personnels.get(i).username);
        }
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
        }while(checkIsThere(branch_name,system,0));
        try {
            system.branches.add(new Branch(branch_name));
            System.out.println("Branch is successfully added.");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        print(system,0);
    }

    /**
     * Add branch employee.
     *
     * @param system the system
     */
    public void addBranchEmployee(AutomationSystem system){
        Scanner input = new Scanner(System.in);
        String branch_employee_username,branch_employee_password;
        int branchNum=0;

        if(system.branches.size() == 0){
            System.out.println("There is no branch!");
            return;
        }

        do {
            System.out.println("Please enter username of the Branch employee ");
            branch_employee_username = input.nextLine();
        }while(checkIsThere(branch_employee_username,system,1));

        System.out.println("Please enter password of the branch employee ");
        branch_employee_password = input.nextLine();

        System.out.println("Which branch would you like to add?");
        print(system,0);
        do {
            try{
                branchNum = input.nextInt();
            }
            catch(Exception e){
                System.out.println("Automatically it is added to 0.branch.");
                System.out.println(e.getMessage());
            }
            if(branchNum < 0 || branchNum >= system.branches.size())
                System.out.println("Wrong Input. Try Again...");
        }while(branchNum < 0 || branchNum >= system.branches.size());

        try{
            system.branches.get(branchNum).branch_employees.add(new BranchEmployee(branch_employee_username,branch_employee_password,system.branches.get(branchNum).branchIndex));
            System.out.println("Branch employee is successfully added.");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        for(int i=0;i<system.branches.get(branchNum).branch_employees.size();++i)
            System.out.println(i + " : " + system.branches.get(branchNum).branch_employees.get(i).username);
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
        }while(checkIsThere(transp_username,system,2));

        System.out.println("Please enter password of the Transportation personnel ");
        transp_password = input.nextLine();

        try {
            system.transportation_personnels.add(new TransportationPersonnel(transp_username, transp_password));
            System.out.println("Transportation Personnel is successfully added.");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        print(system,1);
    }

    /**
     * Remove branch.
     *
     * @param system the system
     */
    public void removeBranch(AutomationSystem system){
        Scanner input = new Scanner(System.in);
        int branchNum=0;

        if(system.branches.size() == 0){
            System.out.println("There is no branch in this system.");
            return;
        }

        System.out.println("Which branch would you like to remove?");
        print(system,0);
        do {
            try{
                branchNum = input.nextInt();
            }
            catch(Exception e){
                System.out.println("Automatically 0.branch is removed.");
                System.out.println(e.getMessage());
            }
            if(branchNum < 0 || branchNum >= system.branches.size())
                System.out.println("Wrong Input. Try Again...");
        }while(branchNum < 0 || branchNum >= system.branches.size());

        try {
            system.branches.remove(branchNum);
            System.out.println("The Branch is successfully removed.");

            for(int i=0;i<=branchNum;++i) {
                system.branches.get(i).branchIndex--;
                for (int j = 0; j < system.branches.get(i).branch_employees.size(); ++j) {
                    system.branches.get(i).branch_employees.get(j).branchIndex--;
                }
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        print(system,0);
    }

    /**
     * Remove branch employee.
     *
     * @param system the system
     */
    public void removeBranchEmployee(AutomationSystem system){
        Scanner input = new Scanner(System.in);
        int branchNum=0,branchEmpNum=0;

        if(system.branches.size() == 0){
            System.out.println("There is no branch in this system.");
            return;
        }

        System.out.println("Which branch would you like to remove the branch employee?");
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

        if(system.branches.get(branchNum).branch_employees.size() == 0){
            System.out.println("There is no branch employee in this branch.");
            return;
        }

        System.out.println("Which branch employee would you like to remove?");
        for(int i=0;i<system.branches.get(branchNum).branch_employees.size();++i)
            System.out.println(i + " : " + system.branches.get(branchNum).branch_employees.get(i).username);
        do {
            try{
                branchEmpNum = input.nextInt();
            }
            catch(Exception e){
                System.out.println("Automatically 0.branch employee is removed.");
                System.out.println(e.getMessage());
            }
            if(branchEmpNum < 0 || branchEmpNum >= system.branches.get(branchNum).branch_employees.size())
                System.out.println("Wrong Input. Try Again...");
        }while(branchNum < 0 || branchEmpNum >= system.branches.get(branchNum).branch_employees.size());

        try {
            system.branches.get(branchNum).branch_employees.remove(branchEmpNum);
            System.out.println("The Branch employee is successfully removed.");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        for(int i=0;i<system.branches.get(branchNum).branch_employees.size();++i)
            System.out.println(i + " : " + system.branches.get(branchNum).branch_employees.get(i).username);
    }

    /**
     * Remove transportation personnel.
     *
     * @param system the system
     */
    public void removeTransportationPersonnel(AutomationSystem system){
        Scanner input = new Scanner(System.in);
        int transpNum=0;

        if(system.transportation_personnels.size() == 0){
            System.out.println("There is no transportation personel in this system.");
            return;
        }

        System.out.println("Which branch would you like to remove the transportation personnel?");
        print(system,1);
        do {
            try{
                transpNum = input.nextInt();
            }
            catch(Exception e){
                System.out.println("Automatically 0.transportation personnel is removed.");
                System.out.println(e.getMessage());
            }
            if(transpNum < 0 || transpNum >= system.transportation_personnels.size())
                System.out.println("Wrong Input. Try Again...");
        }while(transpNum < 0 || transpNum >= system.transportation_personnels.size());

        try {
            system.transportation_personnels.remove(transpNum);
            System.out.println("The Transportation personnel is successfully removed.");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        print(system,1);
    }
}
