package java_0531;

public class Finder {

    public int findKth(int[] arr, int n, int K) {
        quickSort(arr, 0, n - 1);
        return arr[arr.length - K];
    }

    private void quickSort(int[] arr, int left, int right) {
        if (left > right)
            return;
        int beg = left;
        int end = right;
        int cur = arr[left];
        while (beg != end) {
            while (beg < end && arr[end] >= cur)
                end--;
            while (beg < end && arr[beg] <= cur)
                beg++;
            if (beg < end) {
                int tmp = arr[beg];
                arr[beg] = arr[end];
                arr[end] = tmp;
            }
        }
        arr[left] = arr[beg];
        arr[beg] = cur;
        quickSort(arr, left, beg - 1);
        quickSort(arr, beg + 1, right);
    }
}
