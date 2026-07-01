package heap;

import java.util.PriorityQueue;

public class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        for (int stone : stones) {
            pq.add(stone);
        }
        while (pq.size() > 1) {
            int first = pq.poll();
            int second = pq.poll();
            int temp = first - second;
            pq.add(temp);
        }
        return pq.poll();
    }
    public static void main(String[] args) {
        LastStoneWeight ls = new LastStoneWeight();
        System.out.println(ls.lastStoneWeight(new int[]{2,7,4,1,8,1}));
    }
}
