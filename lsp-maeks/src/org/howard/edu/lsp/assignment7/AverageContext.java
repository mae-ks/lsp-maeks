package org.howard.edu.lsp.assignment7;
import java.util.List;

/**
 * Class AverageContext is a context to implement the Strategy pattern to compute the
 * average of a list of submitted grades. The available algorithms are:
 * 1. Calculate the average grade for a list of integer numbers.
 * 2. Calculate the average grade for a list of integer numbers, dropping the two lowest scores.
 */
public class AverageContext {
	private AverageStrategy strategy;
	
	/**
	 * Set strategy for context
	 * @param strategy pattern for chosen algorithm
	 */
	public void setAverageStrategy(AverageStrategy strategy) {
		this.strategy = strategy;
	}
	
	/**
	 * Get value at index
	 * @param grades list of integers grades
	 * @return int res average of grades based on the set strategy
	 * @throws EmptyListException if list is empty
	 */
	public int getAverage(List<Integer> grades) throws EmptyListException {
		int res;
		if (grades.size() == 0) {
			throw new EmptyListException("List is empty.");
		}
		res = strategy.compute(grades);
		return res;
	}
}
