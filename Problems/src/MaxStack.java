import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MaxStack {

    /** initialize your data structure here. */
    Stack<Integer> stack;
    Stack<Integer> maxStack;
    public MaxStack() {
        stack = new Stack<>();
        maxStack = new Stack<>();
    }

    public void push(int x) {
        int max = maxStack.isEmpty() ? x : maxStack.peek();
        maxStack.push(x > max ? x : max);
        stack.push(x);
    }

    public int pop() {
        maxStack.pop();
        return stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int peekMax() {
        return maxStack.peek();
    }

    public int popMax() {
        int max = maxStack.peek();
        Stack<Integer> temp = new Stack<>();
        while(top() != max) temp.push(pop());
        pop();
        while(!temp.isEmpty()) push(temp.pop());
        return max;
    }

    public static void main(String[] args) {
        MaxStack obj = new MaxStack();
        obj.push(5);
        obj.push(1);
        obj.push(-5);
        System.out.println(obj.popMax());
        System.out.println(obj.popMax());
        System.out.println(obj.peekMax());
        System.out.println(obj.top());
        System.out.println("---------");
//        System.out.println(obj.pop());
        MaxStack2 stack = new MaxStack2();
        stack.push(5);
        stack.push(1);
        stack.push(-5);
        System.out.println(stack.popMax());
        System.out.println(stack.popMax());
        System.out.println(stack.peekMax());
        System.out.println(stack.top());
    }
}

class MaxStack2 {

    Stack<Integer> stack;
    List<Integer> list;

    public MaxStack2(){
        stack = new Stack<>();
        list = new ArrayList<>();
    }

    public void push(int x){
        int max = list.isEmpty() ? x : list.get(list.size()-1);
        list.add(max > x ? max : x);
        stack.push(x);
    }

    public int pop(){
        list.remove(stack.peek());
        return stack.pop();
    }

    public int top(){
        return stack.peek();
    }

    public int peekMax(){
        return list.get(list.size()-1);
    }

    public int popMax() {
        int max = list.get(list.size()-1);
        Stack<Integer> temp = new Stack<>();
        while(top() != max) temp.push(pop());
        pop();
        while(!temp.isEmpty()) push(temp.pop());
        return max;
    }
}