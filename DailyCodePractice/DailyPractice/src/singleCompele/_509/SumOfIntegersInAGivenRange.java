package singleCompele._509;

public class SumOfIntegersInAGivenRange {
    public int maxDigitRange(int[] nums) {
        int sum = 0;
        int max = 0;
        for (int num : nums) {
            int maxN = Integer.MIN_VALUE;
            int minN = Integer.MAX_VALUE;
            int numN = num;
            while (num > 0) {
                maxN = Math.max(maxN, num % 10);
                minN = Math.min(minN, num % 10);
                num /= 10;
            }
            int temp = maxN - minN;
            if (temp > max) {
                sum = numN;
                max = temp;
            }else if (temp == max) {
                sum += numN;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        SumOfIntegersInAGivenRange obj = new SumOfIntegersInAGivenRange();
        System.out.println(obj.maxDigitRange(new int[]{90,900}));
    }
}
