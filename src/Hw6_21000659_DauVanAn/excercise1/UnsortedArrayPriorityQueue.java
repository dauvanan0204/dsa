package Hw6_21000659_DauVanAn.excercise1;

import java.util.Arrays;

public class UnsortedArrayPriorityQueue<K extends Comparable, E> implements PriorityQueueInterface<K, E> {

    protected class ArrEntry<K, E> implements Entry<K, E> {
        K key;
        E element;
        public ArrEntry(K k, E e) {
            this.key = k;
            this.element = e;
        }
        public ArrEntry() {

        }
        @Override
        public K getKey() {
            return key;
        }

        @Override
        public E getValue() {
            return element;
        }
    }
    ArrEntry<K, E> [] array;
    int n = 0;
    int defaultSize = 1000;

    public UnsortedArrayPriorityQueue() {
        array = new ArrEntry[defaultSize];
    }
    public UnsortedArrayPriorityQueue(int capacity) {
        array = new ArrEntry[capacity];
    }

    @Override
    public int size() {
        return n;
    }

    @Override
    public boolean isEmpty() {
        return n == 0;
    }

    @Override
    public void insert(Entry entry) {
        if (n == array.length) {
                array = Arrays.copyOf(array, array.length * 2);
        }
        this.array[n] = (ArrEntry<K, E>) entry;
        n++;
    }

    @Override
    public void insert(K k, E e) {
        ArrEntry<K, E> newEntry = new ArrEntry<>((K) k, (E) e);
        insert(newEntry);
    }

    @Override
    public Entry removeMin() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        ArrEntry<K, E> highestPriority = array[0];
        int minIndex = 0;
        for (int i = 0; i < n; i++) {
            if (array[i].getKey().compareTo(highestPriority.getKey()) < 0) {
                highestPriority = array[i];
                minIndex = i;
            }
        }
        for (int i = minIndex; i < n; i++) {
            array[i] = array[i + 1];
        }
        array[n - 1] = null;
        n--;
        return highestPriority;
    }

    @Override
    public Entry min() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        ArrEntry<K, E> highestPriority = array[0];
        for (int i = 1; i < n; i++) {
            if (array[i].getKey().compareTo(highestPriority.getKey()) < 0) {
                highestPriority = array[i];
            }
        }
        return highestPriority;
    }
}
