import java.util.ArrayList;
import java.util.List;

public class Company {
    private String companyName;
    private List<Department> departments;

    public Company(String companyName) {
        this.companyName = companyName;
        this.departments = new ArrayList<>();
    }

    public void addDepartment(Department department) {
        departments.add(department);
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public String getCompanyName() {
        return companyName;
    }

    // No explicit destructor in Java, but garbage collection will handle it
}

class Department {
    private String departmentName;
    private List<Employee> employees;

    public Department(String departmentName) {
        this.departmentName = departmentName;
        this.employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public String getDepartmentName() {
        return departmentName;
    }
}

class Employee {
    private String employeeName;

    public Employee(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeName() {
        return employeeName;
    }
}

public class Main {
    public static void main(String[] args) {
        // Create a Company
        Company company = new Company("XYZ Corp");

        // Create Departments
        Department dept1 = new Department("IT");
        Department dept2 = new Department("HR");
        company.addDepartment(dept1);
        company.addDepartment(dept2);

        // Create Employees
        Employee emp1 = new Employee("John Doe");
        Employee emp2 = new Employee("Jane Smith");
        dept1.addEmployee(emp1);
        dept2.addEmployee(emp2);

        // ... (rest of the program)

        // When the 'company' object goes out of scope, 
        // the garbage collector will reclaim the memory 
        // for the company, departments, and employees.
    }
}
