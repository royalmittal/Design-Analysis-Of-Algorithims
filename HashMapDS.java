import java.util.*;

public class HashMapDS {
    public static void main(String[] args) {
        HashMap<Integer, String> hm = new HashMap<Integer, String>();
        // insertion
        hm.put(1, "one");
        hm.put(2, "two");
        hm.put(3, "three");
        hm.put(4, "four");
        System.out.println(hm);
        // updation
        hm.put(2, "TWO");
        System.out.println(hm);
        // get
        System.out.println("Get of 2 " + hm.get(2));
        // deletion
        hm.remove(2);
        System.out.println("After Removal of 2" + hm);
        // search
        if (hm.containsKey(3)) {
            System.out.println("Key is present");
        } else {
            System.out.println("Key is not present");
        }
        // size
        System.out.println("Size " + hm.size());
        // iteration
        for (Map.Entry<Integer, String> e : hm.entrySet()) {
            System.out.println(e.getKey() + " " + e.getValue());
        }
        // is empty
        System.out.println("Is empty " + hm.isEmpty());
        // clear
        hm.clear();
        System.out.println("After clear " + hm);
    }
}
