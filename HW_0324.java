package java_0324;

public class HW_0324 {
//    public static boolean isAdmin(String userId) {
//        return userId.toLowerCase() == "admin";
//    }

//    String str = new String("good");
//    char[] ch = {'a', 'b', 'c'};
    public static void main(String[] args) {
//        System.out.println(isAdmin("Admin"));

//        HW_0324 ex = new HW_0324();
//        ex.change(ex.str, ex.ch);
//        System.out.print(ex.str + " and ");
//        System.out.print(ex.ch);

        String s1 = "abc" + "def";
        String s2 = new String (s1);
        System.out.println("执行.equals");
        if (s1.equals(s2)) {
            System.out.println(".equals succeeded");
        }
        System.out.println("执行==");
        if (s1 == s2) {
            System.out.println("== succeeded");
        }
    }

    public void change(String str, char[] ch) {
        str = "test ok";
        ch[0] = 'g';
    }
}
