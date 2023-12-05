package Hw2_21000659_DauVanAn.sortalgorithms;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] array = new int[]{29, 10, 14, 37, 13};

        selectionSortByMaxIdx(array);
        selectionSortByMinIdx(array);
    }
    public static void selectionSortByMaxIdx(int[] array) {
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
        System.out.println(Arrays.toString(array));
    }
    public static void selectionSortByMinIdx(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIdx]) {
                    minIdx = j;
                }
            }
            int temp = array[i];
            array[i] = array[minIdx];
            array[minIdx] = temp;
        }
        System.out.println(Arrays.toString(array));
    }
}
