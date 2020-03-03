/**
 * My linked list realization
 */

public class MyLinkedList<T> {

    public Node head;

    static class Node<T>  {
        private T data;
        private Node next;
        public Node(T data) {
            this.data = data;
        }

        public Node next() {
            return next;
        }

        public void setNext(Node node) {
            next = node;
        }

        public T getData() {
            return data;
        }
    }

    // constructs list with nodes
    MyLinkedList (Object ... nodes) {
        for (Object node : nodes) {
            Node listNode = new Node(node);
            add(listNode);
        }
    }

    public void add(Node node) {
        if (head == null) {
            head = node;
            return;
        }
        Node tail = head;
        while (tail.next() != null)
            tail = tail.next();
        tail.setNext(node);
    }

    @Override
    public String toString() {
        Node node = head;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        while (node != null) {
            stringBuilder.append(node.data.toString());
            stringBuilder.append("->");
            node = node.next();
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public int size() {
        Node node = head;
        int size = 0;
        while (node != null) {
            size++;
            node = node.next();
        }
        return size;
    }

}
