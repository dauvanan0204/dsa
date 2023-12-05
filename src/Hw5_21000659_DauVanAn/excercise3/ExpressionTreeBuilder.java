package Hw5_21000659_DauVanAn.excercise3;

import Hw5_21000659_DauVanAn.liststack.LinkedListStack;
import Hw5_21000659_DauVanAn.liststack.StackInterface;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

class BinaryTreeNode {
    String value;
    BinaryTreeNode left;
    BinaryTreeNode right;

    BinaryTreeNode(String value) {
        this.value = value;
        left = right = null;
    }
}

public class ExpressionTreeBuilder {
    public static BinaryTreeNode buildBinaryExpressionTree(List<String> postfix) {
        Stack<BinaryTreeNode> stack = new Stack<>();

        for (String token : postfix) {
            if (isOperand(token)) {
                BinaryTreeNode node = new BinaryTreeNode(token);
                stack.push(node);
            } else if (isOperator(token)) {
                BinaryTreeNode rightNode = stack.pop();
                BinaryTreeNode leftNode = stack.pop();
                BinaryTreeNode operatorNode = new BinaryTreeNode(token);

                operatorNode.left = leftNode;
                operatorNode.right = rightNode;

                stack.push(operatorNode);
            }
        }
        if (!stack.isEmpty()) {
            return stack.pop();
        } else {
            return null;
        }
    }

    private static boolean isOperand(String token) {
        try {
            Double.parseDouble(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    private static int getPriorityOperation(String operation) {
        if (operation == null) return 0;
        if (operation.equals("*") || operation.equals("/")) return 2;
        if (operation.equals("+") || operation.equals("-")) return 1;
        return 0;
    }
    public static List<String> infixToPostfix(List<String> infix) {
        List<String> postfix = new LinkedList<>();
        StackInterface<String> stackOperations = new LinkedListStack<>();

        for (String token : infix) {
            if (isOperand(token)) {  // If token is a number
                postfix.add(token);
            } else if (token.equals("(")) {
                stackOperations.push(token);
            } else if (token.equals(")")) {
                while (!stackOperations.top().equals("(")) {
                    postfix.add(stackOperations.pop());
                }
                stackOperations.pop();
            } else { // If token is an operation
                if (stackOperations.size() == 0) {
                    stackOperations.push(token);
                    continue;
                }
                int currentPriority = getPriorityOperation(token);
                int topPriority = getPriorityOperation(stackOperations.top());
                while (currentPriority <= topPriority) {
                    postfix.add(stackOperations.pop());
                    if (stackOperations.isEmpty()) break;
                    topPriority = getPriorityOperation(stackOperations.top());
                }
                stackOperations.push(token);
            }
        }

        while (!stackOperations.isEmpty()) postfix.add(stackOperations.pop());

        return postfix;
    }
    public static void postOrder(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.value + " ");
    }
    private static boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }
    public static void main(String[] args) {
        String [] tokens = {"(","6", "/", "3","+","2",")", "*", "(", "7", "-", "4",")"};
        List<String> infix = new LinkedList<>();
        for (String token: tokens) {
            infix.add(token);
        }
        List<String> postfix = infixToPostfix(infix);
        System.out.println("Change Infix to Postfix: ");
        System.out.println(postfix);
        BinaryTreeNode tree = buildBinaryExpressionTree(postfix);
        System.out.println("Print tree postorder: ");
        postOrder(tree);
    }
}

