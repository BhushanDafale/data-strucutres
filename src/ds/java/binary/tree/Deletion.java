package ds.java.binary.tree;

import java.util.LinkedList;
import java.util.Queue;

public class Deletion {

	public static void main(String[] args) {

		Node rootNode = new Node(13);
		
		// left tree
		rootNode.left = new Node(12);
		rootNode.left.left = new Node(4);
		rootNode.left.right = new Node(19);
		
		// right tree
		rootNode.right = new Node(10);
		rootNode.right.left = new Node(16);
		rootNode.right.right = new Node(9);
		
		System.out.print("Before: ");
		inorder(rootNode);
		
		int data = 12;
		rootNode = delete(rootNode, data);
		
		System.out.print("\nAfter: ");
		inorder(rootNode);
	}
	
	private static Node delete(Node rootNode, int data) {
		if(rootNode == null) {
			return null;
		} else if(rootNode.left == null && rootNode.right == null) {
			if(rootNode.data == data) {
				return null;
			} else {
				return rootNode;
			}
		}
		
		Node keyNode = null;
		Node tempNode = null;

		Queue<Node> queue = new LinkedList<>();
		queue.add(rootNode);
		
		while(!queue.isEmpty()) {
			tempNode = queue.remove();
			
			if(tempNode.data == data) {
				keyNode = tempNode;
			}
			if(tempNode.left != null) {
				queue.add(tempNode.left);
			}
			if(tempNode.right != null) {
				queue.add(tempNode.right);
			}
		}
		
		if(keyNode != null) {
			int replaceWithData = tempNode.data;
			deleteDeepestNode(rootNode, tempNode);
			keyNode.data = replaceWithData;
		}
		
		return rootNode;
	}
	
	private static void deleteDeepestNode(Node rootNode, Node dNode) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(rootNode);
		
		while(!queue.isEmpty()) {
			rootNode = queue.remove();
			
			if(rootNode == dNode) {
				rootNode = null;
				return;
			} 
			if(rootNode.left != null) {
				if(rootNode.left == dNode) {
					rootNode.left = null;
					return;
				} else {
					queue.add(rootNode.left);
				}
			}
			if(rootNode.right != null) {
				if(rootNode.right == dNode) {
					rootNode.right = null;
					return;
				} else {
					queue.add(rootNode.right);
				}
			}
		}
	}
	
	private static void inorder(Node node) {
		if(node == null) {
			return;
		}
		inorder(node.left);
		System.out.print(node.data + " ");
		inorder(node.right);
	}

}
