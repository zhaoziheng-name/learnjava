package java_0530;

import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileTest {

    @Test
    public void t2() {
        // 文件的相对路径和绝对路径
        // 绝对路径:全路径
        // 相对路径:./(当前目录), ../(上一级目录)
        // java 项目在 idea 中的编译路径
        File file = new File("D:\\1.代码\\01.Java\\io-study\\data");
        // 文件是否存在
        System.out.println(file.exists());
        File file2 = new File("哇.txt");
        System.out.println(file2.exists());
        // 怎么查看当前 java 代码的路径
        File file3 = new File("");
        // 获取绝对路径
        System.out.println(file3.getAbsolutePath());
        // file 类写相对路径不建议在真实的项目中使用
        File file4 = new File("data/哇.txt");
        System.out.println(file4.exists());
    }

    // 递归获取目录下所有的子文件和子文件夹
    public static List<File> list(File file) {
        List<File> files = new ArrayList<>();
        if (file.isFile()) {
            files.add(file);
        } else {
            // 下一级子文件,子文件夹
            File[] children = file.listFiles();
            for (File child : children) {
                List<File> subs = list(child);
                files.addAll(subs);
            }
        }
        return files;
    }

    @Test
    public void t3() {
        File file5 = new File("D:\\1.代码\\01.Java");
        List<File> children = list(file5);// 返回目录下一级的子文件/子文件夹数组
        for (File child : children) {
            System.out.println(child.getName());// 文件名
        }
    }
}
