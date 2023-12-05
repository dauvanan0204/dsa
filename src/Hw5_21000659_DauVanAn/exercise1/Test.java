package Hw5_21000659_DauVanAn.exercise1;

import java.io.FileWriter;
import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {
        FileWriter fileWriter = new FileWriter("output.txt");
        testArrayBinaryTree(fileWriter);
        testLinkedBinaryTree(fileWriter);
    }
    public static void testArrayBinaryTree(FileWriter fileWriter) {
        System.out.println("Test Array Binary Tree: ");
        ArrayBinaryTree<Integer, Integer> tree = new ArrayBinaryTree<>();
        tree.setRoot(1);
        tree.setLeft(1, 5);
        tree.setRight(1, 3);
        tree.setLeft(2, 8);
        tree.setRight(2, 6);
        tree.setLeft(3, 2);
        tree.setRight(3, 7);
        System.out.println("Index of root: " + tree.root());
        System.out.println("Index of sibling of element 3: " + tree.sibling(3));
        System.out.println(tree.left(1));
        System.out.println(tree.right(1));
        System.out.println(tree.parent(3));
        System.out.println(tree.parent(1));
        System.out.println("Num of child of root: " + tree.numChildren(1));
        System.out.println(tree.getValue(3));
        System.out.println("Print tree horizontally: ");
        String binaryTree = tree.printTreeHorizontally(tree, tree.root());
        System.out.println(binaryTree);
        System.out.println("--------------------------------------------------------------------");
        try {
            fileWriter.write("Array Binary Tree:\n ");
            fileWriter.write(binaryTree);
        } catch (IOException e) {
            System.out.println("Lỗi: Không thể ghi vào tệp tin.");
        }
    }
    public static void testLinkedBinaryTree(FileWriter fileWriter) {
        System.out.println("Test Linked Binary Tree: ");
        LinkedBinaryTree<Integer, Integer> binaryTree = new LinkedBinaryTree<>();
        LinkedBinaryTree.Node<Integer> root = binaryTree.addRoot(1);
        LinkedBinaryTree.Node<Integer> node2 = binaryTree.addLeft(root, 5);
        LinkedBinaryTree.Node<Integer> node3 = binaryTree.addRight(root, 3);
        LinkedBinaryTree.Node<Integer> node4 = binaryTree.addLeft(node2, 8);
        LinkedBinaryTree.Node<Integer> node5 = binaryTree.addRight(node2, 6);
        LinkedBinaryTree.Node<Integer> node6 = binaryTree.addLeft(node3, 2);
        LinkedBinaryTree.Node<Integer> node7 = binaryTree.addRight(node3, 7);
        LinkedBinaryTree.Node<Integer> node8 = binaryTree.addRight(node4, 9);
        LinkedBinaryTree.Node<Integer> node9 = binaryTree.addLeft(node4, 10);
        System.out.println("Print tree horizontally: ");
        String printTree = binaryTree.printTreeHorizontally(binaryTree, root);
        System.out.println(printTree);
        try {
            fileWriter.write("Linked Binary Tree:\n ");
            fileWriter.write(printTree);
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("Lỗi: Không thể ghi vào tệp tin.");
        }
    }
}
