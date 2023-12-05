package Hw4_21000659_DauVanAn.palindrome;

import java.util.Stack;

public class EncodeString {
    public static void main(String[] args) {
        String str = "aaabbaaac";
        String encodedStr = encodeString(str);
        System.out.println(encodedStr);
        String str1 = "ab";
        String encodedStr1 = encodeString(str1);
        System.out.println(encodedStr1);
        String str2 = "aaddacc";
        String encodedStr2 = encodeString(str2);
        System.out.println(encodedStr2);

    }

    public static String encodeString(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder encodedString = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (stack.isEmpty() || stack.peek() == c) {
                stack.push(c);
            } else {
                encodedString.append(stack.peek());
                encodedString.append(stack.size());
                stack.clear();
                stack.push(c);
            }
        }

        if (!stack.isEmpty()) {
            encodedString.append(stack.peek());
            encodedString.append(stack.size());
        }

        return encodedString.toString();
    }
}

