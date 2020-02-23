package HomeWork;

import javax.swing.tree.TreeNode;
import java.awt.*;
import java.util.*;
import java.util.List;

public class Done {
    public static void main(String[] args) {
//        int[] arr = {1, 2, 3};
//        System.out.println(subsets(arr));
//        int[][] arr = {{1, 2, 3},
//                       {8, 9, 4},
//                       {7, 6, 5}};
//        System.out.println(longestIncreasingPath(arr));
//        int[][] routes = {{1, 2, 7}, {3, 6 ,7}};
//        System.out.println(numBusesToDestination(routes, 1, 6));
        String s = "adceb";
        String p = "*a*b";
        System.out.println(isMatch(s, p));
    }

    public static boolean isMatch(String s, String p) {
            int m = s.length();
            int n = p.length();
            // 状态 dp[i][j] : 表示 s 的前 i 个字符和 p 的前 j 个字符是否匹配
            boolean[][] dp = new boolean[m + 1][n + 1];
            // 初始化
            dp[0][0] = true;
            for (int i = 1; i <= n; i++) {
                dp[0][i] = dp[0][i - 1] && p.charAt(i - 1) == '*';
            }
            // 状态转移
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else if (p.charAt(j - 1) == '*') {
                        dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                    }
                }
            }
            // 返回结果
            return dp[m][n];
        }

    public static int numBusesToDestination(int[][] routes, int S, int T) {
        if(S == T) {
            return 0;
        }
        int N = routes.length;
        List<List<Integer>> graph = new ArrayList();
        for (int i = 0; i < N; i++) {
            Arrays.sort(routes[i]);
            graph.add(new ArrayList());
        }
        Set<Integer> seen = new HashSet();
        Set<Integer> targets = new HashSet();
        Queue<Point> queue = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (intersect(routes[i], routes[j])) {
                    graph.get(i).add(j);
                    graph.get(j).add(i);
                }
            }
        }
        for (int i = 0; i < N; ++i) {
            if (Arrays.binarySearch(routes[i], S) >= 0) {
                seen.add(i);
                queue.offer(new Point(i, 0));
            }
            if (Arrays.binarySearch(routes[i], T) >= 0)
                targets.add(i);
        }
        while (!queue.isEmpty()) {
            Point info = queue.poll();
            int node = info.x, depth = info.y;
            if (targets.contains(node)) return depth+1;
            for (Integer nei: graph.get(node)) {
                if (!seen.contains(nei)) {
                    seen.add(nei);
                    queue.offer(new Point(nei, depth+1));
                }
            }
        }
        return -1;
    }

    public static boolean intersect(int[] A, int[] B) {
        int i = 0, j = 0;
        while (i < A.length && j < B.length) {
            if (A[i] == B[j]) {
                return true;
            }
            if (A[i] < B[j]) {
                i++;
            } else {
                j++;
            }
        }
        return false;
    }

      public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    public static List<Integer> rightSideView(TreeNode root) {
        Map<Integer, Integer> rightmostValueAtDepth = new HashMap<Integer, Integer>();
        int max_depth = 1;
        Stack<TreeNode> nodeStack = new Stack<TreeNode>();
        Stack<Integer> depthStack = new Stack<Integer>();
        nodeStack.push(root);
        depthStack.push(0);
        while (!nodeStack.isEmpty()) {
            TreeNode node = nodeStack.pop();
            int depth = depthStack.pop();
            if (node != null) {
                max_depth = Math.max(max_depth, depth);
                if (!rightmostValueAtDepth.containsKey(depth)) {
                    rightmostValueAtDepth.put(depth, node.val);
                }
                nodeStack.push(node.left);
                nodeStack.push(node.right);
                depthStack.push(depth + 1);
                depthStack.push(depth + 1);
            }
        }
        List<Integer> rightView = new ArrayList<Integer>();
        for (int depth = 0; depth <= max_depth; depth++) {
            rightView.add(rightmostValueAtDepth.get(depth));
        }
        return rightView;
    }

    private static final int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private static int m, n;
    private static int dfs(int[][] matrix, int i, int j) {
        int ans = 0;
        for (int[] d: dirs) {
            int x = i + d[0], y = j + d[1];
            if (0 <= x && x < m && 0 <= y &&
                    y < n && matrix[x][y] > matrix[i][j])
                ans = Math.max(ans, dfs(matrix, x, y));
        }
        return ++ans;
    }

    public static int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        m = matrix.length;
        n = matrix[0].length;
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans = Math.max(ans, dfs(matrix, i, j));
            }
        }
        return ans;
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(0, nums, res, new ArrayList<Integer>());
        return res;
    }
    private static void backtrack(int i, int[] nums, List<List<Integer>>
            res, ArrayList<Integer> tmp) {
        res.add(new ArrayList<>(tmp));
        for (int j = i; j < nums.length; j++) {
            tmp.add(nums[j]);
            backtrack(j + 1, nums, res, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }
}