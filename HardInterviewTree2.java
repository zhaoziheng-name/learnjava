package java_0406;

public class HardInterviewTree2 {
    class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    // lca 表示最近公共祖先
    private TreeNode lca = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        // findNode 递归找的过程中,一旦找到了就把结果放到 lca 这个变量中
        findNode(root, p, q);
        return lca;
    }

    // 看从 root 出发能不能找到 p 或者 q 只要找到一个就返回 true, 都找不到返回 false
    private boolean findNode(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }
        // 递归按照后序遍历的方式来查找
        int left = findNode(root.left, p, q) ? 1 : 0;
        int right = findNode(root.right, p, q) ? 1 : 0;
        int mid = (root == p || root == q) ? 1 : 0;
        if (left + right + mid == 2) {
            lca = root;
        }
        // 如果三个位置的和为 0 表示没找到, 返回 false
        // 只要能找到 1 个或者以上,都返回 true
        return (left + right + mid) > 0;
    }

    public TreeNode Convert(TreeNode pRootOfTree) {
        // 基于递归的方式来完成双向链表构建,为了保证有序性,需要中序遍历.
        // 二叉搜索树的中序遍历结果是有序.
        if (pRootOfTree == null) {
            return null;
        }
        if (pRootOfTree.left == null && pRootOfTree.right == null) {
            // 当前这个节点没有子树
            return pRootOfTree;
        }
        // 最终的链表 = 左子树的链表 + 左子树 + 右子树的链表
        // 就需要用左子树链表的尾巴和根节点相连
        // 再用右子树的头部和根节点相连

        // 1. 先递归处理左子树
        // left 就是左子树这个链表的根节点
        TreeNode left = Convert(pRootOfTree.left);
        // 2. 需要找到左子树链表的尾节点
        TreeNode leftTail = left;
        // right 相当于链表的 next
        while (leftTail != null && leftTail.right != null) {
            leftTail = leftTail.right;
        }
        // 循环结束之后,left 就指向了左侧的链表尾部
        // 3. 把左子树和当前链表连在一起
        if (left != null) {
            leftTail.right = pRootOfTree;
            pRootOfTree.left = leftTail;
        }
        // 4. 递归转换右子树,把右子树也变成双向链表
        TreeNode right = Convert(pRootOfTree.right);
        // 5. 再把当前节点和右子树连在一起
        if (right != null) {
            right.left = pRootOfTree;
            pRootOfTree.right = right;
        }
        // 6. 最终返回新的链表的头节点
        // 如果 left 为 null, 链表的头节点就是 pRootOfTree
        // 如果 left 不是 null, 头节点就是 left
        return left == null ? pRootOfTree :left;
    }
}
