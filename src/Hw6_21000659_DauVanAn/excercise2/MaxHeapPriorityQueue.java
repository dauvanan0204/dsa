package Hw6_21000659_DauVanAn.excercise2;

import Hw6_21000659_DauVanAn.excercise1.Entry;
import Hw6_21000659_DauVanAn.excercise1.SortedArrayPriorityQueue;

import java.util.Arrays;

public class MaxHeapPriorityQueue<K extends Comparable, E> extends SortedArrayPriorityQueue<K, E> {
    protected ArrEntry<K, E>[] heapPQ;
    int n = 0;
    int defaultSize = 1000;
    public MaxHeapPriorityQueue() {
        this.heapPQ = (ArrEntry<K, E>[]) new ArrEntry[defaultSize];
    }

    @Override
    public int size() {
        return n;
    }

    @Override
    public boolean isEmpty() {
        return n == 0;
    }
    protected void upHeap() {
        int current = size() - 1;

        while (current > 0) {
            int parent = (current - 1) / 2;

            if (heapPQ[current].getKey().compareTo(heapPQ[parent].getKey()) <= 0) {
                break;
            }

            ArrEntry<K, E> temp = heapPQ[current];
            heapPQ[current] = heapPQ[parent];
            heapPQ[parent] = temp;

            current = parent;
        }
    }

    protected void downHeap() {
        int current = 0;
        int leftChild, rightChild, largerChild;

        while (current < (size() - 1) / 2) {
            leftChild = 2 * current + 1;
            rightChild = 2 * current + 2;
            largerChild = leftChild;

            if (rightChild < size() && heapPQ[rightChild].getKey().compareTo(heapPQ[leftChild].getKey()) > 0) {
                largerChild = rightChild;
            }

            if (heapPQ[current].getKey().compareTo(heapPQ[largerChild].getKey()) < 0) {
                ArrEntry<K, E> temp = heapPQ[current];
                heapPQ[current] = heapPQ[largerChild];
                heapPQ[largerChild] = temp;

                current = largerChild;
            } else {
                break;
            }
        }
    }

    @Override
    public void insert(Entry entry) {
        if (size() >= heapPQ.length) {
            heapPQ = Arrays.copyOf(heapPQ, heapPQ.length * 2);
        }

        heapPQ[size()] = (ArrEntry<K, E>) entry;
        upHeap();
        n++;
    }

    @Override
    public void insert(K k, E e) {
        ArrEntry<K, E> newEntry = new ArrEntry<K, E>(k,e);
        insert(newEntry);
    }

    @Override
    public Entry<K, E> removeMin() {
        if (isEmpty()) {
            return null;
        }
        Entry<K, E> max = heapPQ[0];
        heapPQ[0] = heapPQ[size() - 1];
        heapPQ[size() - 1] = null;
        n--;
        downHeap();

        return max;
    }
    @Override
    public Entry min() {
        if (isEmpty()) {
            return null;
        }
        return heapPQ[0];
    }
}
