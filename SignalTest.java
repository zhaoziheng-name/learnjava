package java_0523;

// 假设:
// 1. 面包店有 5 个面包师傅可以一直做面包,每次做三个
// 2. 有 20 个消费者要购买面包,每次购买一个
// 3. 面包店库存的上限是 100 个

public class SignalTest {

    // 表示库存
    private static int SUM = 0;

    public static void main(String[] args) {
        // 5 个面包师傅同时启动
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                try {
                    while (true) {
                        synchronized (SignalTest.class) {
                            if (SUM + 3 > 100) {
                                SignalTest.class.wait();
                            } else {
                                SUM += 3;
                                System.out.println(Thread.currentThread().getName() + "做了面包,库存:" + SUM);
                                Thread.sleep(500);
                                SignalTest.class.notify();
//                                SignalTest.class.notifyAll();
                            }
                        }
                        Thread.sleep(200);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            },"面包师傅[" + i + "]").start();
        }

        // 20 个消费者同时启动
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                try {
                    while (true) {
                        synchronized (SignalTest.class) {
                            if (SUM == 0) {
                                SignalTest.class.wait();
                            } else {
                                SUM--;
                                System.out.println(Thread.currentThread().getName() + "购买了面包,库存" + SUM);
                                Thread.sleep(500);
//                                SignalTest.class.notify();
                                SignalTest.class.notifyAll();
                            }
                        }
                        Thread.sleep(200);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            },"消费者[" + i + "]").start();
        }
    }
}
