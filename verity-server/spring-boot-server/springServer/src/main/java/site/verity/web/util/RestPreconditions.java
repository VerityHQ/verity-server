package site.verity.web.util;

import org.springframework.http.HttpStatus;

import site.verity.web.exception.BadRequestException;
import site.verity.web.exception.ConflictException;
import site.verity.web.exception.ForbiddenException;
import site.verity.web.exception.ResourceNotFoundException;
import site.verity.web.exception.UnprocessableEntityException;

/**
 * Simple static methods that verify correct arguments and state of request. 
 * If the Precondition fails, one of our custom exceptions are thrown.
 * The thrown exception is expected to be caught and mapped in
 * {@link RestResponseEntityExceptionHandler} where it will be converted
 * to a response code.
 */
public final class RestPreconditions {

    private RestPreconditions() {
        throw new AssertionError();
    }

    // API

    /**
     * boolean Assert semantics of operation are valid, 
     * otherwise throw UnprocessableEntityException.
     * 
     * UnprocessableEntityException means the request entity is well formed but the
     * meaning of some elements are semantically incorrect.
     * 
     * @param expression
     *            has value true if semantically correct request, otherwise false
     *
     * @throws UnprocessableEntityException
     *             if expression is false, means operation not possible.
     */
    public static void assertSemanticsValid(final boolean expression) {
        assertAllowed(expression, null);
    }

    /**
     * boolean Assert semantics of operation are valid, 
     * otherwise throw UnprocessableEntityException.
     * 
     * UnprocessableEntityException means the request entity is well formed but the
     * meaning of some elements are semantically incorrect.
     * 
     * @param expression
     *            has value true if semantically correct request, otherwise false
     * @param message
     *            the message of the exception if the check fails
     *
     * @throws UnprocessableEntityException
     *             if expression is false, means operation not possible.
     */
    public static void assertSemanticsValid(final boolean expression, final String message) {
        if (!expression) {
            throw new UnprocessableEntityException(message);
        }
    }
    

    /**
     * Assert request element exists, else throw BadRequestException.
     *
     * @param reference
     *            an object reference
     * @return the non-null reference that was validated
     *
     * @throws BadRequestException
     *             if {@code reference} is null
     */
    public static <T> T assertRequestElementProvided(final T reference) {
        return assertRequestElementProvided(reference, null);
    }

    /**
     * Assert request element exist, else throw BadRequestException.
     *
     * @param reference
     *            an object reference
     * @param message
     *            the message of the exception if the check fails
     *
     * @return the non-null reference that was validated
     *
     * @throws BadRequestException
     *             if {@code reference} is null
     */
    public static <T> T assertRequestElementProvided(final T reference, final String message) {
        if (reference == null) {
            throw new BadRequestException(message);
        }
        return reference;
    }

    /**
     * boolean Assert no conflict, else throw ConflictException.
     * Use in situations where the user might be able to resolve 
     * the conflict and resubmit the request.
     * 
     * @param expression
     *            a boolean expression - true if the is a conflict
     *
     * @throws ConflictException
     *             if {@code expression} is false
     */
    public static void assertNoConflict(final boolean expression) {
        assertNoConflict(expression, null);
    }

    /**
     * Assert object is null, else throw ConflictException.
     * Use in situations where the user might be able to resolve 
     * the conflict and resubmit the request. You should provide a message to
     * assist user in resolving conflict.
     *
     * @param expression
     *            a boolean expression - false if there is a conflict
     * @param message
     *            the message of the exception if the check fails
     *
     * @throws ConflictException
     *             if {@code expression} is false
     */
    public static void assertNoConflict(final boolean expression, final String message) {
        if (!expression) {
            throw new ConflictException(message);
        }
    }
    
    /**
     * Assert object is null, else throw ConflictException.
     * Use in situations where the user might be able to resolve 
     * the conflict and resubmit the request. You should provide a message to
     * assist user in resolving conflict.
     *
     * @param expression
     *            not null if found
     *            
     * @param message
     *            the message of the exception if the check fails
     *
     * @throws ConflictException
     *             if {@code expression} is false
     */
    public static <T> T assertNoConflict(final T resource) {
        return assertResourceFound(resource, null);
    }

    /**
     * Assert some resource is not null, otherwise throw ConflictException.
     *
     * @param expression
     *            not null if found
     * @param message
     *            the message of the exception if the check fails
     *
     * @throws ConflictException
     *             if expression is null, means value not found.
     */
    public static <T> T assertNoConflict(final T resource, final String message) {
        if (resource != null) {
            throw new ConflictException(message);
        }

        return resource;
    }

    /**
     * Assert boolean expression about the validity of the request
     * throw BadRequestException if false 
     *
     * @param expression
     *            a boolean expression
     *
     * @throws BadRequestException
     *             if {@code expression} is false
     */
    public static void assertValidRequest(final boolean expression) {
        assertValidRequest(expression, null);
    }

    /**
     * Assert boolean expression about the validity of the request
     * throw BadRequestException if false 
     * 
     * @param expression
     *            a boolean expression
     * @param message
     *            the message of the exception if the check fails
     *
     * @throws BadRequestException
     *             if {@code expression} is false
     */
    public static void assertValidRequest(final boolean expression, final String message) {
        if (!expression) {
            throw new BadRequestException(message);
        }
    }

    /**
     * boolean Asset some resource was found, otherwise throw ResourceNotFoundException.
     *
     * @param expression
     *            has value true if found, otherwise false
     *
     * @throws 404 ResourceNotFoundException
     *             if expression is false, means value not found.
     */
    public static void assertResourceFound(final boolean expression) {
        assertResourceFound(expression, null);
    }

    /**
     * boolean Assert some resource was found, otherwise throw ResourceNotFoundException.
     *
     * @param expression
     *            has value true if found, otherwise false
     * @param message
     *            the message of the exception if the check fails
     *
     * @throws 404 ResourceNotFoundException
     *             if expression is false, means value not found.
     */
    public static void assertResourceFound(final boolean expression, final String message) {
        if (!expression) {
            throw new ResourceNotFoundException(message);
        }
    }

    /**
     * Assert some resource is not null, otherwise throw ResourceNotFoundException.
     *
     * @param expression
     *            not null if found
     *
     * @throws 404 ResourceNotFoundException
     *             if expression is null, means value not found.
     */
    public static <T> T assertResourceFound(final T resource) {
        return assertResourceFound(resource, null);
    }

    /**
     * Assert some resource is not null, otherwise throw ResourceNotFoundException.
     *
     * @param expression
     *            not null if found
     * @param message
     *            the message of the exception if the check fails
     *
     * @throws 404 ResourceNotFoundException
     *             if expression is null, means value not found.
     */
    public static <T> T assertResourceFound(final T resource, final String message) {
        if (resource == null) {
            throw new ResourceNotFoundException(message);
        }

        return resource;
    }

    /**
     * boolean Assert operation is allowed, otherwise throw ForbiddenException.
     *
     * @param expression
     *            has value true if found, otherwise false
     *
     * @throws 403 ForbiddenException
     *             if expression is false, means operation not allowed.
     */
    public static void assertAllowed(final boolean expression) {
        assertAllowed(expression, null);
    }

    /**
     * boolean Assert operation is allowed, otherwise throw ForbiddenException.
     *
     * @param expression
     *            has value true if found, otherwise false
     * @param message
     *            the message of the exception if the check fails
     *
     * @throws 403 ForbiddenException
     *             if expression is false, means operation not allowed.
     */
    public static void assertAllowed(final boolean expression, final String message) {
        if (!expression) {
            throw new ForbiddenException(message);
        }
    }

}
