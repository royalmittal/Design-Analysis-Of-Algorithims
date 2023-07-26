import java.util.*;

public class StackByFramework {

    // ====================PUDSH AT BOTTOM OF
    // STACK==============================================
    public static void pushAtBottom(Stack<Integer> s, int data) {
        if (s.isEmpty()) {
            s.push(data);
            return;
        }
        int top = s.peek();
        s.pop();
        pushAtBottom(s, data);
        s.push(top);
    }

    // ==============================REVERSE STRING USING
    // STACK=================================
    public static String reverseString(String str) {
        Stack<Character> s = new Stack<Character>();
        int idx = 0;
        while (idx < str.lenght()) {
            s.push(str.charAt(idx));
            idx++;
        }
        StringBuilder sb = new StringBuilder();
        while (!s.isEmpty()) {
            char curr = s.pop();
            result.append(curr);
        }
        return sb.toString();
    }

    // ==============================REVERSE STACK =================================
    public static void reverseStack(Stack<Integer> s) {
        if (s.isEmpty()) {
            return;
        }
        int top = s.pop();
        reverseStack(s);
        pushAtBottom(s, top);
    }

    // ==============================NEXT GRAETER ELEMENT IN
    // STACK==========================================
    public static void nextGreaterElement(int[] arr) {
        Stack<Integer> s = new Stack<Integer>();
        s.push(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            if (s.isEmpty()) {
                s.push(arr[i]);
                continue;
            }
            while (!s.isEmpty() && s.peek() < arr[i]) {
                System.out.println(s.pop() + " -> " + arr[i]);
            }
            s.push(arr[i]);
        }
        while (!s.isEmpty()) {
            System.out.println(s.pop() + " -> " + -1);
        }
    }

    // ==============================SORT
    // STACK==========================================

    public static void insertInSortedOrder(Stack<Integer> s, int data) {
        if (s.isEmpty() || data > s.peek()) {
            s.push(data);
            return;
        }
        int top = s.pop();
        insertInSortedOrder(s, data);
        s.push(top);
    }

    public static void sortStack(Stack<Integer> s) {
        if (s.isEmpty()) {
            return;
        }
        int top = s.pop();
        sortStack(s);
        insertInSortedOrder(s, top);
    }

    // ==============================PRINT STACK=================================
    public static void printStack(Stack<Integer> s) {
        while (!s.isEmpty()) {
            System.out.println(s.pop());
        }
    }

    // ==============================MAIN METHOD=================================

    //
    public static void main(String[] args) {

        Stack<Integer> s = new Stack<Integer>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Size of Stack");
        int size = sc.nextInt();
        System.out.println("Enter the numbers");
        for (int i = 0; i < size; i++) {
            s.push(sc.nextInt());
        }
        printStack(s);

        System.out.println("Enter the number to push at bottom of stack");
        int data = sc.nextInt();
        pushAtBottom(s, data);
        System.out.println("Stack is: " + s);
        while (!s.isEmpty()) {
            System.out.println(s.pop());
        }

        System.out.println("Enter the string to reverse");
        String str = sc.next();
        System.out.println("Reversed String is: " + reverseString(str));

        System.out.println("Reverse Stack is:");
        reverseStack(s);
        System.out.println("Stack is: " + s);
        printStack(s);

        System.out.println("Enter the size of array");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the numbers");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        nextGreaterElement(arr);
        for (int i = 0; i < n; i++) {
            System.out.println(arr[i]);
        }

        System.out.println("Sorted Stack is:");
        sortStack(s);
        System.out.println("Stack is: " + s);
        printStack(s);
    }
}