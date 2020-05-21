package java_0521;

public class VolatileTest {

    private static volatile int SUM;

    public static void increment(int n) {
        // 分解为三条指令
        // 1. 从主内存读取 SUM 到工作内存
        // 2. 在工作内存中修改 SUM 的值为 SUM + 1
        // 3. 写回主内存

        SUM++;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                for (int j = 0; j < 10000; j++) {
                    increment(j);
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
