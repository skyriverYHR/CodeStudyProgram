package stack.monotonic_stack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class NextGreaterElement_I {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums1.length; i++) {
            map.put(nums1[i], i);
        }
        int[] res = new int[nums1.length];
        Arrays.fill(res, -1);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums2.length; i++) {
            while (!stack.isEmpty() && nums2[stack.peek()] < nums2[i]) {
                int index = stack.pop();
                if (map.containsKey(nums2[index])) {
                    res[map.get(nums2[index])] = nums2[i];
                }
            }
            stack.push(i);
        }
        return res;
    }//correct

    public static void main(String[] args) {
        NextGreaterElement_I obj = new NextGreaterElement_I();
        int[] nums1 = {2,4};
        int[] nums2 = {1,2,3,4};
        System.out.println(Arrays.toString(obj.nextGreaterElement(nums1,nums2)));
    }
}
