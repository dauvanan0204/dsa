package Hw3_21000659_DauVanAn.excercise8;

import java.util.Scanner;

public class GetNthFromLast {
    public static void main(String[] args) {
        SimpleLinkedList<Integer> list = new SimpleLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        System.out.println("List: " + list);
        Scanner scanner = new Scanner(System.in);
        System.out.print("Index of element from last want to print: ");
        int indexFromLast = scanner.nextInt();
        System.out.print("Element in nth from last: " + list.getNthFromLast(indexFromLast));
    }
}
