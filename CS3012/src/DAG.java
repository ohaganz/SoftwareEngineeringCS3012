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
	    
	    public Node createUnlinkedNode(int key) {
	    	return new Node(key);
	    }
	    
	    public void linkNodes(Node x, Node y) {
	    	x.addChild(y);
	    	
	    	y.addParent(x);
	    }
	    
	    public void printNodeInfo(Node node) {
	    	System.out.println("Node" +node.key+",From:");
	    	
	    	for(int i=0;i<node.parents.size();i++) {
	    		System.out.print(" "+ node.parents.get(i).key);
	    		
	    	}
	    	
	    	System.out.print(":");
	    	
	    	for(int k=0;k<node.children.size();k++) {
	    		System.out.print(""+node.children.get(k).key);
	    	}
	    }
	    
	}
    
}