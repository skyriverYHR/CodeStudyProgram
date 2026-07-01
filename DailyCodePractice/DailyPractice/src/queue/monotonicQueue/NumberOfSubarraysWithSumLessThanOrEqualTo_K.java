package queue.monotonicQueue;

import java.util.Deque;
import java.util.LinkedList;

public class NumberOfSubarraysWithSumLessThanOrEqualTo_K {
    public long countSubarrays(int[] nums, long k) {
        int left = 0;
        long ans = 0;
        int cost = 0;
        Deque<Integer> maxQ = new LinkedList<>();
        Deque<Integer> minQ = new LinkedList<>();
        for (int right = 0; right < nums.length; right++) {
            while (!minQ.isEmpty() && nums[right] < nums[minQ.peekLast()]) {
                minQ.pollLast();
            }
            minQ.addLast(right);
            while (!maxQ.isEmpty() && nums[right] > nums[maxQ.peekLast()]) {
                maxQ.pollLast();
            }
            maxQ.addLast(right);
            while ((!minQ.isEmpty() && !maxQ.isEmpty()) && (long) (nums[maxQ.peekFirst()] - nums[minQ.peekFirst()])*(right - left + 1) > k) {
                left++;
                while (!minQ.isEmpty() && maxQ.peekFirst() < left) {
                    maxQ.pollFirst();
                }
                while (!maxQ.isEmpty() && minQ.peekFirst() < left) {
                    minQ.pollFirst();
                }
            }
            ans += right - left + 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        NumberOfSubarraysWithSumLessThanOrEqualTo_K obj = new NumberOfSubarraysWithSumLessThanOrEqualTo_K();
        System.out.println(obj.countSubarrays(new int[]{1,2,3}, 0));
    }
}
