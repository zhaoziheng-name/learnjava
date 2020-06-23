package gc.log;

/**
 * JVM参数如下:
 * -XX:+PrintGCDetails -XX:+UseSerialGC -Xms20M -Xmx20M -Xmn10M -XX:SurvivorRatio=8
 * 堆：20m，新生代10m，eden8m，s区1m，t区10m
 */
public class EdenAllocate {
    private static final int _1MB = 1024 * 1024;

    public static void testAllocation() {
        byte[] allocation1, allocation2, allocation3, allocation4;
        allocation1 = new byte[2 * _1MB];
        allocation2 = new byte[2 * _1MB];
        allocation3 = new byte[2 * _1MB];
        // 出现Minor GC：对应的GC日志是[GC 或者[Full GC
        //回收前：allocation1，2，3在e区
        //回收后：1，2，3在老年代
        allocation4 = new byte[4 * _1MB];
        //allocation4对象创建好以后，gc日志信息为：Heap ...
    }

    public static void main(String[] args) throws Exception {
        testAllocation();
    }
}