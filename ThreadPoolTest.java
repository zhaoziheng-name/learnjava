package java_0528;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ThreadPoolTest {

    private static ExecutorService Fixed_Pool = Executors.newFixedThreadPool(4);

    private static ScheduledExecutorService Scheduled_Pool = Executors.newScheduledThreadPool(4);

    public static void runFixedThreadPool(Runnable task) {
        Fixed_Pool.execute(task);
    }

    public static void main(String[] args) {
        runFixedThreadPool(() -> {
            System.out.println("送快递到北京");
        });
        runFixedThreadPool(() -> {
            System.out.println("送快递到上海");
        });
        System.out.println("干自己的事");

        Scheduled_Pool.scheduleAtFixedRate(() -> { // 延迟多少秒后执行一次,再每间隔多少秒执行一次
            Date date = new Date();
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            System.out.println(dateFormat.format(date));
        }, 1, 1, TimeUnit.SECONDS);
        Scheduled_Pool.scheduleAtFixedRate(() -> {
            System.out.println("abc");
        }, 0, 2, TimeUnit.SECONDS);
    }
}
