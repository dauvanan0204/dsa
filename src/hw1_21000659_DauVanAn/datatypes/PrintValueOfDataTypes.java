package hw1_21000659_DauVanAn.datatypes;

import java.util.Scanner;

public class PrintValueOfDataTypes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input int number: ");
        int intNumber = scanner.nextInt();
        System.out.print("The int number: " + intNumber + "\n");
        System.out.print("Input double number: ");
        double doubleNumber = scanner.nextDouble();
        System.out.print("The double number: " + doubleNumber + "\n");
        System.out.print("Input boolean value: ");
        boolean booleanValue = scanner.nextBoolean();
        System.out.print("The boolean value: " + booleanValue + "\n");
        System.out.print("Input char value: ");
        char charValue = scanner.next().charAt(0);
        System.out.print("The char value: " + charValue + "\n");
        scanner.close();
    }
}
