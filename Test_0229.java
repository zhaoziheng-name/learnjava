package Practice;

import com.sun.org.apache.bcel.internal.generic.LNEG;

public class Test_0229 {
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

    public ListNode partition(ListNode pHead, int x) {
        if (pHead == null) {
            return null;
        }
        if (pHead.next == null) {
            return pHead;
        }
        ListNode bigHead = new ListNode(-1);
        ListNode bigTail = bigHead;
        ListNode smallHead = new ListNode(-1);
        ListNode smallTail = smallHead;

        for (ListNode cur = pHead; cur != null; cur = cur.next) {
            if (cur.val < x) {
                // 插入到 smallTail 后面, 创建崭新的节点避免死循环
                smallTail.next = new ListNode(cur.val);
                smallTail = smallTail.next;
            } else {
                // 插入到 bigTail 后面
                bigTail.next = new ListNode(cur.val);
                bigTail = bigTail.next;
            }
        }
        // 合并两个链表, 将首尾连接起来
        smallTail.next = bigHead.next;
        return smallHead.next;
    }

    // 删除有序链表中的所有重复元素
    public ListNode deleteDuplication(ListNode pHead) {
        ListNode newHead = new ListNode(-1);
        ListNode newTail = newHead;

        // 循环遍历链表
        ListNode cur = pHead;
        while (cur != null) {
            // 判定 cur 是否是重复元素
            if (cur.next != null && cur.val == cur.next.val) {
                // 说明 cur 指向的元素就是重复元素, 找到重复元素的区间末尾
                // 跳过所有的重复元素
                while (cur.next != null && cur.val == cur.next.val) {
                    cur = cur.next;
                }
                // 上面的 while 循环结束, cur 就指向相同元素的末尾了
                // 再多走一步,就跳过了所有相同元素的区间
                cur = cur.next;
            } else {
                // 说明 cur 指向的不是重复元素
                // 插入到新链表中
                newTail.next = new ListNode(cur.val);
                newTail = newTail.next;
                cur = cur.next;
            }
        }
        return newHead.next;
    }

    public boolean chkPalindrome(ListNode A) {
        // 1. 先找到A链表的中间节点
        int size = size(A);
        int steps = size / 2;
        ListNode B = A;
        for (int i = 0; i < steps; i++) {
            B = B.next;
        }
        // 1. 上面的循环结束后, B 就指向 A 链表的中间位置了
        // 2. 从 B 开始, 对后面的链表进行逆置
        ListNode prev = null;
        ListNode cur = B;
        while (cur != null) {
            ListNode next = cur.next;
            if (next == null) {
                // 说明此时的 cur 已经是链表的最后一个节点了, 更新头节点的位置
                B = cur;
            }
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        // 3. 分别从 A 和 B 出发,依次比较两个链表的元素是否对应相等
        // 如果链表的长度为奇数个, A 和 B 链表长度相等
        // 如果链表的长度为偶数个, A 的长度比 B 要长 1
        // 遍历的时候, 循环结束条件要以 B 为基准
        while (B != null) {
            if (A.val != B.val) {
                // 对应元素不同, 不是回文
                return false;
            }
            A = A.next;
            B = B.next;
        }
        return true;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 1. 分别求两个链表的长度
        int size1 = size(headA);
        int size2 = size(headB);
        // 2. 算出一个差值, 让长的链表先走
        if (size1 > size2) {
            int offset = size1 - size2;
            for (int i = 0; i < offset; i++) {
                headA = headA.next;
            }
        } else {
            int offset = size2 - size1;
            for (int i = 0; i < offset; i++) {
                headB = headB.next;
            }
        }
        // 此时, headA 和 headB 在同一起跑线了
        while (headA != null && headB != null) {
            // 比较的是节点是不是相同对象(身份)
            if (headA == headB) {
                // 如果相同节点,认为这个位置是链表的交点
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        // 链表不相交
        return null;
    }
}
