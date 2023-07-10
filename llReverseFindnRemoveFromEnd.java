import java.util.*;

public class llReverseFindnRemoveFromEnd {
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

    // ========================REVERESE LL FUNCTION====================
    public static void reverse() {
        Node prev = null;
        Node curr = head = tail;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }
    // ===============FIND & REMOVE NTH NODE FROM END==================
    // ITERATIVE APROACH

    public static void deleteNthFromEnd(int rev) {
        // int size = 0;
        Node temp = head;
        while (temp != null) {
            temp = temp.next;
            size++;
        }
        if (rev == size) {
            head = head.next;
            return;
        }

        // size - n;
        int i = 1;
        int iToFind = size - rev;
        Node prev = head;
        while (i < iToFind) {
            prev = prev.next;
            i++;
        }
        prev.next = prev.next.next;
        return;
    }

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
        System.out.println("Reversed Linked List");
        reverse();
        display();
        System.out.println("Enter the element to remove from End");
        int rev = sc.nextInt();
        deleteNthFromEnd(rev);
        display();
    }
}
