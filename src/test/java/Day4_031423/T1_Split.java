package Day4_031423;

public class T1_Split {
    public static void main(String[] args) {
        //create a single string variable
        String message = "My name is John";
        //extract/ take out the word John from the string and print it out
        //declare and define a new array String to store the split concept
        String[] arrayMessage = message.split(" ");
        System.out.println("Value is" + arrayMessage[3]);
    }//end of main
}// end of class
