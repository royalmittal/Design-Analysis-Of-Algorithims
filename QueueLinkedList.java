public class QueueLinkedList {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }

        static class queue {
            static Node head = null;
            static Node tail = null;

            public static boolean isEmpty() {
                return head == null;
            }

            public static void add(int data) {
                Node newNode = new Node(data);
                if (isEmpty()) {
                    head = newNode;
                    tail = newNode;
                    return;
                } else {
                    tail.next = newNode;
                    tail = newNode;
                }
            }

            public static int remove() {
                if (isEmpty()) {
                    System.out.println("Queue is empty");
                    return -1;
                }
                int front = head.data;
                if (tail == head) {
                    tail = null;
                } else {
                    head = head.next;
                }
                return front;
            }

            public static int peek() {
                if (isEmpty()) {
                    System.out.println("Queue is empty");
                    return -1;
                }
                return head.data;
            }

            public static void print() {
                if (isEmpty()) {
                    System.out.println("Queue is empty");
                    return;
                }
                Node temp = head;
                while (temp != null) {
                    System.out.print(temp.data + " ");
                    temp = temp.next;
                }
                System.out.println();
            }
        }
    }

    // Driver code
    public static void main(String[] args) {
        Node.queue q = new Node.queue();
        for (var i : new int[] { 1, 2, 3, 4, 5 }) {
            q.add(i);
        }
        System.out.println("Queue: ");
        q.print();
        System.out.println("Peek: " + q.peek());
        System.out.println(q.peek());
        q.print();

    }
}
