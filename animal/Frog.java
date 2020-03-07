package java_0307.animal;

public class Frog extends Animal implements ISwimming, IRunning{
    public Frog(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println(this.name + " 一跳一跳 ");
    }

    @Override
    public void swim() {
        System.out.println(this.name + " 正在蛙泳 ");
    }
}
