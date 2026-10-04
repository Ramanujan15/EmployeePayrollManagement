abstract class Employee {

    private final int employeeId;
    private final String employeeName;
    private final double salary;

    // Constructor
    Employee(int employeeId, String employeeName, double salary) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.salary = salary;
    }

    // Getter Methods
    int getemployeeId() {
        return employeeId;
    }

    String getemployeeName() {
        return employeeName;
    }

    double getsalary() {
        return salary;
    }

    // Abstract Methods
    abstract double calculatesalary();

    abstract String getrole();

    abstract double getAllowance();
}


// Developer Class
class Developer extends Employee {

    private final double developerAllowance;

    Developer(int employeeId, String employeeName, double salary,
              double developerAllowance) {

        super(employeeId, employeeName, salary);
        this.developerAllowance = developerAllowance;
    }


    @Override
    double getAllowance() {
        return developerAllowance;
    }

    @Override
    double calculatesalary() {
        return getsalary() + developerAllowance;
    }

    @Override
    String getrole() {
        return "Software Developer";
    }
}


// Senior Developer Class
class SeniorDeveloper extends Developer {

    private final double seniorAllowance;

    SeniorDeveloper(int employeeId, String employeeName, double salary,
                    double developerAllowance, double seniorAllowance) {

        super(employeeId, employeeName, salary, developerAllowance);
        this.seniorAllowance = seniorAllowance;
    }

    @Override
    double getAllowance() {
        return super.getAllowance() + seniorAllowance;
    }

    @Override
    double calculatesalary() {
        return super.calculatesalary() + seniorAllowance;
    }

    @Override
    String getrole() {
        return "Senior Software Developer";
    }

}


// Team Lead Class
class TeamLead extends SeniorDeveloper {

    private final double teamLeadAllowance;

    TeamLead(int employeeId, String employeeName, double salary,
             double developerAllowance, double seniorAllowance,
             double teamLeadAllowance) {

        super(employeeId, employeeName, salary,
                developerAllowance, seniorAllowance);

        this.teamLeadAllowance = teamLeadAllowance;
    }

    @Override
    double calculatesalary() {
        return super.calculatesalary() + teamLeadAllowance;
    }

    @Override
    String getrole() {
        return "Team Lead";
    }

    @Override
    double getAllowance() {
        return super.getAllowance() + teamLeadAllowance;
    }
}


// Main Class
public class EmployeePayroll {

    public static void main(String[] args) {

        // Runtime Polymorphism
        Employee e1 = new Developer(101, "Ram", 35000, 500);

        Employee e2 = new SeniorDeveloper(102, "Guna", 40000,
                700, 1000);

        Employee e3 = new TeamLead(103, "Kishore", 50000,
                800, 1200, 1500);


        System.out.println("========= EMPLOYEE PAYROLL DETAILS ==========");


        System.out.println("\nEmployee 1 Details");
        System.out.println("---------------------");
        System.out.println("Employee Id:" + e1.getemployeeId());
        System.out.println("Employee Name:" + e1.getemployeeName());
        System.out.println("Role: "+ e1.getrole());
        System.out.println("Basic Salary:" + e1.getsalary());
        System.out.println("Total Allowance:" + e1.getAllowance());
        System.out.println("Final Salary:" + e1.calculatesalary());


        System.out.println("\nEmployee 2 Details");
        System.out.println("---------------------");
        System.out.println("Employee Id: " + e2.getemployeeId());
        System.out.println("Employee Name: " + e2.getemployeeName());
        System.out.println("Role: " + e2.getrole());
        System.out.println("Basic Salary:" + e2.getsalary());
        System.out.println("Total Allowance:" + e2.getAllowance());
        System.out.println("Final Salary:" + e2.calculatesalary());


        System.out.println("\nEmployee 3 Details");
        System.out.println("---------------------");
        System.out.println("Employee Id: " + e3.getemployeeId());
        System.out.println("Employee Name: " + e3.getemployeeName());
        System.out.println("Role: " + e3.getrole());
        System.out.println("Basic Salary:" + e3.getsalary());
        System.out.println("Total Allowance:"+ e3.getAllowance());
        System.out.println("Final Salary:" + e3.calculatesalary());

    }
}
