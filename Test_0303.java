package Practice;

public class Test_0303 {
    public static void bubbleSort(int[] arr) {
        // 升序排序
        for (int bound = 0; bound < arr.length; bound++) {
            for (int cur = 0; cur < arr.length - bound - 1; cur++) {
                if (arr[cur] > arr[cur + 1]) {
                    // 需要交换两个数的顺序
                    int tmp = arr[cur];
                    arr[cur] = arr[cur + 1];
                    arr[cur + 1] = tmp;
                }
            }
        }
    }

    public static int binarySearch(int[] arr, int toFind) {
    // 创建两个指针
        int left = 0;
        int right = arr.length - 1;
        // 循环执行条件
        while (left <= right) {
            // 指向数组中间值的指针
            int mid = (left + right) / 2;
            if (toFind < arr[mid]) {
                //  去左边找
                right = mid - 1;
            } else if (toFind > arr[mid]) {
                // 去右边找
                left = mid + 1;
            } else {
                // 找到了
                return mid;
            }
        }
        // 没有找到
        return -1;
    }

    public static void reverse(int[] arr) {
        // 创建指向数组头和数组尾的变量
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;
            // 更新循环变量
            left++;
            right--;
        }
    }

    public boolean Find(int target, int[][] array) {
        int rows = array.length;
        if (rows == 0) {
            return false;
        }
        int cols = array[0].length;
        if (cols == 0) {
            return false;
        }
        int row = rows - 1;
        int col = 0;
        while (row >= 0 && col < cols) {
            if (array[row][col] < target) {
                col++;
            } else if (array[row][col] > target) {
                row--;
            } else {
                return true;
            }
        }
        return false;
    }

    public String replaceSpace(StringBuffer str) {
        if (str == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == ' ') {
                sb.append("%20");
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public int Fibonacci(int n) {
        int prev = 1, cur = 1, next = 0;
        if (n < 0) {
            return 0;
        } else if (n == 1 || n == 2) {
            return 1;
        } else {
            for (int i = 3; i <= n; i++) {
                next = prev + cur;
                cur = prev;
                prev = next;
            }
            return next;
        }
    }
}
