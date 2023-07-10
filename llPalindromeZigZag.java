import java.util.*;

public class llPalindromeZigZag {
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
        size++;
    }

    // PRINT FUNCTION
    public static void display() {
        for (Node temp = head; temp != null; temp = temp.next) {
            System.out.print(temp.data + "->");
        }
        System.out.println("null");
    }

    // ====================================CHECKING LL IS PALINDROME OR
    // NOT==========================================================
    // SLOW-FAST APPROACH
    // FIND MIDDLE
    public static Node findMid(Node head) {
        Node slow = head;
        Node fast = head;
        while (slow != null && fast.next != null) {
            slow = slow.next; // +1
            fast = fast.next; // +2
        }
        return slow;
    }

    public static boolean checkPalindrome() {
        if (head == null || head.next == null) {
            return true;
        }
        Node midNode = findMid(head);
        Node prev = null;
        Node curr = midNode;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node right = prev;
        Node left = head;

        // checking of equal
        while (right != null) {
            if (left.data != right.data) {
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }

    // =====================MAKING
    // ZIG-ZAGLL=================================================================

    public static void ZigZag() {

        // middle
        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node mid = slow;
        // reverse 2nd half
        Node curr = mid.next;
        mid.next = null;
        Node prev = null;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node left = head;
        Node right = prev;
        Node nextL, nextR;

        // alternating merging (Zig-Zag)
        while (left != null && right != null) {
            nextL = left.next;
            left.next = right;
            nextR = right.next;
            right.next = nextL;
            left = nextL;
            right = nextR;
        }
    }

    // =========================================================================================================================

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements you want to add in the linked list: ");
        int n = sc.nextInt();
        System.out.println("Enter the elements: ");
        for (int i = 0; i < n; i++) {
            int data = sc.nextInt();
            addAt(data, i);
        }
        display();
        System.out.println("Does Linked List is PALINDROME - " + checkPalindrome());
        System.out.println("Alternate Merged Zig-Zag Linked List");
        ZigZag();
        display();
    }
}
