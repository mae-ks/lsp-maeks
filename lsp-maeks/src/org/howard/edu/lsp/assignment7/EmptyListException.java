package org.howard.edu.lsp.assignment7;

/**
 * Exception inheriting from Java's default Exception class
 */
public class EmptyListException extends Exception {
	private static final long serialVersionUID = 1L;
	/**
	 * Exception to be thrown if list is empty.
	 * @param message String type
	 */
	public EmptyListException(String message) {
        super(message);
    }
}