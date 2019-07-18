import java.util.Stack;

public class QueueUsingStack {
   /** Initialize your data structure here. */
   Stack<Integer> stack;
   Stack<Integer> tempStack;

   public QueueUsingStack() {
      stack = new Stack<>();
      tempStack = new Stack<>();
   }

   /** Push element x to the back of queue. */
   public void push(int x) {
      while(!stack.isEmpty())
         tempStack.add(stack.pop());

      tempStack.add(x);

      while(!tempStack.isEmpty())
         stack.add(tempStack.pop());
   }

   /** Removes the element from in front of queue and returns that element. */
   public int pop() {
      return stack.pop();
   }

   /** Get the front element. */
   public int peek() {
      return stack.peek();
   }

   /** Returns whether the queue is empty. */
   public boolean empty() {
      return stack.isEmpty();
   }

   public static void main(String[] args) {
      QueueUsingStack queue = new QueueUsingStack();
      queue.push(1);
      queue.push(2);
      System.out.println(queue.peek());  // returns 1
      System.out.println(queue.pop());   // returns 1
      System.out.println(queue.empty()); // returns false

   }
}
