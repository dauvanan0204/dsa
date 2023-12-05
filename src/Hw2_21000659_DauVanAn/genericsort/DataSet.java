package Hw2_21000659_DauVanAn.genericsort;

import java.util.Arrays;

public class DataSet<T extends Comparable<T>> {
    private T[] data;
    private GenericSort<T> strategy;

    public DataSet(T[] data) {
        this.data = data;
    }

    public void setStrategy(GenericSort<T> strategy) {
        this.strategy = strategy;
    }

    public void sort() {
        this.strategy.sort(data, 0, data.length - 1);
    }

    @Override
    public String toString() {
        return Arrays.toString(data);
    }
}
