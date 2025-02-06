import java.util.ArrayList;
import java.util.List;

public class University {
    private String universityName;
    private List<Department> departments;

    public University(String universityName) {
        this.universityName = universityName;
        this.departments = new ArrayList<>();
    }

    public void addDepartment(Department department) {
        departments.add(department);
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public String getUniversityName() {
        return universityName;
    }
}

class Department {
    private String departmentName;
    private List<Faculty> facultyMembers;

    public Department(String departmentName) {
        this.departmentName = departmentName;
        this.facultyMembers = new ArrayList<>();
    }

    public void addFaculty(Faculty faculty) {
        facultyMembers.add(faculty);
    }

    public List<Faculty> getFacultyMembers() {
        return facultyMembers;
    }

    public String getDepartmentName() {
        return departmentName;
    }
}

class Faculty {
    private String facultyName;

    public Faculty(String facultyName) {
        this.facultyName = facultyName;
    }

    public String getFacultyName() {
        return facultyName;
    }
}

public class Main {
    public static void main(String[] args) {
        // Create a University
        University university = new University("XYZ University");

        // Create Departments
        Department dept1 = new Department("Computer Science");
        Department dept2 = new Department("English");
        university.addDepartment(dept1);
        university.addDepartment(dept2);

        // Create Faculty members
        Faculty faculty1 = new Faculty("Prof. Smith"); // Can exist independently
        Faculty faculty2 = new Faculty("Dr. Jones");
        Faculty faculty3 = new Faculty("Prof. Lee");

        // Assign faculty members to departments
        dept1.addFaculty(faculty1);
        dept1.addFaculty(faculty2);
        dept2.addFaculty(faculty3);

        // ... (rest of the program)

        // When the 'university' object goes out of scope, 
        // the 'departments' and their associated 'facultyMembers' 
        // will also be garbage collected due to composition. 
        // However, 'faculty1' will not be garbage collected 
        // as it exists independently.
    }
}
