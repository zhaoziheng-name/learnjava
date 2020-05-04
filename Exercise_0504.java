package java_0504;

import java.util.Stack;

public class Exercise_0504 {
    public boolean IsPopOrder(int[] pushA, int[] popA) {
        if (pushA == null || popA == null || pushA.length != popA.length) {
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        int j = 0;
        stack.push(pushA[i++]);
        while (j <= popA.length - 1) {
            while (popA[j] != stack.peek()) {
                if (i == pushA.length) {
                    return false;
                }
                stack.push(pushA[i++]);
            }
            j++;
            stack.pop();
        }
        return true;
    }

    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        for (String op : ops) {
            if (op.equals("+")) {
                int top = stack.pop();
                int newTop = top + stack.peek();
                stack.push(top);
                stack.push(newTop);
            } else if (op.equals("C")) {
                stack.pop();
            } else if (op.equals("D")) {
                stack.push(2 * stack.peek());
            } else {
                stack.push(Integer.valueOf(op));
            }
        }
        int ans = 0;
        for (int score : stack) {
            ans += score;
        }
        return ans;
    }

    public boolean backspaceCompare(String S, String T) {
        return build(S).equals(build(T));
    }

    public String build(String S) {
        Stack<Character> stack = new Stack<>();
        for (char c : S.toCharArray()) {
            if (c != '#') {
                stack.push(c);
            } else if (!stack.isEmpty()) {
                stack.pop();
            }
        }
        return String.valueOf(stack);
    }
}
