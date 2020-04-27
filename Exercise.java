package java_0427;

import java.util.HashSet;
import java.util.Scanner;

public class Exercise {
    public static void main(String[] args) {
//        String str = "hello world";
//        System.out.println(replace(2, str));
//        String str1 = "hello world";
//        String str2 = "war";
//        System.out.println(contains(str1, str2));
    }

    public static int compareTo(String s1, String s2) {
        int shortLen = 0;
        // 找到较短的字符串
        if (s1.length() > s2.length()) {
            shortLen = s2.length();
        }
        if (s1.length() < s2.length()) {
            shortLen = s1.length();
        }
        // 遍历短的字符串看看字符是否相同
        // 不相同返回对应的值
        for (int i = 0; i < shortLen; i++) {
            if (s1.charAt(i) > s2.charAt(i)) {
                return 1;
            }
            if (s1.charAt(i) < s2.charAt(i)) {
                return -1;
            }
        }
        // 如果相同判断两个字符串的长度
        // 如果在 shortLen 长度内相等,两个字符串相等
        // 如果不相等作比较返回对应的值
        if (s1.length() == s2.length()) {
            return 0;
        }
        return (s1.length() - s2.length() > 0) ? 1 : -1;
    }

    public static boolean contains(String s1, String s2) {
        // 定义一个变量记录循环走了几次
        int count = 0;
        for (int i = 0; i < s1.length(); i++) {
            // 找到第一个字母相同的地方
            if (s1.charAt(i) == s2.charAt(0)) {
                // 更新变量
                count = 0;
                for (int j = 0; j < s2.length(); j++) {
                    // 防止下标越界
                    if (i + j < s1.length()) {
                        if (s1.charAt(i + j) != s2.charAt(j)) {
                            // 遇到不同的字母直接 break 跳出循环
                            break;
                        }
                        count++;
                    }
                }
                // 判断条件成立直接返回 true
                if (count == s2.length()) {
                    return true;
                }
            }
        }
        // 循环全部结束也没有符合的条件成立就返回 false
        return false;
    }

    public static String replace(int beg, String S) {
        System.out.println("请输入您要替换的字符串: ");
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.next();
        // String 是不可修改的,就用 subString 将字符分成几部分
        S = S.substring(0, beg) + s1 +
                S.substring(beg + s1.length(), S.length());
        // 返回新的字符串
        return S;
    }

    public static int IndexOf(String s1, String s2) {
        int count = 0;
        // 找到第一个字符相同的位置
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == s2.charAt(0)) {
                count = 0;
                // 向后遍历字符串
                for (int j = 0; j < s2.length(); j++) {
                    if (i + j < s1.length()) {
                        if (s1.charAt(i + j) != s2.charAt(j)) {
                            break;
                        }
                        count++;
                    }
                }
                if (count == s2.length()) {
                    return i;
                }
            }
        }
        return -1;
    }

    public void Food(String food) {
        HashSet<String> hashSet = new HashSet<>();
        Scanner scanner = new Scanner(System.in);
        int ret = 0;
        while (scanner.hasNext()) {
            hashSet.add(scanner.next());
        }
        ret = hashSet.size();
        System.out.println(ret);
    }
}
