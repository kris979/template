package datastructures.tree;

import datastructures.common.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 1 2 3 4 5
 * Depth First Traversals:
 * (a) Inorder (Left, Root, Right) : 4 2 5 1 3
 * (b) Preorder (Root, Left, Right) : 1 2 4 5 3
 * (c) Postorder (Left, Right,Root) : 4 5 2 3 1
 * Breadth First or Level Order Traversal : 1 2 3 4 5
 */
public class BinaryTree {

	public int getHeight(Node root) {
		if (root == null) {
			return 0;
		}

		int lh = 0, rh = 0;
		Node left = root.getLeft();
		Node right = root.getRight();

		if (left != null) {
			lh = getHeight(left);
		}
		if (right != null) {
			rh = getHeight(right);
		}

		return (lh >= rh ? lh : rh) + 1;
	}

	public int size(Node root) {
		if (root == null) {
			return 0;
		}

		int ls = 0, rs = 0;
		Node left = root.getLeft();
		Node right = root.getRight();

		if (left != null) {
			ls = size(left);
		}

		if (right != null) {
			rs = size(right);
		}

		return ls + rs + 1;
	}

	/**
	 * left - root - right
	 */
	List<Integer> inOrder(Node root) {
		List<Integer> result = new ArrayList<>();
		if (root == null) {
			return result;
		}

		Node left = root.getLeft();
		Node right = root.getRight();

		if (left != null) {
			result.addAll(inOrder(left));
		}

		result.add(root.getValue());

		if (right != null) {
			result.addAll(inOrder(right));
		}

		return result;
	}

	public List<Integer> levelOrderTraversal(Node root) {
		List<Integer> result = new ArrayList<>();
		if (root == null) {
			return result;
		}
        Queue<Node> queue = new LinkedList<Node>(); 
        queue.add(root); 
        while (!queue.isEmpty())  
        { 
  
            Node tempNode = queue.poll(); 
            result.add(tempNode.getValue());
            
            if (tempNode.getLeft() != null) { 
                queue.add(tempNode.getLeft()); 
            } 
  
            if (tempNode.getRight()!= null) { 
                queue.add(tempNode.getRight()); 
            } 
        } 
		return result;
	}
	
	public List<Integer> recursiveLevelOrderTraversal(Node root) {
		List<Integer> result = new ArrayList<>();
		if (root == null) {
			return result;
		}
		int h = getHeight(root);
		for (int i = 1; i <= h; i++) {
			getGivenLevel(root, i, result);
		}
		return result;
	}

	private void getGivenLevel(Node root, int level, List<Integer> result) {
		if (root == null) {
			return;
		}
		if (level == 1) {
			result.add(root.getValue());
		} else if (level > 1) {
			getGivenLevel(root.getLeft(), level-1, result);
			getGivenLevel(root.getRight(), level-1, result);
		}
	}

	public static void main(String[] args) {
		Node left4 = new Node(null, null, 4);
		Node right5 = new Node(null, null, 5);
		Node left2 = new Node(left4, right5, 2);
		Node right3 = new Node(null, null, 3);
		Node root = new Node(left2, right3, 1);
		BinaryTree tree = new BinaryTree();
		System.out.println(tree.getHeight(root));
		System.out.println(tree.size(root));
		System.out.println(tree.inOrder(root));
		System.out.println(tree.recursiveLevelOrderTraversal(root));
		System.out.println(tree.levelOrderTraversal(root));
	}

}
