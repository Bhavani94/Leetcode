import java.util.*;

public class FindOverlap {
    public static String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<>();
        List<String> ans = new ArrayList<>();
        int minIndexSum = Integer.MAX_VALUE;
        for(int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }
        for(int i = 0; i < list2.length; i++) {
            if(map.containsKey(list2[i])) {
                int indexSum = i + map.get(list2[i]);
                if(minIndexSum > indexSum) {
                    minIndexSum = indexSum;
                    ans.clear();
                    ans.add(list2[i]);
                } else if(minIndexSum == indexSum) {
                    ans.add(list2[i]);
                }
            }
        }
        return ans.toArray(new String[ans.size()]);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.asList(findRestaurant(new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"},
                new String[]{"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"})));
    }
}
