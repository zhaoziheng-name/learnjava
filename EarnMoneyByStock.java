package java_0711;

public class EarnMoneyByStock {
    public int calculateMax(int[] prices) {
            int firstBuy = Integer.MIN_VALUE, firstSell = 0;
            int secondBuy = Integer.MIN_VALUE, secondSell = 0;
            for (int curPrice : prices) {
                firstBuy = Math.max(firstBuy, -curPrice);
                firstSell = Math.max(firstSell, firstBuy + curPrice);
                secondBuy = Math.max(secondBuy,firstSell - curPrice);
                secondSell = Math.max(secondSell, secondBuy + curPrice);
            }
            return secondSell;

//        if (prices == null || prices.length < 2)
//            return 0;
//        int len = prices.length;
//        int[] left = new int[len];
//        left[0] = 0;
//        int min = prices[0];
//        int max = 0;
//        for (int i = 1; i < len; i++) {
//            if (prices[i] < min)
//                min = prices[i];
//            if (prices[i] - min > max)
//                max = prices[i] - min;
//            left[i] = max;
//        }
//        int[] right = new int[len];
//        right[0] = 0;
//        int high = prices[len - 1];
//        max = 0;
//        for (int i = len - 2; i >= 0; i--) {
//            if (prices[i] > high)
//                high = prices[i];
//            if (high - prices[i] > max)
//                max = high - prices[i];
//            right[i] = max;
//        }
//        int result = 0;
//        for (int i = 0; i < len; i++) {
//            if (left[i] + right[i] > result)
//                result = left[i] + right[i];
//        }
//        return result;
    }
}
