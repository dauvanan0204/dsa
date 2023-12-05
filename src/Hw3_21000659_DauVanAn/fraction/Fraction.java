package Hw3_21000659_DauVanAn.fraction;


public class Fraction {
    private float numerator;
    private float denominator;

    public Fraction(float numerator, float denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Fraction() {
        this.numerator = 0.0f;
        this.denominator = 0.0f;
    }

    public Fraction add(Fraction c) {
        if (this.denominator == c.denominator) {
            Fraction add = new Fraction(this.numerator + c.numerator, this.denominator);
            return normalize(add);
        }
        float newNumerator = this.numerator * c.denominator + this.denominator * c.numerator;
        float newDenominator = this.denominator * c.denominator;
        Fraction sum = new Fraction(newNumerator, newDenominator);
        return normalize(sum);
    }
    public Fraction minus(Fraction c) {
        if (this.denominator == c.denominator) {
            Fraction minus = new Fraction(this.numerator - c.numerator, this.denominator);
            return normalize(minus);
        }
        float newNumerator = this.numerator * c.denominator - this.denominator * c.numerator;
        float newDenominator = this.denominator * c.denominator;
        Fraction minus = new Fraction(newNumerator, newDenominator);
        return normalize(minus);
    }
    public Fraction multi(Fraction c) {
        float newNumerator = this.numerator * c.numerator;
        float newDenominator = this.denominator * c.denominator;
        Fraction multi = new Fraction(newNumerator, newDenominator);
        return normalize(multi);
    }
    public Fraction divi(Fraction c) {
        float newNumerator = this.numerator * c.denominator;
        float newDenominator = this.denominator * c.numerator;
        Fraction divi = new Fraction(newNumerator, newDenominator);
        return normalize(divi);
    }
    public Fraction normalize(Fraction c) {
        // Count element after floating point

        // Chuyển số kiểu float thành chuỗi
        String numString = Float.toString(c.numerator);
        // Tìm vị trí của dấu chấm trong chuỗi
        int dotIndexOfNum = numString.indexOf(".");
        // Xác định số chữ số sau dấu phẩy
        int decimalPlacesOfNum = numString.length() - dotIndexOfNum - 1;

        // Chuyển số kiểu float thành chuỗi
        String denoString = Float.toString(c.denominator);
        // Tìm vị trí của dấu chấm trong chuỗi
        int dotIndex = denoString.indexOf(".");
        // Xác định số chữ số sau dấu phẩy
        int decimalPlacesOfDeno = denoString.length() - dotIndex - 1;

        int count = Math.max(decimalPlacesOfNum, decimalPlacesOfDeno);
        while (c.numerator % 1.0 != 0.0 || c.denominator % 1.0 != 0.0) {
            c.numerator *= (float) Math.pow(10, count);
            c.denominator *= (float) Math.pow(10, count);
        }
        float gcd = gcd(c.numerator, c.denominator);
        float newNumerator = c.numerator / gcd;
        float newDenominator = c.denominator / gcd;
        return new Fraction(newNumerator, newDenominator);
    }
    private float gcd(float a, float b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public float getNumerator() {
        return numerator;
    }

    public float getDenominator() {
        return denominator;
    }

    public void setNumerator(float numerator) {
        this.numerator = numerator;
    }

    public void setDenominator(float denominator) {
        this.denominator = denominator;
    }

    @Override
    public String toString() {
        if (this.numerator == 0.0) {
            return "0";
        }
        if (this.denominator == 1.0) {
            return (int) this.numerator + "";
        }
        if (this.denominator == -1.0) {
            return "-" + (int) this.numerator;
        }
        if (this.numerator > 0.0 && this.denominator > 0.0) {
            return (int) this.numerator + "/" + (int) this.denominator;
        }
        if (this.numerator < 0.0 && this.denominator < 0.0) {
            return (int) Math.abs(this.numerator) + "/" + (int) Math.abs(this.denominator);
        }
        if (this.numerator < 0.0 || this.denominator < 0.0) {
            return "-" + (int) Math.abs(this.numerator) + "/" + (int) Math.abs(this.denominator);
        }
        return "";
    }
}
