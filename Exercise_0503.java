package java_0503;

import java.util.Stack;

public class Exercise_0503 {

    public class StockSpanner {
        Stack<Integer> prices, weights;

        public StockSpanner() {
            prices = new Stack<>();
            weights = new Stack<>();
        }

        public int next(int price) {
            int w = 1;
            while (!prices.isEmpty() && prices.peek() <= price) {
                prices.pop();
                w += weights.pop();
            }
            prices.push(price);
            weights.push(w);
            return w;
        }
    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> numStack = new Stack<>();
        Integer op1, op2;
        for (String s : tokens) {
            switch (s) {
                case "+":
                    op2 = numStack.pop();
                    op1 = numStack.pop();
                    numStack.push(op1 + op2);
                    break;
                case "-":
                    op2 = numStack.pop();
                    op1 = numStack.pop();
                    numStack.push(op1 - op2);
                    break;
                case "*":
                    op2 = numStack.pop();
                    op1 = numStack.pop();
                    numStack.push(op1 * op2);
                    break;
                case "/":
                    op2 = numStack.pop();
                    op1 = numStack.pop();
                    numStack.push(op1 / op2);
                    break;
                default:
                    numStack.push(Integer.valueOf(s));
                    break;
            }
        }
        return numStack.pop();
    }
}
