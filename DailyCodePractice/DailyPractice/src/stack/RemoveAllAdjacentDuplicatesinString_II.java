package stack;

import java.util.Stack;

public class RemoveAllAdjacentDuplicatesinString_II {
    private static RemoveAllAdjacentDuplicatesinString_II rs = new RemoveAllAdjacentDuplicatesinString_II();

    public String removeDuplicates(String s, int k) {
        Stack<Integer> stack = new Stack<>();
        Stack<Character> stackString = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!stackString.isEmpty() && c == stackString.peek()){
                stackString.push(c);
                int top = stack.pop();
                top++;
                if (top == k){
//                    stack.push(0); 导致记数错误，原来的连续数的次数存储在下面，压入0会导致在继续连续时取出0而不是之前的计数
                    while (top != 0){
                        stackString.pop();
                        top--;
                    }
                }
                else {
                    stack.push(top);
                } ;
            }else {
                stackString.push(c);
                stack.push(1);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stackString.empty()){
            sb.append(stackString.pop());
        }
        return sb.reverse().toString();
    }


    public String correct(String s, int k) {
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (!sb.isEmpty() && s.charAt(i) == sb.charAt(sb.length() - 1)) {
                sb.append(s.charAt(i));
                int top = stack.pop() + 1;
                if (top == k){
                    sb.delete(sb.length() - k, sb.length());
                }
                else {
                    stack.push(top);
                }
            }else {
                sb.append(s.charAt(i));
                stack.push(1);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "ddbbbdab";
        System.out.println(rs.correct(s,3));
    }

    /*
    总结:
        问题:1.对栈的先进先出的思维不够熟悉
            2.对栈处理邻项消除不够熟悉，容易出现不知道什么时候进出栈
        反思:进出栈需要根据题目条件
     */
}
