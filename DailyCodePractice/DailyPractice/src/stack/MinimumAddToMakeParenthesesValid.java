package stack;

import java.util.Stack;

public class MinimumAddToMakeParenthesesValid {

    public int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!stack.isEmpty() && (stack.peek() == '(' && c == ')')) {
                stack.pop();
            }else {
                stack.push(c);
            }
        }
        return stack.size();
    }//可以优化
}
