public class MergeSortedArray {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = nums1.length - 1;
        m--;
        n--;
        while(m >= 0 && n >= 0){
            if(nums1[m] >= nums2[n]) {
                nums1[i--] = nums1[m--];
            } else {
                nums1[i--] = nums2[n--];
            }
        }
        // add missing elements from nums2
        System.arraycopy(nums2, 0, nums1, 0, n + 1);
    }

    public static void main(String[] args) {
        int[] ans = new int[]{1,3,5,7,0,0,0};
        merge(ans, 4, new int[]{2,4,6}, 3);
        for(int i : ans)
            System.out.print(i + " ");
        System.out.println();
        ans = new int[]{0};
        merge(ans, 0, new int[]{2,}, 1);
        for(int i : ans)
            System.out.print(i + " ");
    }
}
