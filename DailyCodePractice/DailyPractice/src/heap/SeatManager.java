package heap;

import java.util.PriorityQueue;

public class SeatManager {
    PriorityQueue<Integer> pq;
    public SeatManager(int n) {
        this.pq = new PriorityQueue<>();
        for (int i = 1; i <= n; i++) {
            pq.add(i);
        }
    }

    public int reserve() {
        if (!pq.isEmpty()) {
            return pq.poll();
        }
        return 0;
    }

    public void unreserve(int seatNumber) {
        pq.add(seatNumber);
    }

    public static void main(String[] args) {
        SeatManager sm = new SeatManager(5);
        System.out.println(sm.reserve());
    }
}
