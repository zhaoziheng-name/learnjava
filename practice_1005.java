package java_1005;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class practice_1005 {
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre.length == 0 || in.length == 0) {
            return null;
        }
        return reConstructBinaryTreeHelper(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }

    private TreeNode reConstructBinaryTreeHelper(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(pre[preStart]);
        int i = inStart;
        for (; i < inEnd; i++) {
            if (in[i] == pre[preStart]) {
                // 找到了根节点
                root.left = reConstructBinaryTreeHelper(pre, preStart + 1, i - inStart + preStart,
                        in, inStart, i - 1);
                root.right = reConstructBinaryTreeHelper(pre, i - inStart + preStart + 1, preEnd,
                        in, i + 1, inEnd);
                break;
            }
        }
        return root;
    }

    public int JumpFloor(int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < target; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[target];
    }

    public int NumberOf1(int n) {
        int count = 0;
        while (n != 0) {
            n &= (n - 1);
            count++;
        }
        return count;
    }

    public void reOrderArray(int[] array) {
        int k = 0;
        for (int i = 0; i < array.length; i++) {
            if ((array[i] & 1) == 1) {
                int tmp = array[i];
                int j = i;
                while (j > k) {
                    array[j] = array[j - 1];
                    j--;
                }
                array[k++] = tmp;
            }
        }
    }
}
