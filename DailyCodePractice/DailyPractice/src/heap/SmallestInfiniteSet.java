package heap;

import java.util.HashSet;
import java.util.PriorityQueue;

public class SmallestInfiniteSet {
    HashSet<Integer> set;
    PriorityQueue<Integer> pq;
    public SmallestInfiniteSet() {
        this.pq = new PriorityQueue<>((a,b)-> a-b);
        this.set = new HashSet<>();
        for (int i = 1; i <= 1000; i++) {
            set.add(i);
            pq.add(i);
        }
    }

    public int popSmallest() {
        int min = pq.poll();
        set.remove(min);
        return min;
    }

    public void addBack(int num) {
        if (set.contains(num)) {
            return;
        }
        set.add(num);
        pq.add(num);
    }
}
