package Stcak.AdjacentElimination;

import java.util.Stack;

public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();
        int num1;
        int num2;
        for (String token : tokens) {
            if (token.equals("+")) {
                stack.push(stack.pop() + stack.pop());
            }else if (token.equals("-")) {
                num1 = stack.pop();
                num2 = stack.pop();
                stack.push(num2 - num1);
            }else if (token.equals("*")) {
                stack.push(stack.pop() * stack.pop());
            }else if (token.equals("/")) {
                num1 = stack.pop();
                num2 = stack.pop();
                stack.push(num2 / num1);
            }else{
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        EvaluateReversePolishNotation eval = new EvaluateReversePolishNotation();
        System.out.println(eval.evalRPN(new String[]{"4","13","5","/","+"}));
    }
}
