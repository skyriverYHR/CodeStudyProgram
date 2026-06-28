package singleCompele._508;

import java.util.*;

public class FilterBusyIntervals {
    public List<List<Integer>> filterOccupiedIntervals(int[][] occupiedIntervals, int freeStart, int freeEnd) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<Integer[]> stack = new LinkedList<>();
        int [][] s = new int[occupiedIntervals.length + 1][occupiedIntervals[0].length];
        for (int i = 0; i < occupiedIntervals.length; i++) {
            s[i][0] = occupiedIntervals[i][0];
            s[i][1] = occupiedIntervals[i][1];
        }
        s[occupiedIntervals.length][0] = freeStart;
        s[occupiedIntervals.length][1] = freeEnd;
        Arrays.sort(s,(a,b)->Integer.compare(a[0], b[0]));
        for (int i = 0; i < s.length; i++) {
            if (stack.isEmpty() || stack.peek()[1] + 1 < s[i][0]) {
                Integer[] temp = new Integer[2];
                temp[0] = s[i][0];
                temp[1] = s[i][1];
                stack.add(temp);
            }else {
                stack.peek()[1] = s[i][1];
            }
        }
        while (!stack.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            List<Integer> temp1 = new ArrayList<>();
            int first = stack.peek()[0];
            int last = stack.peek()[1];
            if (first == freeStart && last == freeEnd) {
                if (freeStart == freeEnd) {
                    stack.poll();
                }
                continue;
            }else if (first == freeStart && last > freeEnd) {
                first = freeEnd + 1;
            }else if (last == freeEnd && first < freeStart) {
                last = freeStart - 1;
            }else if (first < freeStart && last > freeEnd) {
                int last1 = last;
                last = freeStart - 1;
                int first1 = freeEnd + 1;
                temp1.add(first1);
                temp1.add(last1);
            }
            temp.add(first);
            temp.add(last);
            result.add(temp);
            if (!temp1.isEmpty()){
                result.add(temp1);
            }
            stack.poll();
        }
        return result;
    }

    public static void main(String[] args) {
        FilterBusyIntervals f = new FilterBusyIntervals();
        System.out.println(f.filterOccupiedIntervals(new int[][]{{1,1},{2,2}},100,100));
    }

    //分类问题，问题复杂化了。在区间处理上需要的情况考虑的分组不够明确导致处理复杂了， 3情况：1.freeStart 在区间中 -> 1.freeEnd也在2.freeEnd不在  2. freeStart和freeEnd被包裹区间 4.
    //1186 简单版。
}
