package Hw2_21000659_DauVanAn.algorithmsevaluation;

public class BubbleSort implements Sorter {
    @Override
    public void sort(int[] array, int low, int high) {
        for (int i = 0; i < array.length; i++) {
            boolean isSorted = true;
            for (int j = 1; j < array.length - i; j++) {
                if (array[j - 1] > array[j]){
                    int temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                    isSorted = false;
                }
            }
            if (isSorted) {
                break;
            }
        }
    }
}
