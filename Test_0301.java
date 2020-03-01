package Practice;

import java.util.Date;

public class Test_0301 {
    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
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

    public boolean hasCycle(ListNode head) {
        // 使用快慢指针方式
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            // 这个代码要求 fast.next 不能为空, 不然会抛出异常
            fast = fast.next.next;
            if (slow == fast) {
                // 判定两个节点是否相同
                return true;
            }
        }
        return false;
    }

    public ListNode detectCycle(ListNode head) {
        // 1. 使用快慢指针, 找到快慢指针的交点
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                // 此时链表带环
                break;
            }
        }
        if (fast == null && fast.next == null) {
            // 链表不带环
            return null;
        }
        // 带环的情况, 设定两个引用, 分别从链表头部和 fast slow 交点出发
        // 按照同步的速度往后走
        ListNode cur1 = head;
        ListNode cur2 = fast;
        while (cur1 != cur2) {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        // 此时这个位置就是环的入口
        return cur1;
    }

    public static void main(String[] args) {
        Date date = new Date();
        // getTime 获得时间戳, 单位是毫秒
        System.out.println(date.getTime());
    }
}
