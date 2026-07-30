package heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class TheSmallestUnoccupiedChairNumber {
    public int smallestChair(int[][] times, int targetFriend) {
        PriorityQueue<Integer[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        PriorityQueue<Integer[]> pq2 = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        int r = times[targetFriend][0];
        for (int i = 0; i < times.length; i++) {
            if (times[i][0] > r) {
                 continue;
            }
            pq.add(new Integer[]{i, times[i][0]});
            pq2.add(new Integer[]{i, times[i][1]});
        }

        for (int i = 0; i < r; i++) {
//        没路了这里，问题在于怎么处理座位的问题。
        }
        return 0;
    }


    //题解
    public int smallestChairSolution(int[][] times, int targetFriend) {
        int n = times.length;
        // 1. 绑定原始索引，按到达时间排序
        int[][] friends = new int[n][3]; // {arrival, leaving, index}
        for (int i = 0; i < n; i++) {
            friends[i][0] = times[i][0];
            friends[i][1] = times[i][1];
            friends[i][2] = i;
        }
        Arrays.sort(friends, (a, b) -> a[0] - b[0]); // 按到达升序

        // 2. 空闲椅子堆，初始 0 ~ n-1
        PriorityQueue<Integer> available = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            available.offer(i);
        }

        // 3. 占用椅子堆，按离开时间排序 (离开时间, 椅子编号)
        PriorityQueue<int[]> occupied = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        for (int[] f : friends) {
            int arrival = f[0], leaving = f[1], idx = f[2];

            // 释放所有离开时间 <= 当前到达时间的椅子
            while (!occupied.isEmpty() && occupied.peek()[0] <= arrival) {
                int chair = occupied.poll()[1];
                available.offer(chair);
            }

            // 分配最小的空闲椅子
            int chair = available.poll();

            // 如果是目标朋友，直接返回
            if (idx == targetFriend) {
                return chair;
            }

            // 当前朋友占用椅子，加入 occupied 堆
            occupied.offer(new int[]{leaving, chair});
        }

        return -1; // 根据题目，不会执行到这里
    }
}
