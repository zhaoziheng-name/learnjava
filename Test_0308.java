package java_0308;

import java.lang.reflect.Field;

public class Test_0308 {
    public static void main(String[] args) {
//        String str = "hehe";
//        // Field 对象对应到某个对象中的一个具体字段
//        Field field = String.class.getDeclaredField("value");
//        // 由于 String 中的 value 这个字符数组是 private 的，不能直接访问
//        // 先把这个字段改成可访问的
//        field.setAccessible(true);
//        // 获取到 str 中的 value 数组的内容
//        char[] value = (char[])field.get(str);
//        value[0] = 'a';
//        System.out.println(str);

//        for (int i = 0; i < value.length; i++) {
//            System.out.println(value[i]);
//        }

        // 出现异常，after 不输出
//        int[] arr = {1, 2, 3};
//        System.out.println("before");
//        System.out.println(arr[100]);
//        System.out.println("after");

//        int[] arr = {1, 2, 3};
//        try {
//            System.out.println("before");
//            System.out.println(arr[100]);
//            System.out.println("after");
//        } catch (ArrayIndexOutOfBoundsException e) {
//            // 打印出异常的调用栈
//            e.printStackTrace();
//        }
//        System.out.println("捕捉到了异常");

        int[] arr = {1, 2, 3};
        try {
            System.out.println("before");
            arr = null;
            System.out.println(arr[100]);
            System.out.println("after");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("这是数组下标越界异常");
            e.printStackTrace();
        } catch (NullPointerException e) {
            System.out.println("这是空指针异常");
            e.printStackTrace();
        }
        System.out.println("捕捉到了异常");
    }
}
