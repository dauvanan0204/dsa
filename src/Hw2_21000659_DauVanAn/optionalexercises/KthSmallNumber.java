package Hw2_21000659_DauVanAn.optionalexercises;

import java.util.Scanner;

public class KthSmallNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input length of array: ");
        int n = scanner.nextInt();
        System.out.print("Input kth small number: ");
        int k = scanner.nextInt();
        int[] array = new int[n];
        System.out.print("Input element of array: ");
        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
        }
        sort(array);
        System.out.println("kth small number: ");
        System.out.println(array[k - 1]);
    }
    public static void sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            boolean isSorted = true;
            for (int j = 1; j < array.length - i; j++) {
                if (array[j - 1] > array[j]) {
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
