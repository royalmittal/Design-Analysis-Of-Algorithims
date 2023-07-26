import java.util.*;

public class QueueApplication {
    // QUEUE USING TWO STACKS
    public class queue {
        static Stack<Integer> s1 = new Stack<Integer>();
        static Stack<Integer> s2 = new Stack<Integer>();

        public static void add(int x) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
            s1.push(x);
            while (!s2.isEmpty()) {
                s1.push(s2.pop());
            }
        }

        public static int remove() {
            if (s1.isEmpty()) {
                System.out.println("Queue is Empty");
                System.exit(0);
            }
            int x = s1.peek();
            s1.pop();
            return x;
        }

        public static int peek() {
            if (s1.isEmpty()) {
                System.out.println("Queue is Empty");
                System.exit(0);
            }
            return s1.peek();
        }
    }

    // STACK USING TWO QUEUES

    public class stack {
        static Queue<Integer> q1 = new LinkedList<Integer>();
        static Queue<Integer> q2 = new LinkedList<Integer>();
        static int curr_size;

        public stack() {
            curr_size = 0;
        }

        public static int top() {
            if (q1.isEmpty()) {
                System.out.println("Stack is Empty");
                System.exit(0);
            }
            return q1.peek();
        }

        public static int size() {
            return curr_size;
        }

        public static boolean isEmpty() {
            return (curr_size == 0);
        }

        public static void push(int x) {
            curr_size++;
            q2.add(x);
            while (!q1.isEmpty()) {
                q2.add(q1.peek());
                q1.remove();
            }
            Queue<Integer> q = q1;
            q1 = q2;
            q2 = q;
        }

        public static void pop() {
            if (q1.isEmpty()) {
                System.out.println("Stack is Empty");
                return -1;
            }
            int top = -1;
            if(!q1.isEmpty()){
                top = q1.peek();
                q1.remove();
                curr_size--;
            }
            q2.push(top);
            else{
                while(q2.isEmpty()){
                    top = q2.remove();
                    if(q2.isEmpty()){
                        break;
                    }
                    q1.add(top);
                }
            }
            return top;
        }

        public static int peek() {
            if (isEmpty()) {
                System.out.println("Stack is Empty");
                return -1;
            }
            int top = -1;
            if (!q1.isEmpty()) {
                while (!q1.isEmpty()) {
                    top = q1.peek();
                    q1.remove();
                    q2.add(top);
                }
            } else {
                while (q2.isEmpty()) {
                    top = q2.remove();
                    q1.add(top);
                }
            }
            return top;
        }
    }

    // FIRST NON-REPEATING LETTERS

    public static void printNonRepating(String str) {
        int freq[] = new int[26];
        Queue<Character> q = new LinkedList<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            q.add(ch);
            freq[ch - 'a']++;
            while (!q.isEmpty() && freq[q.peek() - 'a']) {
                q.remove();
            }
            if (q.isEmpty()) {
                System.out.println(-1 + " ");
            } else {
                System.out.println(q.peek() + " ");
            }
        }
        System.out.println();
    }

    // INTERLEAFING

    public static void interLeafing(Queue<Integer> q) {
        Queue<Integer> firstHalf = new LinkedList<>();
        int size = q.size();
        for (int i = 0; i < size / 2; i++) {
            firstHalf.add(q.remove());
        }
        while (!firstHalf.isEmpty()) {
            q.add(firstHalf.remove());
            q.add(q.remove());
        }
    }

    // QUEUE REVERSAL

    public static void reversalQueue(Queue<Integer> q) {
        Stack<Integer> s = new Stack<>();
        while (!q.isEmpty()) {
            s.push(q.remove());
        }
        while (!s.isEmpty()) {
            q.add(s.pop());
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Queue<Integer> q = new ArrayQueue<>();
        // Queue<Integer> q = new LinkedList<>();
        // queue q = new queue();
        // q.add(10);
        // q.add(20);
        // q.add(30);
        // q.add(40);
        // q.add(50);
        // while (!q.isEmpty()) {
        // System.out.println(q.peek());
        // q.remove();
        // }

        // stack s = new stack();
        // s.push(10);
        // s.push(20);
        // s.push(30);
        // s.push(40);
        // s.push(50);
        // while (!s.isEmpty()) {
        // System.out.println(s.peek());
        // s.pop();
        // }

        // System.out.println("Enter the String for Non-Repeating\n");
        // String str = sc.nextLine();
        // printNonRepating(str);

        // INTERLEAFING
        Queue<Integer> q = new LinkedList<>();
        System.out.println("Enter The Size ");
        int size = sc.nextInt();
        for (int i = 0; i < size(); i++) {
            q.add(i);
        }
        interLeafing(q);
        while (!q.isEmpty()) {
            System.out.println(q.remove() + " ");
        }
        System.out.println();

        // REVERSAL QUEUE

        reversalQueue(q);
        while (!q.isEmpty()) {
            System.out.println(q.remove() + " ");
        }
        System.out.println();
    }
}
