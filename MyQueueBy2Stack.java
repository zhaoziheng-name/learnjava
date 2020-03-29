package java_0329;

import java.util.Stack;

public class MyQueueBy2Stack {
    private Stack<Integer> A = new Stack<>();
    private Stack<Integer> B = new Stack<>();

    public void push(int x) {
        // 先把 B 中的所有元素给到 A 中,再直接入栈即可
        while (!B.isEmpty()) {
            int tmp = B.pop();
            A.push(tmp);
        }
        A.push(x);
    }

    public Integer pop() {
        // 如果为空就直接返回
        if (empty()) {
            return null;
        }
        // 把 A 中的元素都给到 B
        while (!A.empty()) {
            int tmp = A.pop();
            B.push(tmp);
        }
        // 针对 B 进行出栈
        return B.pop();
    }

    public Integer peek() {
        // 如果为空就直接返回
        if (empty()) {
            return null;
        }
        // 把 A 中的元素都给到 B 中
        while (!A.empty()) {
            int tmp = A.pop();
            B.push(tmp);
        }
        // 直接取出栈顶元素
        return B.peek();
    }

    public boolean empty() {
        return A.isEmpty() && B.isEmpty();
    }
}
