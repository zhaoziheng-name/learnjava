package java_0315;

public class Test_0315 {
    public static void main(String[] args) {
//        // 包含了四个单词,单词之间用空格分隔
//        String str = "hello:world::hehe:haha";
//        String[] result = str.split(":");
//        for (String x : result) {
//            System.out.println(x);
//        }
//        System.out.println("原来的字符串为:" + str);

        // 这种 IP 地址成为 "点分十进制"
        //String str = "192.168.1.0";
        // 没有在 str 中找到分隔符
        // "." 在正则表达式中是一种特殊符号,为了让 split 能识别出原字符串中的 "."
        // 需要用到转义字符(两个 \, 一个是在 Java 中进行转义, 一个是正则表达式中进行转义)
//        String[] result = str.split("\\.");
//        for (String x : result) {
//            System.out.println(x);
//        }

        // 双重切分
//        String str = "name=zhangsan&age=18&sex=male";
        // 先按照 & 切分字符串
//        String[] result = str.split("&");
//        for (String tmp : result) {
//            // 再按 "=" 切分
//            String[] tokens = tmp.split("=");
//            if (tokens.length != 2) {
//                continue;
//            }
//            System.out.println(tokens[0] + ": " + tokens[1]);
//        }

//        String str = "hello world";
//        System.out.println(str.substring(5));
//        // [beg, end)
//        System.out.println(str.substring(5, 7));

//        String str = "           hello    world         ";
//        System.out.println("[" + str.trim() + "]");

//        String str = "heLLo";
//        System.out.println(str.toUpperCase());
//        System.out.println(str.toLowerCase());
        // 如何让一个字符串首字母大写, 其他字母小写
        // 先处理首字母
//        String result = str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
//        System.out.println(result);

//        String str = null;
//        System.out.println(str.isEmpty());

        // String s = "hello";
        // s += "x";

        // stringBuilder 是可变对象, append 拼接字符串的时候修改的是对象本身
//        StringBuilder stringBuilder = new StringBuilder();
//        stringBuilder.append("hello");
//        stringBuilder.append("x");
//        stringBuilder.append("x");
//        stringBuilder.append("x");
//        stringBuilder.append("x");
//        stringBuilder.append("x");
        // 链式调用 stringBuilder.append
//        stringBuilder.append("hello").append("x").append("x").append("x");
//        System.out.println(stringBuilder);

        // 逆置一个字符串
//        StringBuilder stringBuilder = new StringBuilder("abcd");
        //stringBuilder.reverse();
        // 也支持链式调用
//        stringBuilder.reverse().reverse();
//        System.out.println(stringBuilder);

        // 插入删除操作
        StringBuilder stringBuilder = new StringBuilder("abcd");
        stringBuilder.insert(1, "hehe");
        System.out.println(stringBuilder);
    }
}
