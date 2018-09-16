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

	public int getHeight(Node root) {
		if (root == null) {
			return 0;
		}
		
		int lh = 0, rh = 0;
		Node left = root.getLeft();
		Node right = root.getRight(); 
		
		if ( left != null) {
			lh = getHeight(left);
		}
		if (right != null) {
			rh = getHeight(right);
		}
		
		return (lh >= rh ? lh : rh)+1;
	}
	
	public static void main(String[] args) {
		Node left = new Node(null,null, 45);
		Node root = new Node(left, null, 50);
		BinaryTree tree = new BinaryTree(root);
		System.out.println(tree.getHeight(root));
	}

}
