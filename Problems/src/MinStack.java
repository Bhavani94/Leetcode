import java.util.Stack;

public class MinStack {
    /** initialize your data structure here. */
    Stack<Integer> stack;
    int min = Integer.MAX_VALUE;

    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int x) {
        if(min >= x) {
            stack.push(min);
            min = x;
        }
        stack.push(x);
    }

    public void pop() {
        if(min == stack.pop())
            min = stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }

    public static void main(String[] args) {

        /*
        ["MinStack","push","push","push","top","pop","getMin","pop","getMin","pop","push","top","getMin","push","top","getMin","pop","getMin"]
[[],[2147483646],[2147483646],[2147483647],[],[],[],[],[],[],[2147483647],[],[],[-2147483648],[],[],[],[]]
         */
        MinStack obj = new MinStack();
        obj.push(1);
        obj.push(1);
        obj.push(1);
        System.out.println(obj.top());
        obj.pop();
        System.out.println(obj.getMin());
        obj.pop();
        System.out.println(obj.getMin());
        obj.pop();
        obj.push(1);
        System.out.println(obj.top());
        System.out.println(obj.getMin());
        obj.push(-1);
        System.out.println(obj.top());
        System.out.println(obj.getMin());
        obj.pop();
        System.out.println(obj.getMin());
    }
}
