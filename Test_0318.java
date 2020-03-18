package java_0319;

public class Test {
    public static void main(String[] args) {
        StringBuffer stringBuffer = new StringBuffer("abcd");
        StringBuffer result = stringBuffer.insert(1, "hehe");
        System.out.println(result);
    }
}
