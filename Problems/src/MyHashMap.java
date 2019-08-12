public class MyHashMap {
   private Node[] bucket;

   public MyHashMap() {
      bucket = new Node[10000];
   }

   private int getHashKey(int key) {
      return Integer.hashCode(key) % bucket.length;
   }

   /**
    * value will always be non-negative.
    */
   public void put(int key, int value) {
      int index = getHashKey(key);
      Node node = findElement(index, key);
      if (node.next == null)
         node.next = new Node(key, value);
      else
         node.next.value = value;
   }

   /**
    * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
    */
   public int get(int key) {
      Node curr = findElement(getHashKey(key), key);
      return curr.next == null ? -1 : curr.next.value;
   }

   /**
    * Removes the mapping of the specified value key if this map contains a mapping for the key
    */
   public void remove(int key) {
      Node curr = findElement(getHashKey(key), key);
      if (curr.next != null)
         curr.next = curr.next.next;
   }

   private Node findElement(int index, int key) {
      if (bucket[index] == null) {
         bucket[index] = new Node(-1, -1);
      }
      Node node = bucket[index];
      while (node.next != null && node.next.key != key) {
         node = node.next;
      }
      return node;
   }

   private class Node {
      int key, value;
      Node next;

      Node(int key, int value) {
         this.key = key;
         this.value = value;
      }
   }

   public static void main(String[] args) {
      MyHashMap hashMap = new MyHashMap();
      hashMap.remove(123);
      hashMap.put(1, 1);
      hashMap.put(2, 2);
      System.out.println(hashMap.get(1));            // returns 1
      System.out.println(hashMap.get(3));            // returns -1 (not found)
      hashMap.put(2, 1);          // update the existing value
      System.out.println(hashMap.get(2));            // returns 1
      hashMap.remove(2);          // remove the mapping for 2
      System.out.println(hashMap.get(2));              // returns -1 (not found)
   }
}
