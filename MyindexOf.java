package java_0324;

public class MyindexOf {
    public static void main(String[] args) {
        int result = idx("abcdefacd", "cda");
        System.out.println(result);
//        String str = "abcde";
//        System.out.println(str.charAt(2));
    }

    public static int idx(String str1, String str2) {
        int count = 0;
        // 遍历 str1 中的每个字母
        for (int i = 0; i < str1.length(); i++) {
            // 找到 str2 中第一个与 str1 重合的元素, 进入下一层循环遍历
            if (str1.charAt(i) == str2.charAt(0)) {
                count = 0;
                // 用 str2 中的每个元素和 str1 中的元素作比较
                for (int j = 0; j < str2.length(); j++) {
                    if (i + j < str1.length()) {
                        if (str1.charAt(i + j) != str2.charAt(j)) {
                            // 如果找到了不一样的,就跳出循环并且返回 -1
                            break;
                        }
                        // 如果相等,就执行 count++, 不执行上面的 if
                        count++;
                    }
                }
                // 执行到 j >= str.length 或者 i + j >= str1.length 出循环
                // 这时比较 count 与 str.length 的大小
                // 如果相等说明找到了,如果不相等,说明是非正常退出循环,直接 return -1
                if (count == str2.length()) {
                    return i;
                }
            }
        }
        return -1;
    }
}
