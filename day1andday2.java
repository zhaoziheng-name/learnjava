package HomeWork;

public class day1andday2 {
    public static void main(String[] args) {
//        mystery(1234);
//        System.out.println(toLowerCase("WELCOME TO BIT!!!"));
//        int[] arr = {1, 2, 3, 4, 5, 6, 7};
//        rotate(arr, 3);
//        System.out.print("[");
//        for (int i = 0; i < arr.length; i++) {
//            System.out.print(arr[i] + ", ");
//        }
//        System.out.println("]");
//        System.out.println(getValue(2));
//        int[] arr = {1, 2, 3, 4, 5, 6, 7, 5, 6};
//        System.out.println(removeElement(arr, 6));
        int[] arr = {1, 3, 4, 5, 6};
        System.out.println(searchInsert(arr, 2));
    }

    public static int searchInsert(int[] nums, int target) {
        int len = nums.length;
        if(len == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public static int removeElement(int[] nums, int val) {
        int i = 0;
        int n = nums.length;
        while(i < n) {
            if(nums[i] == val) {
                nums[i] = nums[n - 1];
                n--;
            } else {
                i++;
            }
        }
        return n;
    }

    public static int getValue(int i) {
        int result = 0;
        switch (i) {
            case 1:
                result = result + i;
            case 2:
                result = result + i * 2;
            case 3:
                result = result + i * 3;
        }
        return result;
    }

    public static void rotate(int[] nums, int k) {
        int[] arr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[(i + k) % nums.length] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = arr[i];
        }
    }

    public static String toLowerCase(String str) {
        char[] Str = str.toCharArray();
        for (int i = 0; i < Str.length; i++) {
            if(Str[i] <= 'Z' && Str[i] >= 'A') {
                Str[i] = (char)(Str[i] + 32);
            }
        }
        return String.copyValueOf(Str);
    }

    public static void mystery(int x) {
        System.out.println(x % 10);
        if((x / 10) != 0) {
            mystery(x / 10);
        }
        System.out.println(x % 10);
    }
}