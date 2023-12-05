package Hw4_21000659_DauVanAn.palindrome;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class QueueTransformation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Nhập vào số lượng phần tử và các phần tử của queue
        int n = scanner.nextInt();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            queue.add(scanner.nextInt());
        }

        // Nhập vào số lần biến đổi
        int k = scanner.nextInt();

        // Thực hiện biến đổi k lần
        for (int i = 0; i < k; i++) {
            int firstElement = queue.poll();
            queue.add(firstElement);
        }

        // In ra các phần tử của queue
        for (int element : queue) {
            System.out.print(element + " ");
        }
    }
}

