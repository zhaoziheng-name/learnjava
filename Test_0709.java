package java_0709;

public class Test_0709 {
    public static void main(String[] args) {
        StringBuffer stringBuffer = new StringBuffer("helloworld");
        System.out.println(stringBuffer.delete(5, 10).insert(0, "nihao"));
//        stringBuffer.append("Hello").append("World");
//        fun(stringBuffer);
//        System.out.println(stringBuffer);
//        System.out.println(firstUpper("yuisama"));
//        System.out.println(firstUpper(""));
//        System.out.println(firstUpper("a"));
//        System.out.println("hello".isEmpty());
//        System.out.println("".isEmpty());
//        System.out.println(new String().isEmpty());
//        String str = "   hello%$$%@#$%world 哈哈哈   ";
//        System.out.println(str.length());
//        System.out.println("[" + str + "]");
//        System.out.println("[" + str.trim() + "]");
//        System.out.println(str.substring(5));
//        System.out.println(str.substring(0, 5));
//        String str = "name=zhangsan&age = 18";
//        String[] result = str.split("&");
//        for (int i = 0; i < result.length; i++) {
//            String[] tmp = result[i].split("=");
//            System.out.println(tmp[0] + " = " + tmp[1]);
//        }
//        String str = "12234";
//        System.out.println(isNumber(str));
//        String str = "hello world hello bit";
//        String[] result = str.split(" ", 2);
//        for (String s : result) {
//            System.out.println(s);
//        }
//        String str1 = str.replaceFirst("l", "_");
//        str 还是 helloworld, 因为字符不可变
//        System.out.println(str);
//        System.out.println(str1);
//        System.out.println(str.indexOf("world"));
//        System.out.println(str.indexOf("bit"));
//        if (str.indexOf("hello") != -1) {
//            System.out.println("YES!");
//        }
//        String[] result = str.split(" ");
//        for (String s : result) {
//            System.out.println(s);
//        }
    }

    private static void fun(StringBuffer tmp) {
        tmp.append("\n").append("www.bit.com.cn");
    }

    private static String firstUpper(String str) {
        if ("".equals(str) || str == null) {
            return str;
        }
        if (str.length() > 1) {
            str = str.substring(0, 1).toUpperCase() + str.substring(1);
        }
        return str;
    }

    public static boolean isNumber(String str) {
        char[] data = str.toCharArray();
        for (int i = 0; i < data.length; i++) {
            if (data[i] < '0' || data[i] > '9') {
                return false;
            }
        }
        return true;
    }
}
