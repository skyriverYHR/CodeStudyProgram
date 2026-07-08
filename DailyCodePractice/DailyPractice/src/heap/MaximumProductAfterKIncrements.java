package heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MaximumProductAfterKIncrements {
    public int maximumProduct(int[] nums, int k) {
        int n = 1000000000 + 7;
        long are = 1;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for (int i = 0; i < nums.length; i++) {
            pq.add(nums[i]);
        }
        for (int i = 0; i < k; i++) {
            pq.add(pq.poll() + 1);
        }
        while (!pq.isEmpty()) {
            int num = pq.poll();
            are = are * num % n;
        }
        return (int)are;
    }
    public static void main(String[] args) {
        MaximumProductAfterKIncrements m = new MaximumProductAfterKIncrements();
        System.out.println(m.maximumProduct(new int[]{0,4},5));
    }
}
