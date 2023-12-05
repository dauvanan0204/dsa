package hackerrank.day;

import java.util.Scanner;
import java.math.BigDecimal;

public class Day0 {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
//        Scanner scanner = new Scanner(System.in);
//
//        String inputString = scanner.nextLine();
//        System.out.println("Hello, World.");
//        System.out.println(inputString);
        float number = 3.145f;

        // Chuyển số kiểu float thành chuỗi
        String numberString = Float.toString(number);

        // Tìm vị trí của dấu chấm trong chuỗi
        int dotIndex = numberString.indexOf(".");

        // Xác định số chữ số sau dấu phẩy
        int decimalPlaces = numberString.length() - dotIndex - 1;

        System.out.println("Số chữ số sau dấu phẩy: " + decimalPlaces);

        BigDecimal decimal = new BigDecimal(numberString);
        BigDecimal multiplier = new BigDecimal("10");

        BigDecimal result = decimal.multiply(multiplier);

        System.out.println("Kết quả: " + result);
        System.out.println(number * (float) Math.pow(10, decimalPlaces));
        System.out.println(number * Math.pow(10, decimalPlaces));
        System.out.println(number * 10000.0f);
        System.out.println(100 == 100.0f);
    }
}
