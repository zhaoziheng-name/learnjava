package java_0626;

public class AnnoyingRabbit {
    public static void main(String[] args) {
        System.out.println(getTotalCount(100));
    }
    // 递归
//    public static int getTotalCount(int monthCount) {
//        if (monthCount == 1)
//            return 1;
//        if (monthCount == 2)
//            return 1;
//        return getTotalCount(monthCount - 1) + getTotalCount(monthCount - 2);
//    }
    // 非递归
    public static int getTotalCount(int monthCount) {
        if (monthCount < 1) {
            return 0;
        } else if (monthCount == 1 || monthCount == 2) {
            return 1;
        }
        int res = 1;
        int pre = 1;
        int tmp = 0;
        for (int i = 3; i <= monthCount; i++) {
            tmp = res;
            res = tmp + pre;
            pre = tmp;
        }
        return res;
    }
}
