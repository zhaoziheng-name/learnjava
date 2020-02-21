package HomeWork;

import java.util.Arrays;

public class day9andday10 {
    private static int extremeInsertionIndex(int[] nums, int target, boolean left) {
        int start = 0;
        int end = nums.length;
        while (start < end) {
            int mid = (start + end) / 2;
            if (nums[mid] > target || (left && target == nums[mid])) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    public static void main(String[] args) {
//        int[] arr = {9, 5, -1, 7};
//        int[] newArr = twoSum(arr, 6);
//        System.out.println(Arrays.toString(newArr));
//        String a = "1001";
////        String b = "1111";
////        String c = addBinary(a, b);
////        System.out.println(c);
//        String str = "  -42";
//        System.out.println(myAtoi(str));
        int[] arr = {1, 2, 2, 3, 4, 5, 6};
        int[] newArr = searchRange(arr, 2);
        System.out.println(Arrays.toString(newArr));
    }

    public static int[] searchRange(int[] nums, int target) {
        int[] targetRange = {-1, -1};
        int leftIndex = extremeInsertionIndex(nums, target, true);
        if (leftIndex == nums.length || nums[leftIndex] != target) {
            return targetRange;
        }
        targetRange[0] = leftIndex;
        targetRange[1] = extremeInsertionIndex(nums, target, false) - 1;
        return targetRange;
    }

    public static int myAtoi(String str) {
        int len = str.length();
        int index = 0;
        while (index < len) {
            if (str.charAt(index) != ' ') {
                break;
            }
            index++;
        }
        if (index == len) {
            return 0;
        }
        int sign = 1;
        char firstChar = str.charAt(index);
        if(firstChar == '+') {
            index++;
            sign = 1;
        } else if (firstChar == '-') {
            index++;
            sign = -1;
        }
        int result = 0;
        while (index < len) {
            char curChar = str.charAt(index);
            if (curChar > '9' || curChar < '0') {
                break;
            }
            if (result > Integer.MAX_VALUE / 10 ||
                    (result == Integer.MAX_VALUE / 10 && (curChar - '0')
                    > Integer.MAX_VALUE % 10)) {
                return Integer.MAX_VALUE;
            }
            if (result < Integer.MIN_VALUE / 10 ||
                    (result == Integer.MIN_VALUE / 10 && (curChar - '0')
                            > -(Integer.MIN_VALUE % 10))) {
                return Integer.MIN_VALUE;
            }
            result = result * 10 + sign * (curChar - '0');
            index++;
        }
        return result;
    }

    public static String addBinary(String a, String b) {
        StringBuilder s = new StringBuilder();
        int carry = 0;
        for (int i = a.length() - 1, j = b.length() - 1;
             i >= 0 || j >= 0; i--, j--) {
            int sum = carry;
            sum += i >= 0 ? a.charAt(i) - '0' : 0;
            sum += j >= 0 ? b.charAt(j) - '0' : 0;
            s.append(sum % 2);
            carry = sum / 2;
        }
        s.append(carry == 1 ? carry : " ");
        return s.reverse().toString();
    }

    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if(nums[j] == target - nums[i]) {
                    return new int[] {i, j};
                }
            }
        }
        throw new IllegalArgumentException("无法得到结果");
    }
}