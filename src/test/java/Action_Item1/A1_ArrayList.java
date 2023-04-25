package Action_Item1;

import java.util.ArrayList;
public class A1_ArrayList {
    public static void main(String[] args) {
        // Create ArrayLists for country names and country codes
        ArrayList<String> countries = new ArrayList<String>();
        countries.add("Panama");
        countries.add("Canada");
        countries.add("Thailand");
        countries.add("Aruba");

        ArrayList<Integer> countryCodes = new ArrayList<Integer>();
        countryCodes.add(123);
        countryCodes.add(223);
        countryCodes.add(323);
        countryCodes.add(423);

        // Iterate through both ArrayLists using a for loop
        for (int i = 0; i < countries.size(); i++) {
            String country = countries.get(i);
            int code = countryCodes.get(i);
            System.out.println(" My Country is " + countries.get(i) + " and my country code is " + countryCodes.get(i));
        }
    }
}



