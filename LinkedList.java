import java.util.*;

public class LinkedList {
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

    // ADD FIRST FUNCTION
    public static void addFirst(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    // ADD LAST FUNCTION
    public static void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    // ADD AT FUNCTION
    public static void addAt(int data, int idx) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else if (idx < 0 || idx > size()) {
            System.out.println("Invalid arguments");
        } else if (idx == 0) {
            addFirst(data);
        } else if (idx == size()) {
            addLast(data);
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

    // GET FIRST FUNCTION
    public static int getFirst() {
        if (head == null) {
            System.out.println("List is empty");
            return -1;
        } else {
            return head.data;
        }
    }

    // GET LAST FUNCTION
    public static int getLast() {
        if (head == null) {
            System.out.println("List is empty");
            return -1;
        } else {
            return tail.data;
        }
    }

    // GET AT FUNCTION
    public static int getAt(int idx) {
        if (head == null) {
            System.out.println("List is empty");
            return -1;
        } else if (idx < 0 || idx >= size()) {
            System.out.println("Invalid arguments");
            return -1;
        } else {
            Node temp = head;
            for (int i = 0; i < idx; i++) {
                temp = temp.next;
            }
            return temp.data;
        }
    }

    // SIZE FUNCTION
    public static int size() {
        return size;
    }

    // REMOVE FIRST FUNCTION
    public static int removeFirst() {
        if (head == null) {
            System.out.println("List is empty");
            return Integer.MIN_VALUE;
        } else {
            int val = head.data;
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                head = head.next;
            }
            size--;
            return val;
        }
    }

    // REMOVE LAST FUNCTION
    public static int removeLast() {
        if (head == null) {
            System.out.println("List is empty");
            return Integer.MIN_VALUE;
        } else {
            int val = tail.data;
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                Node temp = head;
                while (temp.next != tail) {
                    temp = temp.next;
                }
                tail = temp;
                tail.next = null;
            }
            size--;
            return val;
        }
    }

    // REMOVE AT FUNCTION
    public static int removeAt(int idx) {
        if (head == null) {
            System.out.println("List is empty");
            return -1;
        } else if (idx < 0 || idx >= size()) {
            System.out.println("Invalid arguments");
            return -1;
        } else if (idx == 0) {
            return removeFirst();
        } else if (idx == size() - 1) {
            return removeLast();
        } else {
            Node temp = head;
            for (int i = 0; i < idx - 1; i++) {
                temp = temp.next;
            }
            int val = temp.next.data;
            temp.next = temp.next.next;
            size--;
            return val;
        }
    }

    // IS EMPTY FUNCTION
    public static boolean isEmpty() {
        return size == 0;
    }

    // PRINT FUNCTION
    public static void display() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the list");
        int n = sc.nextInt();
        System.out.println("Enter the elements of the list");
        for (int i = 0; i < n; i++) {
            addLast(sc.nextInt());
        }
        System.out.println("List: ");
        display();
        System.out.println("Size: " + size());
        System.out.println("First Element of List: ");
        System.out.println(getFirst());
        System.out.println("Last Element of List: ");
        System.out.println(getLast());
        System.out.println("Enter the index of the element you want to get");
        int idx = sc.nextInt();
        System.out.println("Element at index " + idx + " is: ");
        System.out.println(getAt(idx));
        System.out.println("Enter the element you want to add at the beginning of the list");
        int data = sc.nextInt();
        addFirst(data);
        System.out.println("List after adding element at the beginning: ");
        display();
        System.out.println("Enter the element you want to add at the end of the list");
        data = sc.nextInt();
        addLast(data);
        System.out.println("List after adding element at the end: ");
        display();
        System.out.println("Enter the element you want to add at a particular index of the list");
        data = sc.nextInt();
        System.out.println("Enter the index at which you want to add the element");
        idx = sc.nextInt();
        addAt(data, idx);
        System.out.println("List after adding element at index " + idx + " is: ");
        display();
        System.out.println("Removing first element of the list");
        removeFirst();
        System.out.println("List after removing first element: ");
        display();
        System.out.println("Removing last element of the list");
        removeLast();
        System.out.println("List after removing last element: ");
        display();
        System.out.println("Enter the index of the element you want to remove");
        idx = sc.nextInt();
        System.out.println("Removing element at index " + idx + " is: ");
        removeAt(idx);
        System.out.println("List after removing element at index " + idx + " is: ");
        display();
        System.out.println("Is the list empty? " + isEmpty());
        sc.close();
    }
}
