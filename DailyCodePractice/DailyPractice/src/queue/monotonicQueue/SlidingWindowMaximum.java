package queue.monotonicQueue;

import java.util.*;

public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer[]> pir = new PriorityQueue<>((a,b)->b[0]-a[0]);
        ArrayList<Integer> res = new ArrayList<Integer>();
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            pir.add(new Integer[]{nums[i], i});
            while (pir.peek()[1] < left){
                pir.remove();
            }
            if (i >= k - 1){
                res.add(pir.peek()[0]);
                left++;
            }
        }
        return res.stream().mapToInt(i->i).toArray();
    }
}

/*
新概念（双端队列）
    1.栈+队列：既可以先进先出，也可以后进先出
遗漏:
    1. 可以通过使用双端队列判断队尾元素来维护单调栈
    2. 方法包括addLast/offerLast removeLast/pollLast getLast/peekLast
 */
