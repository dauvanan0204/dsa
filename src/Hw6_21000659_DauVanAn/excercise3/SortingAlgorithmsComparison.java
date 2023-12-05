package Hw6_21000659_DauVanAn.excercise3;

import Hw6_21000659_DauVanAn.excercise2.MinHeapPriorityQueue;
import java.util.Arrays;
import java.util.Random;

public class SortingAlgorithmsComparison {

    public static void heapSort(int[] arr) {
        MinHeapPriorityQueue<Integer, Integer> heap = new MinHeapPriorityQueue<>();

        // Thêm các phần tử vào heap
        for (int num : arr) {
            heap.insert(num, num);
        }

        // Lấy và ghi lại các phần tử theo thứ tự tăng dần
        int index = 0;
        while (!heap.isEmpty()) {
            arr[index++] = heap.removeMin().getValue();
        }
    }

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    public static void mergeSort(int[] arr, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    private static void merge(int[] arr, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        int L[] = new int[n1];
        int R[] = new int[n2];

        for (int i = 0; i < n1; ++i) {
            L[i] = arr[l + i];
        }
        for (int j = 0; j < n2; ++j) {
            R[j] = arr[m + 1 + j];
        }

        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
    public static long[] test() {
        int n = 10000; // Độ dài của mảng
        int[] arr = new int[n];

        Random random = new Random();

        for (int i = 0; i < n; i++) {
            int rand = random.nextInt(n * 10);
            arr[i] = rand;
        }

        long[] elapsedTimes = new long[6];
        long startTime, endTime;

        // BubbleSort
        startTime = System.nanoTime();
        bubbleSort(arr.clone());
        endTime = System.nanoTime();
        elapsedTimes[0] = endTime - startTime;
        System.out.println("BubbleSort: " + elapsedTimes[0] + " nanoseconds");

        // InsertionSort
        startTime = System.nanoTime();
        insertionSort(arr.clone());
        endTime = System.nanoTime();
        elapsedTimes[1] = endTime - startTime;
        System.out.println("InsertionSort: " + elapsedTimes[1] + " nanoseconds");

        // SelectionSort
        startTime = System.nanoTime();
        selectionSort(arr.clone());
        endTime = System.nanoTime();
        elapsedTimes[2] = endTime - startTime;
        System.out.println("SelectionSort: " + elapsedTimes[2] + " nanoseconds");

        // HeapSort
        startTime = System.nanoTime();
        heapSort(arr.clone());
        endTime = System.nanoTime();
        elapsedTimes[3] = endTime - startTime;
        System.out.println("HeapSort: " + elapsedTimes[3] + " nanoseconds");

        // QuickSort
        startTime = System.nanoTime();
        quickSort(arr.clone(), 0, arr.length - 1);
        endTime = System.nanoTime();
        elapsedTimes[4] = endTime - startTime;
        System.out.println("QuickSort: " + elapsedTimes[4] + " nanoseconds");

        // MergeSort
        startTime = System.nanoTime();
        mergeSort(arr.clone(), 0, arr.length - 1);
        endTime = System.nanoTime();
        elapsedTimes[5] = endTime - startTime;
        System.out.println("MergeSort: " + elapsedTimes[5] + " nanoseconds");

        System.out.println("Array of time sorting: ");
        System.out.println(Arrays.toString(elapsedTimes));

        return elapsedTimes;
    }
    public static void main(String[] args) {
        test();
    }
}


