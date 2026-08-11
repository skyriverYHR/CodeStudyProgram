package heap;

import java.util.PriorityQueue;

public class KthSmallestElementInASortedMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        int length = matrix.length;
        int a = k%length;
        int b = k/length;
        if (b > 1){
            return matrix[b][a-1];
        }else {
            return matrix[0][a-1];
        }//第一行的第二个元素不会必然小于第一行的第一个元素（类似）-----题目理解问题，没有思路


    }

    public int kthSmallestSolution(int[][] matrix, int k) {
        int n = matrix.length;
        // 最小堆，按值排序
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        // 将每一行的第一个元素入堆
        for (int i = 0; i < n; i++) {
            pq.offer(new int[]{matrix[i][0], i, 0});//第一个元素排序
        }

        // 弹出 k-1 次，第 k 次弹出的就是答案
        for (int i = 0; i < k - 1; i++) {
            int[] cur = pq.poll();
            int row = cur[1];
            int col = cur[2];
            if (col + 1 < n) {
                pq.offer(new int[]{matrix[row][col + 1], row, col + 1});
            }
        }
        return pq.poll()[0];
    }
    /*
    起始：
    1   5   9
    10  11  13
    12  13  15

    第一次：
    入堆：（升序）
    1 10 12
    去掉最小的：
    10  12
    加入第一排第二大的：
    5   10  12

    第二次``````
     */

    public static void main(String[] args) {
        KthSmallestElementInASortedMatrix q = new KthSmallestElementInASortedMatrix();
        System.out.println(q.kthSmallest(new int[][]{{1,5,9},{10,11,13},{12,13,15}},1));
    }
}
