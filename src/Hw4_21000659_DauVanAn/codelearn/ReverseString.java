package Hw4_21000659_DauVanAn.codelearn;

import java.util.Stack;

public class ReverseString {
    public static void main(String[] args) {
        String str = "codelearn";
        reverse(str);
        String str2 = "abcd";
        System.out.println();
        reverse(str2);
    }
    public static void reverse(String input) {
        char[] chars = input.toCharArray();
        Stack<Character> characters = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            characters.push(chars[i]);
        }
        while (!characters.isEmpty()) {
            System.out.print(characters.peek());
            characters.pop();
        }
    }
}
