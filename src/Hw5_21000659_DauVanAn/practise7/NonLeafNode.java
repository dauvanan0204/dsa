package Hw5_21000659_DauVanAn.practise7;

import java.util.*;
class NonLeafNode {
    static class Node {
        int data;
        Node left, right;
        Node(int data)
        {
            left = right = null;
            this.data = data;
        }
    }
    public static void printInternalNodes(Node root) {
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        while (!q.isEmpty()) {
            Node curr = q.peek();
            q.remove();
            boolean isInternal = false;
            if (curr.left != null) {
                isInternal = true;
                q.add(curr.left);
            }
            if (curr.right != null) {
                isInternal = true;
                q.add(curr.right);
            }
            if (isInternal == true) {
                System.out.print(curr.data + " ");
            }
        }
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.right.right.right = new Node(10);
        root.right.right.left = new Node(7);
        root.right.left.left = new Node(8);
        root.right.left.right = new Node(9);

        printInternalNodes(root);
    }
}

