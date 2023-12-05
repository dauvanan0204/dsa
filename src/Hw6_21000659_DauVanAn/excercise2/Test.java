package Hw6_21000659_DauVanAn.excercise2;

import Hw6_21000659_DauVanAn.excercise1.Entry;

public class Test {

    public static void main(String[] args) {
        testMinHeapPriorityQueue();
        testMaxHeapPriorityQueue();
    }

    public static void testMinHeapPriorityQueue() {
        MinHeapPriorityQueue<Integer, String> minHeap = new MinHeapPriorityQueue<>();

        minHeap.insert(3, "Entry 3");
        minHeap.insert(1, "Entry 1");
        minHeap.insert(4, "Entry 4");
        minHeap.insert(2, "Entry 2");

        System.out.println("MinHeap Priority Queue:");
        while (!minHeap.isEmpty()) {
            Entry<Integer, String> minEntry = minHeap.removeMin();
            System.out.println("Key: " + minEntry.getKey() + ", Value: " + minEntry.getValue());
        }
        System.out.println();
    }

    public static void testMaxHeapPriorityQueue() {
        MaxHeapPriorityQueue<Integer, String> maxHeap = new MaxHeapPriorityQueue<>();

        maxHeap.insert(3, "Entry 3");
        maxHeap.insert(1, "Entry 1");
        maxHeap.insert(4, "Entry 4");
        maxHeap.insert(2, "Entry 2");

        System.out.println("MaxHeap Priority Queue:");
        while (!maxHeap.isEmpty()) {
            Entry<Integer, String> maxEntry = maxHeap.removeMin();
            System.out.println("Key: " + maxEntry.getKey() + ", Value: " + maxEntry.getValue());
        }
    }
}
