import java.util.Arrays;
import java.util.Stack;

public class AstroidCollision {
    /*
    Find out the state of the asteroids after all collisions.
    If two asteroids meet, the smaller one will explode.
    If both are the same size, both will explode.
    Two asteroids moving in the same direction will never meet.
     */
    private static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for(int i = 0 ; i < asteroids.length; i++) {
            boolean shouldAdd = true;
            while(!stack.isEmpty() && stack.peek() > 0 && asteroids[i] < 0) {
                if(stack.peek() < -asteroids[i]) {
                    stack.pop();
                } else if(stack.peek() == -asteroids[i]) {
                    stack.pop();
                    shouldAdd = false;
                    break;
                } else {
                    shouldAdd = false;
                    break;
                }
            }
            if (shouldAdd)
                stack.push(asteroids[i]);
        }
        int[] ans = new int[stack.size()];
        for (int t = ans.length - 1; t >= 0; --t) {
            ans[t] = stack.pop();
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(asteroidCollision(new int[]{5, -5})));
    }
}
