package Hw6_21000659_DauVanAn.excercise5;

import Hw6_21000659_DauVanAn.excercise1.Entry;
import Hw6_21000659_DauVanAn.excercise2.MinHeapPriorityQueue;

import java.util.Scanner;

public class AirTrafficControlSimulation {
    public static void main(String[] args) {
        // Create a MinHeapPriorityQueue for managing events
        MinHeapPriorityQueue<Double, String> eventQueue = new MinHeapPriorityQueue<>();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Select operation:");
            System.out.println("1. Add takeoff event");
            System.out.println("2. Add landing event");
            System.out.println("3. Process next event");
            System.out.println("4. Quit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter takeoff time:");
                    double takeoffTime = scanner.nextDouble();
                    eventQueue.insert(takeoffTime, "Takeoff event");
                    System.out.println("Takeoff event added at time " + takeoffTime);
                    break;
                case 2:
                    System.out.println("Enter landing time:");
                    double landingTime = scanner.nextDouble();
                    eventQueue.insert(landingTime, "Landing event");
                    System.out.println("Landing event added at time " + landingTime);
                    break;
                case 3:
                    if (!eventQueue.isEmpty()) {
                        Entry<Double, String> nextEvent = eventQueue.removeMin();
                        System.out.println("Next event: " + nextEvent.getValue() + " at time " + nextEvent.getKey());
                    } else {
                        System.out.println("No events in the queue.");
                    }
                    break;
                case 4:
                    System.out.println("Exiting simulation.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}

