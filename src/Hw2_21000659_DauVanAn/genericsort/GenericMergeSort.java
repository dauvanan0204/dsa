package Hw2_21000659_DauVanAn.genericsort;

public class GenericMergeSort<T> extends AbstractGenericSort<T>  {
    public <T extends Comparable<T>> void sort(T[] array, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;

            sort(array, low, mid);
            sort(array, mid + 1, high);
            merge(array, low, mid, high);
        }
    }
    public <T extends Comparable<T>> void merge(T[] array, int low, int mid, int high) {
        int n = high - low + 1;
        T[] b = (T[]) new Comparable[n];
        int left = low, right = mid + 1, bIdx = 0;

        while (left <= mid && right <= high) {
            if (array[left].compareTo(array[right]) < 0) {
                b[bIdx++] = array[left++];
            } else {
                b[bIdx++] = array[right++];
            }
        }
        while (left <= mid) {
            b[bIdx++] = array[left++];
        }
        while (right <= high) {
            b[bIdx++] = array[right++];
        }
        for (int k = 0; k < n; k++) {
            array[low + k] = b[k];
        }
    }
}
