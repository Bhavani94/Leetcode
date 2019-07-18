import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class PhoneDirectory {
   int max;
   Set<Integer> used;
   Queue<Integer> available;
   public PhoneDirectory(int maxNumbers) {
      max = maxNumbers;
      available = new LinkedList<>();
      used = new HashSet<>();
      for(int i = 0 ; i < maxNumbers; i++)
         available.offer(i);
   }

   /** Provide a number which is not assigned to anyone.
    @return - Return an available number. Return -1 if none is available. */
   public int get() {
      if(available.isEmpty())
         return -1;
      int ans = available.poll();
      used.add(ans);
      return ans;
   }

   /** Check if a number is available or not. */
   public boolean check(int number) {
      if(number < 0 || number >= max)
         return false;

      return !used.contains(number);

   }

   /** Recycle or release a number. */
   public void release(int number) {
      if(used.contains(number)) {
         used.remove(number);
         available.offer(number);
      }
   }

   public static void main(String[] args) {
      PhoneDirectory directory = new PhoneDirectory(3);

// It can return any available phone number. Here we assume it returns 0.
      System.out.println(directory.get());

// Assume it returns 1.
      System.out.println(directory.get());

// The number 2 is available, so return true.
      System.out.println(directory.check(2));

// It returns 2, the only number that is left.
      System.out.println(directory.get());

// The number 2 is no longer available, so return false.
      System.out.println(directory.check(2));

// Release number 2 back to the pool.
      directory.release(2);

// Number 2 is available again, return true.
      System.out.println(directory.check(2));
   }
}
