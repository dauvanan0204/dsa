package Hw2_21000659_DauVanAn.algorithmsevaluation;

import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class TestSorter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input length of array: ");
        int length = scanner.nextInt();

        // test a: input small length of array
        int[] data = new int[length];
        System.out.print("Input element of array: ");
        for (int i = 0; i < data.length; i++) {
            data[i] = scanner.nextInt();
        }
        DataSet dataSet = new DataSet(data);
        dataSet.setStrategy(new BubbleSort());
        dataSet.sort();
        System.out.println(dataSet);

        // test b,c, e:
        System.out.print("Input length of array: ");
        int lengthOfArray = scanner.nextInt();
        testBubbleSort(lengthOfArray);
        testIsertionSort(lengthOfArray);
        testSelectionSort(lengthOfArray);
        testQuickSort(lengthOfArray);
        testMergeSort(lengthOfArray);

        // Test average time run program 20 times and compare sort algorithms
        printAverageTime(lengthOfArray);
    }
    public static long[] timeToRunProgame(Sorter strategy, int lengthOfArray) {
        long[] timeArray = new long[20];
        for (int i = 0; i < 20; i++) {
            DataSet dataSet = new DataSet(lengthOfArray);
            dataSet.setStrategy(strategy);
            final long startTime = System.nanoTime();
            dataSet.sort();
            final long endTime = System.nanoTime();
            timeArray[i] = endTime - startTime;
        }
        return timeArray;
    }
    public static long averageTime(long[] timeArray) {
        long sum = 0;
        for (int i = 0; i < timeArray.length; i++) {
            sum += timeArray[i];
        }
        long averageTime = sum / timeArray.length;
        return averageTime;
    }
    public static void printAverageTime(int lengthOfArray) {
        long[] timeOfBubbleSort = timeToRunProgame(new BubbleSort(), lengthOfArray);
        long averageTimeOfBubbleSort = averageTime(timeOfBubbleSort);
        long[] timeOfInsertionSort = timeToRunProgame(new InsertionSort(), lengthOfArray);
        long averageTimeOfInsertionSort = averageTime(timeOfInsertionSort);
        long[] timeOfSelectionSort = timeToRunProgame(new SelectionSort(), lengthOfArray);
        long averageTimeOfSelectionSort = averageTime(timeOfSelectionSort);
        long[] timeOfQuickSort = timeToRunProgame(new QuickSort(), lengthOfArray);
        long averageTimeOfQuickSort = averageTime(timeOfQuickSort);
        long[] timeOfMergeSort = timeToRunProgame(new MergeSort(), lengthOfArray);
        long averageTimeOfMergeSort = averageTime(timeOfMergeSort);
        System.out.println("Average time of bubble sort: " + averageTimeOfBubbleSort);
        System.out.println("Average time of insertion sort: " + averageTimeOfInsertionSort);
        System.out.println("Average time of selection sort: " + averageTimeOfSelectionSort);
        System.out.println("Average time of quick sort: " + averageTimeOfQuickSort);
        System.out.println("Average time of merge sort: " + averageTimeOfMergeSort);
    }
    public static void testBubbleSort(int lengthOfArray) {
        System.out.println("Test Bubble Sort: ");
        DataSet dataSet1 = new DataSet(lengthOfArray);
        System.out.println("Random array: ");
        System.out.println(dataSet1);
        // Set type of sort:
        dataSet1.setStrategy(new BubbleSort());
        System.out.println("Array after sort: ");
        dataSet1.sort();
        System.out.println(dataSet1);
        long[] timeArray1 = timeToRunProgame(new BubbleSort(), lengthOfArray);
        System.out.println("Array of time run program 20 times: ");
        System.out.println(Arrays.toString(timeArray1));
        System.out.println("Time average run program 20 times: " + averageTime(timeArray1));
        System.out.println("--------------------------------------------------------------------------------");
    }
    public static void testIsertionSort(int lengthOfArray) {
        System.out.println("Test Insertion Sort: ");
        DataSet dataSet2 = new DataSet(lengthOfArray);
        System.out.println("Random array: ");
        System.out.println(dataSet2);
        dataSet2.setStrategy(new InsertionSort());
        System.out.println("Array after sort: ");
        dataSet2.sort();
        System.out.println(dataSet2);
        long[] timeArray2 = timeToRunProgame(new InsertionSort(), lengthOfArray);
        System.out.println("Array of time run program 20 times: ");
        System.out.println(Arrays.toString(timeArray2));
        System.out.println("Time average run program 20 times: " + averageTime(timeArray2));
        System.out.println("--------------------------------------------------------------------------------");
    }
    public static void testSelectionSort(int lengthOfArray) {
        System.out.println("Test Selection Sort: ");
        DataSet dataSet3 = new DataSet(lengthOfArray);
        System.out.println("Random array: ");
        System.out.println(dataSet3);
        dataSet3.setStrategy(new SelectionSort());
        System.out.println("Array after sort: ");
        dataSet3.sort();
        System.out.println(dataSet3);
        long[] timeArray3 = timeToRunProgame(new SelectionSort(), lengthOfArray);
        System.out.println("Array of time run program 20 times: ");
        System.out.println(Arrays.toString(timeArray3));
        System.out.println("Time average run program 20 times: " + averageTime(timeArray3));
        System.out.println("--------------------------------------------------------------------------------");
    }
    public static void testQuickSort(int lengthOfArray) {
        System.out.println("Test Quick Sort: ");
        DataSet dataSet4 = new DataSet(lengthOfArray);
        System.out.println("Random array: ");
        System.out.println(dataSet4);
        dataSet4.setStrategy(new QuickSort());
        System.out.println("Array after sort: ");
        dataSet4.sort();
        System.out.println(dataSet4);
        long[] timeArray4 = timeToRunProgame(new QuickSort(), lengthOfArray);
        System.out.println("Array of time run program 20 times: ");
        System.out.println(Arrays.toString(timeArray4));
        System.out.println("Time average run program 20 times: " + averageTime(timeArray4));
        System.out.println("--------------------------------------------------------------------------------");
    }
    public static void testMergeSort(int lengthOfArray) {
        System.out.println("Test Merge Sort: ");
        DataSet dataSet5 = new DataSet(lengthOfArray);
        System.out.println("Random array: ");
        System.out.println(dataSet5);
        dataSet5.setStrategy(new MergeSort());
        System.out.println("Array after sort: ");
        dataSet5.sort();
        System.out.println(dataSet5);
        long[] timeArray5 = timeToRunProgame(new MergeSort(), lengthOfArray);
        System.out.println("Array of time run program 20 times: ");
        System.out.println(Arrays.toString(timeArray5));
        System.out.println("Time average run program 20 times: " + averageTime(timeArray5));
        System.out.println("--------------------------------------------------------------------------------");
    }
}
