import java.util.ArrayList;
import java.util.List;

public class School {
    private String schoolName;
    private List<Student> students;

    public School(String schoolName) {
        this.schoolName = schoolName;
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public List<Student> getStudents() {
        return students;
    }

    public String getSchoolName() {
        return schoolName;
    }
}

class Student {
    private String studentName;
    private List<Course> enrolledCourses;

    public Student(String studentName) {
        this.studentName = studentName;
        this.enrolledCourses = new ArrayList<>();
    }

    public void enrollInCourse(Course course) {
        enrolledCourses.add(course);
    }

    public List<Course> getEnrolledCourses() {
        return enrolledCourses;
    }

    public String getStudentName() {
        return studentName;
    }
}

class Course {
    private String courseName;
    private List<Student> enrolledStudents;

    public Course(String courseName) {
        this.courseName = courseName;
        this.enrolledStudents = new ArrayList<>();
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
        // Create a School
        School school = new School("ABC School");

        // Create Students
        Student student1 = new Student("Alice");
        Student student2 = new Student("Bob");

        // Create Courses
        Course math = new Course("Mathematics");
        Course science = new Course("Science");
        Course history = new Course("History");

        // Enroll students in courses
        student1.enrollInCourse(math);
        student1.enrollInCourse(science);
        student2.enrollInCourse(science);
        student2.enrollInCourse(history);

        // Add students to the school
        school.addStudent(student1);
        school.addStudent(student2);

        // Display student enrollments
        System.out.println("Courses enrolled by " + student1.getStudentName() + ":");
        for (Course course : student1.getEnrolledCourses()) {
            System.out.println("- " + course.getCourseName());
        }

        System.out.println("\nStudents enrolled in " + math.getCourseName() + ":");
        for (Student student : math.getEnrolledStudents()) {
            System.out.println("- " + student.getStudentName());
        }
    }
}
