import java.util.*;

public class LRUCache {
    HashMap<Integer, Integer> map;
    LinkedList<Integer> list;
    int capacity;

    public LRUCache(int capacity) {
        this.map = new HashMap<>();
        this.list = new LinkedList<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        if(map.containsKey(key)) {
            reorder(key);
            list.push(key);
            return map.get(key);
        }

        return -1;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)) {
            reorder(key);
        } else {
            if(capacity == list.size()) {
                int last = list.removeLast();
                map.remove(last);
            }
        }
        map.put(key, value);
        list.push(key);
    }

    private void reorder(int key) {
        int index = 0, i =0;
        Iterator<Integer> iterator = list.iterator();
        while(iterator.hasNext()) {
            if (iterator.next() == key) {
                index = i;
                break;
            }
            i++;
        }
        list.remove(index);
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(2, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);
        System.out.println(cache.get(2));
        cache.put(4, 4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
    }
}
