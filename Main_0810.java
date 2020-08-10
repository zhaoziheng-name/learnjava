import com.sun.org.apache.xpath.internal.operations.String;
import niko.Duck;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main_0810 {
    public static void main(String[] args) {
        // Spring 开启容器的方式: ApplicationContext 应用上下文(可以配置并管理 Bean 对象, 及其他的工作)
        // ClassPathXmlApplicationContext 根据 classpath 路径, 指定一个 xml 文件(配置文件),
        // 并根据配置文件完成配置工作(如 Bean 的实例化)
        ApplicationContext context = new
                ClassPathXmlApplicationContext("applications.xml");
        String bit = (String) context.getBean("bit");
        System.out.println(bit);
//        Duck d1 = (Duck) context.getBean("d1");
//        System.out.println(d1);
        String bit2 = context.getBean(String.class);
        System.out.println(bit2);
        Duck d1 = (Duck) context.getBean("d1");
        System.out.println(d1);
        Duck d2 = (Duck) context.getBean("d2");
        System.out.println(d2);
    }
}
