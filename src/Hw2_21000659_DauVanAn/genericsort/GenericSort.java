package Hw2_21000659_DauVanAn.genericsort;

interface GenericSort<T> {
    <T extends Comparable<T>> void sort(T[] array, int low, int high);
    <T extends Comparable<T>> void swap(T[] array, int i, int j);

}
