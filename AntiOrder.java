package java_0603;

import java.util.*;

public class AntiOrder {
    public int count(int[] A, int n) {
        int count = 0;
        if (n < 2) {
            return count;
        }
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (A[i] > A[j]) {
                    count++;
                }
            }
        }
        return count;
    }
}