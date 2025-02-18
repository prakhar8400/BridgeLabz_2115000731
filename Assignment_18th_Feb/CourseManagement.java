import java.util.ArrayList;
import java.util.List;

abstract class CourseType {
    abstract void evaluate(); 
}

class ExamCourse extends CourseType {
    @Override
    void evaluate() {
        System.out.println("Evaluating through exams.");
    }
}

class AssignmentCourse extends CourseType {
    @Override
    void evaluate() {
        System.out.println("Evaluating through assignments.");
    }
}

class ResearchCourse extends CourseType {
    @Override
    void evaluate() {
        System.out.println("Evaluating through research projects.");
    }
}

class Course<T extends CourseType> {
    private String courseName;
    private T courseType;

    public Course(String courseName, T courseType) {
        this.courseName = courseName;
        this.courseType = courseType;
    }

    public void evaluate() {
        courseType.evaluate();
    }

    public String getCourseName() {
        return courseName;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseName='" + courseName + '\'' +
                '}';
    }
}

class Department {
    private String departmentName;
    private List<Course<? extends CourseType>> courses;

    public Department(String departmentName) {
        this.departmentName = departmentName;
        this.courses = new ArrayList<>();
    }

    public void addCourse(Course<? extends CourseType> course) {
        courses.add(course);
    }

    public void evaluateAllCourses() {
        for (Course<? extends CourseType> course : courses) {
            course.evaluate();
        }
    }

    public void displayAllCourses() {
        for (Course<? extends CourseType> course : courses) {
            System.out.println(course);
        }
    }
}

public class University {
    public static void main(String[] args) {
        Department computerScience = new Department("Computer Science");
        computerScience.addCourse(new Course<>("Data Structures", new ExamCourse()));
        computerScience.addCourse(new Course<>("Algorithms", new AssignmentCourse()));

        Department research = new Department("Research");
        research.addCourse(new Course<>("Machine Learning", new ResearchCourse()));

        computerScience.evaluateAllCourses();
        research.evaluateAllCourses();

        System.out.println("\nComputer Science Courses:");
        computerScience.displayAllCourses();
        System.out.println("\nResearch Courses:");
        research.displayAllCourses();
    }
}
