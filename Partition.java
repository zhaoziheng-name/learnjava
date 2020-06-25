package java_0625;

public class Partition {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
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
                smallTail.next = new ListNode(cur.val);
                smallTail = smallTail.next;
            } else {
                bigTail.next = new ListNode(cur.val);
                bigTail = bigTail.next;
            }
        }
        smallTail.next = bigHead.next;
        return smallHead.next;
    }
}
