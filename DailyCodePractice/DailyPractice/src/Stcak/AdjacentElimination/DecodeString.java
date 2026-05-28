package Stcak.AdjacentElimination;

import java.util.Stack;

public class DecodeString {
    public String decodeString(String s) {
        Stack<Integer> stack = new Stack<>();
        Stack<StringBuilder> stack1 = new Stack<>();
        stack1.push(new StringBuilder());
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '[') {
                stack1.push(new StringBuilder());
            }else if (c == ']') {

            }else if (c >= 'a' && c <= 'z') {
                stack1.peek().append(c);
            }else {

            }
        }
        return "";
    }//不理解题目

    /**
     * 递归处理
     * @param s 处理变量
     * @return 处理后的结果
     */
    public String decodeString_1(String s) {
        if (s.isEmpty()) {
            return s;
        }

        // s[0] 是字母
        if (Character.isLetter(s.charAt(0))) {
            // 分离出 s[0]，解码剩下的
            return s.charAt(0) + decodeString(s.substring(1));
        }

        // s[0] 是数字，后面至少有一对括号
        int i = s.indexOf('['); // 找左括号
        int balance = 1; // 左括号个数减去右括号个数
        for (int j = i + 1; ; j++) {
            char c = s.charAt(j);
            if (c == '[') {
                balance++;
            } else if (c == ']') {
                balance--;
                if (balance == 0) { // 找到与 s[i] 匹配的右括号 s[j]
                    int k = Integer.parseInt(s.substring(0, i));
                    String t = decodeString(s.substring(i + 1, j));
                    return new StringBuilder()
                            .repeat(t, k)
                            .append(decodeString(s.substring(j + 1)))
                            .toString();
                }
            }
        }
    }

    /**
     * 栈模拟递归
     */
    public String decodeString_2(String s) {
        return decode(s.toCharArray());
    }

    private int i = 0;

    private String decode(char[] s) {
        StringBuilder res = new StringBuilder();
        int k = 0;
        while (i < s.length) {
            char c = s[i];
            i++;
            if (Character.isLetter(c)) {
                res.append(c);
            } else if (Character.isDigit(c)) {
                k = k * 10 + (c - '0');//用来处理多位数（123【a】）
            } else if (c == '[') { // '[' 递
                String t = decode(s);
                res.repeat(t, k); // 把括号内的字符串重复 k 次
                k = 0; // 重置 k，若不重置，2[a]3[b] 后面的 3 会算出 k = 23
            } else { // ']' 归
                break;
            }
        }
        return res.toString();
    }

    /*
    为什么做不出来？
        - 思维停留在匹配括号上，进一步怎么匹配括号，怎么处理匹配括号之间的过程问题很大。
        - 数字是重复次数，括号区分层级，字符串是需要用前两项处理的结果
     */

}
