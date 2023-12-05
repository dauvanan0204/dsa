package Hw4_21000659_DauVanAn.palindrome;

import java.util.Stack;

import java.util.LinkedList;
import java.util.Queue;

public class Palindrome {
    public static void main(String[] args) {
        String str = "A man, a plan, a canal: Panama";
        System.out.println("'" + str + "' is Palindrome: " + isPalindrome(str));
        String str1 = "radar";
        System.out.println("'" + str1 + "' is Palindrome: " + isPalindrome(str1));
        String str2 = "anan";
        System.out.println("'" + str2 + "' is Palindrome: " + isPalindrome(str2));
    }
    public static boolean isPalindrome(String input) {
        input = input.toLowerCase();
        char[] chars = input.toCharArray();

        Stack<Character> stack = new Stack<>();
        Queue<Character> queue = new LinkedList<>();

        for (char c : chars) {
            if (Character.isLetterOrDigit(c)) {
                stack.push(c);
                queue.offer(c);
            }
        }

        while (!stack.isEmpty() && !queue.isEmpty()) {
            if (stack.pop() != queue.poll()) {
                return false;
            }
        }

        return true;
    }
}

