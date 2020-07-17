package java_0717;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ToDelete {
    public static void main(String[] args) {
        // 定义一个线性表
        List<Character> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        // 定义原始字符串
        String original = scanner.nextLine();
        // 给定要删除的字符
        String toDelete = scanner.nextLine();
        for (int i = 0; i < original.length(); i++) {
            if (!toDelete.contains(original.charAt(i) + "")) {
                list.add(original.charAt(i));
            }
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + "");
        }
    }
}
