package java_0722;

import java.util.HashMap;
import java.util.Map;

public class CutBranch {
    // 迭代版本
//    public int Fibonacci(int n) {
//        if (n == 0) {
//            return 0;
//        }
//        int first = 1;
//        int second = 1;
//        int third = 1;
//        while (n > 2) {
//            third = first + second;
//            first = second;
//            second = third;
//            n--;
//        }
//        return third;
//    }

    // 剪枝重复操纵
    private Map<Integer, Integer> map = new HashMap<>();
    public int Fibonacci(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int pre = 0;
        if (map.containsKey(n - 1)) {
            pre = map.get(n - 1);
        } else {
            pre = Fibonacci(n - 1);
            map.put(n - 1, pre);
        }
        int ppre = 0;
        if (map.containsKey(n - 2)) {
            ppre = map.get(n - 2);
        } else {
            ppre = Fibonacci(n - 2);
            map.put(n - 2, ppre);
        }
        return pre + ppre;
    }
}
