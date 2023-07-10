import java.util.*;

public class DeletingCycle {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    // size function
    public static int size() {
        return size;
    }

    // ADD AT FUNCTION
    public static void addAt(int data, int idx) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            Node temp = head;
            for (int i = 0; i < idx - 1; i++) {
                temp = temp.next;
            }
            newNode.next = temp.next;
            temp.next = newNode;
        }
    }

    // PRINT FUNCTION
    public static void display() {
        for (Node show = head; show != null; show = show.next) {
            System.out.print(show.data + "->");
        }
        System.out.println("null");
    }

    // ==================================DETECTING & DELETING CYCLE/LOOP IN A LINKED
    // LIST========================================
    public static boolean isCycle() {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true; // cycle exist
            }
        }
        return false; // cycle does not exist
    }

    public static void removeCycle() {

        // detect cycle
        Node slow = head;
        Node fast = head;
        boolean cycle = false;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                cycle = true;
                break;
            }
        }
        if (cycle == false) {
            return;
        }

        // finding meeting poinnt
        slow = head;
        Node prev = null; // last node
        while (slow != fast) {
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }

        // remove cycle
        prev.next = null;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements you want to add in thelinked list: ");
        int n = sc.nextInt();
        System.out.println("Enter the elements: ");
        for (int i = 0; i < n; i++) {
            int data = sc.nextInt();
            addAt(data, i);
        }
        // head = new Node(1);
        // Node temp = new Node(2);
        // head.next = temp;
        // head.next.next = new Node(3);
        // head.next.next.next = temp;
        display();
        System.out.println(head);
        System.out.println(isCycle());
        removeCycle();
        System.out.println(isCycle());
    }

}
