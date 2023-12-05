package Hw2_21000659_DauVanAn.optionalexercises;

import java.util.Scanner;

public class CountCouples {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input length of array: ");
        int number = scanner.nextInt();
        System.out.print("Sum of two element in array: ");
        int sumTwoEle = scanner.nextInt();

        int[] array = new int[number];
        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
        }
        System.out.println(algorithm(array, sumTwoEle));
    }
    public static int algorithm(int[] array, int sum) {
        int count = 0;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if ((array[i] + array[j]) == sum) {
                    count++;
                }
            }
        }
        return count;
    }
}
