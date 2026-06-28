package singleCompele._508;

import java.util.Arrays;

public class MaximumSumofKElements {
    public long maxSum(int[] nums, int k, int mul) {
        Arrays.sort(nums);
        long sum = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (k == 0){
                break;
            }
            if (mul != 0){
                sum = sum + (long) nums[i]*mul;
                mul--;
            }else {
                sum += nums[i];
            }
            k--;
        }
        return sum;
    }

    public static void main(String[] args) {
        MaximumSumofKElements obj = new MaximumSumofKElements();
        System.out.println(obj.maxSum(new int[]{3,7,5,2}, 2, 4));
    }
}
