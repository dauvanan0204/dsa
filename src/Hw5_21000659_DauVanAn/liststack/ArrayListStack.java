package Hw5_21000659_DauVanAn.liststack;

import java.util.Iterator;

public class ArrayListStack<E> implements StackInterface<E> {
    public static final int CAPACITY = 100;
    private E[] data;
    private int t = -1;  // index of top element in stack

    public ArrayListStack(int capacity) {
        data = (E[]) new Object[capacity];
    }

    public ArrayListStack() {
        data = (E[]) new Object[CAPACITY];
    }

    @Override
    public void push(E element) {
        if (size() == data.length) {
            throw new IllegalStateException("Stack is full");
        }
        data[++t] = element;
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            return null;
        }
        E element = data[t];
        data[t] = null;
        t--;
        return element;
    }

    @Override
    public boolean isEmpty() {
        return t == -1;
    }

    @Override
    public E top() {
        if (isEmpty()) {
            return null;
        }
        return data[t];
    }
    @Override
    public int size() {
        return t + 1;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int currentIndex = 0;
            @Override
            public boolean hasNext() {
                return currentIndex < size() && data[currentIndex] != null;
            }

            @Override
            public E next() {
                return data[t + 1];
            }
        };
    }
}
