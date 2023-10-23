import java.util.*;

public class WeakestSoldier {
    static class Soldier implements Comparable<Soldier> {
        int id, health;

        public Soldier(int id, int health) {
            this.id = id;
            this.health = health;
        }

        @Override
        public int compareTo(Soldier s2) {
            if (this.health == s2.health) {
                return this.id - s2.id;
            }
            return this.health - s2.health;
        }
    }

    public static List<Integer> getWeakestSoldiers(int[][] soldiers, int k) {
        PriorityQueue<Soldier> pq = new PriorityQueue<Soldier>();
        for (int i = 0; i < soldiers.length; i++) {
            pq.add(new Soldier(soldiers[i][0], soldiers[i][1]));
        }

        List<Integer> weakest = new ArrayList<Integer>();
        for (int i = 0; i < k; i++) {
            weakest.add(pq.poll().id);
        }

        return weakest;
    }

    public static void main(String[] args) {
        int[][] soldiers = { { 1, 1 }, { 2, 2 }, { 3, 3 }, { 4, 4 }, { 5, 5 } };
        int k = 3;
        List<Integer> weakest = getWeakestSoldiers(soldiers, k);
        System.out.println("The weakest soldiers are: " + weakest);
    }
}