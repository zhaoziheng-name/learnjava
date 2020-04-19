package java_0419;

class  Cat {
    private String name;

    public Cat() {
        this.name = "小猫";
    }

    public Cat(String name) {
        this.name = name;
    }

    public void eat(String food) {
        System.out.println(this.name + " 正在吃 " + food);
    }
}

public class TestReflect {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        // 1. 获取类对象
        // 1) 通过字符串来获取类,参数是类的全限定类名
        // catClass 就是 Cat 类的图纸,里面描述了 Cat 类的内部构造
//        Class catClass = Class.forName("java_0419.Cat");
//
//        // 2) 通过实例来获取,实例的 getClass 方法获取到类对象
//        Cat cat = new Cat("小黑");
//        Class catClass2 = cat.getClass();
//
//        // 得到的类对象在内存中只有一份
//        System.out.println(catClass == catClass2);
//
//        // 3) 通过类来获取
//        Class catClass3 = Cat.class;
//        System.out.println(catClass == catClass3);

        // 2. 通过类对象来创建实例
        // 平时创建实例都是通过 new
        // catClass 表示 Cat 类的类对象
        // 下面这个代码运行时会抛出异常,因为 Cat 类没有提供无参数的构造方法
        // 直接实例化就会出现问题
        Class catClass = Class.forName("java_0419.Cat");
        Cat cat = (Cat) catClass.newInstance();
        cat.eat("鱼");
    }
}
