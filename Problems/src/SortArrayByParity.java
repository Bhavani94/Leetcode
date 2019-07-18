public class SortArrayByParity {
    public static int[] sortArrayByParity(int[] A) {
        int even = 0;
        int odd = A.length-1;
        while(even < odd){
            if(A[even]%2 > A[odd]%2){
                int temp = A[odd];
                A[odd] = A[even];
                A[even] = temp;
            }

            if(A[even]%2 == 0) even++;
            if(A[odd]%2 != 0) odd--;
        }
    return A;
    }

    public static void main(String[] args) {
        int[] a = sortArrayByParity(new int[]{3,7,4,6,9});
        for(int i : a)
            System.out.println(i);
    }
}
