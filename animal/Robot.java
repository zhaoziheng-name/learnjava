package java_0307.animal;

public class Robot implements IRunning {
    public Robot() {
    }

    @Override
    public void run() {
        System.out.println("机器人在使用轮子跑");
    }
}
