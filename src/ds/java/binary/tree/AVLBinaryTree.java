package ds.java.binary.tree;

public class AVLBinaryTree {

	static class Node {
		int data;
		Node left;
		Node right;
		int height;
		int count;

		@Override
		public String toString() {
			return "Node [data=" + data + ", left=" + left + ", right=" + right + ", height=" + height + ", count="
					+ count + "]";
		}

	}

	public static void main(String[] args) {

		Node root = null;

		root = insert(root, 14);
		root = insert(root, 17);
		root = insert(root, 11);
		root = insert(root, 7);
		root = insert(root, 53);
		root = insert(root, 4);
		root = insert(root, 13);
		root = insert(root, 12);
		root = insert(root, 8);
		root = insert(root, 60);
		root = insert(root, 19);
		root = insert(root, 16);
		root = insert(root, 20);
		root = insert(root, 60);
		root = insert(root, 8);
		
		System.out.println("----After insertion");
		preOrder(root);
		
		System.out.println("\ndelete -- 12");
		root = deleteNode(root, 12);
		preOrder(root);
		
		System.out.println("\ndelete -- 8");
		root = deleteNode(root, 8);
		preOrder(root);
		
	}
	
	private static Node deleteNode(Node node, int data) {
		if(node == null) {
			return node;
		}
		
		if(data < node.data) {
			node.left = deleteNode(node.left, data);
		} else if(data > node.data) {
			node.right = deleteNode(node.right, data);
		} else {
			if(node.count > 1) {
				node.count--;
				return null;
			}
			
			if(node.left == null || node.right == null) {
				Node tempNode = node.left != null ? node.left : node.right;
				
				if(tempNode == null) {
					tempNode = node;
					node = null;
				} else {
					node = tempNode;
				}
			} else {
				Node tempNode = minValueNode(node.right);
				
				node.data = tempNode.data;
				node.count = tempNode.count;
				tempNode.count = 1;
				
				node.right = deleteNode(node.right, tempNode.data);
			}
		}
		
		if(node == null) {
			return node;
		}
		
		node.height = max(getHeight(node.left), getHeight(node.right)) + 1;
		
		int balance = getBalance(node);
		
		// LL
		if (balance > 1 && getBalance(node.left) >= 0) {
			return rightRotate(node);
		}
		// LR
		if (balance > 1 && getBalance(node.left) < 0) {
			node.left = leftRotate(node.left);
			return rightRotate(node);
		}

		// RR
		if (balance < -1 && getBalance(node.right) <= 0) {
			return leftRotate(node);
		}
		// RL
		if (balance < -1 && getBalance(node.right) > 0) {
			node.right = rightRotate(node.right);
			return leftRotate(node);
		}
		
		return node;
	}
	
	private static Node minValueNode(Node node) {
		Node current = node;
		
		while(current.left != null) {
			current = current.left;
		}
		return current;
	}
	

	private static void preOrder(Node node) {
		if (node != null) {
			System.out.printf("%d(%d) ", node.data, node.count);
			preOrder(node.left);
			preOrder(node.right);
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

		node.height = max(getHeight(node.left), getHeight(node.right)) + 1;

		int balance = getBalance(node);

		// LL
		if (balance > 1 && data < node.left.data) {
			return rightRotate(node);
		}

		// RR
		if (balance < -1 && data > node.right.data) {
			return leftRotate(node);
		}

		// LR
		if (balance > 1 && data > node.left.data) {
			node.left = leftRotate(node.left);
			return rightRotate(node);
		}

		// RL
		if (balance < -1 && data > node.right.data) {
			node.right = rightRotate(node.right);
			return leftRotate(node);
		}

		return node;
	}
	
	private static int max(int a, int b) {
		return a > b ? a : b;
	}

	private static Node rightRotate(Node node) {
		Node xNode = node.left;
		Node temp = xNode.right;

		// perform rotation
		xNode.right = node;
		node.left = temp;

		node.height = max(getHeight(node.left), getHeight(node.right)) + 1;
		xNode.height = max(getHeight(xNode.left), getHeight(xNode.right)) + 1;

		return xNode;
	}

	private static Node leftRotate(Node node) {
		Node yNode = node.right;
		Node temp = yNode.left;

		yNode.left = node;
		node.right = temp;

		node.height = Math.max(getBalance(node.left), getHeight(node.right)) + 1;
		yNode.height = Math.max(getHeight(yNode.left), getHeight(yNode.right)) + 1;

		return yNode;
	}

	private static int getBalance(Node node) {
		if (node == null) {
			return 0;
		}
		return getHeight(node.left) - getHeight(node.right);
	}

	private static int getHeight(Node node) {
		if (node == null) {
			return 0;
		}
		return node.height;
	}

	private static Node newNode(int data) {
		Node node = new Node();
		node.data = data;
		node.left = null;
		node.right = null;
		node.height = 1;
		node.count = 1;

		return node;
	}

}
