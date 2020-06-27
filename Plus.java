package java_0627;

public class Plus {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode plusAB(ListNode a, ListNode b) {
        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }
        int flag = 0;
        int tmp = 0;
        ListNode node = null;
        ListNode pNode = null;
        while (a != null && b != null) {
            tmp = a.val + b.val + flag;
            flag = 0;
            if (tmp >= 10) {
                tmp %= 10;
                flag = 1;
            }
            ListNode root = new ListNode(tmp);
            if (node == null) {
                node = root;
                pNode = root;
            } else {
                node.next = root;
                node = root;
            }
            a = a.next;
            b = b.next;
        }
        while (a != null) {
            tmp = a.val + flag;
            flag = 0;
            if (tmp >= 10) {
                tmp %= 10;
                flag = 1;
            }
            ListNode root = new ListNode(tmp);
            node.next = root;
            node = root;
            a = a.next;
        }
        while (b != null) {
            tmp = b.val + flag;
            flag = 0;
            if (tmp >= 10) {
                tmp %= 10;
                flag = 1;
            }
            ListNode root = new ListNode(tmp);
            node.next = root;
            node = root;
            b = b.next;
        }
        if (flag == 1) {
            ListNode root = new ListNode(1);
            node.next = root;
            node = root;
        }
        return pNode;
    }
}
