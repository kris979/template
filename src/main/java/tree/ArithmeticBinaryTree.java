package tree;

import java.util.Objects;

/*

Daily Coding Problem 50

Suppose an arithmetic expression is given as a binary tree. Each leaf is an integer and each internal node is one of '+', '−', '∗', or '/'.

        Given the root to such a tree, write a function to evaluate it.

        For example, given the following tree:

        *
        / \
        +    +
        / \  / \
        3  2  4  5
        You should return 45, as it is (3 + 2) * (4 + 5).*/
public class ArithmeticBinaryTree {

    public static void main(String[] args) {
        Node<String> three = new Node<>(null, null, Integer.toString(3));
        Node<String> two = new Node<>(null, null, Integer.toString(2));
        Node<String> four = new Node<>(null, null, Integer.toString(4));
        Node<String> five = new Node<>(null, null, Integer.toString(5));

        Node<String> leftPlus = new Node<>(three, two, "+");
        Node<String> rightPlus = new Node<>(four, five, "+");
        Node<String> rootMulti = new Node<>(leftPlus, rightPlus, "+");

        int result = evaluate(rootMulti);

        System.out.println(result);

    }

    private static int evaluate(Node<String> root) {
        int result = 0;

        if (Objects.isNull(root)) {
            return result;
        }

        int lr = 0;
        Node left = root.getLeft();
        if (Objects.nonNull(left)) {
            lr = evaluate(left);
        }

        int rr = 0;
        Node right = root.getRight();
        if (Objects.nonNull(right)) {
            rr = evaluate(right);
        }

        String value = root.getValue();
        if (Objects.isNull(left) && Objects.isNull(right)) {
            result = Integer.parseInt(value);
        } else {
            result = calc(lr, rr, value);
        }

        return result;
    }

    private static int calc(int lr, int rr, String op) {
        int result = 0;
        switch (op) {
            case "+":
                result = lr + rr;
            break;
            case "-":
                result = lr - rr;
            break;
            case "*":
                result = lr * rr;
            break;
            case "/":
                result = lr / rr;
            break;
        }
        return result;
    }
}
