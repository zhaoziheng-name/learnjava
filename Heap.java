package java_0408;

import java.util.Arrays;

// 以小堆为例
public class Heap {
    // 通过 size 指定 array 中哪些元素是有效元素
    // index 表示从哪个位置的下标开始调整
    // 左右子树都是堆才能进行调整
    public static void shiftDown(int[] array, int size, int index) {
        int parent = index;
        int child = 2 * parent + 1; // 根据 parent 下标找到左子树的下标
        while (child < size) {
            // 比较左右子树,找到较小值
            if (child + 1 < size && array[child + 1] < array[child]) {
                child = child + 1;
            }
            // 经过上面的比较,已经不知道 child 是左子树还是右子树了
            // 但是能知道 child 下标一定对应左右子树最小值的下标

            // 拿 child 位置的元素和 parent 位置的元素比较
            if (array[child] < array[parent]) {
                // 不符合小堆规则,就交换
                int tmp = array[child];
                array[child] = array[parent];
                array[parent] = tmp;
            } else {
                // 调整完成,不需要继续
                break;
            }
            // 更新变量,处理下一层的数据
            parent = child;
            child = 2 * parent + 1;
        }
    }

    public static void createHeap(int[] array, int size) {
        // size - 1 得到的是最后一个叶子节点
        // (size - 1 - 1) / 2 就是最后一个叶子节点的父节点(也就是倒数第一个非叶子节点)
        for (int i = (size - 1 - 1) / 2; i >= 0; i--) {
            shiftDown(array, size, i);
        }
    }

    public static void main(String[] args) {
        int[] array = {9, 5, 2, 7, 3, 6, 8};
        createHeap(array, array.length);
        System.out.println(Arrays.toString(array));
    }
}
