package Hw6_21000659_DauVanAn.excercise4;

import Hw6_21000659_DauVanAn.excercise1.SortedArrayPriorityQueue;
import Hw6_21000659_DauVanAn.excercise1.SortedLinkedPriorityQueue;
import Hw6_21000659_DauVanAn.excercise1.UnsortedArrayPriorityQueue;
import Hw6_21000659_DauVanAn.excercise1.UnsortedLinkedPriorityQueue;

import java.util.Random;

public class PriorityQueueComparison {

    public static void main(String[] args) {
        int[] lengths = {1000, 10000, 100000, 1000000, 10000000, 10000000}; // Different lengths for the lists

        // Creating different PriorityQueue instances for comparison
        UnsortedArrayPriorityQueue<Integer, Integer> unsortedArrayPriorityQueue = new UnsortedArrayPriorityQueue<>();
        SortedArrayPriorityQueue<Integer, Integer> sortedArrayPriorityQueue = new SortedArrayPriorityQueue<>();
        UnsortedLinkedPriorityQueue<Integer, Integer> unsortedLinkedPriorityQueue = new UnsortedLinkedPriorityQueue<>();
        SortedLinkedPriorityQueue<Integer, Integer> sortedLinkedPriorityQueue = new SortedLinkedPriorityQueue<>();

        Random random = new Random();

        for (int n : lengths) {
            // Generate n objects with integer values as keys and elements
            for (int i = 0; i < n; i++) {
                int value = random.nextInt(); // Integer value for the object
                unsortedArrayPriorityQueue.insert(value, value);
                sortedArrayPriorityQueue.insert(value, value);
                unsortedLinkedPriorityQueue.insert(value, value);
                sortedLinkedPriorityQueue.insert(value, value);
            }

            long startTime, endTime;

            // UnsortedArrayPriorityQueue
            startTime = System.nanoTime();
            // Perform operations (insert, removeMin) on unsortedArrayPriorityQueue
            endTime = System.nanoTime();
            long elapsedTimeUnsortedArray = endTime - startTime;

            // SortedArrayPriorityQueue
            startTime = System.nanoTime();
            // Perform operations (insert, removeMin) on sortedArrayPriorityQueue
            endTime = System.nanoTime();
            long elapsedTimeSortedArray = endTime - startTime;

            // UnsortedLinkedPriorityQueue
            startTime = System.nanoTime();
            // Perform operations (insert, removeMin) on unsortedLinkedPriorityQueue
            endTime = System.nanoTime();
            long elapsedTimeUnsortedLinked = endTime - startTime;

            // SortedLinkedPriorityQueue
            startTime = System.nanoTime();
            // Perform operations (insert, removeMin) on sortedLinkedPriorityQueue
            endTime = System.nanoTime();
            long elapsedTimeSortedLinked = endTime - startTime;

            // Print the execution times for each PriorityQueue type and list length
            System.out.println("For list of length " + n + ":");
            System.out.println("UnsortedArrayPriorityQueue: " + elapsedTimeUnsortedArray + " nanoseconds");
            System.out.println("SortedArrayPriorityQueue: " + elapsedTimeSortedArray + " nanoseconds");
            System.out.println("UnsortedLinkedPriorityQueue: " + elapsedTimeUnsortedLinked + " nanoseconds");
            System.out.println("SortedLinkedPriorityQueue: " + elapsedTimeSortedLinked + " nanoseconds");
        }
    }
}

