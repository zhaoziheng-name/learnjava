package java_0414;

import java.util.*;

public class MapInterview {
    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        // 1. 遍历旧链表,把每个元素插入到 map 中,key 是旧链表的节点, value 是新链表的节点
        Map<Node, Node> map = new HashMap<>();
        for (Node cur = head; cur != null; cur = cur.next) {
            map.put(cur, new Node(cur.val));
        }
        // 2. 再遍历链表,修改新链表中的 next 和 random
        for (Node cur = head; cur != null; cur = cur.next) {
            // 先从 map 中找到该 cur 对应的新链表节点
            Node newCur = map.get(cur);
            newCur.next = map.get(cur.next);
            newCur.random = map.get(cur.random);
        }
        // 需要返回新链表的头节点
        return map.get(head);
    }

    public int numJewelsInStones(String J, String S) {
       // 1. 先遍历 J 将所有宝石类型放到一个 Set 中
        Set<Character> set = new HashSet<>();
        for (char c : J.toCharArray()) {
            set.add(c);
        }
        // 2. 再遍历 S 拿每个元素去 set 中找,如果找到了就是宝石
        int num = 0;
        for (char c : S.toCharArray()) {
            if (set.contains(c)) {
                num++;
            }
        }
        return num;
    }

    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 10);
        map.put(2, 20);
        map.put(3, 30);
        map.put(4, 40);

        // 使用迭代器遍历
        Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> entry = iterator.next();
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }

        // 2. 使用 for each
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }
}
