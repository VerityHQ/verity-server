package site.verity.web.exception;

public class UnprocessableEntityException extends RuntimeException {

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
