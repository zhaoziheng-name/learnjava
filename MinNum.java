package java_0617;

import java.util.Scanner;

public class MinNum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int[] nums = new int[10];
            for (int i = 0; i < 10; i++) {
                nums[i] = scanner.nextInt();
            }
            System.out.println(GetNum(nums));
        }
    }

    private static String GetNum(int[] nums) {
        String s = "";
        for (int i = 1; i < 10; i++) {
            if (nums[i] != 0) {
                s += i;
                nums[i]--;
                break;
            }
        }
        for (int i = 0; i < 10; i++) {
            while (nums[i] != 0) {
                s += i;
                nums[i]--;
            }
        }
        return s;
    }
}
