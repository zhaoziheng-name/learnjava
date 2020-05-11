package java_0511;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int val) { this.val = val; }
}

public class Exercise_0511 {
    public int getResult(int n) {
        if (n < 1) {
            return -1;
        }
        LinkedList<Integer> result = new LinkedList<>();
        int round = 2;
        int i = 0;
        int cur = 0;
        for (i = 1; i <= n; i++) {
            result.add(i);
        }
        while (result.size() > 1) {
            i = 0;
            while (result.size() > 1 && i < result.size()) {
                cur = (cur + 1) % round;
                if (cur != 1) {
                    result.remove(i);
                } else {
                    i++;
                }
            }
            round++;
            cur = 0;
            if (result.size() > 1) {
                int last = result.removeLast();
                result.addFirst(last);
            }
        }
        return result.pop();
    }

    Queue<Integer> queue;
    public void RecentCounter() {
        queue = new LinkedList<>();
    }

    public int ping(int t) {
        queue.add(t);
        while (queue.peek() < t - 3000) {
            queue.poll();
        }
        return queue.size();
    }

    public boolean isCompleteTree(TreeNode root) {
        if (root == null) {
            return true;
        }

        boolean isSecondStep = false;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (!isSecondStep) {
                if (cur.left != null && cur.right != null) {
                    queue.offer(cur.left);
                    queue.offer(cur.right);
                } else if (cur.left == null && cur.right != null) {
                    return false;
                } else if (cur.left != null && cur.right == null) {
                    isSecondStep = true;
                    queue.offer(cur.left);
                } else {
                    isSecondStep = true;
                }
            } else {
                if (cur.left != null || cur.right != null) {
                    return false;
                }
            }
        }
        return true;
    }
}
