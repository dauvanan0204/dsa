package hw1_21000659_DauVanAn.goodrichpage57;

public class CreditCard {
    private String name;
    private String number;
    private double limit;
    private double balance;

    public CreditCard(String name, String number, double limit) {
        this.name = name;
        this.number = number;
        this.limit = limit;
        this.balance = 0;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public double getLimit() {
        return limit;
    }

    public double getBalance() {
        return balance;
    }

    public void charge(double amount) {
        if (amount > 0 && balance + amount <= limit) {
            balance += amount;
            System.out.println("Successfully charged $" + amount + " to Credit Card " + number);
        } else {
            System.out.println("Charge failed. Exceeds credit limit.");
        }
    }

    public void makePayment(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Successfully made a payment of $" + amount + " for Credit Card " + number);
        } else {
            System.out.println("Payment failed. Invalid amount.");
        }
    }

    public String toString() {
        return "Name: " + name + ", Credit Card Number: " + number + ", Limit: $" + limit + ", Balance: $" + balance;
    }
}

