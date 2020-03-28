package java_0328;

public class MyQueueByArray {
    private int[] array = new int[100];
    // [head, tail) 有效元素范围, tail 也有可能在 head 之前
    private int head = 0;
    private int tail = 0;
    private int size = 0; // 元素个数

    public void offer(int val) {
        if (size == array.length) {
            // 队列满了,无法继续插入
            return;
        }
        // 这个操作得保证下标不能越界
        array[tail] = val;
        tail++;
        // tail++ 之后如果超出数组长度了,就从头部开始
        if (tail >= array.length) {
            tail = 0;
        }
        size++;
    }

    public Integer poll() {
        if (size == 0) {
            return null;
        }
        Integer ret = array[head];
        head++;
        if (head >= array.length) {
            head = 0;
        }
        size--;
        return ret;
    }

    public Integer peek() {
        if (size == 0) {
            return null;
        }
        return array[head];
    }
}
