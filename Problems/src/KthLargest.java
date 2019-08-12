import java.util.PriorityQueue;

public class KthLargest {
    private static int findKthLargest(int[] nums, int k) {
        if(nums.length < k || k == 0)
            return 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(k);
        for(int i : nums){
            pq.add(i);
            if(pq.size() > k)
                pq.poll();
        }
        return pq.peek();
    }

    private static int thirdMax(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i : nums){
            if(!pq.contains(i)) {
                pq.offer(i);
                if(pq.size() > 3)
                    pq.poll();
            }
        }
        if(pq.size() == 2) pq.poll();
        return pq.peek();
    }

    public static void main(String[] args) {
        System.out.println(findKthLargest(new int[]{1,4}, 3));
        System.out.println(thirdMax(new int[]{1,4}));
    }
}
