package java_0329;

import java.util.LinkedList;
import java.util.Queue;

public class MyStackBy2Queue {
    private Queue<Integer> A = new LinkedList<>();
    private Queue<Integer> B = new LinkedList<>();

    public void push(int x) {
        // x 往 A 中入队列即可
        A.offer(x);
    }

    public Integer pop() {
        if (empty()) {
            return null;
        }
        while (A.size() > 1) {
            Integer front = A.poll();
            B.offer(front);
        }
        // 当循环结束后, A 中只剩一个元素
        // 这个元素就是要被出栈的元素
        int ret = A.poll();
        // 交换 A 和 B 的身份
        swapAB();
        return ret;
    }

    private void swapAB() {
        Queue<Integer> tmp = A;
        A = B;
        B = tmp;
    }

    public Integer top() {
        if (empty()) {
            return null;
        }
        while (A.size() > 1) {
            Integer front = A.poll();
            B.offer(front);
        }
        // 当循环结束后, A 中只剩一个元素
        // 这个元素就是栈顶的元素
        int ret = A.poll();
        B.offer(ret); // pop 和 top 的唯一区别
        // 交换 A 和 B 的身份
        swapAB();
        return ret;
    }

    public boolean empty() {
        return A.isEmpty() && B.isEmpty();
    }
}
