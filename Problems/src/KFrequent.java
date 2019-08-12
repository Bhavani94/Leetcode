import java.util.*;

public class KFrequent {
    private static List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i: nums){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        Queue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o1) - map.get(o2);
            }
        });
        for(Integer e : map.keySet()){
            pq.offer(e);
            if(pq.size() > k)
                pq.poll();
        }

        List<Integer> list = new ArrayList<>();
        while(!pq.isEmpty()){
            list.add(pq.poll());
        }

        Collections.reverse(list);
        return list;
    }

    private static List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for(String i: words){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        Queue<String> pq = new PriorityQueue<String>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return map.get(o1) != map.get(o2) ? map.get(o1) - map.get(o2) : o2.compareTo(o1);
            }
        });
        for(String e : map.keySet()){
            pq.offer(e);
            if(pq.size() > k)
                pq.poll();
        }

        List<String> list = new ArrayList<>();
        while(!pq.isEmpty()){
            list.add(pq.poll());
        }

        Collections.reverse(list);
        return list;
    }

    public static void main(String[] args) {

        System.out.println(topKFrequent(new int[]{1,2,2,3,3,3}, 2));
        System.out.println(topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 2));
    }
}
