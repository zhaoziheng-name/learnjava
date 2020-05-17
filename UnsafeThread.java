package java_0517;

// 有一个共享变量,初始为 0, 启动 20 个线程,每个线程循环 10000 次,每次循环将共享变量++
public class UnsafeThread {

    private static int SUM;

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                for (int j = 0; j < 10000; j++) {
                    SUM++;
                }
            }).start();
        }
        // 所有子线程执行完毕之后,打印 SUM 的值
        while (Thread.activeCount() > 1) { // idea 使用 debug 运行,要用 run 的话,改为 > 2
            // 当前线程(main线程)由运行态转换为就绪态
            Thread.yield();
        }
        System.out.println(SUM);
    }
}
