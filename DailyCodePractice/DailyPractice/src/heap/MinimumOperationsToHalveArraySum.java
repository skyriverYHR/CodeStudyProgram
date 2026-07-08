package heap;

import java.util.PriorityQueue;

public class MinimumOperationsToHalveArraySum {
    public int halveArray(int[] nums) {
        PriorityQueue<Double> maxHeap = new PriorityQueue<>((a,b)-> Double.compare(b,a));
        double sum = 0;
        int times = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            maxHeap.add((double) nums[i]);
        }
        double t = sum / 2;
        while(!maxHeap.isEmpty() && sum > t){
            double temp = maxHeap.poll()/2;
            sum -= temp;
            maxHeap.add(temp);
            times++;
        }
        return times;
    }
    public static void main(String[] args) {
        MinimumOperationsToHalveArraySum m = new MinimumOperationsToHalveArraySum();
    }
}
