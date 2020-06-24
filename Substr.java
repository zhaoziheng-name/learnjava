package java_0624;

import java.util.*;

public class Substr {
    public boolean[] chkSubStr(String[] p, int n, String s) {
        int index = 0;
        boolean[] result = new boolean[n];
        List<String> list = new ArrayList<>();
        while (index < s.length()) {
            for (int i = index + 1; i <= s.length(); i++) {
                String str = s.substring(index, i);
                list.add(str);
            }
            index++;
        }
        for (int i = 0; i < n; i++) {
            if (list.contains(p[i])) {
                result[i] = true;
            } else {
                result[i] = false;
            }
        }
        return result;
    }
}
