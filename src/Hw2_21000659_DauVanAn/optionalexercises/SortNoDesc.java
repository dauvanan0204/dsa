package Hw2_21000659_DauVanAn.optionalexercises;

import java.util.Arrays;
import java.util.Scanner;

public class SortNoDesc {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input length of array: ");
        int number = scanner.nextInt();
        int[] array = new int[number];
        System.out.print("Input element of array: ");
        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
        }
        sort(array);
        System.out.println(Arrays.toString(array));
    }
    public static void sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int next = array[i];
            int j;
            for (j = i - 1; j >= 0 && array[j] > next; j--) {
                array[j + 1] = array[j];
            }
            array[j + 1] = next;
        }
    }
}
