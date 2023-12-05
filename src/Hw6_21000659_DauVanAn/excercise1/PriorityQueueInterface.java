package Hw6_21000659_DauVanAn.excercise1;

public interface PriorityQueueInterface<K, E> {
    public int size();
    public boolean isEmpty();
    public void insert(Entry<K, E> entry);
    public void insert(K k, E e);
    public Entry<K, E> removeMin();
    public Entry<K, E> min();
}
