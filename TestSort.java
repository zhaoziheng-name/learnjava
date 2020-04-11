package java_0411;

import java.util.Arrays;

public class TestSort {
    // 升序排序
    public static void insertSort(int[] array) {
       // 通过 bound 来划分两个区间
       //[0, bound) 已排序区间
       // [bound, size) 待排序区间
       for (int bound = 1; bound < array.length; bound++) {
           int v = array[bound];
           int cur = bound - 1; // 已排序区间的最后一个元素下标
           for (; cur >= 0; cur--) {
               if (array[cur] > v) {
                   array[cur + 1] = array[cur];
               } else {
                   // 此时说明找到了合适的位置
                   break;
               }
           }
           array[cur + 1] = v;
       }
    }

    public static void shellSort(int[] array) {
        int gap = array.length / 2;
        while (gap > 1) {
            // 需要循环进行分组插入排序
            insertSortGap(array, gap);
            gap = gap / 2;
        }
        insertSortGap(array, 1);
    }

    private static void insertSortGap(int[] array, int gap) {
        // 通过 bound 来划分两个区间
        // [0, bound) 已排序区间
        // [bound, size) 待排序区间

        // 当把 gap 替换成 1 的时候,理论上就和插入排序一样
        for (int bound = gap; bound < array.length; bound++) {
            int v = array[bound];
            int cur = bound - gap; // 这是在找同组中的上一个元素
            for (; cur >= 0; cur-= gap) {
                if (array[cur] > v) {
                    array[cur + gap] = array[cur];
                } else {
                    // 说明找到了合适的位置
                    break;
                }
            }
            array[cur + gap] = v;
        }
    }

    public static void selectSort(int[] array) {
        for (int bound = 0; bound < array.length; bound++) {
            // 以 bound 位置元素为擂主,循环从待排序区间取出元素和擂主比较
            for (int cur = bound + 1; cur < array.length; cur++) {
                if (array[cur] < array[bound]) {
                    // 打擂成功
                    int tmp = array[cur];
                    array[cur] = array[bound];
                    array[bound] = tmp;
                }
            }
        }
    }

    public static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static void heapSort(int[] array) {
        // 先建立堆
        createHeap(array);
        // 循环把堆顶元素交换到最后,并进行调整
        // 循环此时是 length - 1, 当堆中只剩一个元素的时候,也就一定是有序的了
        for (int i = 0; i < array.length; i++) {
            // 当前堆的元素个数
            int heapSize = array.length - i;
            // 交换 堆顶元素 和 堆的最后一个元素
            // 堆的元素个数相当于 array.length - i
            // 堆的最后一个元素下标 array.length - i - 1
            // 取堆的最后一个元素
            swap(array, 0, heapSize - 1);
            heapSize--; // 就把最后一个元素从堆中排除掉,堆的 size 就--

            // 交换完成之后,就要把最后一个元素从堆中删掉
            // 堆的长度 array.length - i - 1
            // [0, array.length - i - 1) 待排序区间
            // [array.length - i - 1, array.length) 已排序区间
            shiftDown(array, heapSize, 0);
        }
    }

    private static void createHeap(int[] array) {
        // 从最后一个非叶子节点出发向前循环,依次进行向下调整
        for (int i = (array.length - 1 - 1) / 2; i >= 0; i--) {
            shiftDown(array, array.length, i);
        }
    }

    private static void shiftDown(int[] array, int heapLength, int index) {
        // 这里是升序排序,建立大堆,找出左右子树的较大值,和根节点作比较
        int parent = index;
        int child = 2 * parent + 1;
        while (child < heapLength) {
            if (child + 1 < heapLength && array[child + 1] > array[child]) {
                child = child + 1;
            }
            // 条件结束意味着 child 已经是左右子树中较大的那个值的下标了
            if (array[child] > array[parent]) {
                // 需要交换两个元素
                swap(array, child, parent);
            } else {
                break;
            }
            parent = child;
            child = 2 * parent + 1;
        }
    }

    public static void bubbleSort(int[] array) {
        // 按照每次找最小的方式来遍历
        for (int bound = 0; bound < array.length; bound++) {
            // [0, bound) 已排序区间
            // [bound, size) 待排序区间
            // cur > bound 不能带 "=" 防止下标越界
            for (int cur = array.length - 1; cur > bound; cur--) {
                // 不能写 cur + 1, 防止下标越界
                if (array[cur - 1] > array[cur]) {
                    swap(array, cur - 1, cur);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {9, 5, 2, 7, 3, 6, 8};
        // selectSort(arr);
        // insertSort(arr);
        // shellSort(arr);
        // bubbleSort(arr);
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
