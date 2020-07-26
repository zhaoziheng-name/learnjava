package java_0726;

public class PrinterArray {
    public int[] clockwisePrint(int[][] mat, int n, int m) {
        // 返回的结果数组
        int[] result = new int[n * m];
        // 非法情况判断
        if (m < 0 || n < 0) {
            return result;
        }
        // 行的下标
        int i = 0;
        // 列的下标
        int j = 0;
        // 放入数组的下标
        int index = 0;
        // 圈数
        int N = 0;
        while (index < result.length) {
            // 向右打印
            while (j < m - N && index < result.length) {
                result[index] = mat[i][j];
                index++;
                j++;
            }
            // 向下打印
            i++;
            j--;
            while (i < n - N && index < result.length) {
                result[index] = mat[i][j];
                index++;
                i++;
            }
            // 向左打印
            i--;
            j--;
            while (j >= N && index < result.length) {
                result[index] = mat[i][j];
                j--;
                index++;
            }
            // 向上打印
            j++;
            i--;
            while (i > N && index < result.length) {
                result[index] = mat[i][j];
                i--;
                index++;
            }
            N++;
            i++;
            j++;
        }
        return result;
    }
}
