package stack;

import java.util.Stack;

public class RemoveInvalidParentheses {
    public String minRemoveToMakeValid(String s) {
        Stack<StringBuilder> stack = new Stack<>();
        stack.push(new StringBuilder());
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(new StringBuilder("("));
            }else if (c == ')'){
                StringBuilder pop = stack.pop();
                if (!pop.isEmpty() && pop.charAt(0) == '(') {
                    pop.append(")");
                    String temp = pop.toString();
                    stack.push(stack.pop().append(temp));
                }else {
                    stack.push(pop);
                }
            }else{
                stack.peek().append(c);
            }
        }
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            if (!stack.peek().isEmpty() && stack.peek().charAt(0) == '(') {
                res.append(stack.pop().deleteCharAt(0));
                continue;
            }
            res.append(stack.pop());
        }
        return res.toString();
    }


    public String correct(String s) {
        int n = s.length();
        // 标记哪些位置的括号需要被删除
        boolean[] remain = new boolean[n];
        // 栈里只存 '(' 的下标
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i); // 记录左括号的位置
            } else if (c == ')') {
                if (!stack.isEmpty()) {
                    stack.pop(); // 成功匹配，弹出一个左括号
                } else {
                    remain[i] = true; // 无法匹配的右括号，标记删除
                }
            }
        }

        // 遍历完了，栈里剩下的左括号都是多余的
        while (!stack.isEmpty()) {
            remain[stack.pop()] = true; // 标记删除
        }

        // 根据标记重新重构字符串
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (!remain[i]) {
                res.append(s.charAt(i));
            }
        }

        return res.toString();
    }

    public static void main(String[] args) {
        RemoveInvalidParentheses r = new RemoveInvalidParentheses();
        System.out.println(r.minRemoveToMakeValid("())()((("));
    }

    /*
    问题：
        我的方法问题：无法处理纯括号以及括号前无字符串的情况，无法完全清理右括号
    优化方法：
        不影响栈的思维，标记需要处理的字符串，栈处理后统一处理，化简步骤
     */
}
