public class Student {
    private final int rollNumber;
    private String name;
    private String grade;
    private static int totalStudents = 0;
    private static final String universityName = "XYZ University";

    public Student(String name, String grade) {
        this.rollNumber = ++totalStudents;
        this.name = name;
        this.grade = grade;
    }

    public static int getTotalStudents() {
        return totalStudents;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public static void displayStudentDetails(Object studentObj) {
        if (studentObj instanceof Student) {
            Student student = (Student) studentObj;
            System.out.println("Roll Number: " + student.rollNumber);
            System.out.println("Name: " + student.name);
            System.out.println("Grade: " + student.grade);
            System.out.println("University: " + universityName);
        } else {
            System.out.println("Invalid student object.");
        }
    }
}
