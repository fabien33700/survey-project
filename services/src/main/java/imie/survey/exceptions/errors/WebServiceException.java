package imie.survey.exceptions.errors;

@SuppressWarnings("serial")
public abstract class WebServiceException extends RuntimeException {

	public WebServiceException(String message) {
		super(message);
	}

	public WebServiceException(String message, Throwable cause) {
		super(message, cause);
	}
}
