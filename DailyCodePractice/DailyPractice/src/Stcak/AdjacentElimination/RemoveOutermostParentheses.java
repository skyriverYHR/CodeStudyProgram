package Stcak.AdjacentElimination;

import java.util.Stack;

public class RemoveOutermostParentheses {

    public String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!stack.isEmpty() && c == ')') {
                if (stack.peek() == '(') {
                    stack.pop();
                }
            }else {
                stack.push(c);
            }
        }
        return sb.toString();
    }//问题:处理不好删除除外括号的过程和把括号内在处理中组成字符串

    public String correct(String s) {
        StringBuilder ans = new StringBuilder();
        int opened = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                // 如果在加 1 之前 opened > 0，说明这不是最外层的左括号
                if (opened > 0) {
                    ans.append(ch);
                }
                opened++;
            } else {
                opened--;
                // 如果减 1 之后 opened > 0，说明这不是最外层的右括号
                if (opened > 0) {
                    ans.append(ch);
                }
            }
        }

        return ans.toString();
    }//

    /*
    总结：
        我直接用栈处理时，进出栈只能处理顶上的字符，出栈是从内部括号到外部括号，难以拼接成字符串。
     */


}
