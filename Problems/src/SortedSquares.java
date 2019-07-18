import java.util.Stack;

public class SortedSquares {
    public static int[] sortedSquares1(int[] A) {
        int[] ans = new int[A.length];
        int ind= A.length-1;
        for(int i=0, j = A.length-1; i<=j;){
            ans[ind--] = A[i]*A[i] > A[j]*A[j] ? A[i]*A[i++] : A[j]*A[j--];
        }
        return ans;
    }

    public static int[] sortedSquares(int[] A) {
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[A.length];
        int j= 0;
        for(int i=0; i<A.length; i++){
            if(A[i] < 0)
                stack.push(A[i]*A[i]);
            else if(!stack.isEmpty() && stack.peek() < A[i]*A[i]) {
                ans[j++] = stack.pop();
                i--;
            }
            else if(!stack.isEmpty() && stack.peek() == A[i]*A[i]) {
                ans[j++] = A[i]*A[i];
            }
            else if(stack.isEmpty() || stack.peek() > A[i]*A[i])
                ans[j++] = A[i]*A[i];
        }
        while(!stack.isEmpty())
            ans[j++] = stack.pop();
        return ans;
    }

    public static void main(String[] args) {
        int[] ans = sortedSquares1(new int[]{-4,-1,0,3,10});
        for(int i: ans)
            System.out.println(i);

    }
}
