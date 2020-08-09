package java_0809;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class ReBuild {
    public TreeNode reConstructBinaryTreeHelper(int[] pre, int preBeg, int preEnd, int[] in, int inBeg, int inEnd) {
        if (preBeg > preEnd || inBeg > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(pre[preBeg]);
        int i = inBeg;
        for (; i <= inEnd; i++) {
            if (in[i] == pre[preBeg]) {
                root.left = reConstructBinaryTreeHelper(pre, preBeg + 1, i - inBeg + preBeg,
                        in, inBeg, i - 1);
                root.right = reConstructBinaryTreeHelper(pre, i - inBeg + preBeg + 1, preEnd,
                        in, i + 1, inEnd);
                break;
            }
        }
        return root;
    }
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre.length == 0 || in.length == 0) {
            return null;
        }
        return reConstructBinaryTreeHelper(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }
}
