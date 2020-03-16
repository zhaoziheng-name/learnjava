package java_0316;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test_0316 {
    public static void main(String[] args) {
        // 插入操作
//        StringBuilder stringBuilder = new StringBuilder("abcd");
//        stringBuilder.insert(1, "hehe");
//        System.out.println(stringBuilder);

        // 删除操作
//        StringBuilder stringBuilder = new StringBuilder("abcd");
//        stringBuilder.delete(1, 2);
//        System.out.println(stringBuilder);

        // 针对 String 往下标 1 的位置插入一个 hehe
//        String str = "abcd";
//        String result = str.substring(0, 1) + "hehe" + str.substring(1);
//        System.out.println(result);

        // 针对 String 删除 [1, 2) 范围内的内容
        String str = "abcd";
        String result = str.substring(0, 1) + str.substring(2);
        System.out.println(result);
    }
}

class Solution {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList();
        int len = nums.length;
        if (nums == null || len < 3) {
            return ans;
        }
        Arrays.sort(nums);
        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int L = i + 1;
            int R = len - 1;
            while (L < R) {
                int sum = nums[i] + nums[L] + nums [R];
                if (sum == 0) {
                    ans.add(Arrays.asList(nums[i], nums[L], nums[R]));
                    while (L < R && nums[L] == nums[L + 1]) {
                        L++;
                    }
                    while (L < R && nums[R] == nums[R + 1]) {
                        R--;
                    }
                    L++;
                    R--;
                } else if (sum < 0) {
                    L++;
                } else if (sum > 0) {
                    R--;
                }
            }
        }
        return ans;
    }
}
