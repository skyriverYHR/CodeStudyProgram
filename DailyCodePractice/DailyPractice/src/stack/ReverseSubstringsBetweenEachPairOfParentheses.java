package stack;

import java.util.Stack;

public class ReverseSubstringsBetweenEachPairOfParentheses {

    public String reverseParentheses(String s) {
        Stack<StringBuilder> stack = new Stack<>();
        StringBuilder result = new StringBuilder();
        stack.push(result);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(new StringBuilder());
            }else if (s.charAt(i) == ')') {
                String ans = stack.pop().reverse().toString();
                stack.peek().append(ans);
            }else {
                stack.peek().append(s.charAt(i));
            }
        }
        return stack.peek().toString();
    }

    public static void main(String[] args) {
        ReverseSubstringsBetweenEachPairOfParentheses reverse = new ReverseSubstringsBetweenEachPairOfParentheses();
        System.out.println(reverse.reverseParentheses("a(bcdefghijkl(mno)p)q"));
    }

    /*
    两次通过
    问题：
        第一次没有考虑到括号外字符的情况如：("asd(daw)ad(das(eaf)da)");
        处理：先压入一个StringBuilder，不仅可以处理最后字符拼接问题，还可以处理外部字符串。
     */
}
