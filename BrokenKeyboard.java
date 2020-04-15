package java_0415;

import java.util.*;

public class BrokenKeyboard {
    public static void main(String[] args) {
        // 判定预期输出的哪些字符在实际输出中没有出现
        // 先建一个 Set 把实际输出的每个字符都放进去,然后遍历预期输出字符串
        // 看看哪个字符在这个 Set 中不存在,就是要找到的
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            // 1. 先循环读入两个字符串.第一个字符串是预期输出的内容,第二个是实际输出
            String expected = scanner.next();
            String actual = scanner.next();
            // 2. 把读入的两个字符串全都转成大写
            expected = expected.toUpperCase();
            actual = actual.toUpperCase();
            // 3. 创建一个 Set 保存实际输出的字符
            Set<Character> actualSet = new HashSet<>();
            for (int i = 0; i < actual.length(); i++) {
                // Set 中的元素不能重复,如果 add 的时候发现元素已经存在,add 就失败了
                // 没有任何负面影响
                actualSet.add(actual.charAt(i));
            }
            // 4. 遍历预期输出字符串,看看那个字符没有被实际输出
            Set<Character> brokenKeySet = new HashSet<>();
            for (int i = 0; i < expected.length(); i++) {
                char c = expected.charAt(i);
                if (actualSet.contains(c)) {
                    // 当前字符已经被输出了
                    continue;
                }
                // 还要考虑去重的问题
                if (brokenKeySet.contains(c)) {
                    continue;
                }
                System.out.print(c);
                brokenKeySet.add(c);
            } // end for
        } // end while
    }

    static class MyComparator implements Comparator<String> {
        private Map<String, Integer> map;

        public MyComparator(Map<String, Integer> map) {
            this.map = map;
        }

        @Override
        public int compare(String o1, String o2) {
            int count1 = map.get(o1);
            int count2 = map.get(o2);
            if (count1 == count2) {
                // String 自身也实现了 Comparable,自带字典序的比较
                // compareTo 就是在使用 String 默认的比较规则
                return o1.compareTo(o2);
            }
            // o1 < o2 返回 < 0
            // o1 == o2 返回 0
            // o1 > o2 返回 > 0
            // count1 - count2 升序排序
            // count2 - count1 降序排序
            return count2 - count1;
        }
    }

    public List<String> toKFrequent(String[] words, int k) {
        // 1. 先统计每个单词出现的次数
        Map<String, Integer> map = new HashMap<>();
        for (String s : words) {
            Integer count = map.getOrDefault(s, 0);
            map.put(s, count + 1);
        }
        // 2. 把刚才这里的统计到的字符串放到 ArrayList 中
        // keySet 相当于得到了一个 Set, Set 中存放的就是所有的 key
        ArrayList<String> arrayList = new ArrayList((map.keySet()));
        // 3. 按照刚才字符串出现的次数,针对 arrayList 进行排序
        // 这里的 sort 是升序排序,不可取
        // 我们需要降序,需要通过比较器自定制比较规则
        Collections.sort(arrayList, new MyComparator(map));
        return arrayList.subList(0, k);
    }
}
