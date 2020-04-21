package java_0421;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class MyComp implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        // sort 方法默认是升序,改成降序
        // 就要重新定义什么是 "小"
        return o2 - o1;
    }
}

// 这个注解的目的和 @Override 类似,都是为了进行更严格的语法检查
@FunctionalInterface
interface TwoIntParamReturnInt {
    Integer func(Integer a, Integer b);
}

public class TestLambda {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(9);
        arrayList.add(5);
        arrayList.add(2);
        arrayList.add(7);

        TwoIntParamReturnInt myInterface = (Integer o1, Integer o2) -> {
            return o2 - o1;
        };

        Integer ret = myInterface.func(10, 20);
        System.out.println(ret);

        // Collections.sort(arrayList, func);

        System.out.println(arrayList);
    }
}
