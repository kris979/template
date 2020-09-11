package datastructures.tree;

import datastructures.common.Node;

class BSTTest {

    private BST bst = new BST();

    @org.junit.jupiter.api.Test
    void name() {
        bst.print();
        bst.insert(new Node(null,null,5));
        bst.insert(new Node(null,null,3));
        bst.insert(new Node(null,null,7));
        bst.insert(new Node(null,null,2));
        bst.insert(new Node(null,null,4));
        bst.insert(new Node(null,null,6));
        bst.insert(new Node(null,null,8));
        bst.postOrder(bst.root);

    }
}