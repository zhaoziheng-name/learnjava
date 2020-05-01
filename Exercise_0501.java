package java_0501;

import java.util.*;

public class Exercise_0501 {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        for (; k > 0; k--) {
            int prev = grid[grid.length - 1][grid[0].length - 1];
            for (int row = 0; row < grid.length; row++) {
                for (int col = 0; col < grid[0].length; col++) {
                    int tmp = grid[row][col];
                    grid[row][col] = prev;
                    prev = tmp;
                }
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int[] row : grid) {
            List<Integer> listRow = new ArrayList<>();
            result.add(listRow);
            for (int v : row) listRow.add(v);
        }
        return result;
    }

    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    };

    public int getImportance(List<Employee> employees, int id) {
        if (employees.size() == 0) {
            return 0;
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(id);
        int result = 0;
        while (queue.size() != 0) {
            int tmp = queue.poll();
            for (Employee e : employees) {
                if (tmp == e.id) {
                    result += e.importance;
                    for (int i : e.subordinates) {
                        queue.add(i);
                    }
                }
            }
        }
        return result;
    }

    public int findJudge(int N, int[][] trust) {
        int[] inDegree = new int[N + 1];
        int[] outDegree = new int[N + 1];
        for (int[] tmp : trust) {
            int begin = tmp[0];
            int end = tmp[1];
            inDegree[end]++;
            outDegree[begin]++;
        }
        for (int i = 1; i <= N; i++) {
            if (outDegree[i] == 0 && inDegree[i] == N - 1) {
                return i;
            }
        }
        return -1;
    }

    public boolean canThreePartsEqualSum(int[] A) {
        int sum = 0;
        for (int i : A) {
            sum += i;
        }
        if (sum % 3 != 0) {
            return false;
        }
        int left = 0;
        int leftSum = A[left];
        int right = A.length - 1;
        int rightSum = A[right];
        while (left + 1 < right) {
            if (leftSum == sum / 3 && rightSum == sum / 3) {
                return true;
            }
            if (leftSum != sum / 3) {
                leftSum += A[++left];
            }
            if (rightSum != sum / 3) {
                rightSum += A[--rightSum];
            }
        }
        return false;
    }
}

