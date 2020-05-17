package java_0517;

public class StopThreadTest {

    private volatile static boolean IS_STOP;

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            try {
                while (!IS_STOP) {
                    System.out.println(Thread.currentThread().getName());
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        Thread.sleep(3000);
        // 特殊情况出现,要中断子线程
        IS_STOP = true;
    }
}
