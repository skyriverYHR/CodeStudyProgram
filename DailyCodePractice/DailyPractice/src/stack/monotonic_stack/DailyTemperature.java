package stack.monotonic_stack;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class DailyTemperature {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new LinkedList<>();
        int[] result = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                result[stack.peek()] = i - stack.pop();
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            result[stack.pop()] = 0;
        }
        return result;
    }

    public static void main(String[] args) {
        DailyTemperature dt = new DailyTemperature();
        int[] n = {30,60,90};
        System.out.println(Arrays.toString(dt.dailyTemperatures(n)));
    }

    /*
    对于我自己的算法优化：int[]数组没有赋值数据默认为0，可以删除while不处理栈中剩余元素
     */
}
