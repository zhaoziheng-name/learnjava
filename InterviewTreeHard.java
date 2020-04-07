package java_0407;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class InterviewTreeHard {
    private int index; // 当前访问到先序遍历中的第几个元素了
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        index = 0;
        return buildTreeHelper(preorder, inorder, 0, inorder.length);
    }

    // [left, right) 这个区间就表示当前 preorder[index] 这个节点对应的子树的中序遍历结果
    private TreeNode buildTreeHelper(int[] preorder, int[] inorder, int left, int right) {
        if (left >= right) {
            // 中序遍历结果为空. 这个树就是空树
            return null;
        }
        if (index >= preorder.length) {
            // 遍历元素结束
            return null;
        }
        // 根据当前根节点的值,创建出根节点
        TreeNode root = new TreeNode(preorder[index]);
        index++; // 节点创建完毕就 index++ , 准备处理下一个节点
        // 根据该节点在中序遍历结果中的位置,把 inorder 数组划分成两个部分
        int pos = find(inorder, left, right, root.val);
        // [left, pos) 表示当前 root 左子树的中序遍历结果.
        // [pos + 1, right) 表示当前 root 右子树的中序遍历结果.
        root.left = buildTreeHelper(preorder, inorder, left, pos);
        root.right = buildTreeHelper(preorder, inorder, pos + 1, right);
        return root;
    }

    private int find(int[] inorder, int left, int right, int toFind) {
        for (int i = left; i < right; i++) {
            if (inorder[i] == toFind) {
                return i;
            }
        }
        return -1;
    }

    // 使用 sb 表示最终得到的字符串结果.
    // 递归过程中得到的局部结构都往 sb 中追加即可
    private StringBuilder sb = new StringBuilder();
    public String tree2str(TreeNode t) {
        if (t == null) {
            // 但返回一个空字符串,而不是 null
            return "";
        }
        // 借助 helper 方法递归进行先序遍历
        helper(t);
        // 把最前面和最后面的括号删掉
        sb.deleteCharAt(0);
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    private void helper(TreeNode t) {
        if (t == null) {
            return;
        }
        // 访问根节点,追加字符串到 sb 中
        sb.append("(");
        sb.append(t.val);
        helper(t.left);
        if (t.left == null && t.right != null) {
            // 左子树为空树,右子树非空
            // 一定要加上一组 () 来占位
            sb.append("()");
        }
        helper(t.right);
        sb.append(")");
    }
}
