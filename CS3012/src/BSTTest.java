import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BSTTest {

	@Test
	public void testPrintTree() {
		
		//Testing print of empty binary search tree
		BST<Character, Character> bst = new BST<Character, Character>();
		assertEquals("()", bst.printTree());
		
		//Testing print of one node binary search tree
		bst.insert('A', 'A');
		assertEquals("(()A())", bst.printTree());
		
		//Testing print of multiple node binary search tree
		bst.insert('A', 'A');
		bst.insert('B', 'B');
		bst.insert('C', 'C');
		assertEquals("(()A(()B(()C())))", bst.printTree());
		
		
	}
	
	@Test
	public void testInsert() {
		BST<Character, Character> bst = new BST<Character, Character>();
		
		
		//Testing node insert on empty tree
		bst.insert('B', 'B');
		assertEquals( "(()B())", bst.printTree());
		
		
		bst.insert('A', 'A');
		bst.insert('C', 'C');
		bst.insert('D', 'D');
		//Testing insert of multiple nodes into tree
		/*
		 * 			B
		 * 		   / \
		 * 		  A   C
		 * 			   \
		 * 				D	  
		 */
		
		assertEquals( "((()A())B(()C(()D())))", bst.printTree());
		
	
		
		
		//Testing insert of null value. (Should delete node)
		bst.insert('C', null);
		assertEquals("((()A())B(()D()))", bst.printTree());
		
		
		//Testing insert of null key. (Should have no effect)
		bst.insert(null, 'Q');
		assertEquals( "((()A())B(()D()))", bst.printTree());
		
	}
	
	@Test
	public void testGet() {
		
		BST<Character, Character> bst = new BST<Character, Character>();
		//testing get on empty tree
		assertNull(bst.get('A'));
		
		
		bst.insert('A', 'A');
	     bst.insert('B', 'B');
	     bst.insert('C', 'C');
		//testing get on node contained in the tree
		
	     assertEquals('C',(char)bst.get('C'));// have to cast to char
	     
	     //testing get on node not contained in the tree
	     assertNull(bst.get('X'));
	     
		
	}
	
	@Test
	public void testDelete() {
		
		BST<Integer, Integer> bst = new BST<Integer, Integer>();
		
		//testing delete on empty tree
		bst.delete(5);
		assertNull(bst.printTree());
	}

}
