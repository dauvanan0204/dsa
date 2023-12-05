package hw1_21000659_DauVanAn.complexnumber;

public class TestComplexNumber {
    public static void main(String[] args) {
        ComplexNumber c1 = new ComplexNumber(1.0, 2.0);
        ComplexNumber c2 = new ComplexNumber(2.0, 3.0);
        ComplexNumber c3 = new ComplexNumber(-7.0, -4.0);
//        ComplexNumber result = c1.add(c2).add(c3);
//        System.out.println(result);

        ComplexNumber sum = c1.add(c2);
        ComplexNumber difference = c1.subtract(c2);
        ComplexNumber product = c1.multiply(c2);
        ComplexNumber quotient = c1.divide(c2);
        System.out.print("Complex number 1: ");
        System.out.println(c1);
        System.out.print("Complex number 2: ");
        System.out.println(c2);
        System.out.print("Sum two complex numbers: ");
        System.out.println(sum);
        System.out.print("Subtract two complex numbers: ");
        System.out.println(difference);
        System.out.print("Mutiply two complex numbers: ");
        System.out.println(product);
        System.out.print("Divide two complex numbers: ");
        System.out.println(quotient);

        // sum many complex numbers
        ComplexNumber[] complexNumbers = new ComplexNumber[4];
        complexNumbers[0] = new ComplexNumber(2, 3);
        complexNumbers[1] = new ComplexNumber(-4, 5);
        complexNumbers[2] = new ComplexNumber(1, -2);
        complexNumbers[3] = new ComplexNumber(3, 4);

        ComplexNumber addMany = c1.addMany(complexNumbers);// sum c1 with complexNumbers
        System.out.print("Test funtion addMany: ");
        System.out.println(addMany);

        // multiply many complex numbers
        ComplexNumber productMany = c1.multiplyMany(complexNumbers);// multiply c1 with complexNumbers
        System.out.print("Test funtion mutiplyMany: ");
        System.out.println(productMany);

    }
}
