package Hw2_21000659_DauVanAn.genericsort;

public abstract class AbstractGenericSort<T> implements GenericSort<T> {
    public <T extends Comparable<T>> void sort(T[] array, int low, int high) {

    }

    @Override
    public <T extends Comparable<T>> void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
