package greedyAlgorithm;

import java.util.PriorityQueue;

public class LongestHappyString {
    /*
    和上一题一样，运用贪心思维先放数量最大的，相同就交替
     */
    public String longestDiverseString(int a, int b, int c) {
        StringBuilder sb = new StringBuilder();
        int[] arr = new int[3];
        arr[0] = a;
        arr[1] = b;
        arr[2] = c;
        PriorityQueue<Integer[]> pq = new PriorityQueue<>((d,e)->(e[1] - d[1]));
        for (int i = 0; i < 3; i++) {
            pq.add(new Integer[]{i, arr[i]});
        }
        while (!pq.isEmpty()) {
            Integer[] temp1 = pq.poll();
            Integer[] temp2 = pq.poll();
            char temp = (char)(temp1[0] + 'a');
            if (!sb.isEmpty() && temp != sb.charAt(sb.length() - 1)) {
                sb.append(temp);
                temp1[1]--;
            }else if (!sb.isEmpty() && temp == sb.charAt(sb.length() - 1)) {
                if (temp2 == null){
                    return sb.substring(0, sb.length() - 1);
                }
                temp = (char)(temp2[1] + 'a');
                sb.append(temp);
            }else if (sb.isEmpty()){
                sb.append(temp);
                temp1[1]--;
            }
        }
        return sb.toString();
    }
}
