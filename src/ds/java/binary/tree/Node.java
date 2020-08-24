package ds.java.binary.tree;

public class Node {
	
	Integer data;
	Node left;
	Node right;
	
	public Node(Integer data) {
		this.data = data;
		left = right = null;
	}

	@Override
	public String toString() {
		return "Node [data=" + data + ", left=" + left + ", right=" + right + "]";
	}
	
}
