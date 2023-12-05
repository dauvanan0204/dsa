package Hw2_21000659_DauVanAn.genericsort;

import java.util.Arrays;

public class GenericInsertionSort<T> extends AbstractGenericSort<T> {
    public <T extends Comparable<T>> void sort(T[] array, int low, int high) {
        for (int i = 1; i < array.length; i++) {
            T next = array[i];
            int j;
            for (j = i - 1; j >= 0 && array[j].compareTo(next) > 0; j--) {
                array[j + 1] = array[j];
            }
            array[j + 1] = next;
        }
    }
}
