package ds.java.binary.tree;

public class BSTHandledDuplicates {

	public static void main(String[] args) {

		Node node = new Node();
		node = insert(node, 12);
		node = insert(node, 10);
		node = insert(node, 20);
		node = insert(node, 9);
		node = insert(node, 11);
		node = insert(node, 10);
		node = insert(node, 12);
		node = insert(node, 12);

		System.out.println("In-order traverser of given tree:");
		inorder(node);

		System.out.println("\n-----deleting 12 ------");
		node = delete(node, 12);
		inorder(node);
		
		System.out.println("\n-----deleting 20 ------");
		node = delete(node, 20);
		inorder(node);
	}

	private static class Node {
		int data;
		int count;
		Node left;
		Node right;

		@Override
		public String toString() {
			return "Node [data=" + data + ", count=" + count + ", left=" + left + ", right=" + right + "]";
		}

	}

	private static Node newNode(int data) {
		Node node = new Node();
		node.data = data;
		node.count = 1;
		node.left = null;
		node.right = null;

		return node;
	}

	private static void inorder(Node node) {
		if (node != null) {
			inorder(node.left);
			System.out.print(node.data + "(" + node.count + ") ");
			inorder(node.right);
		}
	}

	private static Node insert(Node node, int data) {
		if (node == null) {
			return newNode(data);
		}
		
		if (node.data == data) {
			node.count++;
			return node;
		}

		if (data < node.data) {
			node.left = insert(node.left, data);
		} else {
			node.right = insert(node.right, data);
		}
		return node;
	}

	private static Node delete(Node node, int data) {
		// base case
		if (node == null) {
			return node;
		}

		if (data < node.data) { // if key is smaller than node data, then pass left child
			node.left = delete(node.left, data);
		} else if (data > node.data) { // if key is greater than node data, then pass right child
			node.right = delete(node.right, data);
		} else { // if key is equal
			if (node.count > 1) {
				node.count--;
				return node;
			}

			// node with only one child
			if (node.left == null) {
				Node tempNode = node.right;
				node = null;
				return tempNode;
			} else if (node.right == null) {
				Node tempNode = node.left;
				node = null;
				return tempNode;
			}

			// node with two children: get the inorder
			// successor (smallest in the right subtree)
			Node minValueNode = minValueNode(node.right);

			// copy the inorder successor
			// content to this node
			node.data = minValueNode.data;
 
			node.right = delete(node.right, minValueNode.data);
		}
		return node;
	}

	private static Node minValueNode(Node node) {
		Node current = node;
		while (current.left != null) {
			current = current.left;
		}
		return current;
	}
}
