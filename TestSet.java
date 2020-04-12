package java_0412;

import java.util.*;

public class TestSet {
//    public static void main(String[] args) {
//        // 1. 实例化 Set
//        Set<String> set = new HashSet<>();
//        // 2. 往 set 中插入元素
//        set.add("hello");
//        set.add("world");
//        set.add("java");
//        // 3. 判断某个元素是否存在
//        System.out.println(set.contains("world"));
//        // 4. 删除某个值
//        set.remove("world");
//        System.out.println(set.contains("world"));
//        // 5. 遍历打印 set
//        // System.out.println(set);
//        // 如果要循环遍历 set 中的元素,就要使用迭代器
//        // 迭代器的泛型参数,要和集合类中保存的元素参数保持一致
//        System.out.println("=============================");
//        Iterator<String> iterator = set.iterator();
//        while (iterator.hasNext()) {
//            String next = iterator.next();
//            System.out.println(next);
//        }
//    }

    // {1, 1, 2, 2, 3, 3, 4, 4, 5}
    public static int singleNumber(int[] nums) {
        Arrays.sort(nums);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums.length - 1; i++) {
            stack.push(nums[i]);
            int ret = nums[i + 1];
            if (nums[i] == ret) {
                stack.pop();
                i++;
            }
        }
        if (stack.isEmpty()) {
            return nums[nums.length - 1];
        } else {
            return stack.peek();
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 5, 4, 1, 2, 3, 4};
        int result = singleNumber(arr);
        System.out.println(result);
    }
}
