package org.howard.edu.lsp.midterm.problem1;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

public class VotingMachineTest extends junit.framework.TestCase {
	private static VotingMachine three_people, no_one;
	
	@Before
	public void setUp() {
		// Set up default test sets for every new test
		// three_people = ["Andrew" : 2 votes, "Barney" : 3 votes, "Carl" : 0 votes]
		three_people = new VotingMachine();
		
		three_people.addCandidate("Andrew");
		three_people.addCandidate("Barney");
		three_people.addCandidate("Carl");
		three_people.castVotes("Andrew", 2);
		three_people.castVotes("Barney", 3);
	}
	@After
	public void tearDown() {}
	
	@Test
	@DisplayName("Test case for get votes")
	public void testGetVotes() throws UnknownCandidateException {
		//JUnit test case(s) for getting votes of each candidate
		assertEquals(three_people.getVotes("Andrew"), 2);
		assertEquals(three_people.getVotes("Carl"), 0);
		
		Throwable exception = assertThrows(
				UnknownCandidateException.class, () -> {
	                three_people.getVotes("Don");
	            }
	    );
		assertEquals("Voter does not exist.", exception.getMessage());
	}
	
	@Test
	@DisplayName("Test case for sum")
	public void testSum() {
		//JUnit test case(s) for getting total votes of all candidates
		assertEquals(three_people.sum(), 5);
		no_one = new VotingMachine();
		assertEquals(no_one.sum(), 0);
		
	}
}
