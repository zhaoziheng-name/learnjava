package java_0920;

public class ThirdMax {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param nums int整型一维数组
     * @return int整型
     */
    public int thirdMax (int[] nums) {
        double first = 0.001;
        double second = 0.001;
        double third = 0.001;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > first) {
                third = second;
                second = first;
                first = nums[i];
            } else if (nums[i] > second && nums[i] < first) {
                third = second;
                second = nums[i];
            } else if (nums[i] > third && nums[i] < second) {
                third = nums[i];
            }
        }
        if (third != 0.001) {
            return new Double(third).intValue();
        } else {
            return new Double(first).intValue();
        }
    }
}
