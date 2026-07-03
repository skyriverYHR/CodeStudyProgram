package heap;

import java.util.PriorityQueue;

public class MinimumOperationsToExceedThresholdValue_II {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            minHeap.add((long)num);
        }
        int count = 0;
        while (!minHeap.isEmpty() && minHeap.size() >= 2 && minHeap.peek() < k) {
            long f1 = minHeap.poll();
            long f2 = minHeap.poll();

            long add = Math.min(f1, f2)*2 + Math.max(f1, f2);
            minHeap.add(add);
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        MinimumOperationsToExceedThresholdValue_II m = new MinimumOperationsToExceedThresholdValue_II();
        System.out.println(m.minOperations(new int[]{1,1,2,4,9}, 20));
    }
}
