package Hw3_21000659_DauVanAn.codelearn;

import java.util.Scanner;

public class TestInsertElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input length of list: ");
        int n = scanner.nextInt();

        System.out.print("Input element of list: ");
        LinkedList list = new LinkedList();
        for (int i = 0; i < n; i++) {
            int num = scanner.nextInt();
            list.insert(i, num);
        }

        System.out.print("Input index and value want to insert: ");
        int index = scanner.nextInt();
        int value = scanner.nextInt();
        list.insert(index, value);

        list.printList();
    }
}
