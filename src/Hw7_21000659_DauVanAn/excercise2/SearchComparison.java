package Hw7_21000659_DauVanAn.excercise2;

import java.util.Arrays;

public class SearchComparison {

    public static void main(String[] args) {
        int[] dataset1 = generateDataset(1000000);  // 10^6
        int[] dataset2 = generateDataset(10000000); // 10^7
        int[] dataset3 = generateDataset(100000000);// 10^8
        int[] dataset4 = generateDataset(10000);// 10^4

        measureBinarySearchTree(dataset4);

        // Perform measurements for each algorithm and dataset
        System.out.println("Data with 10^6 element:");
        measureSequentialSearch(dataset1);
        measureBinarySearch(dataset1);
//        measureBinarySearchTree(dataset1);
        System.out.println("-------------------------------------------------------");

        System.out.println("Data with 10^7 element:");
        measureSequentialSearch(dataset2);
        measureBinarySearch(dataset2);
//        measureBinarySearchTree(dataset2);
        System.out.println("-------------------------------------------------------");

        System.out.println("Data with 10^8 element:");
        measureSequentialSearch(dataset3);
        measureBinarySearch(dataset3);
//        measureBinarySearchTree(dataset3);
    }

    private static int[] generateDataset(int size) {
        // Generate dataset with random integers
        int[] dataset = new int[size];
        for (int i = 0; i < size; i++) {
            dataset[i] = (int) (Math.random() * size);
        }
        Arrays.sort(dataset); // Binary search requires a sorted array
        return dataset;
    }

    private static void measureSequentialSearch(int[] dataset) {
        long startTime = System.nanoTime();
        // Implement and measure sequential search
        // Example: find an element in the middle of the array
        int key = dataset[2403];
        sequentialSearch(dataset, key);
        long endTime = System.nanoTime();
        printExecutionTime("Sequential Search", startTime, endTime);
    }

    private static void measureBinarySearch(int[] dataset) {
        long startTime = System.nanoTime();
        // Implement and measure binary search
        // Example: find an element in the middle of the array
        int key = dataset[2403];
        binarySearch(dataset, key);
        long endTime = System.nanoTime();
        printExecutionTime("Binary Search", startTime, endTime);
    }

    private static void measureBinarySearchTree(int[] dataset) {
        long startTime = System.nanoTime();
        // Implement and measure search in a binary search tree
        // Example: create a binary search tree and search for an element
        BinarySearchTree bst = createBinarySearchTree(dataset);
        int key = dataset[2403];
        bst.search(bst.root, key);
        long endTime = System.nanoTime();
        printExecutionTime("Binary Search Tree Search", startTime, endTime);
    }

    private static void sequentialSearch(int[] array, int key) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == key) {
                return;
            }
        }
    }

    private static void binarySearch(int[] array, int key) {
        Arrays.binarySearch(array, key);
    }

    private static BinarySearchTree createBinarySearchTree(int[] array) {
        BinarySearchTree bst = new BinarySearchTree();
        TreeNode treeNode = bst.insert(null, array[0]);
        for (int i = 1; i < array.length; i++) {
            bst.insert(treeNode, array[i]);
        }
        return bst;
    }

    private static void printExecutionTime(String algorithm, long startTime, long endTime) {
        long executionTime = endTime - startTime;
        System.out.println(algorithm + " Execution Time: " + executionTime + " nanoseconds");
    }
}

