package java_0705;

import java.util.Scanner;

public class PlusEqualsSum {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] p = new int[n+1];
        long[][] dp = new long[n+1][m+1];//dp[i,j]表示前i个可以凑到j的个数
        for(int i=1; i<=n; i++){
            p[i] = sc.nextInt();
        }
        //用前i个数据组成0的方案只有一种
        for(int i=0; i<=n; i++){
            dp[i][0] = 1;
        }
        //用前0个数据组成j的方案不存在
        for(int j=1; j<=m; j++){
            dp[0][j] = 0;
        }
        for(int i=1; i<=n; i++){
            for(int j=0; j<=m; j++){
                //等于拿了这个数据和没拿这个数据的方案总和，没拿时只需要看前i-1个数据组成j-p[i]的方案数
                if(p[i] <= j){
                    dp[i][j] = dp[i-1][j] +dp[i-1][j-p[i]];
                }else{//p[i]>j时只能选择不拿
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        System.out.println(dp[n][m]);
    }
}
