package Java_0213;

public class Student {
    // 成员变量/字段/属性
    private String id;
    private String name;
    private double score;

    public Student() {
        id = "10000";
        name = "张三";
        score = 5.0;
        System.out.println("执行构造方法");
    }

    public Student(String id, String name, double score) {
        this.id = id;
        this.name = name;
        this.score = score;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void print() {
        System.out.println("id: " + id
                + ", name: " + name
                + ", score: " + score);
    }
}