public class stackByLinkedList {
    static class Node {
        int data;
        int next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class stack {
        static Node head = null;

        public static boolean isEmpty() {
            if (head == null) {
                return true;
            }
        }

        public static void push(int data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = newNode;
            } else {
                newNode.next = head;
                head = newNode;
            }
        }

        public static int pop() {
            if (head == null) {
                System.out.println("Stack is Empty");
                return -1;
            }
            int top = head.data;
            head = head.next;
            return top;
        }

        public static int peek() {
            if (head == null) {
                System.out.println("Stack is Empty");
                return -1;
            }
            int top = head.data;
            return top;
        }

        public static void main(String[] args) {
            stack s = new stack();
            s.push(10);
            s.push(20);
            s.push(30);
            while (!s.isEmpty()) {
                System.out.println(s.peek());
                s.pop();
            }
        }
    }
}