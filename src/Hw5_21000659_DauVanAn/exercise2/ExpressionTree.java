package Hw5_21000659_DauVanAn.exercise2;

import Hw5_21000659_DauVanAn.exercise1.LinkedBinaryTree;

public class ExpressionTree<E> extends LinkedBinaryTree {

    public void preorderPrint(Node<E> p) {
        if (p == null) {
            return;
        }
        System.out.print(p.getElement() + " ");
        preorderPrint((Node<E>) left(p));
        preorderPrint((Node<E>) right(p));
    }

    public void postorderPrint(Node<E> p) {
        if (p == null) {
            return;
        }
        postorderPrint((Node<E>) left(p));
        postorderPrint((Node<E>) right(p));
        System.out.print(p.getElement() + " ");
    }

    public void inorderPrint(Node<E> p) {
        if (p == null) {
            return;
        }
        boolean parenthesizeLeft = left(p) != null && isOperator((String) ((Node<E>) left(p)).getElement());
        boolean parenthesizeRight = right(p) != null && isOperator((String) ((Node<E>) right(p)).getElement());

        if (parenthesizeLeft) {
            System.out.print("(");
        }
        inorderPrint((Node<E>) left(p));
        if (parenthesizeLeft) {
            System.out.print(")");
        }
        System.out.print(p.getElement() + " ");
        if (parenthesizeRight) {
            System.out.print("(");
        }
        inorderPrint((Node<E>) right(p));
        if (parenthesizeRight) {
            System.out.print(")");
        }
    }
    public int evaluate(Node<E> p) {
        if (p == null) {
            return 0;
        }
        if (isOperator((String) p.getElement())) {
            int leftValue = evaluate((Node<E>) left(p));
            int rightValue = evaluate((Node<E>) right(p));
            return applyOperator((String) p.getElement(), leftValue, rightValue);
        } else {
            return Integer.parseInt((String) p.getElement());
        }
    }

    private boolean isOperator(String element) {
        return element.equals("+") || element.equals("-") || element.equals("*") || element.equals("/");
    }

    private int applyOperator(String operator, int operand1, int operand2) {
        if (operator.equals("+")) {
            return operand1 + operand2;
        } else if (operator.equals("-")) {
            return operand1 - operand2;
        } else if (operator.equals("*")) {
            return operand1 * operand2;
        } else if (operator.equals("/")) {
            return operand1 / operand2;
        } else {
            throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }

    public static void main(String[] args) {
        // Create the expression tree
        ExpressionTree<String> expressionTree = new ExpressionTree<>();

        // Build the expression tree
        ExpressionTree.Node<String> root = expressionTree.addRoot("*");
        ExpressionTree.Node<String> leftChild = expressionTree.addLeft(root, "+");
        ExpressionTree.Node<String> rightChild = expressionTree.addRight(root, "-");
        ExpressionTree.Node<String> leftChild1 = expressionTree.addLeft(leftChild, "/");
        ExpressionTree.Node<String> rightChild1 = expressionTree.addRight(leftChild, "2");
        expressionTree.addLeft(leftChild1, "6");
        expressionTree.addRight(leftChild1, "3");
        expressionTree.addLeft(rightChild, "7");
        expressionTree.addRight(rightChild, "4");

        // Pre-order print (prefix)
        System.out.print("Prefix: ");
        expressionTree.preorderPrint(root);
        System.out.println();

        // In-order print (infix)
        System.out.print("Infix: ");
        expressionTree.inorderPrint(root);
        System.out.println();

        // Post-order print (postfix)
        System.out.print("Postfix: ");
        expressionTree.postorderPrint(root);
        System.out.println();

        // Result of expression tree
        int result = expressionTree.evaluate((Node<String>) expressionTree.root());
        System.out.println("Result: " + result);
    }
}

