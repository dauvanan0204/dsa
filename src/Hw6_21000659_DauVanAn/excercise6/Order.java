package Hw6_21000659_DauVanAn.excercise6;

public class Order implements Comparable<Order> {
    private String type;
    protected int quantity;
    private double price;

    public Order(String type, int quantity, double price) {
        this.type = type;
        this.quantity = quantity;
        this.price = price;
    }
    public Order(int quantity, double price) {
        this.quantity = quantity;
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public int compareTo(Order other) {
        return Double.compare(this.price, other.price);
    }

    @Override
    public String toString() {
        return type + " " + quantity + " shares at $" + price + " each";
    }
}


