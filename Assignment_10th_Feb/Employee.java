abstract class Employee {
    private int employeeId;
    private String name; 
    private double baseSalary;

    public Employee(int employeeId, String name, double baseSalary) {
        this.employeeId = employeeId;
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public abstract double calculateSalary(); 

    public void displayDetails() {
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Name: " + name);
        System.out.println("Base Salary: " + baseSalary);
        System.out.println("Calculated Salary: " + calculateSalary());
    }
}

class FullTimeEmployee extends Employee {
    public FullTimeEmployee(int employeeId, String name, double baseSalary) {
        super(employeeId, name, baseSalary);
    }

    @Override
    public double calculateSalary() {
        return baseSalary; 
    }
}

class PartTimeEmployee extends Employee {
    private double hourlyRate;
    private int hoursWorked;

    public PartTimeEmployee(int employeeId, String name, double hourlyRate, int hoursWorked) {
        super(employeeId, name, 0.0); // Base salary for part-time is 0
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double calculateSalary() {
        return hourlyRate * hoursWorked;
    }
}

interface Department {
    void assignDepartment(Employee employee);
    String getDepartmentDetails();
}

class ITDepartment implements Department {
    private String departmentName = "IT";
    private List<Employee> employees = new ArrayList<>();

    @Override
    public void assignDepartment(Employee employee) {
        employees.add(employee);
    }

    @Override
    public String getDepartmentDetails() {
        StringBuilder sb = new StringBuilder();
        sb.append("Department: ").append(departmentName).append("\n");
        for (Employee employee : employees) {
            sb.append("Employee: ").append(employee.getName()).append("\n");
        }
        return sb.toString();
    }
}

public class Main {
    public static void main(String[] args) {
        FullTimeEmployee fullTimeEmp = new FullTimeEmployee(1, "John Doe", 50000);
        PartTimeEmployee partTimeEmp = new PartTimeEmployee(2, "Jane Smith", 20, 150); 

        ITDepartment itDept = new ITDepartment();
        itDept.assignDepartment(fullTimeEmp);
        itDept.assignDepartment(partTimeEmp);

        System.out.println(itDept.getDepartmentDetails());

        // Polymorphic behavior
        Employee[] employees = {fullTimeEmp, partTimeEmp};
        for (Employee employee : employees) {
            employee.displayDetails(); 
            System.out.println("");
        }
    }
}
