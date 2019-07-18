public class CountAndSay {
    private static String countAndSay(int n) {
        StringBuilder sb = new StringBuilder("1");
        StringBuilder prev;
        int count;
        char say;
        for(int i = 1; i < n; i++) {
            prev = sb;
            sb = new StringBuilder();
            say = prev.charAt(0);
            count = 1;
            for(int ind = 1; ind < prev.length(); ind++) {
                if( prev.charAt(ind) == say)
                    count++;
                else {
                    sb.append(count).append(say);
                    count = 1;
                    say = prev.charAt(ind);
                }
            }
            sb.append(count).append(say);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(countAndSay(1));
        System.out.println(countAndSay(2));
        System.out.println(countAndSay(3));
        System.out.println(countAndSay(4));
        System.out.println(countAndSay(5));
        System.out.println(countAndSay(6));
    }
}
