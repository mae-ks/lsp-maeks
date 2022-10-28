package org.howard.edu.lsp.midterm.problem1;

import java.util.ArrayList;
import java.util.List;

/**
 * A simplified electronic voting machine with a list of candidates and their votes.
 */
public class VotingMachine {
	/**
	 * Two ArrayLists to keep track of people and their respective votes.
	 * Integer variable to keep track of total number of votes.
	 */
	// YOU must decide upon an appropriate data representation to associate a name with respective votes.  Create whatever you like.
	private List<String> people = new ArrayList<String>();
	private List<Integer> all_votes = new ArrayList<Integer>();
	public int total_votes = 0;
	
	/**
	 * Add a candidate to the list, initialize number of votes to 0
	 * @param name string of candidate to add
	 */
	public void addCandidate(String name) {
		boolean containing = people.contains(name);
		if (!containing) {
			people.add(name);
			all_votes.add(0);
		}
	} 

	/**
	 * Cast votes to the candidate with the given name
	 * @param name string of candidate voting
	 * @param votes integer of candidate's vote
	 */
	public void castVotes(String name, int votes) {
		int index;
		index = people.indexOf(name);
		if (index != -1) {
			all_votes.set(index, votes);
			total_votes += votes;
		}
	}

	/**
	 * Return the number of votes for a given candidate.
	 * @throws UnknownCandidateException if name not present
	 * @param name string of candidate's votes to retrieve
	 * @return votes integer of specified candidate
	 */
	public int getVotes(String name) throws UnknownCandidateException {
		if (!people.contains(name)) throw new UnknownCandidateException("Voter does not exist.");
		int index;
		index = people.indexOf(name);
		return all_votes.get(index);
	}

	/**
	 * Return the total number of votes for all candidates.
	 * @return total votes integer of all candidates
	 */
	public int sum() {
		return total_votes;
	}
}
