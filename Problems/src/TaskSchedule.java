public class TaskSchedule {
   private static int leastInterval(char[] tasks, int n) {
      if(tasks == null || tasks.length == 0)
         return 0;
      if(n == 0)
         return tasks.length;

      int[] count = new int[26];
      int numberOfTasksWIthMaxFreq = 0, maxFrequency = 1;

      for(char task : tasks) {
         count[task - 'A']++;
         if(maxFrequency == count[task - 'A'])
            numberOfTasksWIthMaxFreq++;
         else if(count[task - 'A'] > maxFrequency) {
            numberOfTasksWIthMaxFreq = 1;
            maxFrequency = count[task - 'A'];
         }
      }

      // A X X A X X A
      // A B X A B X A B
      int emptySlots = (maxFrequency - 1) * (n - (numberOfTasksWIthMaxFreq - 1));
      int availableTasks = tasks.length - (numberOfTasksWIthMaxFreq * maxFrequency);
      int idleSlots = Math.max(0, emptySlots - availableTasks);

      return idleSlots + tasks.length;
   }

   public static void main(String[] args) {
      System.out.println(leastInterval(new char[]{'A','A','A','B','B','B'}, 2));
   }
}
