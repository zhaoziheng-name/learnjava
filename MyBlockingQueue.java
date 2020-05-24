package java_0524;

// 阻塞式队列:
// 1. 基于数组的循环队列来实现
// 2. 提供一个队列,取元素的时候,如果队列为空,就进行阻塞等待
//    入队列的时候,如果队列满了,阻塞等待

public class MyBlockingQueue<T> {

    private Object[] table;
    // 取元素时的索引
    private int takeIndex;
    // 存元素时的索引
    private int putIndex;
    // 保存的元素大小
    private int size;

    public MyBlockingQueue(int capacity) {
        table = new Object[capacity];
    }

    public synchronized void put(T element) throws InterruptedException {
        while (size == table.length) {
            wait();
        }
        table[putIndex] = element; // 存放元素
        putIndex = (putIndex + 1) % table.length;
        size++;
        notifyAll();
    }

    public synchronized T take() throws InterruptedException {
        while (size == 0) {
            wait();
        }
        Object element  = table[takeIndex]; // 取元素
        takeIndex = (takeIndex + 1) % table.length;
        size--;
        notifyAll();
        return (T) element;
    }

    public synchronized int size() {
        return size;
    }

    // 模拟使用自定义阻塞队列
//    public static void main(String[] args) {
//        MyBlockingQueue queue = new MyBlockingQueue(capacity);
//        for (int i = 0; i < 5; i++) {
//            new Thread(() -> {
//                // 模拟生产面包
//                queue.put(面包);
//            }).start();
//        }
//        for (int i = 0; i < 20; i++) {
//            new Thread(() -> {
//                // 模拟购买面包
//                queue.take(面包);
//            }).start();
//        }
//    }
}
