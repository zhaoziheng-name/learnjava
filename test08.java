public class test08 {
    public static void main(String[] args) {
        Person p1 = new Person();
        p1.show();
        Person p2 = new Person("zhangfei", 80, "男");
        p2.show();
    }
}

class Person {
    private String name;
    private int age;
    private String sex;

    public Person() {
        this.name = "caocao";
        this.age = 18;
        this.sex = "男";
    }

    public Person(String name, int age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void show() {
        System.out.println("name: "+name+" age: "+age+" sex: "+sex);
    }
}