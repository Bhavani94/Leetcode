import java.util.LinkedList;

public class Fifo {
    private final LinkedList<Integer> queue;

    public Fifo() {
        queue = new LinkedList<>();
    }

    public void enqueue(int value) {
        queue.addLast(value);
    }

    public int dequeue() {
        return queue.isEmpty() ? Integer.MIN_VALUE : queue.removeFirst();
    }

    public static void main(String[] args) {
        Fifo fifo = new Fifo();
        fifo.enqueue(1);
        fifo.enqueue(2);
        fifo.enqueue(3);
        System.out.println(fifo.dequeue());
        System.out.println(fifo.dequeue());
        System.out.println(fifo.dequeue());
        System.out.println(fifo.dequeue());
    }
}
