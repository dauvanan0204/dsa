package hackerrank.day;

import java.util.Scanner;

public class Day1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        double d = scanner.nextDouble();
        scanner.next();
        String s = scanner.nextLine();
        System.out.println(i + 4);
        System.out.println(d + 4.0);
        String str = "HackerRank is" + s;
        System.out.println(str);
    }
}
