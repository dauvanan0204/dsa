package Hw2_21000659_DauVanAn.algorithmsevaluation;

public class SelectionSort implements Sorter {
    @Override
    public void sort(int[] array, int low, int high) {
        for (int i = array.length - 1; i >= 1; i--) {
            int maxIdx = i;
            for (int j = 0; j < i; j++) {
                if (array[j] >= array[maxIdx]) {
                    maxIdx = j;
                }
            }
            int temp = array[maxIdx];
            array[maxIdx] = array[i];
            array[i] = temp;
        }
    }

}
