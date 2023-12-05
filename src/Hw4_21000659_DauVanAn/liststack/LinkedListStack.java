package Hw4_21000659_DauVanAn.liststack;

import java.util.Iterator;

public class LinkedListStack<E> implements StackInterface<E> {
    class Node {
        E element;
        Node next;
    }
    private Node stack = null;
    private int size = 0;
    @Override
    public void push(E element) {
        Node node = new Node();
        node.element = element;
        node.next = stack;
        stack = node;
        size++;
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            return null;
        }
        E element = stack.element;
        stack = stack.next;
        size--;
        return element;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public E top() {
        if (isEmpty()) {
            return null;
        }
        return stack.element;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<E> iterator() {
        return new StackIterator();
    }
    class StackIterator implements Iterator<E> {
        private Node currentNode = stack;
        @Override
        public boolean hasNext() {
            return currentNode != null;
        }

        @Override
        public E next() {
            E data = currentNode.element;
            currentNode = currentNode.next;
            return data;
        }
    }
}
