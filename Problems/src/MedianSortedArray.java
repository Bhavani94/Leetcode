public class MedianSortedArray {
    private static double findMedianSortedArraysBrute(int[] nums1, int[] nums2) {
        // O(1) space O(m+n/2) time
        int med1 = 0, index1 = 0;
        int med2 = 0, index2 = 0;
        for(int i = 0; i <= (nums1.length + nums2.length) / 2; i++) {
            med1 = med2;
            if(index1 == nums1.length) {
                med2 = nums2[index2++];
            } else if(index2 == nums2.length) {
                med2 = nums1[index1++];
            } else if(nums1[index1] < nums2[index2]) {
                med2 = nums1[index1++];
            } else {
                med2 = nums2[index2++];
            }
        }

        if ((nums1.length + nums2.length) % 2 == 0) {
            return (med1 + med2) / 2.0;
        }

        return med2;
    }

    private static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // O(1) space O(log(m+n)) time
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int x = nums1.length;
        int y = nums2.length;

        int low = 0, high = x;

        while( low <= high) {
            int partitionX = (low + high) / 2;
            int partitionY = (x + y + 1) / 2  - partitionX;

            int leftX = partitionX == 0 ? Integer.MIN_VALUE : nums1[partitionX - 1];
            int rightX = partitionX == x ? Integer.MAX_VALUE : nums1[partitionX];

            int leftY = partitionY == 0 ? Integer.MIN_VALUE : nums2[partitionY - 1];
            int rightY = partitionY == y ? Integer.MAX_VALUE : nums2[partitionY];

            if(leftX <= rightY && leftY <= rightX) {
                if((x + y) % 2 == 0) {
                    return (Math.max(leftX, leftY) + Math.min(rightX, rightY)) / 2.0;
                } else {
                    return (double) Math.max(leftX, leftY);
                }
            } else if(leftX > rightY)
                high = partitionX - 1;
            else
                low = partitionX + 1;
        }

        return 0.0;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2};
        int[] nums2 = {3,4};
        System.out.println(findMedianSortedArraysBrute(nums1, nums2));
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }
}
