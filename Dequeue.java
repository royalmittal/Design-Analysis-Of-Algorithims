import java.util.*;

public class Dequeue {

    static class stack {
        Deque<Integer> q1 = new LinkedList<>();

        public void push(int x) {
            q1.addFirst(x);
        }

        public int pop() {
            if (q1.isEmpty()) {
                System.out.println("Stack is Empty");
                return -1;
            }
            return q1.removeFirst();
        }

        public int peek() {
            if (q1.isEmpty()) {
                System.out.println("Stack is Empty");
                return -1;
            }
            return q1.peekFirst();
        }
    }

    static class queue {
        Deque<Integer> q1 = new LinkedList<>();

        public void push(int x) {
            q1.addFirst(x);
        }

        public int pop() {
            if (q1.isEmpty()) {
                System.out.println("Stack is Empty");
                return -1;
            }
            return q1.removeLast();
        }

        public int peek() {
            if (q1.isEmpty()) {
                System.out.println("Stack is Empty");
                return -1;
            }
            return q1.peekLast();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Deque<Integer> dq = new LinkedList<>();
        dq.addFirst(10);
        dq.addFirst(20);
        dq.addFirst(30);
        dq.addFirst(40);
        dq.addFirst(50);
        System.out.println("Dequeue.main()");

        System.out.println("Stack Implementation using Queue");
        stack s = new stack();
        s.push(10);
        s.push(20);
        s.push(30);
        s.push(40);
        while (s.peek() != -1) {
            System.out.println(s.peek());
            s.pop();
        }

        System.out.println("Queue Implementation using Stack");
        queue q1 = new queue();
        q1.push(10);
        q1.push(20);
        q1.push(30);
        q1.push(40);
        while (q1.peek() != -1) {
            System.out.println(q1.peek());
            q1.pop();
        }
    }
}
