package greedyAlgorithm;

import java.util.PriorityQueue;

public class ReorganizeString {
    /*
    思路:
        首先：目标是每一个字符相邻的字符不重复
        所以我根据上一题“AAA”"BBB"不出现的思路去向，可以先放次数最多的和第二多的交替进行，字数平均时，放入最多的即可。
        1.首先我用数组统计每一个字符出现次数
        2.把【0】存放次数，【1】存放索引，降序排列，确保次数最多的在前
        3.根据前一个字符判断最大的字符是否可以填入
            （1）可以-直接填入次数减一
            （2）不行-用第二大的字符
                -   第二大字符可能为空， 此时只能填入第一个，无法满足条件


         用的贪心的思维；
     */
    public String reorganizeString(String s) {
        int[] times = new int[26];
        for (int i = 0; i < s.length(); i++) {
            times[s.charAt(i) - 'a']++;
        }
        PriorityQueue<Integer[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for (int i = 0; i < times.length; i++) {
            if (times[i] > 0) {
                pq.add(new Integer[]{times[i], i});
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            Integer[] temp1 = pq.poll();
            Integer[] temp2 = pq.poll();
            if (!sb.isEmpty() && temp1[1] + 'a' != sb.charAt(sb.length() - 1)) {
                char add = (char)(temp1[1] + 'a');
                sb.append(add);
                temp1[0] --;
            }else if (!sb.isEmpty() && temp1[1] + 'a' == sb.charAt(sb.length() - 1)) {
                if (temp2 != null) {
                    char add = (char)(temp2[1] + 'a');
                    sb.append(add);
                }else {
                    return "";
                }
                temp2[0] --;
            } else {
                char add = (char)(temp1[1] + 'a');
                sb.append(add);
                temp1[0] --;
            }
            if (temp1[0] != 0){
                pq.add(temp1);
            }
            if (temp2 != null && temp2[0] != 0){
                pq.add(temp2);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        ReorganizeString rs = new ReorganizeString();
        System.out.println(rs.reorganizeString("vvvlo"));
    }
}
