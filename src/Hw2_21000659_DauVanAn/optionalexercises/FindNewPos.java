package Hw2_21000659_DauVanAn.optionalexercises;

import java.util.Arrays;
import java.util.Scanner;

public class FindNewPos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input number of student: ");
        int numOfStudent = scanner.nextInt();
        System.out.print("Input index of Ti: ");
        int index = scanner.nextInt();
        int[] high = new int[numOfStudent];
        System.out.print("Input high of student: ");
        for (int i = 0; i < numOfStudent; i++) {
            high[i] = scanner.nextInt();
        }
        int highOfTi = high[index - 1];
        sort(high);
        System.out.println(Arrays.toString(high));
        System.out.print("New Position of Ti: ");
        System.out.println(findNewPos(high, highOfTi));
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
    public static int findNewPos(int[] array, int high) {
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == high) {
                index = i;
            }
        }
        return index + 1;
    }
}
