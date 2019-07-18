public class ToLowerCase {
    public static String toLowerCase(String str) {
        if (str == null || str.length() == 0)
            return "";
        char[] ch = str.toCharArray();
        for(int i = 0; i< ch.length; i++) {
            if('A' <= ch[i] && ch[i] <= 'Z') {
                ch[i] = (char)(ch[i] - 'A' + 'a');
            }
        }
        return new String(ch);
    }

    public static void main(String[] args) {
        System.out.println(toLowerCase("Hello"));
    }
}
