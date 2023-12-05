package Hw3_21000659_DauVanAn.codelearn;

import java.util.Scanner;

public class TestDoublyLinkedList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input length of list: ");
        int n = scanner.nextInt();

        DoublyLinkedList list = new DoublyLinkedList();
        for (int i = n; i >= 1; i--) {
            list.insert(i);
        }
        for (int i = 2; i <= n; i++) {
            list.insert(i);
        }
        System.out.print("Doubly Linked List: ");
        list.printList();
    }
}

