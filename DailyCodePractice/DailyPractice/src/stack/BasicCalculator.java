package stack;

import java.util.Stack;

public class BasicCalculator {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        Stack<Character> stackC = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                if (!stackC.isEmpty()) {
                    if (stackC.peek() == '(') {
                        stack.push(c - '0');
                        stackC.pop();
                    }else if (stackC.peek() == '*') {
                        stack.push(stack.pop()*(c - '0'));
                    }else if (stackC.peek() == '/') {
                        stack.push(stack.pop()/(c - '0'));
                    }
                }else {
                    stack.push(c - '0');
                }
            }else {
                stackC.push(c);
            }
        }
        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }
        return sum;
    }

    //思路对的，没成功实现：通过两个栈控制操作数和运算符号，中间运算逻辑不对
}
