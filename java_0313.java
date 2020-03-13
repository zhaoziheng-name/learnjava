public class java_0313 {
    public static void main(String[] args) {
        String str = "hello worldwor";
        String str2 = "wor";
        System.out.println(str.indexOf(str2));
        System.out.println(str.lastIndexOf(str2));

//        byte[] data = str.getBytes();
//        for (int i = 0; i < data.length; i++) {
//            System.out.println(data[i] + " ");
//        }

        // 是否全部由数字组成
        //String str = "12345";
//        String str = "123a";
//        System.out.println(isNumber(str));

//        String str = "hello world";
//        String str2 = str.replace("l", "-");
//        System.out.println(str);
//        System.out.println(str2);

//        String str = "hello";
//        str = str + "world";
//        str += "!!!";
//        System.out.println(str);

        // 替换第一个字母
//        String str = "hello";
//        str = 'H' + str.substring(1);
//        System.out.println(str);

//        String str = "hello world";
//        char[] data = str.toCharArray();
//        for (int i = 0; i < data.length; i++) {
//           System.out.println(data[i] + " ");

           // 部分转换
            //System.out.println(new String(data, 5, 5));
        //}
    }

    private static boolean isNumber(String str) {
        char[] data = str.toCharArray();
        for (int i = 0; i < data.length; i++) {
            if (data[i] < '0' && data[i] > '9') {
                return false;
            }
        }
        return true;
    }
}

//class Father {
//    int num = 30;
//
//    public void show() {
//        int num = 40;
//        System.out.println(num);
//    }
//}

//class Son extends Father {
//    int num = 20;
//    public void show() {
//        int num = 10;
//        // 希望打印10
//        System.out.println(num);
//        // 希望打印20
//        System.out.println(this.num);
//        // 希望打印30
//        System.out.println(super.num);
//        // 希望打印40
//        super.show();
//    }
//}
