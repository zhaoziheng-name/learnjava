package java_0516;

public class MultiThreadVSSingleThread {

    private static int sum;

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                sum++;
            }).start();
        }

        for (int i = 0; i < 20; i++) {
            sum++;
        }
    }
}
