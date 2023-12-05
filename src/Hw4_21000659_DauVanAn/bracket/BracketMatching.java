package Hw4_21000659_DauVanAn.bracket;

import java.util.Stack;

public class BracketMatching {
    public static boolean isBracketMatched(String input) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            if (isOpenBracket(c)) {
                stack.push(c); // Push opening brackets onto the stack
            } else if (isCloseBracket(c)) {
                // If stack is empty or the corresponding opening bracket does not match, return false
                if (stack.isEmpty() || !isMatchingBracket(stack.peek(), c)) {
                    return false;
                }
                stack.pop(); // Pop the matching opening bracket from the stack
            }
        }

        // If stack is empty, all brackets are matched, otherwise there is an unmatched opening bracket
        return stack.isEmpty();
    }

    private static boolean isMatchingBracket(char open, char close) {
        return (open == '(' && close == ')') ||
                (open == '[' && close == ']') ||
                (open == '{' && close == '}');
    }

    private static boolean isOpenBracket(char c) {
        return c == '(' || c == '[' || c == '{';
    }

    private static boolean isCloseBracket(char c) {
        return c == ')' || c == ']' || c == '}';
    }

    public static void main(String[] args) {
        String input1 = "((a + b) * (c - d))"; // Balanced brackets
        String input2 = "{[()]()}"; // Balanced brackets
        String input3 = "(a + b) * (c - d))"; // Unbalanced brackets
        String string1 = "(a − b) ∗ (c + d)";
        String string2 = "(10 + 8)/((5 − 2) ∗ 17)";
        String string3 = "(a + b) ∗ c − d)";
        String string4 = "(10 − 8/((2 + 5) ∗ 17)";
        String string5 = ")u − v) ∗ (m + n)";

        System.out.println(isBracketMatched(input1)); // true
        System.out.println(isBracketMatched(input2)); // true
        System.out.println(isBracketMatched(input3)); // false
        System.out.println(isBracketMatched(string1)); // true
        System.out.println(isBracketMatched(string2)); // true
        System.out.println(isBracketMatched(string3)); // false
        System.out.println(isBracketMatched(string4)); // false
        System.out.println(isBracketMatched(string5)); // false
    }
}

