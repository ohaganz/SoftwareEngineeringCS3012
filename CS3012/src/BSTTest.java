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
		assertEquals("()",bst.printTree());
		
		//constructing a tree to test delete on
		bst.insert(5,5);
		bst.insert(6,6);
		bst.insert(7,7);
		bst.insert(8,8);
		
		//testing delete a leaf from constructed tree
		bst.delete(8);
		assertEquals("(()5(()6(()7())))",bst.printTree());
		
		//testing delete on node not present
		bst.delete(10);
		assertEquals("(()5(()6(()7())))",bst.printTree());

	}
	
	@Test
	public void testlowestCommonAncestor() {
		
		BST<Integer, Integer> bst1= new BST<Integer, Integer>();
		BST<Integer, Integer> bst2= new BST<Integer, Integer>();
		
		//Testing LCA on empty tree.
		assertNull(bst1.lowestCommonAncestor(1, 2));
			
		//Testing LCA on a one node tree
		bst1.insert(1, 1);
		//testing when neither keys are present
		assertNull(bst1.lowestCommonAncestor(2,3));
		//testing when one key is present - should still be null
		assertNull(bst1.lowestCommonAncestor(1,2));
		
		//constructing a tree to test LCA

       	bst2.insert(9, 9);   //        _9_
        bst2.insert(10, 10);   //      /     \
        bst2.insert(6, 6);   //    _6_      10
        bst2.insert(3, 3);   //  /     \
        bst2.insert(2, 2);   // 3       7
        bst2.insert(7, 7);   //  \     /
        bst2.insert(4, 4);   //   2   4
        bst2.insert(5, 5);   //        \
        					 //         5
		
        assertEquals(6,(int)bst2.lowestCommonAncestor(3,7));
        
		
		
		
		
		
	}
	
	

}
