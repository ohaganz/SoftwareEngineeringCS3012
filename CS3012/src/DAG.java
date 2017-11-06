import java.util.ArrayList;

public class DAG {
	
	public static class Node {
		
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
	    
	    public static Node createUnlinkedNode(int key) {
	    	return new Node(key);
	    }
	    
	    public static void linkNodes(Node x, Node y) {
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
	    
	    public static void main(String[] args) {
			
	
			
			Node n1 = createUnlinkedNode(1);
			Node n2 = createUnlinkedNode(2);			
			Node n3 = createUnlinkedNode(3);
			Node n4 = createUnlinkedNode(4);
			Node n5 = createUnlinkedNode(5);
			Node n6 = createUnlinkedNode(6);
			Node n7 = createUnlinkedNode(7);
			
			linkNodes(n1, n3);
			linkNodes(n2, n4);
			linkNodes(n3, n4);
			linkNodes(n3, n5);
			linkNodes(n3, n6);
			linkNodes(n4, n6);
			linkNodes(n5, n6);
			linkNodes(n6, n7);
			
			
		}
	    
	}
	
	
    
}