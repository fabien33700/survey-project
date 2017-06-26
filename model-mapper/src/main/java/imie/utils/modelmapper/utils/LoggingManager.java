package imie.utils.modelmapper.utils;


import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;

public class LoggingManager {
	
	public static Logger getLogger(Class<?> loggerClass, Level loggerLevel) {
		Logger log = (Logger)LoggerFactory.getLogger(loggerClass);
		log.setLevel(loggerLevel);
		
		return log;
	}
}
