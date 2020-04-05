package java_0404;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HardInterviewTree {
    static class TreeNode {
        public int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 应对多组输入
        while (scanner.hasNext()) {
            // line 这个字符串就对应形如 "abc##de#g##f###" 的输入数据
            String line = scanner.next();
            TreeNode root = build(line);
            inOrder(root);
            System.out.println();
        }
    }

    private static void inOrder(TreeNode root) {
    }

    private static int index;
    private static TreeNode build(String line) {
        // 为了再后面的递归创建过程中能时刻知道当前访问到 line 中的那个元素了
        // 可以使用一个变量来记录
        // 通过下面的方法辅助完成递归
        index = 0;
        return createTreePreOrder(line);
    }

    private static TreeNode createTreePreOrder(String line) {
        // 获取到当前处理到哪个节点
        char cur = line.charAt(index);
        if (cur == '#') {
            return null;
        }
        // 当前字符不是 # 就创建一个节点
        TreeNode root = new TreeNode(cur);
        index++;   // 准备处理下一个节点,下一个节点开始就是当前 root 左子树的先序遍历结果
        root.left = createTreePreOrder(line);
        index++;
        root.right = createTreePreOrder(line);
        return root;
    }

    // result 相当于一个二维数组
    // 针对当前的 ArrayList (包含了所有的层)来说,每个元素又是一个 List (每一层里面的所有节点内容)
    // result 0 号元素对应着第 0 层节点
    // result 1 号元素对应着第 1 层节点
    // ......
    result.clear();
    static List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        // 此处由于要把每一层的节点放到一个单独的 List 中,所以之前的层序遍历方式就不行了
        // 此处还是基于递归的方式来解决问题
        if (root == null) {
            return result;
        }
        // helper 方法辅助递归, 第二个参数表示当前的层数(层数从 0 开始算)
        helper(root, 0);
        return result;
    }

    private void helper(TreeNode root, int level) {
        if (level == result.size()) {
            result.add(new ArrayList<>());
        }
        // 把当前节点添加到 result 中的合适位置
        result.get(level).add(root.val);
        if (root.left != null) {
            helper(root.left, level + 1);
        }
        if (root.right != null) {
            helper(root.right, level + 1);
        }
    }
}
