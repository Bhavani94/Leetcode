public class ShortestDistance {
    public static int shortestDistance(String[] words, String word1, String word2) {
        int ind1 = -1;
        int ind2 = -1;
        int min = words.length;
        for(int i = 0; i<words.length ; i++){
            if(words[i].equals(word1))
                ind1 = i;
            else if(words[i].equals(word2))
                ind2 = i;
            if (ind1 != -1 && ind2 != -1)
                min = Math.min(min, Math.abs(ind1-ind2));
        }
        return min;
    }

    public static void main(String[] args) {
        String[] a = new String[]{"a", "a", "b", "b"};
        System.out.println(shortestDistance(a, "a", "b"));
    }
}
