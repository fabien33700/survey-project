package imie.survey.exceptions.handler;

import javax.validation.ValidationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import imie.survey.exceptions.errors.UnauthorizedException;
import imie.survey.exceptions.errors.WebServiceException;
import io.jsonwebtoken.JwtException;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(WebServiceException.class)
	public ResponseEntity<ExceptionResponse<WebServiceException>> 
		handleWebServiceException(WebServiceException ex) 
	{
		return new ExceptionResponse<>(ex).getResponseEntity();
	}
	
	@ExceptionHandler(ValidationException.class)
	public ResponseEntity<ExceptionResponse<ValidationException>>
		handleValidationException(ValidationException ex) {
		return new ExceptionResponse<>(ex)
				.getResponseEntity(HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(JwtException.class)
	public ResponseEntity<ExceptionResponse<UnauthorizedException>>
		handleJWTAuthenticationException(JwtException e) {
		UnauthorizedException ex = 
			new UnauthorizedException("L'authentification via JWT a échouée.");
		return new ExceptionResponse<>(ex).getResponseEntity();
	}
	
}
