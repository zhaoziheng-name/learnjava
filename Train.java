package java_0621;

import java.util.*;

public class Train {
    private static Stack<String> stack1 = new Stack<>();
    private static Stack<String> stack2 = new Stack<>();
    private static List<String> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            scanner.nextLine();
            String str = scanner.nextLine();
            String[] ss = str.split(" ");
            for (int i = ss.length - 1; i >= 0; i--) {
                stack1.push(ss[i]);
            }
            ff("");
            Collections.sort(list);
            for (String s : list)
                System.out.println(s);
        }
    }

    private static void ff(String str) {
        if (stack1.isEmpty() && stack2.isEmpty()) {
            list.add(str.trim());
            return;
        }
        if (!stack2.isEmpty()) {
            String str1 = stack2.pop();
            ff(str + " " + str1);
            stack2.push(str1);
        }
        if (!stack1.isEmpty()) {
            String str2 = stack1.pop();
            stack2.push(str2);
            ff(str);
            stack2.pop();
            stack1.push(str2);
        }
    }
}
