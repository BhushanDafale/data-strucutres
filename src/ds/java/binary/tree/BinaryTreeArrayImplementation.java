package ds.java.binary.tree;

public class BinaryTreeArrayImplementation {

	static class TreeArray {

		String[] nodes = new String[10];

		public TreeArray(String root) {
			nodes[0] = root;
		}

		public void setLeftElement(String element, int rootIndex) {
			int index = (2 * rootIndex) + 1;

			if (nodes[rootIndex] == null) {
				System.err.printf("Root not found, can't set child %s", element + "\n");
			} else {
				nodes[index] = element;
			}
		}

		public void setRightElement(String element, int rootIndex) {
			int index = (2 * rootIndex) + 2;
			
			if(nodes[rootIndex] == null) {
				System.err.printf("Root not found, can't set child %s", element + "\n");
			} else {
				nodes[index] = element;
			}
		}
		
		public void printTree() {
			for (String node : nodes) {
				if(node != null) {
					System.out.print(node + "-");
				} else {
					System.out.print("*-");
				}
			}
		}
		
	}

	public static void main(String[] args) {

		TreeArray tr = new TreeArray("A"); // 0
		// root - 0
		tr.setLeftElement("B", 0); // 1
		tr.setRightElement("C", 0); // 2
		
		// root - 1
//		tr.setLeftElement("E", 1); // 3
		tr.setRightElement("F", 1); // 4
		
		// root - 2
		tr.setLeftElement("G", 2); // 6
		tr.setRightElement("H", 2); // 7
		
		// root - 3
		tr.setLeftElement("I", 3);
		tr.setRightElement("J", 3);
		
		// root - 4
		tr.setLeftElement("K", 4);
		
		tr.printTree();
		
	}

}
