package Practice;

import com.sun.org.apache.bcel.internal.generic.LNEG;

public class LinkedListTest_0227 {
    // 给内部类加 static 是让这个类和 LinkedListTest_0227 类相关, 而和对象不相关
    // 后续如果要创建 ListNode 的实例的话
    // 就不需要依赖 LinkedListTest_0227 的实例
    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode removeElements(ListNode head, int val) {
        // 删除头部节点和删除中间节点
        // 分别对待
        if (head == null) {
            // 空链表
            return null;
        }
        // 1. 先删除中间节点
        ListNode prev = head; // prev 始终指向 cur 的前一个位置
        ListNode cur = head.next;
        while (cur != null) {
            if (cur.val == val) {
                // 这个节点需要删除
                prev.next = cur.next;
                cur = prev.next;
            } else {
                // 这个节点不需要删除
                prev = cur;
                cur = cur.next;
            }
        }
        // 2. 再考虑删除头部节点
        if (head.val == val) {
            head = head.next;
        }
        return head;
    }

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode newHead = null;
        ListNode cur = head;
        ListNode prev = null;
        ListNode next = cur.next;
        while (cur != null) {
            if (next == null) {
                // 当前cur就是原链表的末尾
                newHead = cur;
            }
            cur.next = prev;
            // 更新三个指针的指向位置
            prev = cur;
            cur = next;
            next = cur.next;
        }
        return newHead;
    }

    public ListNode middleNode(ListNode head) {
        int steps = size(head) / 2;
        ListNode cur = head;
        for (int i = 0; i < steps; i++) {
            cur = cur.next;
        }
        return cur;
    }

    public int size(ListNode head) {
        int size = 0;
        ListNode cur = head;
        while (cur != null) {
            size++;
            cur = cur.next;
        }
        return size;
    }

    public ListNode FindKthToTail(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        int size = size(head);
        if (k <= 0 || k > size) {
            // k是非法值
            return null;
        }
        int steps = size - k;
        ListNode cur = head;
        for (int i = 0; i < steps; i++) {
            cur = cur.next;
        }
        return cur;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode newHead = new ListNode(-1);
        ListNode newTail = newHead;
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        while (cur1 != null && cur2 != null) {
            if (cur1.val < cur2.val) {
                // 把 cur1 对应的节点插入到新链表的末尾
                newTail.next = cur1;
                newTail = newTail.next;
                cur1 = cur1.next;
            } else {
                newTail.next = cur2;
                newTail = newTail.next;
                cur2 = cur2.next;
            }
        }
        if (cur1 == null) {
            newTail.next = cur2;
        } else {
            newTail.next = cur1;
        }
        return newHead.next;
    }
}
