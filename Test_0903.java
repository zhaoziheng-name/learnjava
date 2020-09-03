import java.util.Scanner;

public class Test_0903 {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        while (scanner.hasNext()) {
//            int n = scanner.nextInt(); // 纪念品件数
//            int m = scanner.nextInt(); // 最多能拿的重量
//            int k = scanner.nextInt(); // 预算
//            int[] price = new int[n]; // 价格
//            int[] weight = new int[n]; // 重量
//            int[] v = new int[n]; // 心动值
//            for (int i = 0; i < n; i++) {
//                price[i] = scanner.nextInt();
//                weight[i] = scanner.nextInt();
//                v[i] = scanner.nextInt();
//            }
//            System.out.println(getMax(n, m, k, price, weight, v));
//        }

        Scanner scanner = new Scanner(System.in);
        // 创建数组保存初始位置
        int[] position = new int[2];
        position[0] = scanner.nextInt();
        position[1] = scanner.nextInt();
        // 字符串保存输入的接下来要进行的移动
        String s2 = scanner.next();
        for (int i = 0; i < s2.length(); i++) {
            // 遍历移动指令的字符串,看接下来要向哪个方向移动
            if (s2.charAt(i) == 'U') {
                // 为 'U' 向上移动, y + 1
                position[1] = position[1] + 1;
            } else if (s2.charAt(i) == 'D') {
                // 为 'D' 向下移动, y - 1
                position[1] = position[1] - 1;
            } else if (s2.charAt(i) == 'L') {
                // 为 'L' 向左移动, x - 1
                position[0] = position[0] - 1;
            } else if (s2.charAt(i) == 'R') {
                // 为 'R' 向右移动, x + 1
                position[0] = position[0] + 1;
            }
        }
        System.out.println(position[0] + " " + position[1]);
    }

//    private static int getMax(int n, int m, int k, int[] price, int[] weight, int[] v) {
//        int[][] dp = new int[n + 1][m + 1];
//        for (int i = 1; i <= n; i++) {
//            for (int j = 1; j <= m; j++) {
//                if ()
//            }
//        }
//    }
}
