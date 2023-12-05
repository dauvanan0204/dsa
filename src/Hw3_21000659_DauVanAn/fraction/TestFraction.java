package Hw3_21000659_DauVanAn.fraction;

import java.util.Scanner;

public class TestFraction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Test input n fraction
        Fraction[] fractions = createFraction();
        for (int i = 0; i < fractions.length; i++) {
            System.out.println("Fraction " + (i + 1) + ": " + fractions[i]);
        }
        //Print fraction at position
        System.out.print("Enter the position of the fraction to print: ");
        int position = scanner.nextInt();
        System.out.println("Fraction at position " + position + ": " + fractions[position - 1]);
        // Sum n fraction
        System.out.println("Sum of all fraction: " + sumFraction(fractions));
        // Subtract n fraction
        System.out.println("Subtract of all fraction: " + subtractFraction(fractions));
        // Multiply n fraction
        System.out.println("Multiply of all fraction: " + multiFraction(fractions));
        // Divide n fraction
        System.out.println("Divide of all fraction: " + divideFraction(fractions));
        // Average n fraction
        System.out.println("Average of all fraction: " + averageFraction(fractions));
    }
    public static Fraction[] createFraction() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input number of fraction: ");
        int length = scanner.nextInt();
        Fraction[] fractions = new Fraction[length];
        for (int i = 0; i < length; i++) {
            System.out.print("Input the numerator of fraction " + (i + 1) + ": ");
            float numerator = scanner.nextFloat();
            System.out.print("Input the denominator of fraction " + (i + 1) + ": ");
            float denominator = scanner.nextFloat();
            fractions[i] = new Fraction(numerator, denominator);
            fractions[i] = fractions[i].normalize(fractions[i]);
        }
        return fractions;
    }
    public static Fraction sumFraction(Fraction[] fractions) {
        Fraction sum = fractions[0];
        for (int i = 1; i < fractions.length; i++) {
            sum = sum.add(fractions[i]);
        }
        return sum;
    }
    public static Fraction subtractFraction(Fraction[] fractions) {
        Fraction subtract = fractions[0];
        for (int i = 1; i < fractions.length; i++) {
            subtract = subtract.minus(fractions[i]);
        }
        return subtract;
    }
    public static Fraction multiFraction(Fraction[] fractions) {
        Fraction multi = fractions[0];
        for (int i = 1; i < fractions.length; i++) {
            multi = multi.multi(fractions[i]);
        }
        return multi;
    }
    public static Fraction divideFraction(Fraction[] fractions) {
        Fraction divide = fractions[0];
        for (int i = 1; i < fractions.length; i++) {
            divide = divide.divi(fractions[i]);
        }
        return divide;
    }
    public static Fraction averageFraction(Fraction[] fractions) {
        Fraction sum = new Fraction(0, 1);
        for (int i = 0; i < fractions.length; i++) {
            sum = sum.add(fractions[i]);
        }

        Fraction average = sum.divi(new Fraction(fractions.length, 1));
        return average;
    }
}
