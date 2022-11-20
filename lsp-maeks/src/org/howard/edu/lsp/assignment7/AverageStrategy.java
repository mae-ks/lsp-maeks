package org.howard.edu.lsp.assignment7;
import java.util.List;

/**
 * Strategy generalizing the compute function
 * @author maeky
 */
public interface AverageStrategy {
	/**
	 * @param grades list of integers
	 * @return average grade for specified strategy
	 * @throws EmptyListException exception thrown if list is empty
	 */
	public int compute(List<Integer> grades) throws EmptyListException;
}
