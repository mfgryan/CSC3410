public class nodeList {
	private Node root;
	private Node currentNode = null;
	
	private nodeList(){
		root = null;
	}
	
	public boolean isEmpty() {
	    return root == null; //if empty returns true
    }
	
	public void addRoot(String character){
		Node node = new Node(character);
		root = node;
		currentNode = root;
		node.parentNode = null;
		node.leftNode = null;
		node.rightNode = null;
	}
	
	public void addLeftNode(String character){
		
	}
	
	public void addRightNode(String character){
		
	}

}
