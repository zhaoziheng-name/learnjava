package java_0421;

import java.util.Arrays;

enum Sex {
    MALE,
    FEMALE,
    OTHER,
}

public class TestEnum {
    // 需要在代码中表示性别
    // 可以约定 1.表示男性, 2.表示女性, 3.表示其他
//    public static final int MALE = 1;
//    public static final int FEMALE = 2;
//    public static final int OTHER = 3;

    public static void main(String[] args) {
        Sex sex = Sex.MALE;
        if (sex == Sex.MALE) {
            // 针对男性做出一些处理...
        }

        // 定义常量来表示性别,可读性提高了,但是对于下面的场景
        // 这个代码是无意义的,但是编译器仍能正常编译
        System.out.println(Arrays.toString(Sex.values()));
    }
}
