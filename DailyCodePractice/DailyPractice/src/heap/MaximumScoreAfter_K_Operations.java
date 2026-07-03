package heap;

import java.util.PriorityQueue;

public class MaximumScoreAfter_K_Operations {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)->b-a);
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            maxHeap.add(nums[i]);
        }
        for (int i = 0; i < k; i++) {
            Integer a = maxHeap.poll();
            sum += a;
            a =  (a + 3 - 1)/3;
            maxHeap.add(a);
        }
        return sum;
    }

    public static void main(String[] args) {
        MaximumScoreAfter_K_Operations m = new MaximumScoreAfter_K_Operations();
        System.out.println(m.maxKelements(new int[]{1,10,3,3,3}, 3));
    }
}
