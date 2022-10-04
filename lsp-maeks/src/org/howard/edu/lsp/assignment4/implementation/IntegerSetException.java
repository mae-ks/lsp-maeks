package org.howard.edu.lsp.assignment4.implementation;

/**
 * Exception inheriting from Java's default Exception class
 */
public class IntegerSetException extends Exception {
	private static final long serialVersionUID = 1L;
	/**
	 * Exception to be thrown if set is empty.
	 * @param message String type
	 */
	public IntegerSetException(String message) {
        super(message);
    }
}