package hw1_21000659_DauVanAn.goodrichpage57;

import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double result = 0.0;
        boolean exit = false;

        System.out.println("Simple Calculator");
        System.out.println("-----------------");

        while (!exit) {
            System.out.print("Enter a number or an operator (+, -, *, /) or 'exit' to quit: ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                exit = true;
            } else if (isNumber(input)) {
                double number = Double.parseDouble(input);
                result = number;
                System.out.println("= " + result);
            } else if (isValidOperator(input)) {
                char operator = input.charAt(0);
                System.out.print("Enter another number: ");
                double number = Double.parseDouble(scanner.nextLine());
                result = calculate(result, operator, number);
                System.out.println("= " + result);
            } else {
                System.out.println("Invalid input. Please try again.");
            }
        }

        System.out.println("Thank you for using Simple Calculator!");
    }

    public static boolean isNumber(String input) {
        try {
            Double.parseDouble(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isValidOperator(String input) {
        return input.length() == 1 && "+-*/".contains(input);
    }

    public static double calculate(double num1, char operator, double num2) {
        switch (operator) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            case '/':
                return num1 / num2;
            default:
                return 0.0;
        }
    }
}

