package Hw7_21000659_DauVanAn.practice7;

public class MinElement {
    public TreeNode root;
    public int findMin(TreeNode node) {
        if (root == null) {
            System.out.println("The tree is empty");
            return Integer.MIN_VALUE;
        }
        while (node.left != null) {
            node = node.left;
        }
        return node.item;
    }
    public TreeNode insert(TreeNode node, int key) {
        if (node == null) {
            root = new TreeNode(key,1);
            return root;
        } else if (key < node.item) {
            node.left = insert(node.left, key);
        } else if (key > node.item) {
            node.right = insert(node.right, key);
        } else {
            node.count++;
        }
        return node;
    }

    public static void main(String[] args) {
        MinElement tree = new MinElement();
        TreeNode root = tree.insert(null, 10);
        tree.insert(root, 3);
        tree.insert(root, 5);
        tree.insert(root, 15);
        tree.insert(root, 8);
        System.out.println("Min element: " + tree.findMin(root));
    }
}
