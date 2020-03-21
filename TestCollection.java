package java_0321;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class TestCollection {
    public static void main(String[] args) {
        // 1. 创建 Collection
        Collection<String> collection = new ArrayList<>();
        // 2. 使用 size 方法
        System.out.println(collection.size());
        // 3. 使用 isEmpty
        System.out.println(collection.isEmpty());
        // 4. 使用 add 方法插入元素
        collection.add("我");
        collection.add("爱");
        collection.add("Java");
        // 5. 再次使用 size 和 isEmpty
        System.out.println(collection.size());
        System.out.println(collection.isEmpty());
        // 6. 可以用 toArray 把 collection 转换成数组
        Object[] array = collection.toArray();
        System.out.println(Arrays.toString(array));
        // 7. 可以直接用 for 循环遍历集合中的元素
        for (String s : collection) {
            // s 就会分别指向 collection 中的每一个元素
            System.out.println(s);
        }
        // 8. 使用 contains 方法判定元素是否存在
        System.out.println(collection.contains("我"));
        // 9. 使用 remove 来删除
        collection.remove("我");
        System.out.println("删除之后");
        for (String s : collection) {
            // s 就会分别指向 collection 中的每一个元素
            System.out.println(s);
        }
        // 9. 使用 clear 方法清空所有元素
        collection.clear();
        System.out.println("清空全部元素之后");
        System.out.println(collection.isEmpty());
        System.out.println(collection.size());
    }
}
