package hackerrank.day;

public class Day2 {
    public static void main(String[] args) {
        double meal_cost = 10.25;
        int tip_percent = 17;
        int tax_percent = 5;
        solve(meal_cost, tip_percent, tax_percent);
    }
    public static void solve(double meal_cost, int tip_percent, int tax_percent) {
        // Write your code here
        double result  = meal_cost * (1.0 + (double) tip_percent/100 + (double) tax_percent/100);
        System.out.println(Math.round(result));
    }
}
