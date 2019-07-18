public class PeakIndexInMountainArray {
    public static int peakIndexInMountainArray(int[] A) {
        if(A.length < 3)
            return 0;
        int prev = A[0];
        for(int i = 0; i < A.length; i++){
            if(A[i] < prev)
                return i-1;
            prev = A[i];

        }
    return 0;
    }

    public static void main(String[] args) {
        System.out.println(peakIndexInMountainArray(new int[]{0,2,1,0}));
    }
}
