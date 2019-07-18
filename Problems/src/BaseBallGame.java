import java.util.Stack;

public class BaseBallGame {
   private static int calPoints(String[] ops) {
      Stack<Integer> stack = new Stack<>();
      int sum = 0;
      for(String op : ops) {
         if(op.equals("C")) {
            sum -= stack.peek();
            stack.pop();
         } else if(op.equals("D")) {
            int t = stack.peek() * 2;
            sum += t;
            stack.push(stack.peek() * 2);
         } else if(op.equals("+")) {
            int t1 = stack.pop(), t2 =  stack.pop();
            sum += t1 + t2;
            stack.push(t2);
            stack.push(t1);
            stack.push(t1 + t2);
         } else {
            int t = Integer.parseInt(op);
            sum += t;
            stack.push(t);
         }
      }
      return sum;

   }

   public static void main(String[] args) {
      System.out.println(calPoints(new String[]{"5","2","C","D","+"}));
   }
}
