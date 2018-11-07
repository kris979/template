package tree;

public class Node<T> {

	private Node left, right;
	private final T value;
	
	public Node(Node left, Node right, T value) {
		super();
		this.left = left;
		this.right = right;
		this.value = value;
	}

	public final Node getLeft() {
		return left;
	}

	public final Node getRight() {
		return right;
	}

	public final T getValue() {
		return value;
	}

	@Override
	public String toString() {
		return "Node [value=" + value + "]";
	}

	public final void setLeft(Node left) {
		this.left = left;
	}

	public final void setRight(Node right) {
		this.right = right;
	}

}
