package heap;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.PriorityQueue;

public class UglyNumberII {
    public int nthUglyNumber(int n) {
        Deque<Integer> stack = new ArrayDeque<>();

        while(stack.size() < n){

        }
        return 0;
    }



    public int nthUglyNumberSolution(int n) {
        // 小根堆，存放当前生成的所有丑数候选者，堆顶永远最小
        PriorityQueue<Long> heap = new PriorityQueue<>();
        HashSet<Long> set = new HashSet<>();

        // 初始状态
        heap.offer(1L);
        set.add(1L);

        // 因为 1 是第一个，所以循环 n-1 次，每次弹出一个最小的
        for (int i = 1; i < n; i++) {
            long cur = heap.poll(); // 弹出当前最小的丑数

            long a = cur * 2;
            long b = cur * 3;
            long c = cur * 5;

            if (set.add(a)) heap.offer(a);
            if (set.add(b)) heap.offer(b);
            if (set.add(c)) heap.offer(c);
        }

        // 循环结束后，堆顶就是第 n 个丑数
        return heap.peek().intValue();
    }

}//不会处理丑数，把丑数计算出来计数。
/*
为什么：
1.对丑数不熟悉，不理解丑数的概念
2.丑数一定是丑数乘以丑数的结果，所以可以用到枚举！！！！
 */



