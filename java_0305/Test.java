package java_0305;

public class Test {
    public static void main(String[] args) {
//        Animal animal = new Animal("小动物");
//        animal.eat("爆米花");

//         动态绑定 bird.eat 执行效果是要在运行时看 bird 到底对应的是啥类型的对象
//        animal = new Bird("圆圆");
//        animal.eat("谷子");

        // 向下转型
        Animal animal = new Bird("圆圆");
        Bird bird = (Bird)animal;
        bird.fly();
//        animal.eat("谷子");
    }
}
