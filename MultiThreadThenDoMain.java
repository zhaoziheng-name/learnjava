package java_0516;

// 同时运行多个线程,等所有执行完毕,再执行 main 后面的方法
public class MultiThreadThenDoMain {

    public static void main(String[] args) throws InterruptedException {
        // 目前的结果: main 先打印, 0-19 随机同时打印
        // 期望结果: 先打印 0-19,随机打印.全部打印完,再打印 main
//        for (int i = 0; i < 20; i++) {
//            final int j = i;
//            new Thread(() -> {
//                System.out.println(j);
//            }).start();
//        }
//        System.out.println("main");

        Thread[] threads = new Thread[20];
        for (int i = 0; i < 20; i++) {
            final int j = i;
            Thread t = new Thread(() -> {
                System.out.println(j);
            });
            t.start();
            threads[i] = t;
        }
        for (int i = 0; i < 20; i++) {
            threads[i].join();
        }
        System.out.println("main");
    }
}
