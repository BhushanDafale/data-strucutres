package ds.java.binary.tree;

public class MainBinaryTree {

	public static void main(String[] args) {
		
		Node rootNode = new Node(10);
		
		// left right children of root 10
		rootNode.left = new Node(20);
		rootNode.right = new Node(30);
		
		// left right children of 20
		rootNode.left.left = new Node(40);
		rootNode.left.right = new Node(50);
		
		// left right children of 30 
		rootNode.right.left = new Node(60);
		rootNode.right.right = new Node(70);
		
		System.out.println(rootNode);
		
	}

}

/* Formated output:
Node [
	data=10, 
	left=Node [
			data=20, 
			left=Node [
					data=40, 
					left=null, 
					right=null
					], 
			right=Node [
					data=50, 
					left=null, 
					right=null
					]
			], 
	right=Node [
			data=30, 
			left=Node [
					data=60, 
					left=null, 
					right=null
					], 
			right=Node [
					data=70, 
					left=null, 
					right=null
					]
			]
]
 */
