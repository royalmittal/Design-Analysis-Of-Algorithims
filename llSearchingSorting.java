import java.util.*;

import javax.swing.tree.AbstractLayoutCache.NodeDimensions;

public class llSearchingSorting {
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
        for (Node temp = head; temp != null; temp = temp.next) {
            System.out.print(temp.data + "->");
        }
        System.out.println("null");
    }

    // =================================SEARCHING===========================================================
    // ITERATIVE SEARCH FUNCTION
    // TIME COMPLEXITY = O(N)
    public static int itrSearch(int key) {
        Node temp = head;
        int i = 0;
        while (temp != null) {
            if (temp.data == key) {
                return i;
            }
            temp = temp.next;
            i++;
        }
        return -1; // not found
    }

    // RECURSIVE SEARCH FUNCTION
    // TIME & SPACE COMPLEXITIES = O(N)
    public static int helper(int head, int key) {
        if (head == null) {
            return -1;
        }
        if (head.data == key) {
            return 0;
        }
        int idx = helper(head.next, key);
        if (idx == -1) {
            return -1;
        }
        return idx + 1;
    }

    public static int recursiveSearch(int key) {

        return helper(head, key);
    }

    // ========================================MERGE
    // SORT=========================================================

    public static Node mergeSortLL(Node head){
        //base case 
        if (head === null || head.next == null) {
            return head;
        }
        Node mid  = getMid(head); // find mid 
        //left & right merge sort
        Node rightHead = mid.next;
        mid.next = null;
        Node newLeft = mergeSortLL(head);
        Node newRight = mergeSortLL(rightHead);

        //merge
        return merge(newLeft,newRight);
    }

    private static Node getMid(Node head) {
        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private static Node merge(Node head1, Node head2) {
        Node mergedLL = new Node(-1);
        Node temp = mergedLL;
        while (head1 != null && head2 != null) {
            if (head1.data <= head2.data) {
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;
            } else {
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }
        }
        while (head1 != null) {
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }
        while (head2 != null) {
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }
        return mergedLL.next;
    }

    // ==========================================================================================================

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
        System.out.println("Enter the element you want to search: ");
        int key = sc.nextInt();
        if (itrSearch(key) == -1) {
            System.out.println("Element not found");
        } else {
            System.out.println("Element found at index: " + itrSearch(key));
        }
        if (recursiveSearch(key) == -1) {
            System.out.println("Element not found");
        } else {
            System.out.println("Element found at index: " + recursiveSearch(key));
        }
        System.out.println("Merged Sorted Linked List");
        mergeSortLL(head);
        display();
    }
}
