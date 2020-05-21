package java_0521;

// 单例:在某些场景下,需要获取同一个对象
// 类加载在 JVM 内部执行,保证了线程之间是同步互斥的:
// (1) 只执行一次 (2) 线程安全

public class Sington {

    // 饿汉式:在类加载的时候,就创建对象
    public static Sington SINGTON = new Sington();

    private Sington() {}

    public static Sington getInstance() {
        return SINGTON;
    }

    // 懒汉式
    public static Sington SINGTON2;

    // 省略了构造方法

    // 懒汉式的写法存在很多线程安全问题:
    // 多行代码,并且存在需要分解的代码行 --> 不具有原子性和可见性
    public static Sington getInstance2() {
        if (SINGTON2 == null) {
            SINGTON2 = new Sington();
        }
        return SINGTON2;
    }

    // 懒汉式的多线程安全版本(考虑为啥效率低下)
    public static Sington SINGTON3;

    // 省略了构造方法,存在效率低下的问题

    public synchronized static Sington getInstance3() {
        if (SINGTON3 == null) {
            SINGTON3 = new Sington();
        }
        return SINGTON3;
    }

    // 双重校验锁的单例模式
    public static Sington SINGTON4;

    // 省略了构造方法

    public static Sington getInstance4() {
        if (SINGTON4 == null) {
            synchronized (Sington.class) {
                if (SINGTON4 == null) {
                    SINGTON4 = new Sington();
                    // 分解为三条指令
                    // 分配给对象的内存空间
                    // 初始化对象
                    // 对象赋值给变量(变量引用)
                }
            }
        }
        return SINGTON4;
    }
}
