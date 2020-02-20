package HomeWork;

import java.util.Arrays;

public class day7andday8 {
    public static void main(String[] args) {
//        int x = 10;
//        System.out.println(loop(x));
//        int[] arr = {9, 6, 5, 4, 2, 7};
//        sortArrayByParity(arr);
//        String str = Arrays.toString(arr);
//        System.out.println(str);
//        int[] arr = {1, 7, 3, 6, 5, 6};
//        System.out.println(pivotIndex(arr));
//        int[] arr = {9, 9, 9};
//        int[] newArr = plusOne(arr);
//        System.out.println(Arrays.toString(newArr));
        int[] arr = {1, 2, 3, 4};
        int ret = thirdMax(arr);
        System.out.println("thirdMax = " + ret);
    }

    public static int thirdMax(int[] nums) {
        long MIN = Long.MIN_VALUE;
        if (nums == null || nums.length == 0) {
            throw new  RuntimeException("数组为空数组");
        }
            int first = nums[0];
            long second = MIN;
            long third = MIN;
            for (int i = 0; i < nums.length; i++) {
                int cur = nums[i];
                if (cur == first || cur == second || cur == third) {
                    continue;
                }
                if (cur > first) {
                    third = second;
                    second = first;
                    first = cur;
                } else if (cur > second) {
                    third = second;
                    second = cur;
                } else if (cur > third) {
                    third = cur;
                }
            }
            if(third == MIN) {
                return first;
            }
            return (int)third;
    }

    public static int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if(digits[i] != 0) {
                return digits;
            }
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

    public static int pivotIndex(int[] nums) {
        int sum = 0;
        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            if(leftSum == sum - leftSum - nums[i]) {
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }

    public static int[] sortArrayByParity(int[] A) {
        int i = 0;
        int j = A.length - 1;
        while (i < j) {
            if(A[i] % 2 > A[j] % 2) {
                int tmp = A[i];
                A[i] = A[j];
                A[j] = tmp;
            }
            if (A[i] % 2 == 0) {
                i++;
            }
            if (A[j] % 2 == 1) {
                j--;
            }
        }
        return A;
    }

//    public static int[] sortArrayByParity(int[] A) {
//        int[] arr = new int[A.length];
//        int min = 0;
//        int max = A.length - 1;
//        for (int i : A) {
//            if(i % 2 == 0) {
//                arr[min++] = i;
//            } else {
//                arr[max--] = i;
//            }
//        }
//        return arr;
//    }

//    public static int[] sortArrayByParity(int[] A) {
//        int[] arr = new int[A.length];
//        int n = 0;
//        for (int i = 0; i < A.length; i++) {
//            if(A[i] % 2 == 0) {
//                arr[n++] = A[i];
//            }
//        }
//        for (int i = 0; i < A.length; i++) {
//            if(A[i] % 2 != 1) {
//                arr[n++] = A[i];
//            }
//        }
//        return arr;
//    }

//    public static void loop() {
//        int x = 10;
//        while (x) {
//            System.out.println("x minus one is " + (x - 1));
//            x -= 1;
//        }
//    }
}