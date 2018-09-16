package tree;

public class BinaryTree {
	
	private Node root;

	public BinaryTree(Node root) {
		super();
		this.root = root;
	}

	public final Node getRoot() {
		return root;
	}

	@Override
	public String toString() {
		return "BinaryTree [root=" + root + "]";
	}

	public static void main(String[] args) {
		Node root = new Node(null, null, 0);
		BinaryTree tree = new BinaryTree(root);
		System.out.println(tree);
	}

}
