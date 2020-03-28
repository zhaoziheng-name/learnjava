package java_0328;

public class MyQueueByLinkedList {
    // Node 这个类叫做内部类.定义在某个类或者方法中的类
    // static 效果就是创建的 Node 实例不依赖于 MyQueueByLinkedList 这个类的实例
    static class Node {
        public int val;
        Node next = null;

        public Node(int val) {
            this.val = val;
        }
    }

    // 基于链表来实现队列,可以入队列从尾部插入,出队列从头部删除
    // 也可以入队列从头部插入,出队列从尾部删除
    // 最好记录一下头节点和尾节点
    // 创建一个链表就要有头节点,此处 head 节点不是傀儡节点
    private Node head = null;
    private Node tail = null;

    // 入队列,按照从尾部入队列,头部出队列的方式
    public void offer(int val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = newNode;
            tail = newNode;
            return;
        }
        // 当前如果不是空队列
        tail.next = newNode;
        tail = tail.next;
    }

    // 出队列
    public Integer poll() {
        // 如果队列为空,再执行出队列这个操作就不对
        if (head == null) {
            // 出队列失败,返回一个错误值
            return null;
        }
        int ret = head.val;
        head = head.next;
        if (head == null) {
            // 删除当前元素后,队列变成了空队列
            tail = null;
        }
        return ret;
    }

    // 取队首元素
    public Integer peek() {
        if (head == null) {
            return null;
        }
        return head.val;
    }
}
