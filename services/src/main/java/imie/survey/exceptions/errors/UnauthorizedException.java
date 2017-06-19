package imie.survey.exceptions.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(HttpStatus.NOT_FOUND)
public class UnauthorizedException extends WebServiceException {
    
	public UnauthorizedException() {
        super("Accès à la ressource refusé."); 
    }
	
    public UnauthorizedException(String message) {
        super(message);
    }
    
	public UnauthorizedException(String message, Throwable cause) {
	    super(message, cause);
	}
}
