package stack.monotonic_stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class FinalPricesWithASpecialDiscountInAShop {
    public int[] finalPrices(int[] prices) {
        Deque<Integer> stack = new ArrayDeque<Integer>();
        int[] ans = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            int price = prices[i];
            while (!stack.isEmpty() && price <= prices[stack.peek()]) {
                int pop = stack.pop();
                ans[pop] = prices[pop] - price;
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int pop = stack.pop();
            ans[pop] = prices[pop];
        }
        return ans;
    }

    public int[] improve(int[] prices) {
        // 更快的写法见【Java 数组】
        Deque<Integer> st = new ArrayDeque<>(); // todolist
        for (int i = 0; i < prices.length; i++) {
            int p = prices[i];
            while (!st.isEmpty() && prices[st.peek()] >= p) {
                prices[st.pop()] -= p; // p 是栈顶的折扣值
            }
            st.push(i);
        }
        return prices;
    }

    public static void main(String[] args) {
        FinalPricesWithASpecialDiscountInAShop demo = new FinalPricesWithASpecialDiscountInAShop();
        int[] ans = {10,1,1,6};
        System.out.println(Arrays.toString(demo.finalPrices(ans)));
    }
    /*
    优化：
        直接在数组修改可以不处理栈中剩余元素。
     */
}
