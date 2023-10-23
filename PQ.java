import java.util.PriorityQueue;

static class Student implements Comparable<Student> {
    String name;
    int rank;

    public Student(String name, int rank) {
        this.name = name;
        this.rank = rank;
    }

    @Override
    public int compareTo(Student s2) {
        return this.rank - s2.rank;
    }
}

public class PQ {

    public static void main(String[] args) {
        PriorityQueue<Integer> pq1 = new PriorityQueue<Integer>();
        pq1.add(25);
        pq1.add(-22);
        pq1.add(1343);
        pq1.add(54);
        pq1.add(0);
        pq1.add(-3492);
        pq1.add(429);

        System.out.println(pq1.peek());
        System.out.println(pq1.remove());
        System.out.println(pq1.peek());
        System.out.println(pq1.poll());
        System.out.println(pq1.peek());
        System.out.println(pq1.remove(54));
        System.out.println(pq1.peek());

        Object[] ints = pq1.toArray();
        for (Object num : ints) {
            System.out.println(num);
        }

        System.out.println(pq1.peek());
        pq1.add(-1);
        System.out.println(pq1.peek());

        PriorityQueue<Student> pq2 = new PriorityQueue<Student>();
        pq2.add(new Student("A", 7));
        pq2.add(new Student("B", 9));
        pq2.add(new Student("C", 3));
        pq2.add(new Student("D", -4));

        while (!pq2.isEmpty()) {
            System.out.println(pq2.peek().name + "->" + pq2.peek().rank);
            pq2.poll();
        }
    }
}