package java_0624;

import java.util.*;

public class MarkSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int num = scanner.nextInt();
            int flag = scanner.nextInt();
            List<Integer> list = new ArrayList<>();
            LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
            for (int i = 0; i < num; i++) {
                String name = scanner.next();
                int score = scanner.nextInt();
                list.add(score);
                map.put(name + " " + score, score);
            }
            Collections.sort(list);
            if (flag == 0) {
                Collections.reverse(list);
            }
            int pre = -1;
            for (int i : list) {
                if (pre == 1)
                    continue;
                for (String key : map.keySet())
                    if (map.get(key).equals(i))
                        System.out.println(key);
                    pre = i;
            }
        }
    }
}
