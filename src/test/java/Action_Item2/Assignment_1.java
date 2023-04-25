package Action_Item2;

public class Assignment_1 {
    public static void main(String[] args) {
        // declare a grade as a variable
        int grade = 78;

        // declare the range of numerical grade corresponding to its letter grade

        if (grade >= 90 && grade <= 100) {
            System.out.println('A');

        } else if (grade >= 80 && grade < 90) {
            System.out.println("B");
        } else if (grade >= 70 && grade < 80) {
            System.out.println("C");
        } else if (grade >= 60 && grade < 70) {
            System.out.println("D");
        } else {
            grade = 'F';
        }


    }//end of main
}//end of assignment
