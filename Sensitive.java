package java_0911;

import java.util.Scanner;

public class Sensitive {
    static int total = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        String str = scanner.next();
        String[] s = new String[m];
        // 将输入的字符串放入一个字符串数组
        for (int i = 0; i < m; i++) {
            s[i] = scanner.next();
        }
        // 循环遍历, 将字符串数组中的每一个元素拿出来计算含有敏感词汇的个数
        for (int i = 0; i < m; i++) {
            // 将结果相加
            total += isSensitive(str, s[i]);
        }
        System.out.println(total);
    }

    private static int isSensitive(String str, String s) {
        // 从第一个字母开始向后遍历 str, 看是否包含 s
        // 包含就 +1, 不包含继续向后遍历
        int len = s.length();
        int sum = 0;
        if (len > str.length() || len == 0 || s == null) {
            return 0;
        }
        for (int i = 0; i <= str.length() - len; i++) {
            // 将 str 分割开, 然后看和 s 是否相同, 相同就 count++
            if (str.substring(i, i + len).equals(s)) {
                sum++;
            }
        }
        return sum;
    }
}
