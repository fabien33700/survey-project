package imie.survey.exceptions.handler;

import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class ExceptionResponse<E extends Exception> {
	
	protected final E exception;
	
	public ExceptionResponse(E exception) {
		this.exception = exception;
	}
	
	public String getMessage() {
		return exception.getLocalizedMessage();
	}
	
	public HttpStatus getStatus() {
		ResponseStatus status = (ResponseStatus)
			AnnotationUtils.findAnnotation(exception.getClass(), ResponseStatus.class);
		
		return (status != null) ? status.value() : HttpStatus.INTERNAL_SERVER_ERROR;
	}
	
	public int getStatusCode() {
		return getStatus().value();
	}
	
	@JsonIgnore
	public ResponseEntity<ExceptionResponse<E>> getResponseEntity() {
		return new ResponseEntity<>(this, getStatus());
	}
}
