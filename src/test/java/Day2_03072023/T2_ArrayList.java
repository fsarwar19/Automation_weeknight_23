package Day2_03072023;

import java.util.ArrayList;

public class T2_ArrayList
 {
     public static void main(String[] args) {
         //declare and define and arraylist of countries
        ArrayList<String> countries = new ArrayList<>();
        //add some values for countries
         countries.add("USA");
         countries.add("UK");
         countries.add("BANGLADESH");
         countries.add("INDIA");
         countries.add("PAKISTAN");
                 //print out usa from the arraylist
         System.out.println("My first country is"+ countries.get (0));
         //get the total size of the arraylist
         System.out.println("Size of the countries arrayList is " + countries.size ());
         // add an additional country Canada
         countries.add("Canada");
         //print out the size of the arrayList again
         System.out.println("Size of the countries arraylist is " + countries.size());




     }
}
