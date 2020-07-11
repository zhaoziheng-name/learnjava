package java_0711;

public class ExchangeMoney {
    public static void main(String[] args) {
        // 穷人要掏的钱
        int n = 300;
        double m = 0;
        int sum = 0;
        // 富翁要掏的钱
        // 第一天一分钱,所以从 0 开始
        for (int i = 0; i < 30; i++) {
            m = Math.pow(2, i);
            sum += m;
        }
        System.out.println(n + " " + sum);
    }
}
