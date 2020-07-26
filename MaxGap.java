package java_0726;

public class MaxGap {
    public int findMaxGap(int[] A, int n) {
        int max = A[0];
        for(int i=1; i<n;i++){
            if(A[i] > max){
                max = A[i];
            }
        }
        int min = Math.min(A[0],A[n-1]);
        return max-min;
    }
}
