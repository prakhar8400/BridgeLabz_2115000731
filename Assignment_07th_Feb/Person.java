public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void displayRole() {
        System.out.println("Person");
    }
}

public class Teacher extends Person {
    private String subject;

    public Teacher(String name, int age, String subject) {
        super(name, age);
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }

    @Override
    public void displayRole() {
        System.out.println("Teacher: " + name);
    }
}

public class Student extends Person {
    private String grade;

    public Student(String name, int age, String grade) {
        super(name, age);
        this.grade = grade;
    }

    public String getGrade() {
        return grade;
    }

    @Override
    public void displayRole() {
        System.out.println("Student: " + name);
    }
}

public class Staff extends Person {
    private String department;

    public Staff(String name, int age, String department) {
        super(name, age);
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public void displayRole() {
        System.out.println("Staff: " + name);
    }
}

public class Main {
    public static void main(String[] args) {
        Person person = new Person("John Doe", 30);
        person.displayRole(); // Output: Person

        Teacher teacher = new Teacher("Jane Smith", 35, "Mathematics");
        teacher.displayRole(); // Output: Teacher: Jane Smith

        Student student = new Student("David Lee", 18, "10th Grade");
        student.displayRole(); // Output: Student: David Lee

        Staff staff = new Staff("Alice Brown", 40, "Administration");
        staff.displayRole(); // Output: Staff: Alice Brown
    }
}
