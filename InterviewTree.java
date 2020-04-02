package java_0402;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class InterviewTree {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            // 空树返回一个空的 List(元素个数为 0,不是 null)
            return result;
        }
        // 访问根节点,此处的访问操作,是把元素 add 到 List 中
        result.add(root.val);
        // 递归遍历左子树,把左子树的遍历结果加到 List 中
        result.addAll(preorderTraversal(root.left));
        // 递归遍历右子树,把右子树的遍历结果加到 List 中
        result.addAll(preorderTraversal(root.right));
        return result;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        result.addAll(inorderTraversal(root.left));
        result.add(root.val);
        result.addAll(inorderTraversal(root.right));
        return result;
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        result.addAll(postorderTraversal(root.left));
        result.addAll(postorderTraversal(root.right));
        result.add(root.val);
        return result;
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            // 两个树都是空树,认为是相同的
            return true;
        }
        // 分为四种情况:
        // 1. p q 都为空
        // 2. p 为空, q 不为空
        // 3. q 为空, p 不为空
        // 4. p q 都不为空
        // 由于上面的逻辑,只有 p q 都不为空才能进入条件内部
        if (p == null || q == null) {
            // p q 只有一个为空,另一个不为空
            return false;
        }
        // 下面的逻辑处理 p q 都不为空
        // 先判断根节点是否相同
        if (p.val != q.val) {
            // 说明这两棵树一定不相等
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        boolean ret = false;
        if (s.val == t.val) {
            // 如果两棵树的根节点的值相同,进一步判定 s 和 t 是不是相同的树
            ret = isSameTree(s, t);
        }
        if (ret == false) {
            // s 和 t 不相同,递归看看 s.left 是否包含 t
            ret = isSubtree(s.left, t);
        }
        if (!ret) {
            // 说明 s.left 也不包含 t,再看 s.right 是否包含 t
            ret = isSubtree(s.right, t);
        }
        return ret;
        // 也可以写成:
        // return ret || isSubtree(s.left, t) || isSubtree(s.right, t);
    }
}
