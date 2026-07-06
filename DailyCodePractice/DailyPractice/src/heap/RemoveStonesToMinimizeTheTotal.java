package heap;

import java.util.PriorityQueue;

public class RemoveStonesToMinimizeTheTotal {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b - a);
        for (int p : piles){
            pq.add(p);
        }
        for (int i = 0; i < k; i++){
            if (!pq.isEmpty()){
                pq.add((pq.poll() + 2 -1)/2);
            }
        }

        int sum = 0;
        while (!pq.isEmpty()){
            sum += pq.poll();
        }
        return sum;
    }

    public static void main(String[] args) {
        RemoveStonesToMinimizeTheTotal r = new RemoveStonesToMinimizeTheTotal();
        System.out.println(r.minStoneSum1(new int[]{4,3,6,7}, 3));
    }

    //原地化堆的初次尝试
    //交换根节点和儿子
    private void swap(int[] h, int i, int j){
        int temp = h[i];
        h[i] = h[j];
        h[j] = temp;
    }
    //下沉
    private void sink(int[] h, int i){
        int n = h.length;
        while (2 * i + 1 < n){//是否有左儿子，没有说明已经是叶子节点
            int j = 2 * i + 1;
            if (j + 1 < n && h[j] < h[j + 1]){ //判断是否有右儿子，比较大小
                j++; //选择右儿子作为替换的数字
            }
            if (h[j] <= h[i]){//根节点>=最大的子节点
                break;
            }
            swap(h, i, j);
            i = j;//继续下沉
        }
    }

    private void heapIfy(int[] h){
        for (int i = h.length / 2 - 1; i >= 0; i--){
            sink(h, i);
        }//从最后一个根节点向上遍历
    }

    public int minStoneSum1(int[] piles, int k) {
        heapIfy(piles); // 原地堆化（最大堆）
        while (k-- > 0 && piles[0] != 1) {
            piles[0] -= piles[0] / 2; // 直接修改堆顶
            sink(piles, 0); // 堆化（只需要把 piles[0] 下沉）
        }

        int ans = 0;
        for (int x : piles) {
            ans += x;
        }
        return ans;
    }

}
