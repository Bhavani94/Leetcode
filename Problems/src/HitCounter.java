public class HitCounter {

   int[] times, count;
   public HitCounter() {
      this.times = new int[300];
      this.count = new int[300];
   }

   /**
    * Record a hit.
    *
    * @param timestamp - The current timestamp (in seconds granularity).
    */
   public void hit(int timestamp) {
      int index = timestamp % 300;
      if(times[index] != timestamp) {
         times[index] = timestamp;
         count[index] = 1;
      } else {
         count[index]++;
      }
   }

   /**
    * Return the number of hits in the past 5 minutes.
    *
    * @param timestamp - The current timestamp (in seconds granularity).
    */
   public int getHits(int timestamp) {
      int hits = 0;
      for(int i = 0; i < 300; i++) {
         if(timestamp - times[i] < 300)
            hits += count[i];
      }
      return hits;
   }
}
