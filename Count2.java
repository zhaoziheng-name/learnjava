package java_0708;

public class Count2 {
    public int countNumberOf2s(int n) {
        int div = 1;
        int count = 0;
        while (n / div != 0) {
            int num = n / div;
            int cur = num % 10;
            int high = num / 10;
            int low = n % div;
            if (cur < 2) {
                count += high * div;
            } else if (cur == 2) {
                count += high * div + (low + 1);
            } else {
                count += (high + 1) * div;
            }
            if (n / div < 20) {
                break;
            }
            div *= 10;
        }
        return count;
    }
}
