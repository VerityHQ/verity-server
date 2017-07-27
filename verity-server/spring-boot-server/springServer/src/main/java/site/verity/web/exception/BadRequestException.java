package site.verity.web.exception;

public final class BadRequestException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 4803990456194722516L;

	public BadRequestException() {
        super();
    }

    public BadRequestException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public BadRequestException(final String message) {
        super(message);
    }

    public BadRequestException(final Throwable cause) {
        super(cause);
    }

}
