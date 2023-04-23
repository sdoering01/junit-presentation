package domain;

public class IllegalUhrzeitException extends Exception {
	public static final long serialVersionUID = 1L;

	public IllegalUhrzeitException() {}

	public IllegalUhrzeitException(String message) {
		super(message);
	}
}
