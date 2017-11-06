import java.util.ArrayList;

public class DAG {
	
	public class Node {
		
	    private int key;
	    private ArrayList<Node> children = new ArrayList<Node>();
	    private ArrayList<Node> parents = new ArrayList<Node>();
	    
	    public Node(int key) {
	    	this.key=key;
	    }
	    
	    public void addChild(Node child) {
	    	children.add(child);
	    }
	    
	    public void addParent(Node parent) {
	    	parents.add(parent);
	    }
	}
    
}