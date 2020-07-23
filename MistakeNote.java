package java_0723;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MistakeNote {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> map = new HashMap<>();
        while (scanner.hasNext()) {
            String file = scanner.next();
            int lineCount = scanner.nextInt();
            String fileName = file.substring(file.lastIndexOf("\\") + 1, file.length());
            if (fileName.length() > 16) {
                fileName = fileName.substring(fileName.length() - 16);
            }
            String k = fileName + " " + lineCount;
            if (map.containsKey(k)) {
                int count = map.get(k);
                count++;
                map.put(k, count);
            } else {
                map.put(k, 1);
            }
        }
        String filename = "";
    }
}
