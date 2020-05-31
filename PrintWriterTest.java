package java_0530;

import org.junit.Assert;
import org.junit.Test;

import java.io.PrintWriter;
import java.io.StringWriter;

public class PrintWriterTest {

    @Test
    public void t1() {
        try {
            int i = 1 / 0;
            System.out.println("1 / 0");
        } catch (Exception e) {
            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            e.printStackTrace(printWriter);
            System.out.println(stringWriter.toString());
        }
        System.out.println("t1");
    }
}
