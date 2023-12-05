package Hw2_21000659_DauVanAn.genericsort;

public class GenericBubbleSort<T> extends AbstractGenericSort<T> {
    public <T extends Comparable<T>> void sort(T[] array, int low, int high) {
        for (int i = 0; i < array.length; i++) {
            boolean isSorted = true;
            for (int j = 1; j < array.length - i; j++) {
                if (array[j - 1].compareTo(array[j]) > 0) {
                    swap(array, j - 1, j);
                }
                isSorted = false;
            }
            if (isSorted) {
                break;
            }
        }
    }
}
