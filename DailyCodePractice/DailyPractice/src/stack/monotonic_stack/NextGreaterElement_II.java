package stack.monotonic_stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;

public class NextGreaterElement_II {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<Integer>();
        int len = nums.length;
        int[] num = new int[len*2];
        for (int i = 0; i < len; i++) {
            num[i] = nums[i];
            num[len + i] = num[i];
        }
        int[] res = new int[len];
        Arrays.fill(res, -1);
        for (int i = 0; i < len*2; i++) {
            while (!stack.isEmpty() && num[stack.peek()] < num[i] ) {
                res[stack.pop()%len] = num[i];
            }
            stack.push(i);
        }
        return res;
    }//correct

    public int[] correct(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        Deque<Integer> st = new ArrayDeque<>();
        for (int i = 0; i < 2 * n; i++) {
            int x = nums[i % n];
            while (!st.isEmpty() && x > nums[st.peek()]) {
                // x 是 nums[st.peek()] 的下一个更大元素
                // 既然 nums[st.peek()] 已经算出答案，则从栈顶弹出
                ans[st.pop()] = x;
            }
            if (i < n) {
                st.push(i);
            }//找之前的是否存在比这个数大的
        }
        return ans;
    }


    public static void main(String[] args) {
        NextGreaterElement_II n = new NextGreaterElement_II();
        System.out.println(Arrays.toString(n.nextGreaterElements(new int[]{1,2,3,4,3})));
    }
}
