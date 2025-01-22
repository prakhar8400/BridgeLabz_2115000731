package Assignment_21st_January;

public class PensDivision {
    public static void main(String[] args) {
        int pens = 14, students = 3;
        int pensPerStudent = pens / students;
        int remainingPens = pens % students;
        System.out.println("The Pen Per Student is " + pensPerStudent + " and the remaining pen not distributed is "
                + remainingPens);
    }
}
