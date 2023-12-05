package Hw5_21000659_DauVanAn.practise21;


public class CreateTreeByTravesalLevel {
    Node root;
    static class Node {
        int data;
        Node left, right;
        Node(int data)
        {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public Node insertLevelOrder(int[] arr, int i) {
        Node root = null;
        if (i < arr.length) {
            root = new Node(arr[i]);

            root.left = insertLevelOrder(arr, 2 * i + 1);

            root.right = insertLevelOrder(arr, 2 * i + 2);
        }
        return root;
    }

    public void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }
    public void preOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }
    public void postOrder(Node root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }

    public static void main(String args[]) {
        CreateTreeByTravesalLevel t2 = new CreateTreeByTravesalLevel();
        int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9};
        t2.root = t2.insertLevelOrder(arr, 0);
        System.out.println("Preorder :");
        t2.preOrder(t2.root);
        System.out.println("\nInorder :");
        t2.inOrder(t2.root);
        System.out.println("\nPostorder :");
        t2.postOrder(t2.root);
    }
}

