package heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class TakeGiftsFromTheRichestPile {

    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer[]> pq = new PriorityQueue<Integer[]>(Comparator
                .<Integer[]>comparingInt(a -> a[1])
                .thenComparingInt(a -> a[0])
                .reversed()
        );
        for (int i = 0; i < gifts.length; i++) {
            pq.add(new Integer[]{i, gifts[i]});
        }

        for (int i = 0; i < k; i++) {
            Integer[] temp = pq.poll();
            temp[1] = (int) Math.sqrt(temp[1]);
            pq.add(temp);
        }
        long ans = 0;
        while (!pq.isEmpty()) {
            ans += pq.poll()[1];
        }
        return ans;
    }
    public static void main(String[] args) {
        TakeGiftsFromTheRichestPile p = new TakeGiftsFromTheRichestPile();
        System.out.println(p.pickGifts(new int[]{1,1,1,1}, 4));
    }

    //数组堆化需要学习！！！！！！！！
    private void heapify(int[] h) {
        // 倒着遍历，从而保证 i 的左右子树一定是堆，那么 sink(h, i) 就可以把左右子树合并成一个堆
        // 下标 >= h.length / 2 的元素是二叉树的叶子，无需下沉
        for (int i = h.length / 2 - 1; i >= 0; i--) {
            sink(h, i);
        }
    }

    // 把 h[i] 不断下沉，每次找左右儿子中最大的交换，直到 i 的左右儿子都 <= h[i] 时停止
    private void sink(int[] h, int i) {
        int n = h.length;
        while (2 * i + 1 < n) {
            int j = 2 * i + 1; // i 的左儿子
            if (j + 1 < n && h[j + 1] > h[j]) { // i 的右儿子比 i 的左儿子大
                j++;
            }
            if (h[j] <= h[i]) { // 说明 i 的左右儿子都 <= h[i]，停止下沉
                break;
            }
            swap(h, i, j); // 下沉
            i = j;
        }
    }

    // 交换 h[i] 和 h[j]
    private void swap(int[] h, int i, int j) {
        int tmp = h[i];
        h[i] = h[j];
        h[j] = tmp;
    }

//    作者：灵茶山艾府
//    链接：https://leetcode.cn/problems/take-gifts-from-the-richest-pile/solutions/2501655/yuan-di-dui-hua-o1-kong-jian-fu-ti-dan-p-fzdh/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
