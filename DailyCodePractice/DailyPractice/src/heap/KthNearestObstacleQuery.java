package heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KthNearestObstacleQuery {
    public int[] resultsArray(int[][] queries, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a,b)->b-a);
        int[] result = new int[queries.length];
        Arrays.fill(result, -1);
        for (int i = 0; i < queries.length; i++) {
            int distance = Math.abs(queries[i][0]) + Math.abs(queries[i][1]);
            minHeap.add(distance);
            while (minHeap.size() > k) {
                minHeap.poll();
            }
            if (minHeap.size() == k) {
                result[i] = minHeap.peek();
            }
        }
        return result;
    }

    public static void main(String[] args) {
        KthNearestObstacleQuery obj = new KthNearestObstacleQuery();
        System.out.println(Arrays.toString(obj.resultsArray(new int[][]{{1,2},{3,4},{2,3},{-3,0}},2)));
    }
}
