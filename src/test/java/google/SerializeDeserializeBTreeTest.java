/**
 * 
 */
package google;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import common.Node;
/**
 * @author kris9
 *
 */
public class SerializeDeserializeBTreeTest {
	
	/**
	 * Given the root to a binary tree, implement serialize(root), which serializes
	 * the tree into a string, and deserialize(s), which deserializes the string
	 * back into the tree.
	 * 
	 * For example, given the following Node class
	 * 
	 * class Node: def __init__(self, val, left=None, right=None): 
	 * self.val = val
	 * self.left = left 
	 * self.right = right 
	 * 
	 * The following test should pass:
	 * 
	 * node = Node('root', Node('left', Node('left.left')), Node('right')) 
	 * assert deserialize(serialize(node)).left.left.val == 'left.left'
	 */
	private String serialize(Node root) {
		StringBuilder serialized = new StringBuilder();
		preOrder(root,serialized);
		return serialized.toString();
	}

	private void preOrder(Node root, StringBuilder serialized) {
		if (root == null) {
			serialized.append("-1");
		}
		
		serialized.append(root.getValue());
		
		if (root.getLeft() != null) {
			preOrder(root.getLeft(),serialized);
		}
		if (root.getRight() != null) {
			preOrder(root.getRight(),serialized);
		}
	}

	private Node deserialize(String tree) {
		return deserialize(tree.toCharArray(), -1);
	}
	
	private Node deserialize(char[] nodeValues, int index) {
		++index;
		if (index >= nodeValues.length || nodeValues[index] == -1) {
			return null;
		}
		Node node = new Node(null,null,Character.getNumericValue(nodeValues[index]));
		node.setLeft(deserialize(nodeValues, index));
		node.setRight(deserialize(nodeValues, index));
		return node;
	}
	
	
	@Test
	public void serializeTest() {
		Node right = new Node(null, null,3);
		Node left = new Node(new Node(null,null,4), null,2);
		Node root = new Node(left, right,1);
		assertThat(serialize(root),is("1243"));
	}

	@Test
	public void deserializeTest() {
		Node right = new Node(null, null,3);
		Node left = new Node(new Node(null,null,4), null,2);
		Node root = new Node(left, right,1);
		assertThat(deserialize(serialize(root)).getLeft().getLeft().getValue(),is(equalTo(4)));
		assertThat(deserialize(serialize(root)).getLeft().getValue(),is(equalTo(2)));
		
	}
	
}
