package HomeWork;

import java.util.Arrays;

public class day5andday6 {
    public static void main(String[] args) {
//        int[] arr = {1, 2, 2, 4, 5};
//        System.out.println(containsDuplicate(arr));
//        String name = "bruce";
//        String typed = "bruce";
//        System.out.println(isLongPressedName(name, typed));
        String str = "ab-cd";
        System.out.println(reverseOnlyLetters(str));
    }

    public static String reverseOnlyLetters(String S) {
        StringBuilder arr = new StringBuilder();
        int n =S.length() - 1;
        for (int i = 0; i < S.length(); i++) {
            if (Character.isLetter(S.charAt(i))) {
                while (!Character.isLetter(S.charAt(n))) {
                    n--;
                }
                arr.append(S.charAt(n--));
            } else {
                arr.append(S.charAt(i));
            }
        }
        return arr.toString();
    }

    public static int[] sortedSquares(int[] A) {
        int n = A.length;
        int j = 0;
        while(j < n && A[j] < 0) {
            j++;
        }
        int i = j - 1;
        int[] arr = new int[n];
        int tmp = 0;
        while(i >= 0 && j < n) {
            if(A[i] * A[i] < A[j] * A[j]) {
                arr[tmp++] = A[i] * A[i];
                i--;
            } else {
                arr[tmp++] = A[j] * A[j];
                j++;
            }
        }
        while(j < n) {
            arr[tmp++] = A[j] * A[j];
            j++;
        }
        return arr;
    }

    public static boolean isLongPressedName(String name, String typed) {
        int j = 0;
        for (char c : name.toCharArray()) {
            if(j == typed.length()) {
                return false;
            }
            if(typed.charAt(j) != c) {
                if(j == 0 || typed.charAt(j - 1) != typed.charAt(j)) {
                    return false;
                }
                char cur = typed.charAt(j);
                while(j < typed.length() && typed.charAt(j) == cur) {
                    j++;
                }
                if(j == typed.length() || typed.charAt(j) != c) {
                    return false;
                }
            }
            j++;
        }
        return true;
    }

    public static boolean containsDuplicate(int[] nums) {
        // 时间复杂度为O(N ^ 2) 会超时
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if(nums[j] == nums[i]) {
                    return true;
                }
            }
        }
        return false;
    }
//        Arrays.sort(nums);
//          for (int i = 0; i < nums.length - 1; i++) {
//            if(nums[i] == nums[i + 1]) {
//                return true;
//            }
//        }
//        return false;
}