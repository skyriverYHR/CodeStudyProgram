package singleCompele._505;

public class UmOfCompatibleNumbersWithinARangeI {

    public int sumOfGoodIntegers(int n, int k) {
        int min = Math.max(n - k, 0);
        int max = n + k;
        int sum = 0;
        for (int i = min; i <= max; i++) {
            if ((i & n) == 0){
                sum += i;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        UmOfCompatibleNumbersWithinARangeI um = new UmOfCompatibleNumbersWithinARangeI();
        System.out.println(um.sumOfGoodIntegers(5, 1));
    }
}
