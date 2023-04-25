package Action_Item1;

public class A1_LinearArray {
    public static void main(String[] args) {
        String[] region;
        region = new String[]{"Brooklyn", "New York", "Long Island", "Queens"};
        int[] areaCodes = {718, 212, 516, 347};

        // Iterate through both arrays using a for loop
        for (int i = 0; i < region.length; i++) {
            String region2 = region[i];
            int areaCode = areaCodes[i];
            System.out.println("My region is " + region2 + " and my area code is " + areaCode);

        }
    }
}











