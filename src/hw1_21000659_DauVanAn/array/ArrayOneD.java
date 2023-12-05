package hw1_21000659_DauVanAn.array;

import java.util.Scanner;

public class ArrayOneD {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.print("Input size of array: ");
        int sizeOfArray = scanner.nextInt();
        System.out.print("Input element of array: ");
        int[] arrays = inputArray(sizeOfArray);
        printArray(arrays);
        System.out.println();
        System.out.print("Prime number in array: ");
        primeNumberInArray(arrays);
        System.out.println();
        System.out.print("Perfect number in array: ");
        perfectNumber(arrays);
        System.out.println();
        // Test generics array
        Integer[] integers = {5, 7, 1, 9, 6, 3, 2, 8};
        Double[] doubles = {5.1, 7.2, 1.3, 9.8, 6.5, 3.4, 2.7, 8.6};
        Character[] characters = {'v', 'd', 'a', 'c', 'q', 'b'};
        String[] strings = {"VietNam", "China", "Russia", "USA", "England", "Germany"};
        System.out.println("Sorted integers arrays: ");
        sortArray(integers);
        System.out.println("Sorted double arrays: ");
        sortArray(doubles);
        System.out.println("Sorted characters arrays: ");
        sortArray(characters);
        System.out.println("Sorted strings arrays: ");
        sortArray(strings);
    }
    public static void perfectNumber(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int squareRoot = (int) Math.sqrt(array[i]);
            if ((squareRoot * squareRoot) == array[i]) {
                System.out.print(array[i] + " ");
            }
        }
    }
    public static void primeNumberInArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (isPrime(array[i])) {
                System.out.print(array[i] + " ");
            }
        }
    }
    public static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }
        for (int i = 2; i <= (int) Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
    public static int[] inputArray(int n) {
        int[] newArray = new int[n];
        for (int i = 0; i < n; i++) {
            newArray[i] = scanner.nextInt();
        }
        return newArray;
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
    public static <T extends Comparable<T> > void sortArray(T[] array) {
        for (int i = 0; i < array.length; i++) {
            boolean isSorted = true;
            for (int j = 1; j < array.length - i; j++) {
                if (array[j - 1].compareTo(array[j]) > 0) {
                    swap(array, j - 1, j);
                }
                isSorted = false;
            }
            if (isSorted) {
                break;
            }
        }
        for (T i : array){
            System.out.print(i + " ");
        }
        System.out.println();
    }
    public static <T> void swap(T[] array, int low, int high) {
        T temp = array[low];
        array[low] = array[high];
        array[high] = temp;
    }
}
