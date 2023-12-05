package hw1_21000659_DauVanAn.sphere;

public class Sphere {
    private double x;
    private double y;
    private double z;
    private double radius;

    public Sphere( double radius, double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.radius = radius;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
    public double calculateVolume() {
        double volume = (4.0 / 3.0) * Math.PI * Math.pow(this.radius, 3);
        return volume;
    }
    public double surfaceArea() {
        double surfaceArea = 4.0 * Math.PI * Math.pow(this.radius, 2);
        return surfaceArea;
    }
}
