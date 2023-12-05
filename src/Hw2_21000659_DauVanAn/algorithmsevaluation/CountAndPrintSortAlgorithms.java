package Hw2_21000659_DauVanAn.algorithmsevaluation;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class CountAndPrintSortAlgorithms {
    private static int quickSortComparisons = 0;
    private static int quickSortSwaps = 0;
    private static int mergeSortComparisons = 0;
    private static int mergeSortSwaps = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input number of array: ");
        int n = scanner.nextInt();
        int[] array = new int[n];
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            int randomNumber = rand.nextInt(1000000) + 1;
            array[i] = randomNumber;
        }
        System.out.println("Bubble Sort: ");
        bubbleSort(array.clone());
        System.out.println("----------------------------------------------");
        System.out.println("Selection Sort: ");
        selectionSort(array.clone());
        System.out.println("----------------------------------------------");
        System.out.println("Insertion Sort: ");
        insertionSort(array.clone());
        System.out.println("----------------------------------------------");
        System.out.println("Quick Sort: ");
        quickSort(array.clone(), 0, n - 1);
        System.out.println("Compare times: " + quickSortComparisons);
        System.out.println("Swap times: " + quickSortSwaps);
        System.out.println("----------------------------------------------");
        System.out.println("Merge Sort: ");
        mergeSort(array.clone(), 0, n - 1);
        System.out.println("Compare times: " + mergeSortComparisons);
        System.out.println("Swap times: " + mergeSortSwaps);
    }
    public static void bubbleSort(int[] array) {
        int countCompare = 0;
        int countSwap = 0;
        for (int i = 0; i < array.length; i++) {
            boolean isSorted = true;
            countCompare++;
            for (int j = 1; j < array.length - i; j++) {
                if (array[j - 1] > array[j]){
                    swap(array, j - 1, j);
                    isSorted = false;
                    countSwap++;

                }
            }
            System.out.println(Arrays.toString(array));
            if (isSorted) {
                break;
            }
        }
        System.out.println("Compare times: " + countCompare);
        System.out.println("Swap times: " + countSwap);
    }
    public static void selectionSort(int[] array) {
        int countCompare = 0;
        int countSwap = 0;
        for (int i = array.length - 1; i >= 1; i--) {
            int maxIdx = i;
            for (int j = 0; j < i; j++) {
                countCompare++;
                if (array[j] >= array[maxIdx]) {
                    maxIdx = j;
                }
            }
            swap(array, maxIdx, i);
            countSwap++;
            System.out.println(Arrays.toString(array));
        }
        System.out.println("Compare times: " + countCompare);
        System.out.println("Swap times: " + countSwap);
    }
    public static void insertionSort(int[] array) {
        int countCompare = 0;
        int countSwap = 0;
        for (int i = 1; i < array.length; i++) {
            int next = array[i];
            int j;
            for (j = i - 1; j >= 0 && array[j] > next; j--) {
                countCompare++;
                array[j + 1] = array[j];
                countSwap++;
            }
            array[j + 1] = next;
            System.out.println(Arrays.toString(array));
        }
        System.out.println("Compare times: " + countCompare);
        System.out.println("Swap times: " + countSwap);
    }
    public static void swap(int[] arr, int i, int j) {
        quickSortSwaps++;
        mergeSortSwaps++;
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j <= high - 1; j++) {
            quickSortComparisons++;
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            System.out.println(Arrays.toString(arr));
            System.out.println(Arrays.toString(arr));
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }
    public static void merge(int[] array, int low, int mid, int high) {
        int n = high - low + 1;
        int[] b = new int[n];
        int left = low, right = mid + 1, bIdx = 0;

        while (left <= mid && right <= high) {
            mergeSortComparisons++;
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
        Arrays.toString(Arrays.copyOfRange(array, low, high+1));
    }
    public static void mergeSort(int[] arr, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;

            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);
            merge(arr, low, mid, high);
            System.out.println(Arrays.toString(arr));
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
