package org.howard.edu.lsp.assignment4.test;
import org.howard.edu.lsp.assignment4.implementation.IntegerSet;
import org.howard.edu.lsp.assignment4.implementation.IntegerSetException;

/**
 * Testing out methods defined in org.howard.edu.lsp.assignment4 package
 */
public class Driver {
	/**
	 * Main function calling methods from implementation
	 * @param args no parameters needed
	 */
	public static void main(String[] args) {
		IntegerSet set1 = new IntegerSet();
		set1.add(1);
		set1.add(2);
		set1.add(3);
		
		System.out.println("Value of Set1 is: " + set1.toString());
		try {
			System.out.println("Smallest value in Set1 is: " + set1.smallest());
			System.out.println("Largest value in Set1 is: " + set1.largest());
		}
		catch (IntegerSetException ex) {
			System.out.println("Cannot get elements. Set is empty.");
		}
	
		
		IntegerSet set2 = new IntegerSet();
		set2.add(4);
		set2.add(5);
		System.out.println("\nSet2 created with elements: " + set2.toString());
	
		
		System.out.println("\nUnion of Set1 and Set2");
		System.out.println("Value of Set1 is: " + set1.toString());
		System.out.println("Value of Set2 is: " + set2.toString());
		set1.union(set2); // union of set1 and set2
		System.out.println("Result of union of Set1 and Set2: " + set1.toString());
		
		
		System.out.println("\nSet1 is now: " + set1.toString());
		set1.intersect(set2);
		System.out.println("Set1 is 12345 and Set2 is 45,\nso Set1 intersect Set2: " + set1.toString());
		System.out.println("Set1 is now: " + set1.toString());
		
		
		System.out.println("\nRemoving all elements of Set2 from Set1");
		set1.difference(set2);
		System.out.println("Set1 is now: " + set1.toString());
		
		
		System.out.println("\nTrying to print elements in empty Set1: ");
		try {
			System.out.println("Smallest value in Set1 is: " + set1.smallest());
			System.out.println("Largest value in Set1 is: " + set1.largest());
		}
		catch (IntegerSetException ex) {
			System.out.println("Cannot get elements. Set is empty.");
		}
	}
}
