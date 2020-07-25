package java_0725;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class TheMax {
    static class People {
        private int weight;
        private int height;

        public People(int weight, int height) {
            this.weight = weight;
            this.height = height;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            People[] array = new People[n];
            for (int i = 0; i < n; i++) {
                int index = scanner.nextInt();
                array[index - 1] = new People(scanner.nextInt(), scanner.nextInt());
            }
            Arrays.sort(array, new Comparator<People>() {
                @Override
                public int compare(People o1, People o2) {
                    int result = Integer.compare(o1.height, o2.height);
                    if (result != 0) {
                        return result;
                    } else {
                        return Integer.compare(o1.weight, o2.weight);
                    }
                }
            });
            int max = Integer.MIN_VALUE;
            int[] dp = new int[n];
            for (int i = 0; i < dp.length; i++) {
                dp[i] = 1;
                for (int j = i - 1; j >= 0; j--) {
                    if (array[i].weight > array[j].weight || array[i].weight == array[j].weight
                    && array[i].height == array[j].height) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
                max = Math.max(dp[i], max);
            }
            System.out.println(max);
        }
    }
}
