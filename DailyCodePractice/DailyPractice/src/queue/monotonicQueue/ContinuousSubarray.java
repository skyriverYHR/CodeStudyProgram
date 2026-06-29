package queue.monotonicQueue;

import java.util.Deque;
import java.util.LinkedList;

public class ContinuousSubarray {
    public long continuousSubarrays(int[] nums) {
        int left = 0;
        int ans = 0;
        Deque<Integer> min = new LinkedList<>();
        Deque<Integer> max = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            while (!min.isEmpty() && x < nums[min.peekLast()]) {
                min.removeLast();
            }
            min.addLast(i);
            while (!max.isEmpty() && x > nums[max.peekLast()]) {
                max.removeLast();
            }
            max.addLast(i);

            while (Math.abs(nums[max.peekFirst()] - nums[min.peekFirst()]) > 2) {
                left++;
                if (!min.isEmpty() && min.peekFirst() < left){
                    min.removeFirst();
                }
                if (!max.isEmpty() && max.peekFirst() < left){
                    max.removeFirst();
                }
            }
            //结构计算有问题，不会算子数组？？？？
//            int length = i - left + 1;
//            ans += length*(length + 1)/2;
            ans += i - left + 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        ContinuousSubarray cs = new ContinuousSubarray();
        System.out.println(cs.continuousSubarrays(new int[]{5,4,2,4}));
    }
}
