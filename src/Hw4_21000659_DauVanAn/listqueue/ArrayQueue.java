package Hw4_21000659_DauVanAn.listqueue;

import java.util.Iterator;

public class ArrayQueue<E> implements QueueInterface<E> {
    private E[] queue;
    private int n = 0;              // size of queue
    private int top = 0;            // index of front element
    private int count = 0;          // current number of elements
    private int defaultSize = 100;  // default size = 100
    public ArrayQueue(int capacity) {
        n = capacity;
        queue = (E[]) new Object[capacity];
    }

    public ArrayQueue() {
        n = defaultSize;
        queue = (E[]) new Object[defaultSize];
    }

    @Override
    public void enqueue(E element) {
        if (count == queue.length) {
            enlarge();
        }
        int available = (top + count) % queue.length;
        queue[available] = element;
        count++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            return null;
        }
        E answer = queue[top];
        queue[top] = null;
        top = (top + 1) % queue.length;
        count--;
        return answer;
    }

    @Override
    public boolean isEmpty() {
        return n == 0;
    }

    @Override
    public E first() {
        if (isEmpty()) {
            return null;
        }
        return queue[top];
    }
    public int size() {
        return n;
    }
    public void enlarge() {
        E[] newQueue = (E[]) new Object[queue.length * 2];
        for (int i = 0; i < n; i++) {
            newQueue[i + queue.length] = queue[i];
        }
        top = top + queue.length;
        queue = newQueue;
    }

    @Override
    public Iterator<E> iterator() {
        return new ArrayQueueIterator();
    }
    class ArrayQueueIterator implements Iterator<E> {
        private int current = top;
        private int num = 0;
        @Override
        public boolean hasNext() {
            return num < count;
        }

        @Override
        public E next() {
            E data = queue[(current + num) % n];
            num++;
            return data;
        }
    }
}
