package imie.survey.exceptions.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends WebServiceException {
    
	public ResourceNotFoundException() {
        super("La ressource demandée n'a pas été trouvée."); 
    }
	
    public ResourceNotFoundException(String message) {
        super(message);
    }
    
	public ResourceNotFoundException(String message, Throwable cause) {
	    super(message, cause);
	}
}
