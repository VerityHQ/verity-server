package site.verity.web.exception;

public final class PreconditionFailedException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = -2128460598941449024L;

	public PreconditionFailedException() {
        super();
    }

    public PreconditionFailedException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public PreconditionFailedException(final String message) {
        super(message);
    }

    public PreconditionFailedException(final Throwable cause) {
        super(cause);
    }

}
