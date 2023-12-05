package Hw6_21000659_DauVanAn.excercise1;

public class SortedLinkedPriorityQueue<K extends Comparable<K>, E> implements PriorityQueueInterface<K, E> {
    protected class NodeEntry<K, E> implements Entry<K, E> {
        private K key;
        private E element;
        private NodeEntry<K, E> next;

        public NodeEntry(K k, E e) {
            key = k;
            element = e;
        }

        public K getKey() {
            return key;
        }

        public E getValue() {
            return element;
        }
    }

    private NodeEntry<K, E> head;
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
        NodeEntry<K, E> newEntry = new NodeEntry<>(entry.getKey(), entry.getValue());

        if (isEmpty() || head.getKey().compareTo(entry.getKey()) > 0) {
            newEntry.next = head;
            head = newEntry;
        } else {
            NodeEntry<K, E> current = head;
            while (current.next != null && current.next.getKey().compareTo(entry.getKey()) < 0) {
                current = current.next;
            }
            newEntry.next = current.next;
            current.next = newEntry;
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

        NodeEntry<K, E> removed = head;
        head = head.next;
        n--;
        return removed;
    }

    @Override
    public Entry<K, E> min() {
        return head;
    }
}

