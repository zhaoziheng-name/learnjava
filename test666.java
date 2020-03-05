package Practice;

class Person {
    private String name;
    private int age;
    private  String sex;
    private static int count = 0;

    public Person() {
        System.out.println("我是构造方法");
    }
    
    // 实例代码块
    {
        this.name = "bit";
        this.age = 12;
        this.sex  = "man";
        System.out.println("我是实例代码块");
    }

    static {
        count = 10;
        System.out.println("我是静态代码");
    }

    public void show() {
        System.out.println("name: "+name+" age: "+age+" sex: "+sex);
    }
}

public class test666 {
    public static void main(String[] args) {
        // 静态代码只会执行一次, 然后是实例, 然后是构造方法
        Person p1 = new Person();
        Person p2 = new Person();
    }
}
