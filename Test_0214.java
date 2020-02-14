package java_0214;

import javax.swing.plaf.basic.BasicBorders;

public class Test_0214 {
    public static void main(String[] args) {
        Student_0214 student1 = new Student_0214();
        System.out.println(student1);
//        student1.print();
    }
//    时间复杂度O(N ^ 2)
    void func1(int N) {
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                count++;
            }
        }
        for (int i = 0; i < 2 * N; i++) {
            count++;
        }
        int m = 10;
        while(N < m) {
            count++;
        }
        m--;
    }

//    时间复杂度O(N)
    void func2(int N) {
        int count = 0;
        for (int k = 0; k < 2 * N; k++) {
            count++;
        }
        int m = 10;
        while((m--) < 10) {
            count++;
        }
        System.out.println(count);
    }

//    时间复杂度O(M + N)
    void func3(int N, int M) {
        int count = 0;
        for (int k = 0; k < M; k++) {
            count++;
        }
        for (int k = 0; k < N; k++) {
            count++;
        }
        System.out.println(count);
    }

//    时间复杂度O(1),不是只执行了一次,只要和问题规模无关,就算常量
    void func4(int N) {
        int count = 0;
        for (int k = 0; k < 100; k++) {
            count++;
        }
        System.out.println(count);
    }

//    时间复杂度O(N ^ 2)
//    空间复杂度O(1),常量
    void bubblesort(int[] array) {
        for (int end = array.length; end > 0; end--) {
            boolean sorted = true;
            for (int i = 1; i < end; i++) {
                if(array[i - 1] > array[i]) {
                    Swap(array, i - 1, i);
                    sorted = false;
                }
            }
            if(sorted == true) {
                break;
            }
        }
    }

//    时间复杂度O(logN)
    int binarySearch(int[] array, int toFind) {
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (array[mid] < toFind) {
                left = mid + 1;
            } else if (array[mid] > toFind) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

//    时间复杂度O(N)
    long factorial(int N) {
        return N < 2 ? N : factorial(N - 1) * N;
    }

//    时间复杂度O(2 ^ N)
    int fibonacci(int N) {
        return N < 2 ? N : fibonacci(N - 1) + fibonacci(N - 2);
    }
}