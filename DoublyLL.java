import java.util.*;

public class DoublyLL {
    public class Node {
        int data;
        Node next, prev;

        public Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    // add
    public static void addFirst(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    public static void addLast(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    public static void addAt(int data, int idx) {
        if (idx < 0 || idx > size) {
            System.out.println("Invalid index");
            return;
        }
        if (idx == 0) {
            addFirst(data);
            return;
        }
        if (idx == size) {
            addLast(data);
            return;
        }
        Node newNode = new Node(data);
        Node temp = head;
        for (int i = 0; i < idx - 1; i++) {
            temp = temp.next;
        }
        newNode.next = temp.next;
        temp.next.prev = newNode;
        temp.next = newNode;
        newNode.prev = temp;
        size++;
    }

    // remove
    public static int removeFirst() {
        if (head == null) {
            System.out.println("Double Linked List is empty");
            return Integer.MIN_VALUE;

        }
        if (size == 1) {
            int val = head.data;
            head = tail = null;
            size--;
            return val;
        }
        int val = head.data;
        head = head.next;
        head.prev = null;
        size--;
        return val;
    }

    public static int removeLast() {
        if (head == null) {
            System.out.println("Double Linked List is empty");
            return Integer.MIN_VALUE;
        }
        if (size == 1) {
            int val = head.data;
            head = tail = null;
            size--;
            return val;
        }
        int val = tail.data;
        tail = tail.prev;
        tail.next = null;
        size--;
        return val;
    }

    private static int removeAt(int idx) {
        if (idx < 0 || idx >= size) {
            System.out.println("Invalid index");
            return Integer.MIN_VALUE;
        }
        if (idx == 0) {
            return removeFirst();
        }
        if (idx == size - 1) {
            return removeLast();
        }
        Node temp = head;
        for (int i = 0; i < idx - 1; i++) {
            temp = temp.next;
        }
        int val = temp.next.data;
        temp.next = temp.next.next;
        temp.next.prev = temp;
        size--;
        return val;
    }

    // get
    public int getFirst() {
        if (head == null) {
            System.out.println("Double Linked List is empty");
            return Integer.MIN_VALUE;
        }
        return head.data;
    }

    public int getLast() {
        if (head == null) {
            System.out.println("Double Linked List is empty");
            return Integer.MIN_VALUE;
        }
        return tail.data;
    }

    public int getAt(int idx) {
        if (idx < 0 || idx >= size) {
            System.out.println("Invalid index");
            return Integer.MIN_VALUE;
        }
        Node temp = head;
        for (int i = 0; i < idx; i++) {
            temp = temp.next;
        }
        return temp.data;
    }

    // size
    public int size() {
        return size;
    }

    // display
    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "<->");
            temp = temp.next;
        }
        System.out.println("END");
    }

    // reverse
    public void reverse() {
        Node curr = head;
        Node prev = null;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            curr.prev = next;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    public static void main(String[] args) {
        DoublyLL dll = new DoublyLL();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements");
        int n = sc.nextInt();
        System.out.println("Enter the elements");
        for (int i = 0; i < n; i++) {
            dll.addLast(sc.nextInt());
        }
        System.out.println("The elements are");
        dll.display();
        System.out.println("The size of the list is " + dll.size());
        System.out.println("The first element is " + dll.getFirst());
        System.out.println("The last element is " + dll.getLast());
        System.out.println("The element removed from the first is " + dll.removeFirst());
        System.out.println("The element removed from the last is " + dll.removeLast());
        System.out.println("The elements are");
        dll.display();
        System.out.println("The size of the list is " + dll.size());
        System.out.println("Reversing the list");
        dll.reverse();
        System.out.println("The elements are");
        dll.display();
    }
}
