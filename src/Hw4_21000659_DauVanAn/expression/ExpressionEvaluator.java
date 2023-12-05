package Hw4_21000659_DauVanAn.expression;

import java.util.Stack;

public class ExpressionEvaluator {
    public static int evaluateExpression(String expression) {
        // Check the validity of parentheses in the expression
        if (!isBracketMatching(expression)) {
            throw new IllegalArgumentException("Invalid parentheses in the expression");
        }

        // Remove white spaces from the expression
        expression = expression.replaceAll("\\s+", "");

        // Create stacks to store operands and operators
        Stack<Integer> operandStack = new Stack<>();
        Stack<Character> operatorStack = new Stack<>();

        // Iterate through each character in the expression
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            // If the character is a digit, push it to the operand stack
            if (Character.isDigit(c)) {
                StringBuilder number = new StringBuilder();
                while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
                    number.append(expression.charAt(i++));
                }
                i--;

                operandStack.push(Integer.parseInt(number.toString()));
            }
            // If the character is an opening parenthesis, push it to the operator stack
            else if (c == '(') {
                operatorStack.push(c);
            }
            // If the character is a closing parenthesis, perform the calculations on the operand stack
            else if (c == ')') {
                while (!operatorStack.isEmpty() && operatorStack.peek() != '(') {
                    processOperator(operandStack, operatorStack);
                }
                // Remove the opening parenthesis from the operator stack
                operatorStack.pop();
            }
            // If the character is an operator (+, -, *, /), push it to the operator stack
            else if (isOperator(c)) {
                while (!operatorStack.isEmpty() && hasPrecedence(c, operatorStack.peek())) {
                    processOperator(operandStack, operatorStack);
                }
                operatorStack.push(c);
            }
        }

        // Perform the remaining calculations on the operand stack and operator stack
        while (!operatorStack.isEmpty()) {
            processOperator(operandStack, operatorStack);
        }

        // The final result is the value left on the operand stack
        return operandStack.pop();
    }

    private static boolean isBracketMatching(String expression) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.isEmpty() || stack.pop() != '(') {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    private static boolean hasPrecedence(char op1, char op2) {
        return (op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-');
    }

    private static void processOperator(Stack<Integer> operandStack, Stack<Character> operatorStack) {
        char operator = operatorStack.pop();
        int operand2 = operandStack.pop();
        int operand1 = operandStack.pop();

        switch (operator) {
            case '+':
                operandStack.push(operand1 + operand2);
                break;
            case '-':
                operandStack.push(operand1 - operand2);
                break;
            case '*':
                operandStack.push(operand1 * operand2);
                break;
            case '/':
                operandStack.push(operand1 / operand2);
                break;
        }
    }

    public static void main(String[] args) {
        String expression1 = "(2 + 3) * 4"; // Result: 20
        String expression2 = "((3 + 4) * 5) + 5"; // Result: 40
        String expression3 = "(10 + ((2 + 3) * (8 * 5)))"; // Result: 210
        String expression4 = "(1 + ((2 + 3) * (8 * 5)))"; // Result: 201


        try {
            int result1 = evaluateExpression(expression1);
            System.out.println("Expression 1 result: " + result1);

            int result2 = evaluateExpression(expression2);
            System.out.println("Expression 2 result: " + result2);

            int result3 = evaluateExpression(expression3);
            System.out.println("Expression 3 result: " + result3);

            int result4 = evaluateExpression(expression4);
            System.out.println("Expression 4 result: " + result4);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid parentheses in the expression: " + e.getMessage());
        }
    }
}




