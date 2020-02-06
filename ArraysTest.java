import java.util.Arrays;

public class ArraysTest {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4,};
        transform(arr);
        System.out.println(Arrays.toString(arr));
//        int[] newArr = copyOf(arr);
//        arr[0] = 10;
//        System.out.println("newArr: " + Arrays.toString(newArr));
//        System.out.println("arr: " + Arrays.toString(arr));
//        int[] newArr2 = Arrays.copyOfRange(arr, 2, 4);
//        System.out.println("newArr2: " + Arrays.toString(newArr2));
        int[][] arr2 = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };
        for (int row = 0; row < arr2.length; row++) {
            for (int col = 0; col < arr2[row].length; col++) {
                System.out.printf("%d\t", arr2[row][col]);
            }
            System.out.println("");
        }
    }
    class Person {
        public int age;
        public String name;
        public String sex;
        public void eat() {
            System.out.println("吃饭!");
        }
        public void sleep() {
            System.out.println("睡觉!");
        }
    }

    public static void transform(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            while (left < right && arr[left] % 2 == 0) {
                left++;
            }
            while (left < right && arr[right] % 2 != 0) {
                right--;
            }
            int tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;
        }
    }

    public static void reverse(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;
            left++;
            right--;
        }
    }

    public static void bubbleSort(int[] arr) {
        for (int bound = 0; bound < arr.length; bound++) {
            for (int cur = arr.length - 1; cur > bound ; cur--) {
                // 升序排列
                if(arr[cur - 1] > arr[cur]) {
                    int tmp = arr[cur - 1];
                    arr[cur - 1] = arr[cur];
                    arr[cur] = tmp;
                }
            }
        }
    }

    public static boolean isSorted(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if(arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static int binarySearch(int[] arr, int toFind) {
        int left = 0;
        int right = arr.length - 1;
        while(left <= right) {
            int mid = (left + right) / 2;
            // 去右边找
            if(toFind > arr[mid]) {
                left = mid + 1;
                // 去左边找
            } else if(toFind < arr[mid]) {
                right = mid - 1;
            } else {
                // 相等,找到了
                return mid;
            }
        }
        return -1;
    }

    public static int find(int[] arr, int toFind) {
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == toFind) {
                return i;
            }
        }
        return -1;
    }

    public static double avg(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return (double)sum / (double)arr.length;
    }

    public static int findMin(int[] arr) {
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }

    public static int findMax(int[] arr) {
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    public static int[] copyOf(int[] arr) {
        int[] ret = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            ret[i] = arr[i];
        }
        return ret;
    }
}
