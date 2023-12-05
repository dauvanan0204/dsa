package hw1_21000659_DauVanAn.complexnumber;

public class ComplexNumber {
    private double real;
    private double imaginary;

    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public double getReal() {
        return real;
    }

    public double getImaginary() {
        return imaginary;
    }

    public ComplexNumber add(ComplexNumber other) {
        double newReal = this.real + other.real;
        double newImaginary = this.imaginary + other.imaginary;
        return new ComplexNumber(newReal, newImaginary);
    }

    public ComplexNumber subtract(ComplexNumber other) {
        double newReal = this.real - other.real;
        double newImaginary = this.imaginary - other.imaginary;
        return new ComplexNumber(newReal, newImaginary);
    }

    public ComplexNumber multiply(ComplexNumber other) {
        double newReal = (this.real * other.real) - (this.imaginary * other.imaginary);
        double newImaginary = (this.real * other.imaginary) + (this.imaginary * other.real);
        return new ComplexNumber(newReal, newImaginary);
    }

    public ComplexNumber divide(ComplexNumber other) {
        double divisor = (other.real * other.real) + (other.imaginary * other.imaginary);
        double newReal = ((this.real * other.real) + (this.imaginary * other.imaginary)) / divisor;
        double newImaginary = ((this.imaginary * other.real) - (this.real * other.imaginary)) / divisor;
        return new ComplexNumber(newReal, newImaginary);
    }
    public ComplexNumber addMany(ComplexNumber[] others) {
        ComplexNumber sumMany = others[0];
        for (int i = 1; i < others.length; i++) {
            sumMany = sumMany.add(others[i]);
        }
        double newReal = this.real + sumMany.real;
        double newImaginary = this.imaginary + sumMany.imaginary;
        return new ComplexNumber(newReal, newImaginary);
    }
    public ComplexNumber multiplyMany(ComplexNumber[] others) {
        ComplexNumber productMany = others[0];
        for (int i = 1; i < others.length; i++) {
            productMany = productMany.multiply(others[i]);
        }
        double newReal = (this.real * productMany.real) - (this.imaginary * productMany.imaginary);
        double newImaginary = (this.real * productMany.imaginary) + (this.imaginary * productMany.real);
        return new ComplexNumber(newReal, newImaginary);
    }
    @Override
    public String toString() {
        if (imaginary >= 0) {
            return real + " + " + imaginary + "i";
        } else {
            return real + " - " + Math.abs(imaginary) + "i";
        }
    }
}

