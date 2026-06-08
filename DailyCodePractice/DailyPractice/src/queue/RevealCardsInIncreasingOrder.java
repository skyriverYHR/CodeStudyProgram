package queue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class RevealCardsInIncreasingOrder {

    //思路: 逆推，从结果退回去，但是想不出过程方法怎么操作

    //看完解析后写的
    public int[] deckRevealedIncreasing(int[] deck) {
        LinkedList<Integer> queue = new LinkedList<>();
        Arrays.sort(deck);
        for (int i = deck.length - 1; i >= 0; i--) {
            if (!queue.isEmpty()) {
                // 倒带操作：先把队尾的牌挪回到队头
                queue.addFirst(queue.pollLast());
            }
            // 再把当前较小的牌放到队头
            queue.addFirst(deck[i]);
        }
        int[] res = new int[queue.size()];
        for (int i = 0; i < queue.size(); i++) {
            res[i] = queue.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        RevealCardsInIncreasingOrder r = new RevealCardsInIncreasingOrder();
        int[] a = new int[]{17,13,11,2,3,5,7};
        System.out.println(Arrays.toString(r.deckRevealedIncreasing(a)));
    }
}
