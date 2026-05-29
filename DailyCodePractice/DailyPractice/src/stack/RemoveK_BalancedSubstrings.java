package stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class RemoveK_BalancedSubstrings {
    private static RemoveK_BalancedSubstrings re = new RemoveK_BalancedSubstrings();

    public String removeSubstring(String s, int k) {
        Stack<Integer> left = new Stack<>();
        Stack<Integer> right = new Stack<>();
        StringBuilder sb = new StringBuilder();
        left.push(0);
        right.push(0);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (sb.isEmpty()){
                sb.append(c);
                if (c == '('){
                    left.push(left.pop() + 1);
                }else if (c == ')'){
                    right.push(right.pop() + 1);
                }
            } else if (c == '(' && sb.charAt(sb.length() - 1) == '(') {
                left.push(left.pop() + 1);
                sb.append(c);
            }else if (c == '(' && sb.charAt(sb.length() - 1) == ')') {
                left.push(1);
                sb.append(c);
            }else if (c == ')' && sb.charAt(sb.length() - 1) == '(') {
                right.push(1);
                sb.append(c);
            }else if (c == ')' && sb.charAt(sb.length() - 1) == ')') {
                right.push(right.pop() + 1);
                sb.append(c);
            }
            if (!right.isEmpty() && right.peek() == k && left.peek() >= k && sb.charAt(sb.length() - 1) == ')') {
                int top = left.pop();
                if (top - k != 0){
                    left.push(top - k);
                }
                sb.delete(sb.length() - 2*right.pop(), sb.length());
            }
        }
        return sb.toString();
    }//整个函数在处理空栈时存在无法抛出的问题？？


    public String correct(String s, int k) {
        List<int[]> st = new ArrayList<>(); // 栈中保存 [字符, 连续出现次数]
        for (char b : s.toCharArray()) {
            if (!st.isEmpty() && st.getLast()[0] == b) {
                st.getLast()[1]++; // 连续相同括号个数 +1
            } else {
                st.add(new int[]{b, 1}); // 新的括号
            }

            // 栈顶的 k 个右括号与栈顶下面的 k 个左括号抵消
            if (b == ')' && st.size() > 1 && st.getLast()[1] == k && st.get(st.size() - 2)[1] >= k) {
                st.removeLast();
                st.getLast()[1] -= k;
                if (st.getLast()[1] == 0) {
                    st.removeLast();
                }
            }
        }

        StringBuilder ans = new StringBuilder();
        for (int[] p : st) {
            ans.repeat(p[0], p[1]);
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println(re.removeSubstring("(()(()(()))((()", 2));
    }

    /*
    总结:
        问题: 对于处理连续的子串条件存在，不知道怎么处理空栈以及消除逻辑
     */
}
