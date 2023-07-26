import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class QueueFrameWork {
    public static void main(String[] args) {
        Queue<Integer> Q = new LinkedList<>();
        Q.add(1);
        Q.add(2);
        Q.add(3);
        Q.add(4);
        System.err.println(Q.peek());
    }
}
