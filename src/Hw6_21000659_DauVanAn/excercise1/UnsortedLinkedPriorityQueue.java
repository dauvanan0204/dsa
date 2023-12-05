package Hw6_21000659_DauVanAn.excercise1;

import Hw3_21000659_DauVanAn.codelearn.Node;

public class UnsortedLinkedPriorityQueue<K extends Comparable, E> implements PriorityQueueInterface<K, E> {
    protected class NodeEntry<K, E> implements Entry<K, E> {
        private K key;
        private E element;
        private NodeEntry<K, E> next;

        public NodeEntry(K k, E e) {
            this.key = k;
            this.element = e;
        }

        public K getKey() {
            return key;
        }

        public E getValue() {
            return element;
        }
    }

    private NodeEntry<K, E> head;
    private NodeEntry<K, E> tail;
    private int n = 0;
    @Override
    public int size() {
        return n;
    }

    @Override
    public boolean isEmpty() {
        return n == 0;
    }

    @Override
    public void insert(Entry<K, E> entry) {
        NodeEntry<K, E> nodeEntry = new NodeEntry<>(entry.getKey(), entry.getValue());
        if (head == null) {
            head = nodeEntry;
            tail = nodeEntry;
        } else {
            tail.next = nodeEntry;
            tail = nodeEntry;
        }
        n++;
    }

    @Override
    public void insert(K k, E e) {
        NodeEntry<K, E> newEntry = new NodeEntry<>(k, e);
        insert(newEntry);
    }

    @Override
    public Entry<K, E> removeMin() {
        if (isEmpty()) {
            return null;
        }
        NodeEntry<K, E> current = head;
        NodeEntry<K, E> prev = null;
        NodeEntry<K, E> min = head;
        NodeEntry<K, E> minPrev = null;

        while (current != null) {
            if (min.getKey().compareTo(current.getKey()) > 0) {
                min = current;
                minPrev = prev;
            }
            prev = current;
            current = current.next;
        }

        if (minPrev != null) {
            minPrev.next = min.next;
        } else {
            head = min.next;
        }

        if (min == tail) {
            tail = minPrev;
        }
        n--;
        return min;
    }

    @Override
    public Entry<K, E> min() {
        if (isEmpty()) {
            return null;
        }
        NodeEntry<K, E> current = head;
        NodeEntry<K, E> min = head;

        while (current != null) {
            if (min.getKey().compareTo(current.getKey()) > 0) {
                min = current;
            }
            current = current.next;
        }

        return min;
    }
}
