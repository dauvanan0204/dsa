package Hw2_21000659_DauVanAn.algorithmsevaluation;

public class InsertionSort implements Sorter {
    @Override
    public void sort(int[] array, int low, int high) {
        for (int i = 1; i < array.length; i++) {
            int next = array[i];
            int j;
            for (j = i - 1; j >= 0 && array[j] > next; j--) {
                array[j + 1] = array[j];
            }
            array[j + 1] = next;
        }
    }
}
