package heap;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class FinalArrayAfter_K_MultiplicationOperations_I {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        //优先队列的二维数组排序用法，先按a[1]升序，相同再按a[0]升序
        PriorityQueue<Integer[]> heap = new PriorityQueue<Integer[]>(
                Comparator.<Integer[]>comparingInt(a -> a[1])
                        .thenComparingInt(a -> a[0])
        );
        for (int i = 0; i < nums.length; i++) {
            Integer[] temp = new Integer[2];
            temp[0] = i;
            temp[1] = nums[i];
            heap.add(temp);
        }

        for (int i = 0; i < k; i++) {
            Integer[] temp = heap.poll();
            temp[1] *= multiplier;
            heap.add(temp);
        }

        while (!heap.isEmpty()) {
            Integer[] temp = heap.poll();
            nums[temp[0]] = temp[1];
        }

        return nums;
    }


    public static void main(String[] args) {
        FinalArrayAfter_K_MultiplicationOperations_I f = new FinalArrayAfter_K_MultiplicationOperations_I();
        System.out.println(Arrays.toString(f.getFinalState(new int[]{1,2},3,4)));
    }
}
