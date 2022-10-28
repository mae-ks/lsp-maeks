package org.howard.edu.lsp.midterm.problem1;

/**
 * Exception inheriting from Java's default Exception class
 */
public class UnknownCandidateException extends Exception {
	private static final long serialVersionUID = 1L;
	/**
	 * Exception to be thrown if set is empty.
	 * @param message String type
	 */
	public UnknownCandidateException(String message) {
        super(message);
    }
}