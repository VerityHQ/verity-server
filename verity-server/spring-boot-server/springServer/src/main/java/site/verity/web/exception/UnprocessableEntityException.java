package site.verity.web.exception;

public class UnprocessableEntityException extends RuntimeException {



	/**
	 * 
	 */
	private static final long serialVersionUID = -893576662843388986L;

	public UnprocessableEntityException() {
		super();
	}

	public UnprocessableEntityException(final String message, final Throwable cause) {
		super(message, cause);
	}

	public UnprocessableEntityException(final String message) {
		super(message);
	}

	public UnprocessableEntityException(final Throwable cause) {
		super(cause);
	}

}
