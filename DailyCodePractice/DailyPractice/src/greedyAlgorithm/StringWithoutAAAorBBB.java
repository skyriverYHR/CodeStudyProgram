package greedyAlgorithm;

public class StringWithoutAAAorBBB {
    //代码不知道怎么写，写一下思路把
    /*
    因为不能出现三个连着的一摸一样的字母，所以可以把a和b分成aa a 和 bb b 两种字符串；
    然后怎么分配aa a 和bb b 没有思路。
     */



    /*
    看完题解：
    只要任意的符合要求的字符串，就需要在有限的长度内尽可能消耗多的字母就有三种情况；
    a多每次两a一b（b同理）
    a=b 交替进行
     */
    public String strWithout3a3b(int a, int b) {
        String str = "";
        int bn = 0;
        int an = 0;
        while (b != 0 || a != 0) {
            if (a > b) {
                if (an == 2){
                    str = str + "b";
                    bn = 1;
                    an = 0;
                    b--;
                }else {
                    str = str + "a";
                    an++;
                    a--;
                }
            }else if (b > a) {
                if (bn == 2){
                    str = str + "a";
                    bn = 0;
                    an = 1;
                    a--;
                }else {
                    str = str + "b";
                    bn++;
                    b--;
                }
            }else if (b == a) {
                String str1 = "ab";
                if (an == 2){
                    str1 = "ba";
                    an = 0;
                }
                str = str + str1;
                a--;
                b--;
            }
        }
        return str;
    }
    public static void main(String[] args) {
        StringWithoutAAAorBBB s = new StringWithoutAAAorBBB();
        System.out.println(s.strWithout3a3b(4, 1));
    }
}
