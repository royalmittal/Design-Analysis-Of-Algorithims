import java.util.*;

public class LinkedHashSetDS {
    public static void main(String[] args) {
        LinkedHashSet<String> Jyotirling = new LinkedHashSet<>();
        Jyotirling.add("Somnath");
        Jyotirling.add("Kedareshwar");
        Jyotirling.add("Kashi Vishwanath");
        Jyotirling.add("Mahakaleshwar");
        Jyotirling.add("Rameshwaram");
        Jyotirling.add("Omkareshwar");
        Jyotirling.add("Baijyanath");
        Jyotirling.add("Bhimashankar");
        Jyotirling.add("Nageshwar");
        Jyotirling.add("Triambikeshwar");
        Jyotirling.add("Mallikarjun Maharaj");
        Jyotirling.add("Ghrishneshwar");
        System.out.println(Jyotirling);
        System.out.println("Total Jyotirling = " + Jyotirling.size());
        System.out.println(Jyotirling.isEmpty());
    }
}
