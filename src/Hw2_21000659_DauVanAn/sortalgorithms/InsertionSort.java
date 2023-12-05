package Hw2_21000659_DauVanAn.sortalgorithms;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class InsertionSort {
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
        System.out.println(Arrays.toString(array));
        System.out.println();
        int countSwap = 0;
        int countCompare = 0;
        for (int i = 1; i < array.length; i++) {
            int next = array[i];
            int j;
            countCompare++;
            for (j = i - 1; j >= 0 && array[j] > next; j--) {
                array[j + 1] = array[j];
                System.out.println(Arrays.toString(array));
                countSwap++;
            }
            array[j + 1] = next;
        }

        System.out.println(Arrays.toString(array));
        System.out.println(countCompare);
        System.out.println(countSwap);
    }
}
