package org.howard.edu.lsp.assignment7;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

/**
 * Test for both algorithm strategies to get average grade
 * @author maeky
 */
public class AverageGradesTest extends junit.framework.TestCase {
	/**
	 * Test for first algorithm
	 * @throws EmptyListException if list is empty
	 */
	@Test
	@DisplayName("Test case for first algorithm")
	public void testAlgo1() throws EmptyListException {
		AverageContext ctx = new AverageContext();
		ctx.setAverageStrategy(new algo1());
		
		List<Integer> grades = new ArrayList<Integer>();
		
		Throwable exception = assertThrows(
				EmptyListException.class, () -> {
					System.out.println("Average of all grades: " + ctx.getAverage(grades));
	            }
	    );
		assertEquals("List is empty.", exception.getMessage());
		
		grades.add(1);
		grades.add(2);
		grades.add(3);
		grades.add(4);
		assertEquals(ctx.getAverage(grades), 2);
	};
	
	/**
	 * Test for second algorithm
	 * @throws EmptyListException if list is empty
	 */
	@Test
	@DisplayName("Test case for second algorithm")
	public void testAlgo2() throws EmptyListException {
		AverageContext ctx = new AverageContext();
		ctx.setAverageStrategy(new algo2());
		
		List<Integer> grades = new ArrayList<Integer>();
		
		Throwable exception = assertThrows(
				EmptyListException.class, () -> {
					System.out.println("Average of all grades after dropping two lowest scores: " + ctx.getAverage(grades));
	            }
	    );
		assertEquals("List is empty.", exception.getMessage());
		
		grades.add(1);
		grades.add(2);
		
		exception = assertThrows(
				EmptyListException.class, () -> {
					System.out.println("Average of all grades after dropping two lowest scores: " + ctx.getAverage(grades));
	            }
	    );
		assertEquals("List becomes empty after dropping two lowest scores.", exception.getMessage());
		
		grades.add(3);
		grades.add(4);
		assertEquals(ctx.getAverage(grades), 3);
	}
	
}
