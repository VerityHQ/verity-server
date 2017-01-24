package site.verity.web.error;

import java.sql.SQLException;

import javax.persistence.EntityNotFoundException;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.hibernate.exception.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import site.verity.web.exception.ApiError;
import site.verity.web.exception.ConflictException;
import site.verity.web.exception.ResourceNotFoundException;
import site.verity.web.exception.UnprocessableEntityException;
/**
 * 
 * @author kingdo
 *
 * Methods to handle exceptions and map them to response codes.
 *  
 */
@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    private Logger log = LoggerFactory.getLogger(getClass());
    
    public RestResponseEntityExceptionHandler() {
        super();  //constructor will be called on startup during configuration
    }


    // 400
    //TODO: handlers that catch exceptions that we don't explicitly throw
    // should not fire if we are doing our job.
    // We should be explicitly handling expected exceptions and validating in such a way 
    // that we don't end up handling lower level (Hibernate / SQL) exception.
    // If we do, we should alert the API user / developer to report the exception
    // or we need to have logging in place that makes us aware of these types.
    // For now we will ignore above advice and deal with it as technical debt later.
    @ExceptionHandler({ ConstraintViolationException.class })
    public ResponseEntity<Object> handleBadRequest(final ConstraintViolationException ex, final WebRequest request) {
        log.warn("Unexpected exception - we should be explicitly handling for this case.  Bad Request: {}", ex.getLocalizedMessage());
        final ApiError bodyOfResponse = message(HttpStatus.BAD_REQUEST, ex);
        return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler({ DataIntegrityViolationException.class })
    public ResponseEntity<Object> handleBadRequest(final DataIntegrityViolationException ex, final WebRequest request) {
        log.warn("Unexpected exception - we should be explicitly handling for this case.  Bad Request: {}", ex.getLocalizedMessage());
        final ApiError bodyOfResponse = message(HttpStatus.BAD_REQUEST, ex); 
        return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(final HttpMessageNotReadableException ex, final HttpHeaders headers, final HttpStatus status, final WebRequest request) {
        log.warn("Unexpected exception - we should be explicitly handling for this case.  Bad Request: {}", ex.getLocalizedMessage());
        final ApiError bodyOfResponse = message(HttpStatus.BAD_REQUEST, ex); 
        // ex.getCause() instanceof JsonMappingException, JsonParseException // for additional information later on
        return handleExceptionInternal(ex, bodyOfResponse, headers, HttpStatus.BAD_REQUEST, request);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(final MethodArgumentNotValidException ex, final HttpHeaders headers, final HttpStatus status, final WebRequest request) {
        log.warn("Unexpected exception - we should be explicitly handling for this case.  Bad Request: {}", ex.getLocalizedMessage());
        final ApiError bodyOfResponse = message(HttpStatus.BAD_REQUEST, ex); 
        return handleExceptionInternal(ex, bodyOfResponse, headers, HttpStatus.BAD_REQUEST, request);
    }

    // 403

    // 404

    @ExceptionHandler(value = { EntityNotFoundException.class, ResourceNotFoundException.class })
    protected ResponseEntity<Object> handleNotFound(final RuntimeException ex, final WebRequest request) {
        final ApiError apiError = message(HttpStatus.NOT_FOUND, ex);
        return handleExceptionInternal(ex, apiError, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    // 409
    @ExceptionHandler({ InvalidDataAccessApiUsageException.class, DataAccessException.class, ConflictException.class })
    protected ResponseEntity<Object> handleConflict(final RuntimeException ex, final WebRequest request) {
        log.warn("Conflict: {}", ex.getMessage());
        final ApiError apiError = message(HttpStatus.CONFLICT, ex);
        return handleExceptionInternal(ex, apiError, new HttpHeaders(), HttpStatus.CONFLICT, request);
    }

    // 412

    // 422
	//https://stackoverflow.com/questions/3825990/http-response-code-for-post-when-resource-already-exists?rq=1
    // appropriate if an XML request body contains well-formed 
    // (i.e., syntactically correct), but semantically erroneous, XML instructions.
    @ExceptionHandler({ UnprocessableEntityException.class })
    protected ResponseEntity<Object> handleUnProcessableEntity(final RuntimeException ex, final WebRequest request) {
        log.info("Bad Request: {}", ex.getLocalizedMessage());
        log.debug("Bad Request: ", ex);
        final ApiError apiError = message(HttpStatus.UNPROCESSABLE_ENTITY, ex);
		return new ResponseEntity<Object>(apiError, new HttpHeaders(), HttpStatus.UNPROCESSABLE_ENTITY);   
    }
    
    // 500
    @ExceptionHandler({ NullPointerException.class, IllegalArgumentException.class, IllegalStateException.class })
    public ResponseEntity<Object> handleInternal(final RuntimeException ex, final WebRequest request) {
        log.error("500 Status Code", ex);
        final String bodyOfResponse = "";
        return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }
    
    private ApiError message(final HttpStatus httpStatus, final Exception ex) {
        final String message = ex.getMessage() == null ? ex.getClass().getSimpleName() : ex.getMessage();        
        // TODO: configure dev instance to return stack trace via API
        final String devMessage = ExceptionUtils.getRootCauseMessage(ex);
        return new ApiError(httpStatus.value(), message, devMessage);
    }
}
