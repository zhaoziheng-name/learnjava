package java_0729;

import java.util.ArrayList;
import java.util.Stack;

class ListNode {
    int val;
    ListNode next = null;

    public ListNode(int val) {
        this.val = val;
    }
}

public class Reverse {
    // 方法一: 利用栈结构
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Stack<Integer> stack = new Stack<>();
        while (listNode.next != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        ArrayList<Integer> list = new ArrayList<>();
        while (!stack.empty()) {
            list.add(stack.pop());
        }
        return list;
    }

    // 方法二: 逆置数组
    public ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        while (listNode.next != null) {
            list.add(listNode.val);
            listNode = listNode.next;
        }
        int i = 0;
        int j = list.size() - 1;
        while (i < j) {
            int tmp = list.get(i);
            list.set(i, list.get(j));
            list.set(j, tmp);
            i++;
            j--;
        }
        return list;
    }

    // 方法三: 递归, 问题分解(要打印倒数第一个, 就要先打印前面的 n - 1 个节点)
    public ArrayList<Integer> printListFromTailToHead3(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        printListFromTailToHeadHelper(list, listNode);
        return list;
    }

    public void printListFromTailToHeadHelper(ArrayList<Integer> list, ListNode listNode) {
        if (listNode == null) {
            return;
        }
        printListFromTailToHeadHelper(list, listNode.next);
        list.add(listNode.val);
    }
}
