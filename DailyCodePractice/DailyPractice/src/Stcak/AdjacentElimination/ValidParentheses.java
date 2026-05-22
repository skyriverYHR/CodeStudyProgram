package Stcak.AdjacentElimination;

import java.util.*;

public class ValidParentheses {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!stack.isEmpty()){
                if (stack.peek() == '(' && c == ')') {
                    stack.pop();
                }else if (stack.peek() == '{' && c == '}') {
                    stack.pop();
                }else if (stack.peek() == '[' && c == ']') {
                    stack.pop();
                }else {
                    stack.push(c);
                }
            }else {
                stack.push(c);
            }
        }
        if (stack.isEmpty()){
            return true;
        }
        return false;
    }

    public boolean correct(String s) {
        if (s.length() % 2 != 0) { // s 长度必须是偶数
            return false;
        }
        Map<Character, Character> mp = new HashMap<>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};
        Deque<Character> st = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (!mp.containsKey(c)) { // c 是左括号
                st.push(c); // 入栈
            } else if (st.isEmpty() || st.pop() != mp.get(c)) { // c 是右括号
                return false; // 没有左括号，或者左括号类型不对
            }
        }
        return st.isEmpty(); // 所有左括号必须匹配完毕
    }//灵茶山艾府题解

    public static void main(String[] args) {
        String s = "({[)";
        ValidParentheses v = new ValidParentheses();
        System.out.println(v.isValid(s));
    }

    /*
    总结：
        为什么下面的代码快：核心匹配当第一次出现右括号时，栈上一个一定是一个左括号和它匹配，然后移除 -> 循环这个过程
     */
}
