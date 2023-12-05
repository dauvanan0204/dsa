package Hw2_21000659_DauVanAn.sortalgorithms;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class BubbleSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input number of array:");
        int n = scanner.nextInt();
        int[] array = new int[n];
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            int randomNumber = rand.nextInt(10000000) + 1;
            array[i] = randomNumber;
        }
        System.out.println(Arrays.toString(array));
        System.out.println();
        int countCompare = 0;
        int countSwap = 0;
        for (int i = 0; i < array.length; i++) {
            boolean isSorted = true;
            for (int j = 1; j < array.length - i; j++) {
                countCompare++;
                if (array[j - 1] > array[j]){
                    swap(array, j - 1, j);
                    isSorted = false;
                    countSwap++;
                    System.out.println(Arrays.toString(array));
                }
            }
            if (isSorted) {
                break;
            }
        }
        System.out.println(Arrays.toString(array));
        System.out.println(countCompare);
        System.out.println(countSwap);
    }
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
