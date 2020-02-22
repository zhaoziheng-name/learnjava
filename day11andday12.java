package HomeWork;

import java.util.Arrays;
import java.util.Stack;

public class day11andday12 {
    public static void main(String[] args) {
//        int num = 10;
//        System.out.println(test(num));
//        double d = Math.cos(Math.toRadians(60));
//        System.out.println(d);
//        String s = "A man, a plan, a canal: Panama";
//        System.out.println(isPalindrome(s));
//        char[] chars = {'a', 'a', 'b', 'b', 'b', 'b', 'b', 'b'};
//        System.out.println(compress(chars));
//        int[] arr = {2, 6, 4, 8, 10, 9, 15};
//        System.out.println(findUnsortedSubarray(arr));
        String[] s = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println(evalRPN(s));
    }

    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String s : tokens) {
            if (s.equals("+")) {
                stack.push(stack.pop() + stack.pop());
            } else if (s.equals("-")) {
                stack.push(-stack.pop() + stack.pop());
            } else if (s.equals("*")) {
                stack.push(stack.pop() * stack.pop());
            } else if (s.equals("/")) {
                int num1 = stack.pop();
                stack.push(stack.pop() / num1);
            } else {
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.pop();
    }

    public static int findUnsortedSubarray(int[] nums) {
        int[] num = nums.clone();
        Arrays.sort(num);
        int start = num.length, end = 0;
        for (int i = 0; i < num.length; i++) {
            if (num[i] != nums[i]) {
                start = Math.min(start, i);
                end = Math.max(end, i);
            }
        }
        return (end - start >= 0 ? end - start + 1 : 0);
    }

    public static int compress(char[] chars) {
        int point = 0, write = 0;
        for (int read = 0; read < chars.length; read++) {
            if (read + 1 == chars.length || chars[read + 1] != chars[read]) {
                chars[write++] = chars[point];
                if (read > point) {
                    for (char c: ("" + (read - point + 1)).toCharArray()) {
                        chars[write++] = c;
                    }
                }
                point = read + 1;
            }
        }
        return write;
    }

    public static boolean isPalindrome(String s) {
        int size = s.length();
        s = s.toLowerCase();
        int i = 0;
        int j = size - 1;
        while (i < j) {
            while (!isAlphanumeric(s.charAt(i))) {
                i++;
                if (i == size) {
                    return true;
                }
            }
            while (!isAlphanumeric(s.charAt(j))) {
                j--;
            }
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    private static boolean isAlphanumeric(char c) {
        if ('a' <= c && c <= 'z' || 'A' <= c && c <= 'Z'
                || '0' <= c && c <= '9') {
            return true;
        }
        return false;
    }

    public static int test(int b) {
        try {
            b += 10;
            return b;
        } catch (RuntimeException e) {

        } catch (Exception e2) {

        }finally {
            b += 10;
            return b;
        }
    }
}