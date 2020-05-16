package java_0516;

public class JoinTest {

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            try {
                Thread.sleep(3000);
                System.out.println("Thread Baby");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t.start();
        t.join();
        System.out.println("main");
    }
}
