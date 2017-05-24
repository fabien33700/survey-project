package imie.survey.exceptions.handler;

import java.util.Optional;

import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class ExceptionResponse<E extends Exception> {
	
	protected final E exception;
	
	protected Optional<HttpStatus> status;
	
	public ExceptionResponse(E exception) {
		this.exception = exception;
	}
	
	public ExceptionResponse(E exception, HttpStatus status) {
		this.exception = exception;
		this.status = Optional.of(status);
	}
	
	public String getMessage() {
		return exception.getLocalizedMessage();
	}
	
	public HttpStatus getStatus() {
		if (status.isPresent()) {
			return status.get();
		}
		
		ResponseStatus annotatedStatus = (ResponseStatus)
			AnnotationUtils.findAnnotation(exception.getClass(), ResponseStatus.class);
		
		return (annotatedStatus != null) ?
			annotatedStatus.value() : HttpStatus.INTERNAL_SERVER_ERROR;
	}
	
	public int getStatusCode() {
		return getStatus().value();
	}
	
	@JsonIgnore
	public ResponseEntity<ExceptionResponse<E>> getResponseEntity() {
		return new ResponseEntity<>(this, getStatus());
	}
}
