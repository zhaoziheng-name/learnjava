package java_0917;

public class isPowerOfTwo {
    /**
     * 如果n是2的幂，则返回true，否则返回false
     * @param n int整型 n
     * @return bool布尔型
     */
    public boolean isPowerOfTwo (int n) {
        if (n <= 0) {
            return false;
        }
        if (n == 1) {
            return true;
        }
        while (n % 2 == 0) {
            n /= 2;
        }
        if (n == 1) {
            return true;
        } else {
            return false;
        }
    }
}