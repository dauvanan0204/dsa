package Hw7_21000659_DauVanAn.excercise1.simplelinkedlist;

public class SimpleLinkedList<T> {
    class Node {
        T data;
        Node next;
    }
    private Node top = null;
    private Node bot = null;
    private int n = 0;

    public void add(T data) {
        Node newNode = new Node();
        newNode.data = data;
        newNode.next = null;
        if (top == null) {
            top = newNode;
            bot = newNode;
        } else {
            bot.next = newNode;
            bot = newNode;
        }
        n++;
    }
    public void addBot(T data) {
        Node newNode = new Node();
        newNode.data = data;
        newNode.next = null;

        if (bot == null) {
            top = bot = newNode;
        } else {
            bot.next = newNode;
            bot = newNode;
        }
        n++;
    }
    public T get(int i) {
        checkBoundaries(i, n - 1);
        Node current = top;
        int count = 0;

        while (count < i) {
            current = current.next;
            count++;
        }

        return current.data;
    }
    public void set(int i, T data) {
        checkBoundaries(i, n - 1);
        Node current = top;
        int count = 0;
        while (count < i) {
            current = current.next;
            count++;
        }
        current.data = data;
    }
    public boolean isContain(T data) {
        Node current = top;
        while (current != null) {
            if (current.data.equals(data)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }
    public int size() {
        return this.n;
    }
    public boolean isEmpty() {
        return this.n == 0;
    }
    public T removeTop() {
        if (isEmpty()) {
            return null;
        }
        T removedData = top.data;
        top = top.next;
        if (top == null) {
            bot = null;
        }
        n--;
        return removedData;
    }
    public T removeBot() {
        if (isEmpty()) {
            return null;
        }
        T removedData = bot.data;

        if (size() == 1) {
            top = null;
            bot = null;
        } else {
            Node current = top;
            while (current.next != bot) {
                current = current.next;
            }
            current.next = null;
            bot = current;
        }
        n--;
        return removedData;
    }
    public void remove(T data) {
        if (isEmpty()) {
            return;
        }
        if (top.data.equals(data)) {
            removeTop();
            return;
        }
        Node current = top;
        while (current.next != null) {
            if (current.next.data.equals(data)) {
                current.next = current.next.next;
                if (current.next == null) {
                    bot = current;
                }
                n--;
                return;
            }
            current = current.next;
        }
    }
    public void checkBoundaries(int index, int limit) {
        if(index < 0 || index > limit) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node current = top;

        while (current != null) {
            sb.append(current.data);
            if (current.next != null) {
                sb.append(", ");
            }
            current = current.next;
        }

        sb.append("]");
        return sb.toString();
    }
}
