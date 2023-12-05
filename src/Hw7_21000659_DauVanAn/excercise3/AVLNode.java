package Hw7_21000659_DauVanAn.excercise3;

public class AVLNode {
    int item;
    int height;
    int count;
    AVLNode left;
    AVLNode right;

    public AVLNode(int item) {
        this.item = item;
        this.height = 1;
        this.count = 1;
        this.left = null;
        this.right = null;
    }

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public AVLNode getLeft() {
        return left;
    }

    public void setLeft(AVLNode left) {
        this.left = left;
    }

    public AVLNode getRight() {
        return right;
    }

    public void setRight(AVLNode right) {
        this.right = right;
    }

    public int getBalanceFactor() {
        int leftHeight = (left != null) ? left.height : 0;
        int rightHeight = (right != null) ? right.height : 0;
        return rightHeight - leftHeight;
    }
}
