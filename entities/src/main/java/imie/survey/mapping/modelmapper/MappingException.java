package imie.survey.mapping.modelmapper;

@SuppressWarnings("serial")
public class MappingException extends RuntimeException {

	public MappingException(String message) {
		super(message);
	}
	
	public MappingException(String formatMessage, Object... arguments) {
		super(format(formatMessage, arguments));
	}
	
	private static String format(String format, Object... arguments) {
		String result = "";
		String[] words = format.split("{}");
		
		for (int i = 0; i < words.length; i++) {
			String arg = "";
			try {
				arg = arguments[i].toString();
			} catch (ArrayIndexOutOfBoundsException e) { }
			result = words[i] + arg;
		}
		
		return result;
	}

}
