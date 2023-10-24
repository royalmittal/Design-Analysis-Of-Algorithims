import java.util.*;

public class HashSetDS {
    public static void main(String[] args) {
        HashSet<String> hs = new HashSet<>();
        hs.add("India");
        hs.add("USA");
        hs.add("Russia");
        hs.add("China");
        System.out.println(hs);

        if (hs.contains("India")) {
            System.out.println("India is present");
        } else {
            System.out.println("India is not present");
        }
        System.out.println("Set size: " + hs.size());
        // System.out.println(hs.iterator());
        // System.out.println(hs.toArray());
        Iterator it = hs.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
