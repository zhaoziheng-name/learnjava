package java_0920;

public class MaxAdd {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param nums int整型一维数组 给定一个整数数组 nums
     * @return int整型
     */
    public int maxSubArray (int[] nums) {
        int[] dp = new int[nums.length];
        // 初始化最大和
        int sum = nums[0];
        dp[0] = sum;
        for (int i = 1; i < nums.length; i++) {
            // 取当前元素的值和当前元素的值加上之前的结果二者中较大的
            dp[i] = Math.max(nums[i], nums[i] + dp[i - 1]);
            // 和最大数作比较, 取较大的
            sum = Math.max(sum, dp[i]);
        }
        return sum;
    }
}
