package java_0327;

import java.util.ArrayList;
import java.util.List;

public class YHTriangle {
    public List<List<Integer>> generate(int numRows) {
        // 杨辉三角特点:
        // 1. 第一行固定就是一个 1
        // 2. 第二行也固定,就是两个 1
        // 3. 第三行开始首尾元素固定为 1
        // 4. 第 i 行有 i 列
        // 5. 对于第 i 行,第 j 列的值是第 i - 1 行 j - 1 列的值加上 i - 1 行 j 列的值
        if (numRows <= 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        // 1. 先准备第一行只有 1 行
        List<Integer> firstLine = new ArrayList<>();
        firstLine.add(1);
        result.add(firstLine);
        if (numRows == 1) {
            return result;
        }
        // 2. 再准备第二行,只有两个 1
        List<Integer> secondLine = new ArrayList<>();
        secondLine.add(1);
        secondLine.add(1);
        result.add(secondLine);
        if (numRows == 2) {
            return result;
        }
        // 3. 处理第 i 行的情况
        //  a) 第 i 行有 i 列
        //  b) 第 i 行第 j 列的元素 (i, j) = (i - 1, j) + (i - 1, j - 1).
        //  c) 第一个元素和最后一个元素都固定是 1
        for (int row = 3; row <= numRows; row++) {
            // 如果想知道第 row 行的情况,就得先知道 row - 1 行的内容
            List<Integer> prevLine = result.get(row - 1 - 1);
            List<Integer> curLine = new ArrayList<>();
            curLine.add(1);
            // 第 row 行应该有 row 列,下面这个循环相当于循环了 row - 2 次
            // 第一列和最后一列都固定是 1, 不参与循环
            for (int col = 2; col < row; col++) {
                // 此处 col 也是从 1 开始计算的,转换成下标需要再 - 1
                // col - 1 - 1 是 col - 1 列的元素
                // col - 1 是 col 列的元素
                int curNum = prevLine.get(col - 1 - 1) + prevLine.get(col - 1);
                curLine.add(curNum);
            }
            // 最后处理该行的最后一个 1
            curLine.add(1);
            result.add(curLine);
        }
        return result;
    }
}
