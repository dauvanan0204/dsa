package Hw3_21000659_DauVanAn.simplearraylist;

import java.util.Iterator;

public class SimpleArrayList<T> implements ListInterface<T> {
    private T[] array;
    private int n = 0;
    private int defaultSize = 100;

    public SimpleArrayList() {
        array = (T[]) new Object[defaultSize];
    }

    public SimpleArrayList(int capacity) {
        this.n = capacity;
        this.array = (T[]) new Object[capacity];
    }
    @Override
    public void add(T data) {
        if (n == array.length) {
            enlarge();
        }
        array[n] = data;
        n++;
    }

    @Override
    public T get(int i) {
        checkBoundaries(i, n - 1);
        return array[i];
    }

    @Override
    public void set(int i, T data) {
        checkBoundaries(i, n - 1);
        array[i] = data;
    }

    @Override
    public void remove(T data) {
        int index = -1;
        if (data == null) {
            for (int i = 0; i < n; i++) {
                if (array[i] == null) {
                    index = i;
                    break;
                }
            }
        } else {
            for (int i = 0; i < n; i++) {
                if (array[i].equals(data)) {
                    index = i;
                    break;
                }
            }
        }
        if (index != -1) {
            for (int i = index; i < n - 1; i++) {
                array[i] = array[i + 1];
            }
            array[n - 1] = null;
            n--;
        }
    }

    @Override
    public void isContain(T data) {
        if (data == null) {
            for (int i = 0; i < n; i++) {
                if (array[i] == null) {
                    System.out.println(data + " is contained in the list.");
                }
            }
        } else {
            for (int i = 0; i < n; i++) {
                if (array[i].equals(data)) {
                    System.out.println(data + " is contained in the list.");
                    return;
                }
            }
            System.out.println(data + " is not contained in the list.");
        }
    }

    @Override
    public int size() {
        return this.n;
    }

    @Override
    public boolean isEmpty() {
        return this.n == 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < n && array[currentIndex] != null;
            }

            @Override
            public T next() {
                return array[currentIndex++];
            }
        };
    }
    public void checkBoundaries(int index, int limit) {
        if(index < 0 || index > limit) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }
    public void enlarge() {
        T[] tmp = (T[]) new Object[array.length * 2];
        System.arraycopy(array, 0, tmp, 0, array.length);
        this.array = tmp;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(int i=0; i<n; i++) {
            sb.append(array[i]);
            if(i != n-1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
