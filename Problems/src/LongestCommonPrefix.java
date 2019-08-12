public class LongestCommonPrefix {
    private static String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0)
            return "";

        String common = strs[0];
        for(int i = 1; i < strs.length; i++) {
            while ( strs[i].indexOf(common) != 0){
                common = common.substring(0 , common.length() - 1);
                if( common.length() == 0)
                    return "";
            }
        }
        return common;
    }

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"abcd", "abd", "a"}));
    }
}