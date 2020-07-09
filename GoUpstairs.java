package java_0709;

public class GoUpstairs {
    // 递归
//    public int countWays(int n) {
//        if (n < 0) {
//            return 0;
//        } else if (n == 0) {
//            return 1;
//        } else {
//            return countWays(n - 1) + countWays(n - 2) + countWays(n - 3);
//        }
//    }

    // 非递归
    public int countWays(int n) {
        // 新建数组,从 1 开始,所以要 n + 1
        int[] a = new int[n + 1];
        a[1] = 1;
        a[2] = 2;
        a[3] = 4;
        for (int i = 4; i <= n; i++) {
            a[i] = ((a[i - 1] + a[i - 2]) % 1000000007 + a[i - 3]) % 1000000007;
        }
        return a[n];
    }
}
