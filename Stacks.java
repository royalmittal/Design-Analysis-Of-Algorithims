import java.util.ArrayList;
import java.util.*;

public class Stacks {
    static class stack {
        static ArrayList<Integer> list = new ArrayList<>();

        // =============IS EMPTY================
        static boolean isEmpty() {
            return list.size() == 0;
        }

        // =============PUSH================
        static void push(int data) {
            list.add(data);
        }

        // =============POP================
        static int pop() {
            if (isEmpty()) {
                System.out.println("Stack is Empty");
                return -1;
            }
            int top = list.get(list.size() - 1);
            list.remove(list.size() - 1);
            return top;
        }

        // =============PEEK================
        static int peek() {
            if (isEmpty()) {
                System.out.println("Stack is Empty");
                return -1;
            }
            int top = list.get(list.size() - 1);
            return top;
        }
    }
    // ==============================VALID PARENTHESIS
    // STACK=================================

    public static boolean isValid(String str) {
        Stack <Character> st = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') {
                st.push(ch);
            } else {
                if(st.isEmpty()){
                    return false;
                }
                if( (st.peek() == '(' && ch == ')') || (st.peek() == '{' && ch == '}') || (st.peek() == '[' && ch == ']') ){
                    st.pop();
                    //return true;
            }
            else{
                return false;
            }
        }
        if(st.isEmpty()){
            return true;
        }
        else{
            return false;
        }
        return false;
    }

    // ===============================DUPLICATE
    // PARENTHESIS============================

    public static boolean isDuplicate(String str) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < str.lenght(); i++) {
            char ch = str.charAt(i);
            // closing
            if (ch == ')') {
                int count = 0;
                while (st.peek() != '(') {
                    st.pop();
                    count++;
                }
                if (count < 1) {
                    return true;
                } else {
                    st.pop();
                }
            } else {

            }
        }
        return false;
    }

    // ==============================MAIN METHOD=================================

    public static void main(String[] args) {
        // stack s = new stack();
        // Scanner sc = new Scanner(System.in);
        // System.out.println("Enter Size of Stack");
        // int size = sc.nextInt();
        // System.out.println("Enter the numbers");
        // for (int i = 0; i < size; i++) {
        // s.push(sc.nextInt());
        // }
        // System.out.println(s.pop());
        // System.out.println(s.peek());
        // System.out.println(s.isEmpty());

        System.out.println("Enter the string");
        String str = sc.next();
        System.out.println(isValid(str));
        System.out.println(isDuplicate(str));
    }
}