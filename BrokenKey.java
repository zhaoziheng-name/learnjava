package java_0710;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BrokenKey {
    public static void main(String[] args) {
        // 判定预期输出的哪些字符在实际输出中没有出现
        // 先建一个 Set 把实际输出的每个字符都放进去,然后遍历预期输出字符串
        // 看看哪个字符在这个 Set 中不存在,就是要找到的
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            // 1. 先循环读入两个字符串,第一个是预期输出,第二个是实际输出
            String expected = scanner.next();
            String actual = scanner.next();
            // 2. 全部转成大写
            expected = expected.toUpperCase();
            actual = actual.toUpperCase();
            // 3. 创建一个 Set 保存实际输出的字符
            Set<Character> actualSet = new HashSet<>();
            for (int i = 0; i < actual.length(); i++) {
                actualSet.add(actual.charAt(i));
            }
            Set<Character> brokenKeySet = new HashSet<>();
            for (int i = 0; i < expected.length(); i++) {
                char c = expected.charAt(i);
                // 已经被输出了
                if (actualSet.contains(c)) {
                    continue;
                }
                // 去重
                if (brokenKeySet.contains(c)) {
                    continue;
                }
                System.out.print(c);
                brokenKeySet.add(c);
            }
        }
    }
}
