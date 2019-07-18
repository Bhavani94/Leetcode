public class CompareVersions {
   private static int compareVersion(String version1, String version2) {
      if(version1 == null || version2 == null)
         return 0;

      String[] v1 = version1.split("\\.");
      String[] v2 = version2.split("\\.");
      int i, len = Math.max(v1.length, v2.length);
      for(i = 0; i < len; i++) {
         Integer val1 = i < v1.length ? Integer.parseInt(v1[i]) : 0;
         Integer val2 = i < v2.length ? Integer.parseInt(v2[i]) : 0;
         if(val1 > val2)
            return 1;
         else if(val1 < val2)
            return -1;
      }

      return 0;
   }

   public static void main(String[] args) {
      System.out.println(compareVersion("0.1", "1.1"));
   }
}
