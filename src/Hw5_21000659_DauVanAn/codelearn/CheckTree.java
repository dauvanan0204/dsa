package Hw5_21000659_DauVanAn.codelearn;

import java.util.Scanner;

public class CheckTree {
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

    public static int treeLevel(Node t) {
        if (t == null) return -1;
        return 1 + Math.max(treeLevel(t.left), treeLevel(t.right));
    }

    public static boolean isAVL(Node t) {
        if (t == null) return true;
        if (Math.abs(treeLevel(t.left) - treeLevel(t.right)) > 1) return false;
        return isAVL(t.left) && isAVL(t.right);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Node t = null;
        for (int i = 0; i < n; i++) {
            int temp = scanner.nextInt();
            t = insert(t, temp);
        }
        System.out.println(isAVL(t));
    }
}
