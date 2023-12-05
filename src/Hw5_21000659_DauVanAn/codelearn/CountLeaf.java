package Hw5_21000659_DauVanAn.codelearn;

import java.util.Scanner;
public class CountLeaf {
    public static Node insert(Node t, int x) {
        if (t == null) {
            Node temp = new Node();
            temp.data = x;
            temp.left = null;
            temp.right = null;
            return temp;
        } else {
            if (x < t.data) {
                t.left = insert(t.left, x);
            } else {
                t.right = insert(t.right, x);
            }
        }
        return t;
    }
    public static boolean isLeafNode(Node leaf) {
         return (leaf.left == null && leaf.right == null);
    }
    public static int countLeafNode(Node t) {
         if (t == null) return 0;
         if (isLeafNode(t)) return 1;
         return countLeafNode(t.left) + countLeafNode(t.right);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Node t = null;
        for (int i = 0; i < n; i++) {
            int temp = scanner.nextInt();
            t = insert(t, temp);
        }
        System.out.println(countLeafNode(t));
    }
}
