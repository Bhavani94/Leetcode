import java.util.*;

public class RandomizedSetWithDuplicates {
    ArrayList<Integer> list;
    Map<Integer, Set<Integer>> map;
    Random rand = new Random();
    /** Initialize your data structure here. */
    public RandomizedSetWithDuplicates() {
        list = new ArrayList<>();
        map = new HashMap<>();
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        list.add(val);
        boolean ans = !map.containsKey(val);
        if (ans)
            map.put(val, new HashSet<>());
        map.get(val).add(list.size()-1);
        return ans;
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val))
            return false;
        else {
            int index = map.get(val).iterator().next();
            map.get(val).remove(index);
            // can remove last element in array list in O(1)
            if(index < list.size()-1)
            {
                int lastitem = list.get(list.size()-1);
                list.set(index, lastitem);
                map.get(lastitem).remove(list.size()-1);
                map.get(lastitem).add(index);
            }
            list.remove(list.size()-1);
            if(map.get(val).isEmpty()) map.remove(val);
            return true;
        }
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
    public static void main(String[] args) {
        RandomizedSetWithDuplicates obj = new RandomizedSetWithDuplicates();
        System.out.println(obj.insert(1));
        System.out.println(obj.remove(2));
        System.out.println(obj.insert(2));
        System.out.println(obj.remove(2));
        System.out.println(obj.getRandom());
    }
}
