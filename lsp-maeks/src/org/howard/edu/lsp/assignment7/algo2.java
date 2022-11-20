package org.howard.edu.lsp.assignment7;
import java.util.Collections;
import java.util.List;

/**
 * Average grade of list of integer numbers dropping two lowest scores
 * @author maeky
 */
public class algo2 implements AverageStrategy {
	/**
	 * Get average of grades
	 * @param grades list of integers
	 * @return int average of grades excluding two lowest scores
	 * @throws EmptyListException if dropping scores give empty list
	 */
	public int compute(List<Integer> grades) throws EmptyListException {
		if (grades.size() < 3 && grades.size() > 0) {
			throw new EmptyListException("List becomes empty after dropping two lowest scores.");
		}
		Collections.sort(grades);
	
		grades = grades.subList(2, grades.size());

		int total = 0;
		for (int num : grades) {
			total += num;
		}
		return total/grades.size();
	};
}
