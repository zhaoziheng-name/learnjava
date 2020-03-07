package java_0307.animal;

public class Insect extends Animal implements IFlying, IRunning{
    public Insect(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println(this.name + " 使用六条腿跑 ");
    }

    @Override
    public void fly() {
        System.out.println(this.name + " 正在使用翅膀飞 ");
    }
}
