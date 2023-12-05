package Hw4_21000659_DauVanAn.listqueue;

import java.util.Iterator;

public class LinkedListQueue<E> implements QueueInterface<E> {
    class Node {
        E data;
        Node next;
    }
    private int size = 0;
    private Node head = null;
    @Override
    public void enqueue(E element) {
        Node newNode = new Node();
        newNode.data = element;
        newNode.next = null;
        if (isEmpty()) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) return null;
        E data = head.data;
        head = head.next;
        size--;
        return data;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public E first() {
        if (isEmpty()) throw new IllegalStateException("Queue is empty");
        return head.data;
    }

    @Override
    public Iterator<E> iterator() {
        return new LinkedListQueueIterator();
    }
    class LinkedListQueueIterator implements Iterator<E> {
        private Node current;

        public LinkedListQueueIterator() {
            current = head;
        }
        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            if (!hasNext()) throw new IllegalStateException("No more elements");
            E data = current.data;
            current = current.next;
            return data;
        }
    }
}
