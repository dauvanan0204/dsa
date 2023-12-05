package Hw4_21000659_DauVanAn.palindrome;

import java.util.Scanner;
import java.util.Stack;

public class DecToBinByStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input decima number: ");
        int number = scanner.nextInt();
        String str = convertToBinary(number);
        System.out.println(str);
    }
    public static String convertToBinary(int n) {
        Stack<Integer> stack = new Stack<>();

        while (n > 0) {
            stack.push(n % 2);
            n /= 2;
        }
        StringBuilder binaryString = new StringBuilder();
        while (!stack.isEmpty()) {
            binaryString.append(stack.pop());
        }
        return binaryString.toString();
    }
}
