package org.howard.edu.lsp.assignment7;
import java.util.List;

/**
 * Average grade of list of integer numbers
 * @author maeky
 */
public class algo1 implements AverageStrategy {
	/**
	 * Get average of grades
	 * @param grades list of integers
	 * @return int average of grades
	 */
	public int compute(List<Integer> grades) {
		int total = 0;
		for (int num : grades) {
			total += num;
		}
		return total/grades.size();
	};
}
