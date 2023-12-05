package Hw7_21000659_DauVanAn.excercise1.simplearraylist;

public interface ListInterface<T> extends Iterable<T> {
    public void add(T data);
    public T get(int i);
    public void set(int i, T data);
    public void remove(T data);
    public void isContain(T data);
    public int size();
    public boolean isEmpty();
}
