public class DeepCopyLinkedList {
    private static class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {}

        public Node(int _val,Node _next,Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    }

    public static Node copyRandomList(Node head) {
        if(head == null)
            return null;

        Node current = head;
        // A->A->B->B->C->C->D->D
        // no random pointer copied
        while(current != null) {
            Node temp = current.next;
            current.next = new Node(current.val, temp, null);
            current = temp;
        }

        // assign random
        current = head;
        while (current != null) {
            if(current.random != null)
                current.next.random = current.random.next;
            current = current.next.next;
        }

        // break lists
        current = head;
        Node copyList = head.next;
        while (current != null) {
            Node copy = current.next;
            Node next = current.next.next;
            // break previous link
            current.next = copy.next;

            // fix next link
            if(next != null)
                copy.next = next.next;
            current = next;
        }
        return copyList;
    }

    public static void main(String[] args) {
        Node n4 = new Node(4, null, null);
        Node n3 = new Node(3, n4, null);
        Node n2 = new Node(2, n3, n4);
        Node head = new Node(1, n2, n3);

        Node head2 = copyRandomList(head);
        print(head2);
    }

    private static void print(Node node) {
        while(node != null) {
            System.out.println(node.val);
            if(node.random != null) {
                System.out.print("#");
                System.out.print(node.random.val);
                System.out.print("#");
            }
            if(node.next != null)
                System.out.print("->");
            node = node.next;
        }
    }

}
