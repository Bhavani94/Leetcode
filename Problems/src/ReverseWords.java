public class ReverseWords {
    private static String reverseWords(String s) {
        String[] strs = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for(int i = strs.length - 1; i > 0; i--){
            sb.append(strs[i]);
            sb.append(" ");
        }
        return sb.append(strs[0]).toString();
    }

    private static String reverseWordsInPlace(String s) {
        char[] chars = s.toCharArray();
        reverse(chars, 0, s.length() - 1);
        int start = 0, end = 0;
        for(int i = 0; i < chars.length; i++) {
            if (chars[i] != ' ')
                chars[end++] = chars[i];
            else if (i > 0 && chars[i-1] != ' ') {
                reverse(chars, start, end - 1);
                chars[end++] = ' ';
                start = end;
            }
        }
        reverse(chars, start, end - 1);
        return new String(chars, 0, end > 0 && chars[end-1] == ' ' ? end-1 : end);
    }

    private static String reverseWordsIII(String s) {
        char[] chars = s.toCharArray();
        int start = 0, end = 0;
        for(int i = 0; i < chars.length; i++) {
            if (i == chars.length - 1) {
                reverse(chars, start, end);
            } else if (chars[i] != ' ') {
                end++;
            } else if (i > 0 && chars[i-1] != ' ') {
                reverse(chars, start, end - 1);
                chars[end++] = ' ';
                start = end;
            }
        }
        return new String(chars, 0, s.length());
    }

    private static void reverse(char[] c, int start, int end){
        while( start < end){
            char t = c[start];
            c[start++] = c[end];
            c[end--] = t;
        }
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("the sky is  blue"));
        System.out.println(reverseWordsInPlace("the sky is  blue"));
        System.out.println(reverseWordsInPlace(" hello world! "));
        System.out.println(reverseWordsIII("Let's take LeetCode contest"));
        System.out.println(reverseWordsIII("abc def"));
    }
}
