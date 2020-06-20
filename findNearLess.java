package java_0620;

import java.util.Scanner;
import java.util.Stack;

public class findNearLess {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr [i] = scanner.nextInt();
        }
        int[][] result = getNear(arr);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i][0] + " " + result[i][1]);
        }
    }

    private static int[][] getNear(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[][] result = new int[arr.length][2];
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[i] < arr[stack.peek()]) {
                int top = stack.pop();
                int leftIndex = stack.isEmpty() ? - 1 :stack.peek();
                result[top][0] = leftIndex;
                result[top][1] = i;
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int top = stack.pop();
            int leftIdx = stack.isEmpty() ? -1 : stack.peek();
            result[top][0] = leftIdx;
            result[top][1] = -1;
        }
        return result;
    }
}
