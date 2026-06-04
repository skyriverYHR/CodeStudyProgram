package stack.monotonic_stack;

import java.util.Arrays;
import java.util.Stack;

public class ALineOfCars {
    public int carFleet(int target, int[] position, int[] speed) {
        Stack<Integer[]> stack = new Stack<Integer[]>();
        Integer[][] cars = new Integer[position.length][2];
        for (int i = 0; i < position.length; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }
        Arrays.sort(cars,(a,b)-> Integer.compare(a[0],b[0]));
        for (int i = 0; i < position.length; i++) {
            while (!stack.isEmpty() && stack.peek()[1] > cars[i][1]) {
                int last = stack.peek()[0];
                int cur = cars[i][0];
                int t = (cur - last)/(stack.peek()[1]-cars[i][1]);
                int l = t*cars[i][1];
                if (l > target) {
                    break;
                }
                stack.pop();
            }
            stack.push(cars[i]);
        }
        return stack.size();
    }

    public int correct(int target, int[] position, int[] speed) {
        int n = position.length;
        if (n == 0) return 0;

        // 1. 将车的位置和速度组合
        double[][] cars = new double[n][2];
        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            // 提前算好这辆车【独立到达终点】所需要的时间
            cars[i][1] = (double)(target - position[i]) / speed[i];
        }

        // 2. 按照初始位置【从小到大】排序
        Arrays.sort(cars, (a, b) -> Double.compare(a[0], b[0]));

        int fleets = 0;
        // 3. 从右往左（从离终点最近的车开始）倒序遍历
        // maxTime 记录当前车队（领头车）到达终点所需的最大时间
        double maxTime = 0;

        for (int i = n - 1; i >= 0; i--) {
            // 如果当前车到达终点的时间，比它前面的车队领头车还要长
            if (cars[i][1] > maxTime) {
                // 说明它追不上前面的车队，它自己成为了一个新的车队领头车
                fleets++;
                maxTime = cars[i][1]; // 更新当前阻挡后车的最大时间限制
            }
            // 如果 cars[i][1] <= maxTime，说明它能追上，自动融入前面的车队，不需要任何操作
        }

        return fleets;
    }

    public static void main(String[] args) {
        ALineOfCars al = new ALineOfCars();
        int[] testPosition = new int[]{3};
        int[] testSpeed = new int[]{3};
        System.out.println(al.carFleet(10, testPosition, testSpeed));
    }

    /*
    问题：
        我的代码有两个问题：
            1.除法“/”的精度不行t时间不准会误判
            2.前面的车会使得后面的的车变慢 比如 2 4 1 后面的1，4 会并为速度1 那么第一个2就能追上，但是我直接在处理4的时候把2抛出了
     */
}
