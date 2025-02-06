import java.util.ArrayList;
import java.util.List;

public class UniversityManagement {
    private String universityName;
    private List<Student> students;
    private List<Professor> professors;
    private List<Course> courses;

    public University(String universityName) {
        this.universityName = universityName;
        this.students = new ArrayList<>();
        this.professors = new ArrayList<>();
        this.courses = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void addProfessor(Professor professor) {
        professors.add(professor);
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public List<Student> getStudents() {
        return students;
    }

    public List<Professor> getProfessors() {
        return professors;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public String getUniversityName() {
        return universityName;
    }
}

class Student {
    private String studentName;
    private List<Course> enrolledCourses;

    public Student(String studentName) {
        this.studentName = studentName;
        this.enrolledCourses = new ArrayList<>();
    }

    public void enrollCourse(Course course) {
        enrolledCourses.add(course);
    }

    public List<Course> getEnrolledCourses() {
        return enrolledCourses;
    }

    public String getStudentName() {
        return studentName;
    }
}

class Professor {
    private String professorName;
    private List<Course> assignedCourses;

    public Professor(String professorName) {
        this.professorName = professorName;
        this.assignedCourses = new ArrayList<>();
    }

    public void assignCourse(Course course) {
        assignedCourses.add(course);
    }

    public List<Course> getAssignedCourses() {
        return assignedCourses;
    }

    public String getProfessorName() {
        return professorName;
    }
}

class Course {
    private String courseName;
    private Professor assignedProfessor;
    private List<Student> enrolledStudents;

    public Course(String courseName) {
        this.courseName = courseName;
        this.enrolledStudents = new ArrayList<>();
    }

    public void assignProfessor(Professor professor) {
        this.assignedProfessor = professor;
    }

    public Professor getAssignedProfessor() {
        return assignedProfessor;
    }

    public void enrollStudent(Student student) {
        enrolledStudents.add(student);
    }

    public List<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    public String getCourseName() {
        return courseName;
    }
}

public class Main {
    public static void main(String[] args) {
        // Create a University
        University university = new University("XYZ University");

        // Create Students
        Student student1 = new Student("Alice");
        Student student2 = new Student("Bob");
        university.addStudent(student1);
        university.addStudent(student2);

        // Create Professors
        Professor professor1 = new Professor("Prof. Smith");
        Professor professor2 = new Professor("Dr. Jones");
        university.addProfessor(professor1);
        university.addProfessor(professor2);

        // Create Courses
        Course math = new Course("Mathematics");
        Course science = new Course("Science");
        university.addCourse(math);
        university.addCourse(science);

        // Assign Professor to Courses
        math.assignProfessor(professor1);
        science.assignProfessor(professor2);

        // Enroll Students in Courses
        student1.enrollCourse(math);
        student1.enrollCourse(science);
        student2.enrollCourse(math);

        // ... (Further interactions and data display can be added)
    }
}
