package Hw2_21000659_DauVanAn.genericsort;

public class GenericSelectionSort<T> extends AbstractGenericSort<T> {
    public <T extends Comparable<T>> void sort(T[] array, int low, int high) {
        for (int i = array.length - 1; i >= 1; i--) {
            int maxIdx = i;
            for (int j = 0; j < i; j++) {
                if (array[j].compareTo(array[maxIdx]) >= 0) {
                    maxIdx = j;
                }
            }
            swap(array, maxIdx, i);
        }
    }
}
