package java_0305;

public class Bird extends Animal {
    public Bird(String name) {
        // 调用父类的构造方法
        super(name);
    }

    @Override
    public void eat(String food) {
        System.out.println("Bird.eat");
        System.out.println(this.name + " 正在吃 " + food);
    }

    public void fly() {
        System.out.println(this.name + " 使用翅膀正在飞 ");
    }
}
