package Hw2_21000659_DauVanAn.sortalgorithms;

import java.util.Random;
import java.util.Scanner;

public class MergeSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input number of array: ");
        int n = scanner.nextInt();
        int[] array = new int[n];
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            int randomNumber = rand.nextInt(10000000) + 1;
            array[i] = randomNumber;
        }
        mergeSort(array, 0, n - 1);
        printArray(array);
    }
    public static void merge(int[] array, int low, int mid, int high) {
        int n = high - low + 1;
        int[] b = new int[n];
        int left = low, right = mid + 1, bIdx = 0;

        while (left <= mid && right <= high) {
            if (array[left] < array[right]) {
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
    public static void mergeSort(int[] a, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;

            mergeSort(a, low, mid);
            mergeSort(a, mid + 1, high);
            merge(a, low, mid, high);
        }
    }
    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (i == 0) {
                System.out.print("[" + array[i]);
            } else {
                System.out.print(", " + array[i]);
            }
        }
        System.out.print("]");
    }
}
