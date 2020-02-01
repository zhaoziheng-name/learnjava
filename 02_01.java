import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

public class test {
    public static void main(String[] args) {
//        int x = 10;
//        double y = 1.5;
//        x = (int)y;
//        System.out.println(x);
//        byte a = 10;
//        byte b = 20;
//        byte c =(byte) (a + b);
//        int num = 10;
//        String str1 = num + "";
//        String str2 = String.valueOf(num);
//        String str = "100";
//        int num = Integer.parseInt(str);
//        int a = 10;
//        int b = 20;
//      int c = 30;
//        b = a + b;
//        a = b - a;
//        b = b - a;
//        System.out.println("a =" + a);
//        System.out.println("b =" + b);
        int a = 10;
        int b = 20;
        int c = 30;
        if(a < b) {
            int tmp = a;
            a = b;
            b = tmp;
        }
        if(b < c) {
            int tmp = b;
            b = c;
            c = tmp;
        }
        if(a < b) {
            int tmp = a;
            a = b;
            b = tmp;
        }
        int MAX = a;
        int MIN = c;
        System.out.println("MAX = " + a);
        System.out.println("MIN = " + c);
    }
}