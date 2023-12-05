package Hw3_21000659_DauVanAn.codelearn;

import java.util.Scanner;

public class TestCircularLinkedList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Input length of list: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        System.out.print("Input element of list: ");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // Tạo danh sách liên kết vòng
        CircularLinkedList circularLinkedList = new CircularLinkedList();
        for (int i = 0; i < n; i++) {
            circularLinkedList.addToEnd(arr[i]);
        }

        System.out.print("Input index want to print: ");
        int k = scanner.nextInt();

        // In ra các phần tử từ chỉ số k đến n-1 rồi từ chỉ số 0 đến k-1
        System.out.print("List: ");
        circularLinkedList.printCircularListFromK(k);

        scanner.close();
    }
}
