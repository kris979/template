package tree;

public class BinaryTree {
	
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
	
	public int size(Node root) {
		if (root == null) {
			return 0;
		}

		int ls = 0, rs = 0;
		Node left = root.getLeft();
		Node right = root.getRight(); 
		
		if ( left != null) {
			ls = size(left);
		}
		
		if ( right != null) {
			rs = size(right);
		}
		
		return ls + rs + 1;
	}
	
	public static void main(String[] args) {
		Node left = new Node(null,null, 45);
		Node right = new Node(null,null, 55);
		Node root = new Node(left, right, 50);
		BinaryTree tree = new BinaryTree();
		System.out.println(tree.getHeight(root));
		System.out.println(tree.size(root));
	}

}
