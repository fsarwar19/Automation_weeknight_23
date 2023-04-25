package Day2_03072023;

public class T1_LinearArray {
    public static void main(String[] args) {
        String[] zipCode;
        //store zipcode value in  the string array
        zipCode= new String[]{" 11210","11320","12562","11230","11110"};
                //print the first zipcode from the zipcode array
        //Array always start from index 0
        System.out.println("My First Zipcode is"+ zipCode[0]);
                //print the second value from the zipcode array
        System.out.println("My Second Zipcode is "+zipCode[1]);
        //alternative way to declare and define linear array
        String[]zipCode2= new String[]{"11210","11320","12562","11230","11110"};
        //print out the 5th zipcode from zipCode2 array
        System.out.println("My Fifth Zipcode is " + zipCode[4]);
        //declare a linear array of int values
        int[] streetNumber = new int[]{111, 222, 333};
        System.out.println("My second street number is" + streetNumber[1]);
//with grades example
        int[] studentGrades = new int[]{90, 99, 52};
        System.out.println("My second street number is " + studentGrades[1]);




    }//end of main
}//end of class
