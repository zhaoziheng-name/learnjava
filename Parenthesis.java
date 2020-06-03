package java_0603;

import java.util.*;

public class Parenthesis {
    public boolean chkParenthesis(String A, int n) {
        if (n % 2 != 0) {
            return false;
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (A.charAt(i) == '(') {
                sum++;
            } else if (A.charAt(i) == ')' && sum > 0) {
                sum--;
            } else {
                return false;
            }
        }
        return sum == 0;
    }
}