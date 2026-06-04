package stack.monotonic_stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class StockPriceRange {

}

class StockSpanner {
    Stack<Integer> stack;
    int t = 0;
    public StockSpanner() {
        stack = new Stack<>();
    }

    public int next(int price) {
        while (!stack.isEmpty() && price > stack.peek()) {
            stack.pop();
        }
        return stack.isEmpty() ? -1 : stack.peek();
    }
}

class correct {
    private final Deque<int[]> stack = new ArrayDeque<>();
    private int curDay = -1; // 第一个 next 调用算作第 0 天

    public correct() {
        stack.push(new int[]{-1, Integer.MAX_VALUE}); // 这样无需判断栈为空的情况
    }

    public int next(int price) {
        while (price >= stack.peek()[1]) {
            stack.pop(); // 栈顶数据后面不会再用到了，因为 price 更大
        }
        curDay++;
        int ans = curDay - stack.peek()[0];
        stack.push(new int[]{curDay, price});
        return ans;
    }
}
/*
问题:
    1.题目没有仔细阅读读懂，看不懂的下次应该画图写数据方便理解
    2.这是一道关于单调栈的题目关键是要找到栈中的元素进出和题目的关系
        为什么进栈：因为元素有用才进栈
        为什么出栈：无用的就出栈
解：
    在这题中，找的是连续非递减的子数列 -> 找上一个大于当前数字的数字
    例子：5345143
        运行到4时上一个比它大的是5，那么3出栈，4入栈，4比3大，能找打3必然能找到4，4在3之后入栈，所以3没用。
 */
