import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {
   /** Initialize your data structure here. */
   Queue<Integer> queue;
   public StackUsingQueue() {
      this.queue = new LinkedList<>();
   }

   /** Push element x onto stack. */
   public void push(int x) {
      this.queue.add(x);
      for(int i = 0; i < queue.size() - 1; i++) {
         queue.add(queue.poll());
      }
   }

   /** Removes the element on top of the stack and returns that element. */
   public int pop() {
      return queue.poll();
   }

   /** Get the top element. */
   public int top() {
      return queue.peek();
   }

   /** Returns whether the stack is empty. */
   public boolean empty() {
      return queue.isEmpty();
   }

   public static void main(String[] args) {
      StackUsingQueue stack = new StackUsingQueue();
      stack.push(1);
      stack.push(2);
      System.out.println(stack.top());   // returns 2
      System.out.println(stack.pop());   // returns 2
      System.out.println(stack.empty()); // returns false
   }
}
