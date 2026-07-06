package heap;

import java.util.PriorityQueue;

class KthLargest {
    PriorityQueue<Integer> pqL;
    int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        int times = 0;
        this.pqL = new PriorityQueue<>((a,b)-> a-b);
        for (int i = 0; i < nums.length; i++) {
            pqL.add(nums[i]);
            times++;
            while (times > k){
                pqL.poll();
                times--;
            }
        }
    }

    public int add(int val) {
        pqL.add(val);
        while (pqL.size() > k){
            pqL.poll();
        }
        return pqL.peek();
    }
}
