package Hw7_21000659_DauVanAn.excercise2;

public class BinarySearchTree {
    public TreeNode root;

    public BinarySearchTree() {
        this.root = null;
    }

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
    public TreeNode search(TreeNode node, int key) {
//        Search recursive solution
        if (node == null) {
            return null;
        }
        if (key == node.item) {
            return node;
        } else if (key < node.item) {
            return search(node.left, key);
        } else {
            return search(node.right, key);
        }
//      Search iterative solution
//        while (node != null) {
//            if (key == node.item) {
//                return node;
//            } else if (key < node.item) {
//                node = node.left;
//            } else {
//                node = node.right;
//            }
//        }
//        return null;
    }
    public TreeNode delete(TreeNode node, int key) {
        if (node == null) {
            throw new IllegalArgumentException("Not found");
        }

        if (key < node.item) {
            node.left = delete(node.left, key);
        } else if (key > node.item) {
            node.right = delete(node.right, key);
        } else {
            if (node.count > 1) {
                node.count--;
            } else if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            } else {
                node.item = findMin(node.right);
                node.right = delete(node.right, node.item);
            }
        }
        return node;
        //        if (node == null) {
//            throw new IllegalArgumentException("Not found");
//        }
//        if (node.left == null && node.right == null) { // no children
//            if (node.item == key) {
//                return null;
//            } else {
//                throw new IllegalArgumentException("Not found");
//            }
//        }
//        if (node.left != null && node.right == null) { // only left child
//            if (node.item == key) {
//                return node.left;
//            } else {
//                node.left = delete(node.left, key);
//            }
//            return node;
//        }
//        if (node.left == null && node.right != null) { // only right child
//            if (node.item == key) {
//                return node.right;
//            } else {
//                node.right = delete(node.right, key);
//            }
//            return node;
//        }
//        if (node.left != null && node.right != null) { // have two child
//            if (node.item == key) {
//                node.item = findMin(node.right);
//                node.right = delete(node.right, node.item);
//            } else if (key < node.item){
//                node.left = delete(node.left, key);
//            } else {
//                node.right = delete(node.right, key);
//            }
//            return node;
//        }
//        return node;
    }
}
