import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class MedianInfiniteStream {
    /** initialize your data structure here. */
    private Queue<Integer> minHeap;
    private Queue<Integer> maxHeap;

    public MedianInfiniteStream() {
        this.minHeap = new PriorityQueue<>();
        this.maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    }

    public void addNum(int num) {
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());
        if(maxHeap.size() < minHeap.size())
            maxHeap.add(minHeap.poll());
    }

    public double findMedian() {
        if(minHeap.size() == maxHeap.size())
            return (minHeap.peek() + maxHeap.peek()) / 2;
        return maxHeap.peek();
    }

    public static void main(String[] args) {
        MedianInfiniteStream obj = new MedianInfiniteStream();
        obj.addNum(41);
        obj.addNum(35);
        obj.addNum(62);
        obj.addNum(4);
        System.out.println(obj.findMedian());
    }
}
