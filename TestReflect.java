package java_0419;

import javax.tools.JavaCompiler;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

class Animal {
    public void eat (String food) {

    }
}

class Cat extends Animal {
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

class Bird extends Animal {
    private String name;

    public Bird() {
        name = "小鸟";
    }

    public void eat(String food) {
        System.out.println(this.name + " 正在吃 " + food);
    }
}

public class TestReflect {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException {
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
//        Scanner scanner = new Scanner(System.in);
////        String classname = scanner.next();
////        System.out.println("您要创建的实例类型为: " + classname);
////
////        Class catClass = Class.forName(classname);
////        Animal animal = (Animal) catClass.newInstance();
////        animal.eat("鱼");

        // 3.通过反射来获取/修改属性(可以修改 private 的属性)
//        Class catClass = Class.forName("java_0419.Cat");
//        // Cat 类中包含 name 属性, private 的属性.
//        // 通过 getDeclaredField 可以得到局部内容.通过 Field 对象来表示
//        Field field = catClass.getDeclaredField("name");
//        // 这行代码加上之后,才能访问 private 的成员
//        field.setAccessible(true);
//
//        Cat cat = new Cat();
//        String name = (String) field.get(cat);
//        System.out.println(name);

        // 4. 通过反射获取到类中的方法
//        Class catClass = Class.forName("java_0419,Cat");
//        // 根据 catClass 图纸找到 Cat 类中的 eat 方法
//        // 下面这个方法是要获取到只有一个参数,且参数类型为 String 的 eat 方法
//        Method method = catClass.getMethod("eat", String.class);
//
//        Cat cat = new Cat();
//        method.invoke(cat, "猫粮");

        // 5. 获取构造方法,借助构造方法来实例化对象
        Class catClass = Class.forName("java_0419.Cat");
        // 获取到 Cat 类中,只有一个参数且类型为 String 的构造方法
        Constructor constructor = catClass.getConstructor(String.class);
        Cat cat = (Cat) constructor.newInstance("小黑");
        cat.eat("鱼");
    }
}
