package imie.survey.exceptions.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import imie.survey.exceptions.errors.WebServiceException;

@ControllerAdvice
public class WebServiceExceptionHandler {
	
	@ExceptionHandler(WebServiceException.class)
	public ResponseEntity<ExceptionResponse<WebServiceException>> 
		handleWebServiceException(WebServiceException ex) 
	{
		return new ExceptionResponse<>(ex).getResponseEntity();
	}
	
}
