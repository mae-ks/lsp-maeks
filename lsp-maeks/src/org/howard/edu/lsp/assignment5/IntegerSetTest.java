package org.howard.edu.lsp.assignment5;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.DisplayName;
import org.junit.Test;

public class IntegerSetTest extends junit.framework.TestCase{
	private static IntegerSet testSet1, testSet2, emptySet;
	
	@Before
	public void setUp() {
		// Set up default test sets for every new test
		// testSet1 = testSet2 = [0, 1, 2]
		// emptySet = []
		testSet1 = new IntegerSet();
		testSet2 = new IntegerSet();
		emptySet = new IntegerSet();
		for (int i=0; i<3; i++) {
			testSet1.add(i);
			testSet2.add(i);
		}
		System.out.println(emptySet);
	}
	@After
	public void tearDown() {}
	
	@Test
	@DisplayName("Test case for equals")
	public void testEquals() {
		//JUnit test case(s) for equal
		// same values
		assertTrue(testSet1.equals(testSet2));
		// different values
		assertFalse(testSet1.equals(emptySet));
	}
	
	@Test
	@DisplayName("Test case for length")
	public void testLength() {
		//JUnit test case(s) for length
		// correct lengths
		assertTrue(testSet1.length() == 3);
		assertTrue(emptySet.length() == 0);
		// incorrect lengths
		assertFalse(testSet1.length() == 1);
		assertFalse(testSet1.length() == 4);
		assertFalse(testSet1.length() == 5);
	}
	
	@Test
	@DisplayName("Test case for contains")
	public void testContains() {
		//JUnit test case(s) for contains
		// contains
		assertTrue(testSet1.contains(0));
		// does not contain
		assertFalse(testSet1.contains(5));
		assertFalse(testSet1.contains(-1));
		assertFalse(emptySet.contains(0));
	}
	
	@Test
	@DisplayName("Test case for largest")
	public void testLargest() throws IntegerSetException {
		//JUnit test case(s) for largest
		// correct largest
		assertTrue(testSet1.largest() == 2);
		// incorrect largest
		assertFalse(testSet1.largest() == 3);
		assertFalse(testSet1.largest() == 1);
		// empty set
	    Throwable exception = assertThrows(
	            IntegerSetException.class, () -> {
	                IntegerSet emptySet = new IntegerSet();
	                emptySet.largest();
	            }
	    );
		assertEquals("Set is empty.", exception.getMessage());
	}
	
	@Test
	@DisplayName("Test case for smallest")
	public void testSmallest() throws IntegerSetException {
		//JUnit test case(s) for smallest
		// correct smallest
		assertTrue(testSet1.smallest() == 0);
		//incorrect smallest
		assertFalse(testSet1.smallest() == -1);
		assertFalse(testSet1.smallest() == 1);
		// empty set
	    Throwable exception = assertThrows(
	            IntegerSetException.class, () -> {
	                IntegerSet emptySet = new IntegerSet();
	                emptySet.smallest();
	            }
	    );
		assertEquals("Set is empty.", exception.getMessage());
	}
	
	@Test
	@DisplayName("Test case for add")
	public void testAdd() {
		//JUnit test case(s) for add
		// adding existing should keep set the same
		testSet1.add(0);
		assertTrue(testSet1.equals(testSet2));
		// adding nonexisting value
		testSet1.add(3);
		assertFalse(testSet1.equals(testSet2));
		
		emptySet.add(0);
		emptySet.add(1);
		emptySet.add(2);
		// emptySet = [0,1,2]
		assertTrue(emptySet.equals(testSet2));
		assertFalse(emptySet.equals(testSet1));
		emptySet.add(3);
		// emptySet = [0,1,2,3]
		assertTrue(emptySet.equals(testSet1));
		assertFalse(emptySet.equals(testSet2));
		
	}
	
	@Test
	@DisplayName("Test case for remove")
	public void testRemove() {
		//JUnit test case(s) for remove
		// removing nonexisting value should keep set the same
		testSet1.remove(3);
		assertTrue(testSet1.equals(testSet2));
		assertTrue(testSet1.length() == 3);
		// removing existing values
		testSet1.remove(0);
		testSet1.remove(1);
		testSet1.remove(2);
		assertFalse(testSet1.equals(testSet2));
		assertTrue(testSet1.equals(emptySet));
	}
	
	@Test
	@DisplayName("Test case for set union")
	public void testUnion() {
		//JUnit test case(s) for union
		// union same value sets gives same set
		testSet1.union(testSet2);
		assertTrue(testSet1.equals(testSet2));
		// union empty set gives same set
		testSet1.union(emptySet);
		assertTrue(testSet1.equals(testSet2));
		// union different value sets
		testSet2.remove(0);
		testSet2.add(5);
		testSet1.union(testSet2);
		assertFalse(testSet1.equals(testSet2));
	}
	
	@Test
	@DisplayName("Test case for set intersection")
	public void testIntersect() {
		//JUnit test case(s) for intersect
		// intersect same value sets give same set
		testSet1.intersect(testSet2);
		assertTrue(testSet1.equals(testSet2));
		// intersect empty set gives empty set
		testSet1.intersect(emptySet);
		assertTrue(testSet1.equals(emptySet));
		// intersect different value sets
		testSet1.union(testSet2);
		testSet1.add(3);
		testSet1.remove(0);
		testSet1.intersect(testSet2);
		assertFalse(testSet1.equals(testSet2));
		emptySet.add(1);
		emptySet.add(2);
		assertTrue(testSet1.equals(emptySet));
	}
	
	@Test
	@DisplayName("Test case for set difference")
	public void testDiff() {
		//JUnit test case(s) for diff
		// difference empty set gives same set
		testSet1.difference(emptySet);
		assertTrue(testSet1.equals(testSet1));
		// difference same value sets give empty set
		testSet1.difference(testSet2);
		assertTrue(testSet1.equals(emptySet));
		// difference different value sets
		testSet1.add(1);
		testSet1.add(2);
		testSet1.add(3);
		testSet1.difference(testSet2);
		assertFalse(testSet1.equals(testSet2));
		emptySet.add(3);
		assertTrue(testSet1.equals(emptySet));
	}
	
	@Test
	@DisplayName("Test case for isEmpty")
	public void testIsEmpty() {
		//JUnit test case(s) for isEmpty
		// empty set
		assertTrue(emptySet.isEmpty());
		// non empty set
		assertFalse(testSet1.isEmpty());
	}
	
	@Test
	@DisplayName("Test case for toString")
	public void testToString() {
		//JUnit test case(s) for toString
		assertTrue(testSet1.toString().equals("012"));
		assertTrue(emptySet.toString().equals(""));
	}
}
