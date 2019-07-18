public class Palindrome {
    public static boolean isPalindrome(int x) {
        if (x < 0 || (x != 0 && x%10 == 0 ))
            return false;

        int rev = 0;
        while(x > rev){
            rev = rev * 10 + x % 10;
            x = x / 10;
        }

        return x == rev || x == rev/10;
    }

    public static String longestPalindrome(String s) {
        String longest = "";
        for(int i = 0; i < s.length(); i++){
            String temp1 = find(s, i , i);
            String temp2 = find(s, i, i+1);
            temp1 = temp1.length() > temp2.length() ? temp1 : temp2;
            longest = temp1.length() > longest.length() ? temp1 : longest;
        }
        return longest;
    }

    public static String find(String s, int start, int end){
        int l = start;
        while(start >= 0  && end < s.length() && s.charAt(start) == s.charAt(end)){
            l = start;
            start--; end++;
        }
        return s.substring(l, end);
    }

    public static void main(String[] args) {
//        System.out.println(isPalindrome(12321));
        System.out.println(longestPalindrome("bb"));
    }
}
