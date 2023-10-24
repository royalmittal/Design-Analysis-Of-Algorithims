import java.util.*;

public class TreeSetDS {
    public static void main(String[] args) {
        TreeSet<String> IndianStates = new TreeSet<>();
        IndianStates.add("Uttrakhand");
        IndianStates.add("Himachal Pradesh");
        IndianStates.add("Punjab");
        IndianStates.add("Delhi");
        IndianStates.add("Jharkhand");
        IndianStates.add("Uttar Pradesh");
        IndianStates.add("Madhya Pradesh");
        IndianStates.add("Rajasthan");
        IndianStates.add("Bihar");
        IndianStates.add("Assam");
        IndianStates.add("Arunachal Pradesh");
        System.out.println(IndianStates);
        // isEmpty
        System.out.println("Set is empty: " + IndianStates.isEmpty());
        // size
        System.out.println("Set size: " + IndianStates.size());
        // clear
        IndianStates.clear();
        System.out.println("Set is empty: " + IndianStates.isEmpty());
        // iterator
        Iterator it = IndianStates.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        // toArray
        String[] arr = IndianStates.toArray(new String[0]);
        System.out.println(Arrays.toString(arr));
        // contains
        System.out.println("India is present: " + IndianStates.contains("India"));
        // remove
        IndianStates.remove("Assam");
        System.out.println(IndianStates);
    }
}
