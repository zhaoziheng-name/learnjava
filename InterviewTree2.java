package java_0403;

import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class InterviewTree2 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            // 叶子节点深度就是 1
            return 1;
        }
        // 这个操作递归执行了 3 次
//        return 1 + (maxDepth(root.left) > maxDepth(root.right)
//                ? maxDepth(root.left) : maxDepth(root.right));

        // 这个操作递归只执行了 2 次
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return 1 + (Math.max(leftDepth, rightDepth));
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            // 空树认为是平衡的
            return true;
        }
        if (root.left == null && root.right == null) {
            // 没有子树也认为是平衡的
            return true;
        }
        // 看当前节点对应的子树是否是平衡的
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        if (leftDepth - rightDepth > 1 || leftDepth - rightDepth < -1) {
            // 说明不是平衡的
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }
        if (t1 == null || t2 == null) {
            return false;
        }
        if (t1.val != t2.val) {
            return false;
        }
        return isMirror(t1.left, t2.right) && isMirror(t1.right, t2.left);
    }

    public void levelOrder(TreeNode root) {
        // 不能使用递归
        // 可以借助队列来完成
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            // 访问元素
            System.out.print(cur.val + " ");
            // 把左右子树入队列
            if (cur.left != null) {
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
            }
        }
    }

    public boolean isCompleteTree(TreeNode root) {
        if (root == null) {
            return true;
        }

        boolean isSecondStep = false;

        // 针对这个树进行层序遍历
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            // 针对当前节点访问(判断是否符合完全二叉树的要求)
            if (!isSecondStep) {
               // 这是第一阶段
                if (cur.left != null && cur.right != null) {
                    // 直接把这两个子树入队列
                    queue.offer(cur.left);
                    queue.offer(cur.right);
                } else if (cur.left == null && cur.right != null) {
                    // 当前第一阶段某个节点只有右子树,没有左子树,一定不是完全二叉树
                    return false;
                } else if (cur.left != null && cur.right == null) {
                    // 切换到第二阶段
                    isSecondStep = true;
                    queue.offer(cur.left);
                } else {
                    // 左右子树都为空,也要切换到第二阶段
                    isSecondStep = true;
                }
            } else {
                // 这是第二阶段
                // 要求第二阶段中,任何一个节点都不能有子树
                // 只要找到某个节点有子树,就说明找到了反例
                if (cur.left != null || cur.right != null) {
                    return false;
                }
            }
        }
        // 整个树都遍历完了,也没找到返利,最后就返回 true ,是完全二叉树
        return true;
    }
}
