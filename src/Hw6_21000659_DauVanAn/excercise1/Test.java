package Hw6_21000659_DauVanAn.excercise1;

public class Test {
    public static void main(String[] args) {
        PriorityQueueInterface<Integer, Integer> unsorted = new UnsortedArrayPriorityQueue<>();
        unsorted.insert(5, 50);
        unsorted.insert(3, 30);
        unsorted.insert(8, 80);
        System.out.println("Test Unsorted Array PriorityQueue: ");
        System.out.println("Size: " + unsorted.size());
        System.out.println("Min: " + unsorted.min().getValue());
        System.out.println("Removed min: " + unsorted.removeMin().getValue());
        System.out.println("Size: " + unsorted.size());

        PriorityQueueInterface<Integer, String> sorted = new SortedArrayPriorityQueue<>();
        sorted.insert(5, "Apple");
        sorted.insert(3, "Banana");
        sorted.insert(8, "Orange");
        System.out.println("Test Sorted Array PriorityQueue: ");
        System.out.println("Size: " + sorted.size());
        System.out.println("Min: " + sorted.min().getValue());
        System.out.println("Removed min: " + sorted.removeMin().getValue());
        System.out.println("Size: " + sorted.size());

        PriorityQueueInterface<Integer, Integer> unsortedQueue = new UnsortedLinkedPriorityQueue<>();
        unsortedQueue.insert(5, 50);
        unsortedQueue.insert(3, 30);
        unsortedQueue.insert(8, 80);
        System.out.println("Test Unsorted Linked PriorityQueue: ");
        System.out.println("Size: " + unsortedQueue.size());
        System.out.println("Min: " + unsortedQueue.min().getValue());
        System.out.println("Removed min: " + unsortedQueue.removeMin().getValue());
        System.out.println("Size: " + unsortedQueue.size());

        PriorityQueueInterface<Integer, String> sortedQueue = new SortedLinkedPriorityQueue<>();
        sortedQueue.insert(5, "Apple");
        sortedQueue.insert(3, "Banana");
        sortedQueue.insert(8, "Orange");
        System.out.println("Test Sorted Linked PriorityQueue: ");
        System.out.println("Size: " + sortedQueue.size());
        System.out.println("Min: " + sortedQueue.min().getValue());
        System.out.println("Removed min: " + sortedQueue.removeMin().getValue());
        System.out.println("Size: " + sortedQueue.size());
    }
}
