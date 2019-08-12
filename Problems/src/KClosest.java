import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class KClosest {
    private int[][] findKClosest(int[][] points, int K) {
        if(points == null || points.length == 0)
            return new int[K][];
        if(points.length <= K)
            return points;

        Queue<int[]> heap = new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return (o2[0]*o2[0] + o2[1]*o2[1]) - (o1[0]*o1[0] + o1[1]*o1[1]);
            }
        });

        for(int[] point : points) {
            heap.add(point);
            if(heap.size() > K)
                heap.poll();
        }

        int[][] ans = new int[K][];
        while(K > 0) {
            ans[--K] = heap.poll();
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] points = new int[][]{{3,3}, {5,-1}, {-2,4}};
        KClosest k = new KClosest();
        int[][] t =  k.findKClosest(points, 2);
        for(int i = 0; i < t.length; i++){
            System.out.println(Arrays.toString(t[i]));
        }

        points = new int[][]{{68,97},{34,-84},{60,100},{2,31},{-27,-38},{-73,-74},{-55,-39},{62,91},{62,92},{-57,-67}};
        t = k.findKClosest(points, 5);

        for(int i =0; i< t.length; i++){
            System.out.println(Arrays.toString(t[i]));
        }
    }
}
