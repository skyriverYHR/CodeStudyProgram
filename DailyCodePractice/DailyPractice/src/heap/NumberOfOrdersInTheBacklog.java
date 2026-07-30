package heap;

import java.util.PriorityQueue;

public class NumberOfOrdersInTheBacklog {
    public int getNumberOfBacklogOrders(int[][] orders) {
        int N = 1000000000 + 7;
        PriorityQueue<Integer> buy = new PriorityQueue<>((a, b) -> b - a);
        PriorityQueue<Integer> sell = new PriorityQueue<>((a, b) -> a - b);
        for (int[] order : orders) {
            int type = order[2];
            int num = order[1];
            int price = order[0];

            if (type == 0) {
                while (!sell.isEmpty() && sell.peek() <= price && num > 0) {
                    sell.poll();
                    num--;
                }
                while (num > 0) {
                    buy.add(price);
                    num--;
                }
            }
            else if (type == 1) {
                while (!buy.isEmpty() && buy.peek() >= price && num > 0) {
                    buy.poll();
                    num--;
                }
                while (num > 0) {
                    sell.add(price);
                    num--;
                }
            }
        }

        int count = (buy.size() + sell.size())%N;
        return count;
    }
    //问题每笔都存入，用循环存入剩余的货物时间过慢，且占用过多空间，可以用数组存储数量和价格优化
    public static void main(String[] args) {
        NumberOfOrdersInTheBacklog ob = new NumberOfOrdersInTheBacklog();
        System.out.println(ob.getNumberOfBacklogOrders(new int[][]{{10,5,0},{15,2,1},{25,1,1},{30,4,0}}));
    }
}
