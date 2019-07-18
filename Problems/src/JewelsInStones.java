public class JewelsInStones {
    public static int numJewelsInStones(String J, String S) {
        int ans = 0;
        for(char c : S.toCharArray()){
            if(J.contains(Character.toString(c)))
                ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(numJewelsInStones("aAbB", "achdgBhiABb"));
    }
}
