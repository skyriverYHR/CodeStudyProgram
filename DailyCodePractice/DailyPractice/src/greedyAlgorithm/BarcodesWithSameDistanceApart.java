package greedyAlgorithm;

import java.util.*;

public class BarcodesWithSameDistanceApart {
    /*
    思路和上一题，无相邻的相同字符串类似
     */
    public int[] rearrangeBarcodes(int[] barcodes) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < barcodes.length; i++) {
            map.merge(barcodes[i], 1, Integer::sum);
        }
        PriorityQueue<Integer[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (Integer key : map.keySet()) {
            pq.add(new Integer[]{key, map.get(key)});
        }
        ArrayList<Integer> result = new ArrayList<>();
        while (!pq.isEmpty()) {
            Integer[] arr = pq.poll();
            Integer[] arr2 = pq.poll();
            if (!result.isEmpty() && !Objects.equals(result.getLast(), arr[0])) {
                result.add(arr[0]);
                arr[1]--;
            }else if (!result.isEmpty() && Objects.equals(result.getLast(), arr[0])) {
                if (arr2 != null) {
                    result.add(arr2[0]);
                    arr2[1]--;
                }
            }else {
                result.add(arr[0]);
                arr[1]--;
            }
            if (arr[1] != 0){
                pq.add(arr);
            }
            if (arr2 != null && arr2[1] != 0){
                pq.add(arr2);
            }
        }
        return result.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        BarcodesWithSameDistanceApart bsa = new BarcodesWithSameDistanceApart();
        int[] barcodes = bsa.rearrangeBarcodes(new int[]{1,1,1,1,2,2,3,3});
        System.out.println(Arrays.toString(barcodes));
    }
}
