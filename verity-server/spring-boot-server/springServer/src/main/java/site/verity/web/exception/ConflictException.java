package site.verity.web.exception;

public final class ConflictException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = -6207376968123873729L;

	public ConflictException() {
        super();
    }

    public ConflictException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public ConflictException(final String message) {
        super(message);
    }

    public ConflictException(final Throwable cause) {
        super(cause);
    }

}
