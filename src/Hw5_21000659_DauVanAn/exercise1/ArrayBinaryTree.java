package Hw5_21000659_DauVanAn.exercise1;

public class ArrayBinaryTree<E,T> implements BinaryTreeInterface<T> {
    private E[] array;
    private int n = 0;
    private int defaultSize = 100;

    public ArrayBinaryTree() {
        array = (E[]) new Object[defaultSize];
    }
    public void setRoot(E element) {
        array[1] = element;
        n++;
    }
    public void setLeft(int p, E element) {
        if (array[2 * p] == null) {
            array[2 * p] = element;
            n++;
        } else {
            array[2 * p] = element;
        }
    }
    public void setRight(int p, E element) {
        if (array[2 * p + 1] == null) {
            array[2 * p + 1] = element;
            n++;
        } else {
            array[2 * p + 1] = element;
        }
    }
    @Override
    public T root() {
        if (isEmpty()) {
            return null;
        }
        return (T) (Object) 1;
    }

    @Override
    public int size() {
        return n;
    }

    @Override
    public boolean isEmpty() {
        return n == 0;
    }

    @Override
    public int numChildren(T p) {
        int index = getIndex(p);
        if (index == -1) {
            return 0;
        }
        int count = 0;
        if (hasLeft(index)) {
            count++;
        }
        if (hasRight(index)) {
            count++;
        }
        return count;
    }

    @Override
    public T parent(T p) {
        int index = getIndex(p);
        if (index == -1 || index == 1) {
            return null;
        }
        int indexOfParent = index / 2;
        return (T) (Object) indexOfParent;
    }

    @Override
    public T left(T p) {
        int index = getIndex(p);
        if (index == -1 || !hasLeft(index)) {
            return null;
        }
        int indexOfLeft = index * 2;
        return (T) (Object) indexOfLeft;
    }

    @Override
    public T right(T p) {
        int index = getIndex(p);
        if (index == -1 || !hasRight(index)) {
            return null;
        }
        int indexOfRight = index * 2 + 1;
        return (T) (Object) indexOfRight;
    }

    @Override
    public T sibling(T p) {
        int index = getIndex(p);
        if (index == - 1 || index == 1) {
            return null;
        }
        if (index % 2 == 0) {   // left child
            if (hasRight(index + 1)) {
                return (T) (Object) (index + 1);
            }
        } else if (index % 2 != 0) {    // right child
            if (hasLeft(index - 1)) {
                return (T) (Object) (index - 1);
            }
        }
        return null;
    }
    private int getIndex(T p) {
        return (int) (Object) p;
    }
    private boolean hasLeft(int index) {
        return 2 * index <= n && array[2 * index] != null;
    }
    private boolean hasRight(int index) {
        return 2 * index + 1 <= n && array[2 * index + 1] != null;
    }
    public T getValue(T index) {
        return (T) array[(int) index];
    }

    public  String printTreeHorizontally(ArrayBinaryTree<E,T> binaryTree, T root) {
        StringBuilder sb = new StringBuilder();
        printTreeHorizontallyHelper(binaryTree, root, sb, 0);
        return sb.toString();
    }
    private void printTreeHorizontallyHelper(ArrayBinaryTree<E,T> binaryTree, T index, StringBuilder sb, int level) {
        if (index == null) {
            return;
        }
        printTreeHorizontallyHelper(binaryTree, right(index), sb, level + 1);
        for (int i = 0; i < level; i++) {
            sb.append("\t");
        }
        sb.append(binaryTree.getValue(index)).append("\n");
        printTreeHorizontallyHelper(binaryTree, left(index), sb, level + 1);
    }
}
