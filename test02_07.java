import java.time.Period;

public class test02_07 {
    public static void main(String[] args) {
        Person person = new Person();
        System.out.println(person.age);
        System.out.println(person.name);
        System.out.println(person.count);
        System.out.println(person.COUNT);
        Person.staticTest();
        person.eat();
        person.sleep();
//        TestDemo.change();
//        System.out.println(TestDemo.count);
//        TestDemo t1 = new TestDemo();
//        t1.a++;
//        TestDemo.count++;
//        System.out.println(t1.a);
//        System.out.println(TestDemo.count);
//        System.out.println("============");
//        TestDemo t2 = new TestDemo();
//        t2.a++;
//        TestDemo.count++;
//        System.out.println(t2.a);
//        System.out.println(TestDemo.count);
//        Person person = new Person();
//        person.eat();
//        person.sleep();
//        Person person2 = new Person();
//        Person person3 = new Person();
    }
}
class TestDemo {
    public int a;
    public static int count;
    public static void change() {
        count = 100;
    }
}
class Person {
    public int age;
    public String name;
    public String sex;
    public static int count;
    public final int SIZE = 10;
    public static final int COUNT = 99;
    public void eat() {
        int a = 10;
        System.out.println("吃饭()!");
    }
    public void sleep() {
        System.out.println("睡觉()!");
    }
    public static void staticTest() {
        System.out.println("staticTest()");
    }
}