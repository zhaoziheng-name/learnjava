package Java_0213;

public class Test {
    public static void main(String[] args) {
        String id = "20000";
        Student student = new Student(id, "李四", 4.5);
//        student.id = "10000";
//        student.name = "张三";
//        student.score = 5.0;
//        student.setId("20000");
//        student.print();
        System.out.println(student.getId());
    }
}