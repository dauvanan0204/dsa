package midterm;

//public class BinaryTree {
//
//    static class Node {
//        int data;
//        Node left, right;
//
//        public Node(int data) {
//            this.data = data;
//            this.left = this.right = null;
//        }
//    }
//
//    private int findHeight(Node node) {
//        if (node == null)
//            return 0;
//
//        int leftHeight = findHeight(node.left);
//        int rightHeight = findHeight(node.right);
//
//        return 1 + Math.max(leftHeight, rightHeight);
//    }
//
//    public int getLongestPath(Node root) {
//        if (root == null)
//            return 0;
//
//        int leftHeight = findHeight(root.left);
//        int rightHeight = findHeight(root.right);
//
//        int leftLongestPath = getLongestPath(root.left);
//        int rightLongestPath = getLongestPath(root.right);
//
//        // Compare and return the longest path among left subtree, right subtree, and through the root
//        return Math.max(leftHeight + rightHeight + 1, Math.max(leftLongestPath, rightLongestPath));
//    }
//
//    public static void main(String[] args) {
//        BinaryTree tree = new BinaryTree();
//
//        // Example binary tree creation
//        Node root = new Node(1);
//        root.left = new Node(2);
//        root.right = new Node(3);
//        root.left.left = new Node(4);
//        root.left.right = new Node(5);
//        root.left.right.right = new Node(5);
//        root.left.right.right = new Node(5);
//        root.left.right.right.left = new Node(5);
//        root.left.right.right.right = new Node(5);
//        root.left.right.right.right.left = new Node(5);
//        root.left.left.left = new Node(4);
//        root.left.right.left = new Node(5);
//        root.left.left.right = new Node(4);
//        root.left.left.right.left = new Node(4);
//        root.left.left.right.left.right = new Node(4);
//
//        int longestPath = tree.getLongestPath(root);
//        System.out.println("Length of the longest path in the binary tree: " + longestPath);
//        System.out.println(tree.findHeight(root));
//    }
//}


public class BinaryTree {

    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    public Node convertMirror(Node root) {
        if (root == null) {
            return null;
        }

        // Swap the left and right subtrees of the current node
        Node temp = root.left;
        root.left = root.right;
        root.right = temp;

        // Recursively convert the left and right subtrees
        convertMirror(root.left);
        convertMirror(root.right);

        return root;
    }

    // Other methods and main function can go here...

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        // Example binary tree creation
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println("Original Tree:");
        tree.printInOrder(root);

        // Convert the tree to its mirror
        Node mirroredRoot = tree.convertMirror(root);

        System.out.println("\nTree after conversion to mirror:");
        tree.printInOrder(mirroredRoot);
    }

    // Additional methods, e.g., for tree traversal, can be added here...
    private void printInOrder(Node node) {
        if (node != null) {
            printInOrder(node.left);
            System.out.print(node.data + " ");
            printInOrder(node.right);
        }
    }
}
