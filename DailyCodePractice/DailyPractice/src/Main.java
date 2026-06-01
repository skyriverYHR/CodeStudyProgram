import java.util.*;

public class Main {
    public int digitFrequencyScore(int n) {
        int[] counts = new int[10];
        while (n > 0) {
            counts[n % 10]++;
            n /= 10;
        }
        int sum = 0;
        for (int i = 0; i < counts.length; i++) {
            sum =sum + counts[i]*i;
        }
        return sum;
    }

    public int[] maximumMEX(int[] nums) {
        int max = 0;
        ArrayList<Integer> list = new ArrayList<Integer>();
        PriorityQueue<Integer[]> maxS = new PriorityQueue<>((a,b)->{
            if(a[0] != b[0]){
                return Integer.compare(b[0], a[0]);
            }
            return Integer.compare(a[1], b[1]);
        });
        for (int i = 0; i < nums.length; i++) {
            maxS.add(new Integer[]{nums[i] + 1,i});
        }
        int index = 0;
        for (Integer[] arr : maxS) {
            if (arr[1] < index) {
                continue;
            }
            index = arr[1];
            list.add(arr[0]);
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        Main main = new Main();
        int[] nums = {0,1,0};
        System.out.println(Arrays.toString(main.maximumMEX(nums)));
    }
}