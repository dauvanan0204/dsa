package Hw2_21000659_DauVanAn.genericsort;


import java.util.Arrays;

public class TestGenericSort {
    public static void main(String[] args) { // exercise 2
        String[] name = new String[] {"Bao", "An", "Dat", "Cuong", "Ha"};
        Character[] characters = new Character[] {'B', 'C', 'A', 'D', 'E'};
        Double[] doubles = new Double[] {5.3, 4.6, 7.2, 1.9, 8.7};

        System.out.println("Test Generic Bubble Sort: ");
        testGenericBubbleSort(name.clone(), characters.clone(), doubles.clone());
        System.out.println("----------------------------------------");
        System.out.println("Test Generic Insertion Sort: ");
        testGenericInsertionSort(name.clone(), characters.clone(), doubles.clone());
        System.out.println("----------------------------------------");
        System.out.println("Test Generic Selection Sort: ");
        testGenericSelectionSort(name.clone(), characters.clone(), doubles.clone());
        System.out.println("----------------------------------------");
        System.out.println("Test Generic Quick Sort: ");
        testGenericQuickSort(name.clone(), characters.clone(), doubles.clone());
        System.out.println("----------------------------------------");
        System.out.println("Test Generic Merge Sort: ");
        testGenericMergeSort(name.clone(), characters.clone(), doubles.clone());
    }
    public static void testGenericBubbleSort(String[] name, Character[] characters, Double[] doubles) {
        DataSet dataSet1 = new DataSet(name);
        dataSet1.setStrategy(new GenericBubbleSort());
        dataSet1.sort();
        System.out.println(dataSet1);

        DataSet dataSet2 = new DataSet(characters);
        dataSet2.setStrategy(new GenericBubbleSort());
        dataSet2.sort();
        System.out.println(dataSet2);

        DataSet dataSet3 = new DataSet(doubles);
        dataSet3.setStrategy(new GenericBubbleSort());
        dataSet3.sort();
        System.out.println(dataSet3);
    }
    public static void testGenericInsertionSort(String[] name, Character[] characters, Double[] doubles) {
        DataSet dataSet1 = new DataSet(name);
        dataSet1.setStrategy(new GenericInsertionSort());
        dataSet1.sort();
        System.out.println(dataSet1);

        DataSet dataSet2 = new DataSet(characters);
        dataSet2.setStrategy(new GenericInsertionSort());
        dataSet2.sort();
        System.out.println(dataSet2);

        DataSet dataSet3 = new DataSet(doubles);
        dataSet3.setStrategy(new GenericInsertionSort());
        dataSet3.sort();
        System.out.println(dataSet3);
    }
    public static void testGenericSelectionSort(String[] name, Character[] characters, Double[] doubles) {
        DataSet dataSet1 = new DataSet(name);
        dataSet1.setStrategy(new GenericSelectionSort());
        dataSet1.sort();
        System.out.println(dataSet1);

        DataSet dataSet2 = new DataSet(characters);
        dataSet2.setStrategy(new GenericSelectionSort());
        dataSet2.sort();
        System.out.println(dataSet2);

        DataSet dataSet3 = new DataSet(doubles);
        dataSet3.setStrategy(new GenericSelectionSort());
        dataSet3.sort();
        System.out.println(dataSet3);
    }
    public static void testGenericQuickSort(String[] name, Character[] characters, Double[] doubles) {
        DataSet dataSet1 = new DataSet(name);
        dataSet1.setStrategy(new GenericQuickSort());
        dataSet1.sort();
        System.out.println(dataSet1);

        DataSet dataSet2 = new DataSet(characters);
        dataSet2.setStrategy(new GenericQuickSort());
        dataSet2.sort();
        System.out.println(dataSet2);

        DataSet dataSet3 = new DataSet(doubles);
        dataSet3.setStrategy(new GenericQuickSort());
        dataSet3.sort();
        System.out.println(dataSet3);
    }
    public static void testGenericMergeSort(String[] name, Character[] characters, Double[] doubles) {
        DataSet dataSet1 = new DataSet(name);
        dataSet1.setStrategy(new GenericMergeSort());
        dataSet1.sort();
        System.out.println(dataSet1);

        DataSet dataSet2 = new DataSet(characters);
        dataSet2.setStrategy(new GenericMergeSort());
        dataSet2.sort();
        System.out.println(dataSet2);

        DataSet dataSet3 = new DataSet(doubles);
        dataSet3.setStrategy(new GenericMergeSort());
        dataSet3.sort();
        System.out.println(dataSet3);
    }
}
