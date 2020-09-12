package java_0912;

public class TheMaxCandy {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * M包糖果，抛M次硬币，硬币连续n次为正面，最多能得到多少颗糖果
     * @param candies int整型一维数组 每包糖果的数量
     * @param coin int整型一维数组 抛硬币的结果
     * @param n int整型 连续是正面的次数
     * @return int整型
     */
    public int maxCandies (int[] candies, int[] coin, int n) {
        int max = 0;
        int sum = 0;
        // 遍历 coin 数组, 当数组元素为 1 的时候, 记录下来
        // 将 n 个连续的数组的元素加起来, 获取最大值
        for (int i = 0; i < coin.length - n; i++) {
            for (int j = 1; j <= n; j++) {
                    max = max > candies[i] + candies[i + j] ? max : (candies[i] + candies[i + j]);
                    candies[i] = candies[i] + candies[i + j];
                }
        }
        for (int i = 0; i < candies.length; i++) {
            if (coin[i] == 0) {
                sum += candies[i];
            }
        }
        sum = sum + max;
        return sum;
    }
}
