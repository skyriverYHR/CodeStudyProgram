package Stcak.AdjacentElimination;

import java.util.Stack;

public class ClumsyFactorial {
    public int clumsy(int n) {
        Stack<Integer> stack = new Stack<Integer>();
        int index = 0;
        stack.push(n);
        for (int i = n - 1; i > 0; i--) {
            index = index % 4;
            if (index == 0){
                stack.push(stack.pop()*i);
            }else if (index == 1){
                stack.push(stack.pop()/i);
            }else if (index == 2){
                stack.push(i);
            }else if (index == 3){
                stack.push(-i);
            }
            index++;
        }
        int sum = 0;
        while (!stack.isEmpty()){
            sum += stack.pop();
        }
        return sum;
    }

    public static void main(String[] args) {
        ClumsyFactorial clumsyFactorial = new ClumsyFactorial();
        System.out.println(clumsyFactorial.clumsy(10));
    }

    //正确
}
