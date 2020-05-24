package java_0524;

// 三个线程: A, B, C
// 第一个只能打印 A, 第二个只能打印 B, 第三个只能打印 C
// 要求:
// 1. 三个线程同时执行
// 2. 打印结果: ABC

public class SequencePrint {

    public static void print1() {
        Thread t = new Thread(new Print("A", null));
        Thread t1 = new Thread(new Print("B", t));
        Thread t2 = new Thread(new Print("C", t1));
        t.start();
        t1.start();
        t2.start();
    }

    public static void main(String[] args) {
        print1();
    }

    private static class Print implements Runnable{
        private String content;
        private Thread t;

        public Print(String content, Thread t) {
            this.content = content;
            this.t = t;
        }

        @Override
        public void run() {
            try {
                if (t != null) {
                    t.join();
                }
                System.out.print(content);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
