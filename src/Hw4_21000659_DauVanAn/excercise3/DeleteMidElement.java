package Hw4_21000659_DauVanAn.excercise3;

import java.util.Scanner;
import java.util.Stack;

public class DeleteMidElement {
    public static void deleteMiddleElement(Stack<Integer> stack, int sizeOfStack) {
        int size = stack.size();
        if (size == (sizeOfStack + 1) / 2) {
            stack.pop();
            return;
        }
        int temp = stack.pop();
        deleteMiddleElement(stack, sizeOfStack);
        stack.push(temp);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Input length of stack: ");
        int n = scanner.nextInt();
        System.out.print("Input element of stack: ");
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            stack.push(scanner.nextInt());
        }
        deleteMiddleElement(stack, n);

        System.out.print("Stack after delete middle element: ");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

}
