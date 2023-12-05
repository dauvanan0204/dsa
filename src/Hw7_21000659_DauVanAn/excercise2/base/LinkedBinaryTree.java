package Hw7_21000659_DauVanAn.excercise2.base;

public class LinkedBinaryTree<E,T> implements BinaryTreeInterface<T> {
    protected static class Node<E> {
        private E element;  // an element stored at this node
        private Node<E> parent; // a reference to the parent node
        private Node<E> left;   // a reference to the left child
        private Node<E> right;  // a reference to the left child

        public Node(E e, Node<E> above, Node<E> leftChild, Node<E> rightChild) {
            this.element = e;
            this.parent = above;
            this.left = leftChild;
            this.right = rightChild;
        }
        public Node(E e) {
            this.element = e;
        }

        public E getElement() {
            return element;
        }

        public Node<E> getParent() {
            return parent;
        }

        public Node<E> getLeft() {
            return left;
        }

        public Node<E> getRight() {
            return right;
        }
    }
    public LinkedBinaryTree() {

    }
    public LinkedBinaryTree(E key) {
        root.element = key;
    }
    private Node<E> root = null;
    private int size = 0;
    public Node<E> addRoot(E element) {
        if (!isEmpty()) {
            throw new IllegalArgumentException("Root already exists");
        }
        root = new Node<>(element, null, null, null);
        size++;
        return root;
    }
    public Node<E> addLeft(Node p, E element) {
        if (p.left != null) {
            throw new IllegalArgumentException("Left child already exists");
        }
        Node<E> newNode = new Node<>(element, p, null, null);
        p.left = newNode;
        size++;
        return newNode;
    }
    public Node<E> addRight(Node p, E element) {
        if (p.right != null) {
            throw new IllegalArgumentException("Right child already exists");
        }
        Node<E> newNode = new Node<>(element, p, null, null);
        p.right = newNode;
        size++;
        return newNode;
    }
    public void set(Node p, E element) {
        p.element = element;
    }
    @Override
    public T root() {
        if (isEmpty()) {
            return null;
        }
        return (T) root;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int numChildren(T p) {
        Node<E> node = (Node<E>) p;
        if (node.left == null && node.right == null) {
            return 0;
        } else if (node.left != null && node.right != null) {
            return 2;
        } else {
            return 1;
        }
    }

    @Override
    public T parent(T p) {
        Node<E> node = (Node<E>) p;
        return (T) node.parent;
    }

    @Override
    public T left(T p) {
        Node<E> node = (Node<E>) p;
        return (T) node.left;
    }

    @Override
    public T right(T p) {
        Node<E> node = (Node<E>) p;
        return (T) node.right;
    }

    @Override
    public T sibling(T p) {
        Node<E> node = (Node<E>) p;
        Node<E> parent = node.parent;
        if (parent == null) {
            return null;
        }
        if (parent.left == node) {
            return (T) parent.right;
        } else {
            return (T) parent.left;
        }
    }
    public String printTreeHorizontally(LinkedBinaryTree<E,T> binaryTree, Node<E> root) {
        StringBuilder sb = new StringBuilder();
        printTreeHorizontallyHelper(binaryTree, root, sb, 0);
        return sb.toString();
    }
    private  void printTreeHorizontallyHelper(LinkedBinaryTree<E,T> binaryTree, Node<E> node, StringBuilder sb, int level) {
        if (node == null) {
            return;
        }

        printTreeHorizontallyHelper(binaryTree, node.right, sb, level + 1);

        for (int i = 0; i < level; i++) {
            sb.append("\t");
        }
        sb.append(node.element).append("\n");

        printTreeHorizontallyHelper(binaryTree, node.left, sb, level + 1);
    }
}
