package site.verity.web.exception;

public final class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -2483848188836994578L;

	public ResourceNotFoundException() {
        super();
    }

    public ResourceNotFoundException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public ResourceNotFoundException(final String message) {
        super(message);
    }

    public ResourceNotFoundException(final Throwable cause) {
        super(cause);
    }

}
