package datastructures.tree;

import datastructures.common.Node;

public class BST {

    public Node root;

    public void print() {
        System.out.println("     5");
        System.out.println("   /   \\");
        System.out.println("  3     7");
        System.out.println(" / \\   / \\");
        System.out.println("2   4 6   8");
    }

    public void insert(Node node) {
        if (root == null) {
            root = node;
        } else {
            insert(root, node);
        }
    }

    private Node insert(Node current, final Node newNode) {
        if (current == null) {
            current = newNode;
            return current;
        }
        if (newNode.getValue() < current.getValue()) {
            current.setLeft(insert(current.getLeft(), newNode));
        } else {
            current.setRight(insert(current.getRight(), newNode));
        }
        return current;
    }

    //root, left, right
    public void preOrder(Node node) {
        System.out.println(node);
        if (node.getLeft() != null) {
            preOrder(node.getLeft());
        }
        if (node.getRight() != null) {
            preOrder(node.getRight());
        }
    }

    //left, root, right
    public void inOrder(Node node) {
        if (node.getLeft() != null) {
            inOrder(node.getLeft());
        }
        System.out.println(node);
        if (node.getRight() != null) {
            inOrder(node.getRight());
        }
    }

    //left, right, root
    public void postOrder(final Node node) {
        if (node.getLeft() != null) {
            postOrder(node.getLeft());
        }
        if (node.getRight() != null) {
            postOrder(node.getRight());
        }
        System.out.println(node);
    }

    public Node find(Integer value) {

        return null;
    }

    public void delete(Integer value) {
    }
}
