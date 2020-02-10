class Node {
    public int data;
    public Node next = null;

    public Node(int data) {
        this.data = data;
    }
}

public class SingleLinkedList {
    // 记录头节点
    // 初始情况下,head为null,此时为空链表
    private Node head = null;
    //private Node tail = null; // 优化尾插
    //private int size = 0; // 优化获取长度

    // 头插法
    public void addFirst(int data) {
        // 1.根据data值构建一个链表节点(Node对象)
        Node node = new Node(data);
        // 2.如果链表为空链表
        if(head == null) {
            head = node;
            return;
        }
        // 3.如果链表不是空链表
        node.next = head;
        head = node;
    }

    // 尾插法
    public void addLast(int data) {
        Node node = new Node(data);
        if(head == null) {
            head = node;
            return;
        }
        // 3.如果链表为非空链表,要先找到链表末尾的最后一个节点
        Node tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        // 循环结束后,tail就对应到最后一个节点了
        tail.next = node;
    }

    // 任意位置插入,第一个数据节点为0号下标
    // 插入成功返回true,否则返回false
    public boolean addIndex(int index, int data) {
        int size = getSize();
        // 1.判定index是否有效
        if (index < 0 || index > size) {
            // index无效
            return false;
        }
        // 2.如果index为0,相当于头插
        if(index == 0) {
            addFirst(data);
            return true;
        }
        // 3.如果index为size,相当于尾插
        if(index == size) {
            addLast(data);
            return true;
        }
        Node node = new Node(data);
        // 4.如果index是一个中间的位置
        // a)先找到index的前一个节点index - 1
        Node prev = getPos(index - 1);
        // b)接下来就把新节点插入到prev之后
        node.next = prev.next;
        prev.next = node;
        return true;
    }

    // 给定index下标,找到对应的节点
    private Node getPos(int index) {
        Node cur = head;
        for(int i = 0; i < index; i++) {
            // cur.next操作之前必须保证cur是非null的
            cur = cur.next;
        }
        return cur;
    }

    public boolean contains(int toFind) {
        for (Node cur = head; cur != null; cur = cur.next) {
            if(cur.data == toFind) {
                return true;
            }
        }
        return false;
    }

    public void remove(int toRemove) {
        // 1.如果要删除的元素是头节点,特殊处理
        if(head.data == toRemove) {
            // 头节点要被删掉
            head = head.next;
            return;
        }
        // 2.如果要删除的是不是头节点,找到要删除节点的前一个位置
        Node prev = searchPrev(toRemove);
        // 3.修改引用的指向,完成删除
        Node toDelete = prev.next;
        prev.next = toDelete.next;
    }

    private Node searchPrev(int toRemove) {
        // 找到toRemove的前一个节点
        for(Node cur = head; cur != null && cur.next != null;
        cur = cur.next) {
            if(cur.next.data == toRemove) {
                return cur;
            }
        }
        return null;
    }

    public void removeAll(int toRemove) {
        // 1.先删除非头结点,需要找到待删除节点的前一个位置
        // prev始终指向cur的前一个位置
        Node prev = head;
        Node cur = head.next;
        while (cur != null) {
            if(cur.data == toRemove) {
                // cur节点需要被删除
                prev.next = cur.next;
                cur = prev.next;
            } else {
                // prev和cur同步往后移动
                prev = cur;
                cur = cur.next;
            }
        }
        // 2.处理头节点为要删除节点的情况
        if(head.data == toRemove) {
            head = head.next;
        }
    }

    // 得到单链表的长度
    public int getSize() {
        int size = 0;
        for(Node cur = head; cur != null; cur = cur.next) {
            size++;
        }
        return size;
    }

    public void display() {
        for (Node cur = head; cur != null; cur = cur.next) {
            System.out.print(cur.data + " ");
        }
        System.out.println();
    }

    public void clear() {
        head = null;
    }
}
