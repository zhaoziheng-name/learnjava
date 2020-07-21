package java_0721;

import java.util.Scanner;
import java.util.Stack;

public class ReSort {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] s = str.split(" ");
        for (int i = 0; i < s.length; i++) {
            stack.push(s[i]);
        }
        String n = "";
        while (!stack.empty()) {
            n = n + stack.pop();
        }
        System.out.println(n);
    }
}
