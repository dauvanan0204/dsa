package Hw4_21000659_DauVanAn.listqueue;

public interface QueueInterface<E> extends Iterable<E> {
    public void enqueue(E element);
    public E dequeue();
    public boolean isEmpty();
    public E first();
}
