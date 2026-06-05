package queue;

import java.util.LinkedList;
import java.util.Queue;

public class TheNumberOfRecentRequests {
    public static void main(String[] args) {
        RecentCounter recentCounter = new RecentCounter();
        for (int i = 0; i < 4000; i++) {
            System.out.println(recentCounter.ping(i));
        }
    }

}


class RecentCounter {
    Queue<Integer> queue;
    public RecentCounter() {
        queue = new LinkedList<Integer>();
    }

    public int ping(int t) {
        while(!queue.isEmpty() && t - 3000 > queue.peek()) {
            queue.poll();
        }
        queue.offer(t);
        return queue.size();
    }
}