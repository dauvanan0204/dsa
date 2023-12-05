package hw1_21000659_DauVanAn.sphere;

public class TestSphere {
    public static void main(String[] args) {
        Sphere sphere1 = new Sphere(1, 0, 0, 0);
        Sphere sphere2 = new Sphere(1.5, 0, 0, 0);
        Sphere sphere3 = new Sphere(1, 0, 0, 0);
        Sphere sphere4 = new Sphere(1, 2, 0, 0);

        double volume1 = sphere1.calculateVolume();
        System.out.println("Volume of sphere 1: " + volume1);
        double volume2 = sphere2.calculateVolume();
        System.out.println("Volume of sphere 2: " + volume2);
        double surfaceArea1 = sphere1.surfaceArea();
        System.out.println("Surface area of sphere 1: " + surfaceArea1);
        double surfaceArea2 = sphere2.surfaceArea();
        System.out.println("Surface area of sphere 2: " + surfaceArea2);
        relationshipBetweenTwoSpheres(sphere1, sphere2);
        relationshipBetweenTwoSpheres(sphere3, sphere4);
        relationshipBetweenTwoSpheres(sphere2, sphere4);
    }
    public static boolean checkNoIntersecting(Sphere sphere1, Sphere sphere2) {
        double distanceBetweenCenters = distanceBetweenCenters(sphere1, sphere2);
        return distanceBetweenCenters > (sphere1.getRadius() + sphere2.getRadius());
    }
    public static boolean checkOverlapping(Sphere sphere1, Sphere sphere2) {
        double distanceBetweenCenters = distanceBetweenCenters(sphere1, sphere2);
        return distanceBetweenCenters <= (sphere1.getRadius() + sphere2.getRadius());
    }
    public static boolean checkIntersectingOnePoint(Sphere sphere1, Sphere sphere2) {
        double distanceBetweenCenters = distanceBetweenCenters(sphere1, sphere2);
        return distanceBetweenCenters == (sphere1.getRadius()+ sphere2.getRadius());
    }
    public static double distanceBetweenCenters(Sphere sphere1, Sphere sphere2) {
        double distanceBetweenCenters = Math.sqrt(Math.pow(sphere2.getX() - sphere1.getX(), 2) + Math.pow(sphere2.getY() - sphere1.getY(), 2) + Math.pow(sphere2.getZ() - sphere1.getZ(), 2));
        return distanceBetweenCenters;
    }
    public static void relationshipBetweenTwoSpheres(Sphere sphere1, Sphere sphere2) {
        if (checkNoIntersecting(sphere1, sphere2)) {
            System.out.println("Two spheres do not intersect");
        } else if (checkIntersectingOnePoint(sphere1, sphere2)) {
            System.out.println("Two spheres intersect at a point");
        } else if (checkOverlapping(sphere1, sphere2)) {
            System.out.println("Two spheres overlapping");
        }
    }
}
