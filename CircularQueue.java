import java.util.Scanner;

public class CircularQueue {
    static class queue {
        static int arr[], size, rear, front;

        public queue(int n) {
            int arr[] = new int[n];
            n = size;
            rear = -1;
            front = -1;
        }

        // IS EMPTY
        public static boolean isEmpty() {
            return rear == -1;
        }

        // IS FULL
        public static boolean isFull() {
            // return (rear == size - 1 && front == 0) || (rear == front - 1);
            return (rear + 1) % size == front;
        }

        // ADD
        public static void add(int data) {
            if (isFull()) {
                System.out.println("Queue is full");
                return;
            }
            if (front == -1) {
                front = 0;
            }
            rear = (rear + 1) % size;
            arr[rear] = data;
        }

        // DELETE
        public static int delete() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            int result = arr[front];
            if (front == rear) {
                front = rear = -1;
            } else {
                front = (front + 1) % size;
            }
            return result;
        }

        // PEEK
        public static int peek() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            return arr[front];
        }
    }

    // MAIN
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of queue");
        int n = sc.nextInt();
        queue q = new queue(n);
        while (true) {
            System.out.println("1. Add");
            System.out.println("2. Delete");
            System.out.println("3. Peek");
            System.out.println("4. Exit");
            System.out.println("Enter your choice");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter data");
                    int data = sc.nextInt();
                    q.add(data);
                    break;
                case 2:
                    System.out.println("Deleted element is " + q.delete());
                    break;
                case 3:
                    System.out.println("Peek element is " + q.peek());
                    break;
                case 4:
                    System.exit(0);
            }
        }
    }
}
