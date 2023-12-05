package Hw2_21000659_DauVanAn.codelearn;

import java.util.Arrays;
import java.util.Scanner;

public class ShellSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input length of array: ");
        int n = scanner.nextInt();
        int[] array = new int[n];
        System.out.print("Input element of array: ");
        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
        }
        sort(array, n);
        System.out.println(Arrays.toString(array));
    }
    public static void sort(int[] a, int n){
        int interval, i, j, temp;
        for(interval = n/2; interval > 0; interval /= 2){
            for(i = interval; i < n; i++){
                temp = a[i];
                for(j = i; j >= interval && a[j - interval] > temp; j -= interval){
                    a[j] = a[j - interval];
                }
                a[j] = temp;
            }
        }
    }
}
