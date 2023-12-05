package Hw2_21000659_DauVanAn.algorithmsevaluation;

import java.util.Arrays;
import java.util.Random;

public class DataSet {
    private Sorter strategy;
    private int[] data;
    private int lengthOfArray;
    public DataSet(int lengthOfArray) {
        int n = lengthOfArray;
        int[] array = new int[n];
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            int randomNumber = rand.nextInt(1000000) + 1;
            array[i] = randomNumber;
        }
        this.data = array;
    }
    public DataSet(int[] data) {
        this.data = data;
    }

    public void setStrategy(Sorter strategy) {
        this.strategy = strategy;
    }

    public void sort() {
        this.strategy.sort(this.data, 0, data.length - 1);
    }

    public int getLengthOfArray() {
        return lengthOfArray;
    }

    public void setLengthOfArray(int lengthOfArray) {
        this.lengthOfArray = lengthOfArray;
    }

    @Override
    public String toString() {
        return Arrays.toString(this.data);
    }
}
