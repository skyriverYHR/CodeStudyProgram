package queue.monotonicQueue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class Checkout {
    Deque<Integer> queue;
    int[] list;
    int left;
    int right;
    public Checkout() {
        queue = new ArrayDeque<>();
        list = new int[10000];
        left = 0;
        right = 0;
    }

    public int get_max() {
        if (left == right) {
            return -1;
        }
        while (!queue.isEmpty() && queue.peek() < left) {
            queue.poll();
        }
        return list[queue.peek()];
    }

    public void add(int value) {
        list[right] = value;
        while (!queue.isEmpty() && list[queue.peekLast()] < value) {
            queue.removeLast();
        }
        queue.addLast(right);
        right++;
    }

    public int remove() {
        if (left == right) {
            return -1;
        }
        int value = list[left];
        left++;
        return value;
    }

    public static void main(String[] args) {
        Checkout checkout = new Checkout();
        checkout.add(15);
        System.out.println(checkout.get_max());
        checkout.add(9);
        System.out.println(checkout.get_max());
    }
}
/*
运行时两个问题，add()方法的比较和get_Max()方法的返回值，问题都出在Deque中存储的是数组索引不是直接值，需要带入数组拿去最大值
 */
