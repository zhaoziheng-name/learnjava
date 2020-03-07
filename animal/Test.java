package java_0307.animal;

public class Test {
    public static void main(String[] args) {
        Frog frog = new Frog("小青蛙");
        walk(frog);
        swim(frog);

        Cat cat = new Cat("小猫");
        walk(cat);

        Insect insect = new Insect("小虫子");
        walk(insect);
        fly(insect);

        Robot robot = new Robot();
        walk(robot);

        Fish fish = new Fish("小鱼");
        swim(fish);
    }

    public static void walk(IRunning animal) {
        animal.run();
    }

    public static void fly(IFlying animal) {
        animal.fly();
    }

    public static void swim(ISwimming animal) {
        animal.swim();
    }
}
