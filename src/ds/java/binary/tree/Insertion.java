package ds.java.binary.tree;

import java.util.LinkedList;
import java.util.Queue;

public class Insertion {

	public static void main(String[] args) {

		Node rootNode = new Node(10);
		rootNode.left = new Node(20);
		rootNode.right = new Node(30);
		
		rootNode.left.left = new Node(40);
		rootNode.right.right = new Node(50);
		
		System.out.print("Before Insertion: ");
		inorder(rootNode);
		
		int data = 60;
		insert(rootNode, data);
		
		System.out.print("\nAfter Insertion: ");
		inorder(rootNode);
		
	}
	
	private static void inorder(Node node) {
		if(node == null) {
			return;
		}
		
		inorder(node.left);
		System.out.print(node.data + " ");
		inorder(node.right);
	}
	
	private static void insert(Node node, Integer data) {
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(node);
		
		while(!queue.isEmpty()) {
			node = queue.peek();
			queue.remove();
			
			if(node.left == null) {
				node.left = new Node(data);
				break;
			} else {
				queue.add(node.left);
			}
			
			if(node.right == null) {
				node.right = new Node(data);
				break;
			} else {
				queue.add(node.right);
			}
		}
	}

}
