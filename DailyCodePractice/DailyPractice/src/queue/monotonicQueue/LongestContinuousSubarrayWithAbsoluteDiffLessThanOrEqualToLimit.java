package queue.monotonicQueue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit {
    public int longestSubarray(int[] nums, int limit) {
        int left = 0;
        int length = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->a-b);
        for (int i = 0; i < nums.length; i++) {
            pq.add(i);
            while (!pq.isEmpty() && Math.abs(nums[pq.peek()] - nums[i]) > limit) {
                left =Math.max(left,pq.poll() + 1);
                while (!pq.isEmpty() && pq.peek() < left) {
                    pq.poll();
                }
            }
            length = Math.max(length, pq.size());
        }
        return length;
    }

    public static void main(String[] args) {
        LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit l = new LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit();
        System.out.println(l.longestSubarray(new int[]{4,2,2,2,4,4,2,2}, 0));
    }

    public int correct(int[] nums, int limit) {
        Deque<Integer> minQ = new ArrayDeque<>(); // 更快的写法见【Java 数组】
        Deque<Integer> maxQ = new ArrayDeque<>();
        int ans = 0;
        int left = 0;

        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];

            // 1. 右边入
            while (!minQ.isEmpty() && x <= nums[minQ.peekLast()]) {
                minQ.pollLast();
            }
            minQ.addLast(i);

            while (!maxQ.isEmpty() && x >= nums[maxQ.peekLast()]) {
                maxQ.pollLast();
            }
            maxQ.addLast(i);

            // 2. 左边出
            //从左往右判断队首的最大最小是否还在队列中。
            while (nums[maxQ.peekFirst()] - nums[minQ.peekFirst()] > limit) {
                left++;
                if (minQ.peekFirst() < left) { // 队首不在窗口中
                    minQ.pollFirst();
                }
                if (maxQ.peekFirst() < left) { // 队首不在窗口中
                    maxQ.pollFirst();
                }
            }

            // 3. 更新答案
            ans = Math.max(ans, i - left + 1);
        }

        return ans;
    }

    /*
    窗口更新和双端什么时候进什么时候出不够熟练
     */

}
