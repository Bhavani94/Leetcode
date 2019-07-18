import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
    public static boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put('{', '}');
        map.put('(', ')');
        map.put('[', ']');
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(map.containsKey(c))
                stack.push(c);
            else if(map.containsValue(c) && stack.isEmpty())
                return false;
            else if(!stack.isEmpty() && map.get(stack.peek()).equals(c))
                stack.pop();
            else
                return false;
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("{()}()"));
        System.out.println(isValid("{(})()"));
        System.out.println(isValid(""));
        System.out.println(isValid("{()}(ab)"));
        System.out.println(isValid("(])"));
    }
}
