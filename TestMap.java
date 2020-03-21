package java_0321;

import java.util.HashMap;
import java.util.Map;

public class TestMap {
    public static void main(String[] args) {
        // 1. 创建 Map 实例,泛型参数有两个,第一个是 value 的类型,第二个是 key 的
        // key value 这种结构最主要的目的就是根据 key 找到对应的 value
        Map<String, String> map = new HashMap<>();
        // 2. 使用 size 获取元素个数(键值对的个数)
        System.out.println(map.size());
        // 3. 使用 isEmpty 查看是否为空
        System.out.println(map.isEmpty());
        // 4. 使用 put 方法把一些键值对存放进去
        map.put("及时雨", "宋江");
        map.put("玉麒麟", "卢俊义");
        map.put("智多星", "吴用");
        map.put("入云龙", "公孙胜");
        // 5. 使用 get 方法根据 key 来查找对应的 value,如果 key 不存在,则返回 null
        // getOrDefault 如果 key 不存在,返回默认值
        System.out.println(map.get("及时雨"));
        System.out.println(map.get("玉麒麟"));
        System.out.println(map.get("大刀"));
        System.out.println(map.getOrDefault("行者", "武松"));
        // 6. 通过 containsKey 和 containsValue 来判定某个值是否存在
        // containsKey 执行效率高而 containsValue 执行效率低
        System.out.println(map.containsKey("智多星"));
        System.out.println(map.containsValue("公孙胜"));
        // 7. 再次使用 isEmpty 和 size
        System.out.println(map.isEmpty());
        System.out.println(map.size());
        // 8. for each 遍历 Map 中的所有键值对
        // Entry : 表示一个"条目", 也就是一个键值对
        // Map.EntrySet 就是获取到所有键值对
        // Map 中的元素顺序和插入顺序无关. 取决于具体的实现方式.
        for (Map.Entry<String, String > entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
