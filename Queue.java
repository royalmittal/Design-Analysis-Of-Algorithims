import java.util.Scanner;

public class Queue {
    static class queue {
        static int arr[], size, rear;

        public queue(int n) {
            int arr[] = new int[n];
            n = size;
            rear = -1;
        }

        // IS EMPTY
        public static boolean isEmpty() {
            return rear == -1;
        }

        // IS FULL
        public static boolean isFull() {
            return rear == size - 1;
        }

        // ADD
        pubic static void add(int data) {
            if (isFull()) {
                System.out.println("Queue is full");
                return;
            }
            rear = rear +1;
            arr[rear] = data;
        }

        // DEQUEUE
        public static int dequeue() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            int temp = arr[0];
            for (int i = 0; i < rear; i++) {
                arr[i] = arr[i + 1];
            }
            rear--;
            return temp;
        }

        // REMOVE
        public static void remove() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return-1;
            }
            int front = arr[0];
            for (int i = 0; i < rear; i++) {
                arr[i] = arr[i + 1];
            }
            rear--;
            return front;
        }

        // PEEK
        public static int peek() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            return arr[0];
        }

        // DISPLAY
        public static void display() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return;
            }
            for (int i = 0; i <= rear; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }

        // SIZE
        public static int size() {
            return rear + 1;
        }

        // CLEAR
        public static void clear() {
            rear = -1;
        }

        // REVERSE
        public static void reverse() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return;
            }
            int temp[] = new int[size];
            int j = 0;
            for (int i = rear; i >= 0; i--) {
                temp[j++] = arr[i];
            }
            arr = temp;
        }
    }

    // MAIN

    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of queue");
        n = sc.nextInt();
        queue q = new queue(n);
        System.out.println("Enter elements");
        for (int i = 0; i < n; i++) {
            q.enqueue(sc.nextInt());
        }
        System.out.println("Queue is");
        q.display();
        System.out.println("Size of queue is " + q.size());
        System.out.println("Peek of queue is " + q.peek());
        System.out.println("Dequeue of queue is " + q.dequeue());
        System.out.println("Queue is");
        q.display();
        System.out.println("Size of queue is " + q.size());
        System.out.println("Reverse of queue is");
        q.reverse();
        q.display();
    }
}
