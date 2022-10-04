package org.howard.edu.lsp.assignment4.implementation;
import java.util.ArrayList;
import java.util.List;

/**
 * Class IntegerSet is an ArrayList containing only single instances of each integer added to imitate a set.
 *
 */
public class IntegerSet {
	private List<Integer> set = new ArrayList<Integer>();
	
	/**
	 * Get value at index
	 * @param index integer type
	 * @return int value inside set at index
	 */
	public int get(int index) {
		return set.get(index);
	}
	
	/**
	 * Default Constructor
	 */
	public IntegerSet() {
		set = new ArrayList<Integer>();
	}
	
	/**
	 * Clears the internal representation of the set
	 */
	public void clear() {
		this.clear();
	}
	
	/**
	 * Returns the length of the set
	 * @return length of set
	 */
	public int length() {
		return set.size();
	}
	
	/** Returns true if the 2 sets are equal, false otherwise.
	* Two sets are equal if they contain all of the same values in ANY order.
	* @param intSetb IntegerSet type
	* @return boolean
	*/
	public boolean equals(IntegerSet intSetb) {
		return set == intSetb;
	}
	
	/**
	 * Returns true if the set contains the value, otherwise false
	 * @param value integer type to check for in set
	 * @return boolean
	 */
	public boolean contains(int value) {
		return set.contains(value);
	}
	
	/**
	 * Returns the largest item in the set; Throws a IntegerSetException if the set is empty
	 * @return biggest integer value from set
	 * @throws IntegerSetException thrown when set is empty
	 */
	public double largest() throws IntegerSetException {
		if (set.size() == 0) throw new IntegerSetException("Set is empty.");
		int curr;
		double biggest = Double.POSITIVE_INFINITY * -1;
		for (int i=0; i<set.size(); i++) {
			curr = set.get(i);
			if (curr > biggest) biggest = curr;
		}
		return biggest;
	}
	
	/**
	 * Returns the smallest item in the set; Throws a IntegerSetException if the set is empty
	 * @return tiniest integer value from set
	 * @throws IntegerSetException thrown when set is empty
	 */
	public double smallest() throws IntegerSetException {
		if (set.size() == 0) throw new IntegerSetException("Set is empty.");
		int curr;
		double tiniest = Double.POSITIVE_INFINITY;
		for (int i=0; i<set.size(); i++) {
			curr = set.get(i);
			if (curr < tiniest) tiniest = curr;
		}
		return tiniest;
	}
	
	/**
	 * Adds an item to the set or does nothing already there
	 * @param item integer
	 */
	public void add(int item) {
		boolean containing = set.contains(item);
		if (!containing) set.add(item);
	}
	
	/**
	 * Removes an item from the set or does nothing if not there
	 * @param item integer
	 */
	public void remove(int item) {
		int index;
		index = set.indexOf(item);
		set.remove(index);
	}
	
	/**
	 * Set union
	 * @param intSetb IntegerSet type
	 */
	public void union(IntegerSet intSetb) {
		boolean contains;
		int curr;
		for (int i = 0; i < intSetb.length(); i++) {
			curr = intSetb.get(i);
			contains = set.contains(curr);
			if (!contains) set.add(curr);
		}
	}

	/**
	 * Set intersection
	 * @param intSetb IntegerSet type
	 */
	public void intersect(IntegerSet intSetb) {
		List<Integer> res = new ArrayList<Integer>();
		boolean contains;
		for (int i = 0; i < set.size(); i++) {
			contains = intSetb.contains(set.get(i));
			if (contains) res.add(set.get(i));
		}
		set = res;
	}
	
	/**
	 * Set difference, i.e., set1-set2
	 * @param intSetb IntegerSet type
	 */
	public void difference(IntegerSet intSetb) {
		int curr;
		int index;
		
		for (int i = 0; i<intSetb.length(); i++) {
			curr = intSetb.get(i);
			index = set.indexOf(curr);
			set.remove(index);
		}
	}
	
	/**
	 * Returns true if the set is empty, false otherwise
	 */
	boolean isEmpty() {
		int size = set.size();
		return size == 0;
	}
	
	/**
	 * Return String representation of your set
	 */
	public String toString() {
		String res = new String();
		for (int i = 0; i<set.size(); i++) {
			res += set.get(i);
		}
		return res;
	}
	
}
