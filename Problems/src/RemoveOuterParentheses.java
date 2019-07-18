public class RemoveOuterParentheses {
    public static String removeOuterParentheses(String S) {
        StringBuilder ans = new StringBuilder();
        int ind = 0;
        for(char c : S.toCharArray()){
            if(c == '(' && ind++ > 0)
                ans.append(c);
            if(c == ')' && ind-- > 1)
                ans.append(c);
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println(removeOuterParentheses("(()(()))"));
    }
}
