package testdeallock;

public class BalanceInsufficentException extends Exception {
	private static final long serialVersionUID = 1L;

	public BalanceInsufficentException() {
	}


	public BalanceInsufficentException(String message, Throwable cause) {
		super(message, cause);
	}

	public BalanceInsufficentException(String message) {
		super(message);
	}

	public BalanceInsufficentException(Throwable cause) {
		super(cause);
	}
	
	

}
