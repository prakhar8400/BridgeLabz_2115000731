public class Employee {
    private final int id;
    private String name;
    private String designation;
    private static int employeeCount = 0; 
    private static final String companyName = "XYZ Corp"; 

    public Employee(String name, String designation) {
        this.id = ++employeeCount; 
        this.name = name;
        this.designation = designation;
    }

    public static int getTotalEmployees() {
        return employeeCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public int getId() {
        return id;
    }

    public static void displayEmployeeDetails(Object employeeObj) {
        if (employeeObj instanceof Employee) {
            Employee employee = (Employee) employeeObj;
            System.out.println("Employee ID: " + employee.id);
            System.out.println("Employee Name: " + employee.name);
            System.out.println("Designation: " + employee.designation);
            System.out.println("Company Name: " + companyName); 
        } else {
            System.out.println("Invalid employee object.");
        }
    }
}
